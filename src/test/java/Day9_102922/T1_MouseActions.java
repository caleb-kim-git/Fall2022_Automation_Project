package Day9_102922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions {

    public static void main(String[] args) throws InterruptedException {

        //setup chrome driver using wdm
        WebDriverManager.chromedriver().setup();
        //declare and define a new chrome options
        ChromeOptions options = new ChromeOptions();
        //start chrome maximized
        options.addArguments("start-maximized");
        //create new chromedriver and pass options
        WebDriver driver = new ChromeDriver(options);

        //navigate to usps homepage
        driver.navigate().to("https://www.usps.com");
        //delay 1s
        Thread.sleep(1000);

        //hover of send tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        //declare mouse action
        Actions actions = new Actions(driver);
        //always end in perform
        actions.moveToElement(sendTab).perform();
        //delay 1s
        Thread.sleep(1000);

        WebElement calculatePrice = driver.findElement(By.xpath("//li[@class='tool-calc']"));
        //click on "Calculate a Price"
        actions.moveToElement(calculatePrice).click().perform();
        //delay 1s
        Thread.sleep(1000);

        //click on USPS logo
        WebElement uspsHome = driver.findElement(By.xpath("//*[@alt='USPS.com home']"));
        //right click on logo
        actions.moveToElement(uspsHome).contextClick().perform();
        //double click on logo
        actions.moveToElement(uspsHome).doubleClick().perform();

    }//end of main

}//end of java class
