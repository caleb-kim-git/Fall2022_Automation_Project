package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_WebDriverExample {

    public static void main(String[] args) throws InterruptedException {

        //define the webdriver manager setup for chromedriver
        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for test
        //creating an instance for a chrome driver (browser) to use for automation
        WebDriver driver = new ChromeDriver();

        //navigate to google website
        driver.navigate().to("https://www.google.com");
        //maximize browser window
        driver.manage().window().maximize();
//        //wait some seconds
//        Thread.sleep(3000);
//
//        //quit the chrome session
//        driver.quit();


    }//end of main

}//end of java class

