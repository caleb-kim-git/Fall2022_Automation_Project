package Day4_100922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T4_GoogleSearch_DataDrivenTesting {

    public static void main(String[] args) throws InterruptedException {

        //ArrayList for cars
        ArrayList<String> cars = new ArrayList<>();
        cars.add("Audi");
        cars.add("BMW");
        cars.add("Lexus");

        //define the webdriver manager setup for chrome driver

        WebDriverManager.chromedriver().setup();
        //define the chrome driver to use for your test
        WebDriver driver = new ChromeDriver();

        for (int i=0;i<cars.size();i++) {

            //navigate to google website
            driver.navigate().to("https://www.google.com");
            //maximize window
            driver.manage().window().maximize();

            //sleep statement
            Thread.sleep(3000);

            //search a keyword in search field
            //relative xpath to locate element

            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cars.get(i));
            //hit submit on the google search button

            driver.findElement(By.xpath("//*[@name='btnK']")).submit();

            //sleep statement
            Thread.sleep(3000);

            //capture search text result
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();

            //split message to extract the search number

            String[] splitResult = result.split(" ");

            System.out.println("the search number for " + cars.get(i) + " is " + splitResult[1]);

        }//end of for loop

        //quit driver to end session after loop
        driver.quit();

    }//end of main

}//end of java class

