package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_FindElements {

    public static void main(String[] args) throws InterruptedException {

        //setup chromedriver with WDM
        WebDriverManager.chromedriver().setup();

        //initialize chromeoptions
        ChromeOptions options = new ChromeOptions();

        //add arguments
        options.addArguments("start-maximized");

        //define the webdriver and enter the chromeoptions as a parameter
        WebDriver driver = new ChromeDriver(options);

        //go to yahoo's homepage
        driver.navigate().to("https://yahoo.com");

        //delay
        Thread.sleep(2000);

        //use findElements to click on the second click in the group which is News
        driver.findElements(By.xpath("//*[contains(@class, '_yb_sc88r')]")).get(1).click();

    }//end of main

}//end of class

