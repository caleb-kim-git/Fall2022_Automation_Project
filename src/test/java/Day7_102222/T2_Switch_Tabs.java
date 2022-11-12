package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_Switch_Tabs {

    public static void main(String[] args) throws InterruptedException{

        //setup chrome driver using WDM
        WebDriverManager.chromedriver().setup();
        //declare and define a new chrome options
        ChromeOptions options = new ChromeOptions();
        //start chrome maximized
        options.addArguments("start-maximized");
        //create new chromedriver and pass options
        WebDriver driver = new ChromeDriver(options);

        //navigate to calculator website
        driver.navigate().to("https://fideliscare.org");
        //delay 2s
        Thread.sleep(2000);

        //locate shop for a plan button
        driver.findElement(By.xpath("//*[@id='root-3']")).click();
        //delay 0.5s
        Thread.sleep(500);
        //click on medicaid managed care
        driver.findElement(By.xpath("//*[text()='Medicaid Managed Care']")).click();
        //delay 0.5s
        Thread.sleep(500);

        //click search button under find a doctor
        driver.findElement(By.xpath("//*[@class='btn btn-outline-primary btn-external btn-show link-external']")).click();

        //store tabs in array list
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to the new tab
        //if you dont switch the code will fail
        driver.switchTo().window(tabs.get(1));

        //enter zipcode in location
        driver.findElement(By.xpath("//*[@id='searchLocation']")).sendKeys("11801");
        //delay 2s
        Thread.sleep(2000);
        //close tab
        driver.close();
        //switch to parent tab (initial)
        driver.switchTo().window(tabs.get(0));
        //go back to home page
        driver.navigate().to("https://fideliscare.org");
        //delay 2s
        Thread.sleep(2000);
        //click get coverage
        driver.findElements(By.xpath("//*[text()='Get Coverage']")).get(1).click();
        //delay 2s
        Thread.sleep(2000);


    }//end of main

}//end of java class
