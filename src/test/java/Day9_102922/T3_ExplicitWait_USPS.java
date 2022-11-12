package Day9_102922;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class T3_ExplicitWait_USPS {

    public static void main(String[] args) {

        //setup chrome driver using wdm
        WebDriverManager.chromedriver().setup();
        //declare and define a new chrome options
        ChromeOptions options = new ChromeOptions();
        //start chrome maximized
        options.addArguments("start-maximized");
        //create new chromedriver and pass options
        WebDriver driver = new ChromeDriver(options);

        //navigate to metlife
        driver.navigate().to("https://metLife.com");
        //Declare the explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 20);
        //click on solutions tab using explicit condition
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'SOLUTIONS')]"))).click();

        //click on first dental link
        ArrayList<WebElement> dentalLink = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[text()='Dental']"))));
        dentalLink.get(0).click();

    }//end of main

}//end of java class
