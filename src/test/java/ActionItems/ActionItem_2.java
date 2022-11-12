package ActionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ActionItem_2 {

    public static void main(String[] args) throws InterruptedException {

        //Create ArrayList for hobbies after one value works
        ArrayList <String> hobbies = new ArrayList<>();
        //add hobbies to ArrayList
        hobbies.add("jigsaw puzzles");
        hobbies.add("stargazing");
        hobbies.add("wine tasting");
        hobbies.add("glassblowing");

        //set up the chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        //define a new chromedriver for our test
        WebDriver driver = new ChromeDriver();
        //maximize the window
        driver.manage().window().maximize();

        //create a for loop to use each item in the ArrayList
        for (int i=0; i<hobbies.size();i++) {

            //starting point is bing.com
            driver.navigate().to("https://bing.com");
            //delay to load site
            Thread.sleep(3000);
            //use relative xpath to locate the search field
            //enter the current array item into search field
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(hobbies.get(i));
            //submit after finding the relative xpath of the search icon/button
            driver.findElement(By.xpath("//*[@viewBox='0 0 25 25']")).submit();
            //delay to load page
            Thread.sleep(3000);
            //store the number of search results into a string variable
            String searchResult = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //turn the String into a linear array using split
            String[] searchArray = searchResult.split(" ");
            //print out the first item of the array which is the number
            System.out.println("The search number for " + hobbies.get(i) + " is " + searchArray[0]);

        }//end of for loop

        //quit the driver
        driver.quit();

    }//end of main

}//end of java class
