package ActionItems;

import com.fasterxml.jackson.databind.ext.Java7Support;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
public class ActionItem_3 {

    public static void main(String[] args) throws InterruptedException{

        //declare and define a new array list for zip codes
        ArrayList <String> zipCode = new ArrayList<>();
        //add three zip code values
        zipCode.add("11801");
        zipCode.add("11790");
        zipCode.add("11004");

        //setup chromedriver using WDM
        WebDriverManager.chromedriver().setup();
        //declare and define new chrome options
        ChromeOptions options = new ChromeOptions();
        //add start full screen and incognito
        options.addArguments("start-maximized","incognito");
        //declare and define new chrome driver, pass chrome options
        WebDriver driver = new ChromeDriver(options);

        //create for loop to iterate through the zip codes
        for (int i = 0; i < zipCode.size(); i++){

            //navigate to workshop locator webpage
            driver.navigate().to("https://weightwatchers.com/us/find-a-workshop");
            //delay 2s
            Thread.sleep(2000);
            //click button to find a workshop
            driver.findElement(By.xpath("//*[@data-e2e-name='find_a workshop']")).click();
            //click button for in-person
            driver.findElements(By.xpath("//*[contains(@class,'buttonText')]")).get(0).click();
            //delay 2s
            Thread.sleep(2000);
            //store location input field into a web element
            WebElement locSearch = driver.findElement(By.xpath("//*[@id='location-search']"));
            //clear the input field
            locSearch.clear();
            //enter the i'th index of zipCode as input
            locSearch.sendKeys(zipCode.get(i));
            //hit the search arrow
            driver.findElement(By.xpath("//*[contains(@class,'rightArrow')]")).click();
            //delay 2s
            Thread.sleep(2000);

            //store studio links as a WebElement Array List
            ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class,'wrapperLink')]")));
            //conditional statement to click on studio links
            if (i==0) {
                links.get(1).click();
            } else if (i==1) {
                links.get(2).click();
            } else {
                links.get(0).click();
            }
            //delay 2s
            Thread.sleep(2000);

            //No relative xpath to grab addresses, use absolute
            WebElement addressOne = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div[2]/div/div[2]/div[1]/div[1]"));
            WebElement addressTwo = driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div[2]/div/div[2]/div[1]/div[2]"));
            //combine address elements into one
            String address = addressOne.getText() + ", " + addressTwo.getText();
            //print out the address
            System.out.println("Weight watchers near " + zipCode.get(i) + ": " + address);

            //define Javascript Executor
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            //store schedule into a web element
            WebElement scheduleSection = driver.findElement(By.xpath("//*[@id='studioWorkshopSchedule']"));
            //scroll into view of schedule
            jse.executeScript("arguments[0].scrollIntoView(true);", scheduleSection);
            //delay 2s
            Thread.sleep(2000);
            //store table of days and hours into web element
            WebElement scheduleInfoTable = driver.findElements(By.xpath("//*[contains(@class,'scheduleContainer')]")).get(0);
            //get the text to print the table
            System.out.println("In-person Studio Workshop Schedule:");
            System.out.println(scheduleInfoTable.getText());
            //separate with empty line
            System.out.println("");

        }//end for loop

        //quit the driver
        driver.quit();

    }//end of main

}//end of java class
