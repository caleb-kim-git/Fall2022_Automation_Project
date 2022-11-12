package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_XpathTextContains {

    public static void main(String[] args) throws InterruptedException {

        //setup chromedriver using WDM
        WebDriverManager.chromedriver().setup();
        //define the new webdriver
        WebDriver driver = new ChromeDriver();
        //go to yahoo.com
        driver.navigate().to("https://yahoo.com");
        //maximize the window
        //driver.manage().window().maximize();
        //use xpath text() to find the sign in button
        //click the signin button
        driver.findElement(By.xpath("//*[text() = 'Sign in']")).click();
        //2 second delay
        Thread.sleep(2000);
        //go back to home page
        driver.navigate().to("https://yahoo.com");
        //2 second delay
        Thread.sleep(2000);
        //click the bell icon
        driver.findElement(By.xpath("//*[contains(@class,'rapid-nonanchor')]")).click();
        //2 sec delay
        Thread.sleep(2000);
        //quit the driver
        driver.quit();

    }//end of main

}//end of java class
