package Day6_101622;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_mlcalc_forloop {

    public static void main(String[] args) throws InterruptedException {

        //setup chromedriver with WDM
        WebDriverManager.chromedriver().setup();

        //initialize chromeoptions
        ChromeOptions options = new ChromeOptions();

        //add arguments
        options.addArguments("start-maximized");

        //define the webdriver and enter the chromeoptions as a parameter
        WebDriver driver = new ChromeDriver(options);

        //create arraylists for purchase price, down payment, and interest rate
        ArrayList<String> pPrice, dPayment, intRate;
        pPrice = new ArrayList<>();
        pPrice.add("439843");
        pPrice.add("938540");
        pPrice.add("694730");

        //dPayment
        dPayment = new ArrayList<>();
        dPayment.add("30");
        dPayment.add("35");
        dPayment.add("32");

        //intRate
        intRate = new ArrayList<>();
        intRate.add("4.2");
        intRate.add("2.8");
        intRate.add("3.1");

        //for loop to add items from arraylists
        for (int i=0;i<intRate.size();i++) {

            //go to mlcalc.com
            driver.navigate().to("https://mlcalc.com");

            //delay
            Thread.sleep(2000);

            //clear and enter new value for purchase price
            WebElement purchasePrice = driver.findElement(By.xpath("//*[@id='ma']"));
            //clear the field
            purchasePrice.clear();
            //enter i'th index of array
            purchasePrice.sendKeys(pPrice.get(i));

            //clear and enter new value for down payment
            WebElement downPayment = driver.findElement(By.xpath("//*[@id='dp']"));
            //clear the field
            downPayment.clear();
            //enter i'th index of array
            downPayment.sendKeys(dPayment.get(i));

            //clear and enter new value for interest rate
            WebElement interestRate = driver.findElement(By.xpath("//*[@id='ir']"));
            //clear the field
            interestRate.clear();
            //enter i'th index of array
            interestRate.sendKeys(intRate.get(i));

            //click on calculate button
            driver.findElement(By.xpath("//*[@value = 'Calculate']")).click();

            //delay
            Thread.sleep(2000);

            //capture and print monthly value
            String mthPayment = driver.findElements(By.xpath("//*[@style='font-size: 32px']")).get(0).getText();
            System.out.println("The monthly payment is: " + mthPayment);


        }//end of for loop

        //quit driver
        driver.quit();

    }//end of main

}//end of java class
