package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_WebElement_Mlcalc {

    public static void main(String[] args) throws InterruptedException {

        //setup chromedriver with WDM
        WebDriverManager.chromedriver().setup();

        //initialize chromeoptions
        ChromeOptions options = new ChromeOptions();

        //add arguments
        options.addArguments("start-maximized");

        //define the webdriver and enter the chromeoptions as a parameter
        WebDriver driver = new ChromeDriver(options);

        //go to mlcalc.com
        driver.navigate().to("https://mlcalc.com");

        //delay
        Thread.sleep(2000);

        //locate and store purchase price field into a variable
        WebElement pPrice = driver.findElement(By.xpath("//*[@id='ma']"));
        //clear purchase price
        pPrice.clear();
        //type new value in purchase price field
        pPrice.sendKeys("500000");

        //locate down payment field and store into variable
        WebElement dPayment = driver.findElement(By.xpath("//*[@id='dp']"));
        //clear down payment
        dPayment.clear();
        //type new value in down payment
        dPayment.sendKeys("30");

    }//end of main

}//end of java class
