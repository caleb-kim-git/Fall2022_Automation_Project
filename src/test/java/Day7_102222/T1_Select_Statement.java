package Day7_102222;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_Select_Statement {

    public static void main(String[] args) throws InterruptedException {

        //setup chrome driver using WDM
        WebDriverManager.chromedriver().setup();
        //declare and define a new chrome options
        ChromeOptions options = new ChromeOptions();
        //start chrome maximized
        options.addArguments("start-maximized");
        //create new chromedriver and pass options
        WebDriver driver = new ChromeDriver(options);

        //navigate to calculator website
        driver.navigate().to("https://mlcalc.com");
        //delay 2s
        Thread.sleep(2000);
        //locate and click advanced options using xpath
        driver.findElement(By.xpath("//*[text() = 'Show advanced options']")).click();
        //delay 0.5s
        Thread.sleep(500);

        //create web element set to the locator of the starting month
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
        //create a new select with locator to the web element
        Select startMonthDropDown = new Select(startMonth);
        //use select to select november by text
        startMonthDropDown.selectByVisibleText("Nov");

        //create web element set to the locator of the starting year
        WebElement startYear = driver.findElement(By.xpath("//*[@name='sy']"));
        //create a new select with locator to the web element
        Select startYearDropDown = new Select(startYear);
        //use select to select 2025 by text
        startYearDropDown.selectByVisibleText("2025");

        //can also just click on dropdown menu using xpath
        driver.findElement(By.xpath("//*[@name='sy']")).click();
        //then click the dropdown element using xpath
        driver.findElement(By.xpath("//*[text()='2025']")).click();
        //click outside the dropdown to close it
        driver.findElement(By.xpath("//*[text()='Start date:']")).click();

        //delay 2s
        Thread.sleep(2000);

        //quit the driver
        driver.quit();

    }//end of main

}//end of java class
