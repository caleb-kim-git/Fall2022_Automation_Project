package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T4_mcalc_scroll {

    public static void main(String[] args) throws InterruptedException {

        //setup chromedriver with WDM
        WebDriverManager.chromedriver().setup();

        //initialize chromeoptions
        ChromeOptions options = new ChromeOptions();

        //add arguments
        options.addArguments("start-maximized");

        //define the webdriver and enter the chromeoptions as a parameter
        WebDriver driver = new ChromeDriver(options);

        //navigate to mlcalc
        driver.navigate().to("https://mlcalc.com");

        //wait 2s
        Thread.sleep(2000);

        //define JSE
        JavascriptExecutor jse= (JavascriptExecutor)driver;

        //scroll down 1000 px
        jse.executeScript("scroll(0 , 2000)");
        //wait 2s
        Thread.sleep(2000);
        //scroll up 400 px
        jse.executeScript("scroll(0 , -1)");
        //wait 2s
        Thread.sleep(2000);

        //store calculate button and scroll intoit
        WebElement calculateButton = driver.findElement(By.xpath("//*[@value='Calculate']"));
        //scroll into view of calculate button
        jse.executeScript("arguments[0].scrollIntoView(true);", calculateButton);
        //2s delay
        Thread.sleep(2000);
        //quit
        driver.quit();

    }//end of main

}//end of java class
