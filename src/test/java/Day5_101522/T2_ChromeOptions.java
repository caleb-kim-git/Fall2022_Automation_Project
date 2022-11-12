package Day5_101522;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_ChromeOptions {

    public static void main(String[] args) throws InterruptedException {

        //setup chromedriver with WDM
        WebDriverManager.chromedriver().setup();
        //initialize chromeoptions
        ChromeOptions options = new ChromeOptions();
        //add arguments
        options.addArguments("start-maximized","headless");
        //define the webdriver and enter the chromeoptions as a parameter
        WebDriver driver = new ChromeDriver(options);
        //go to google homepage
        driver.navigate().to("https://google.com");
        //delay
        Thread.sleep(2000);
        //search keyword in search field
        //relative xpath to locate element
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Locating Element by xpath");
        //hit submit on the google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        //delay
        Thread.sleep(2000);
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //split message to extract search number
        String[] splitResult = result.split(" ");
        System.out.println("the search number is " + splitResult [1]);
        //delay
        Thread.sleep(2000);
        driver.quit();
        //quit



    }//end of main

}//end of class
