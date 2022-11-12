package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearchExample {

    public static void main(String[] args) throws InterruptedException {

        //define the webdriver manager for chrome driver
        WebDriverManager.chromedriver().setup();
        //define the chromedriver to use for test
        //creating an instance for a chrome driver (browser) to use for automation
        WebDriver driver = new ChromeDriver();

        //navigate to google website
        driver.navigate().to("https://www.google.com");

        //maximize window
        driver.manage().window().maximize();

        //sleep statement
        Thread.sleep(2000);

        //search keyword in search field
        //relative xpath to locate element
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Locating Element by xpath");
        //hit submit on the google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //sleep statement which helps loading and delay
        Thread.sleep(3000);

        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //split message to extract search number
        String[] splitResult = result.split(" ");
        System.out.println("the search number is " + splitResult [1]);

        Thread.sleep(2000);
        driver.quit();
    }//end of main

}//end of java class

