package Day9_102922;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Reusable_Library.Reusable_Actions.setUpDriver;

public class T4_MetLife_Reusable {

    public static void main(String[] args) throws InterruptedException{

        //call webdriver method using reusable library
        WebDriver driver = setUpDriver();

        //navigate to metlife
        driver.navigate().to("https://metLife.com");
        //Declare the explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 20);
//        //hover on solutions dropdown
//        ReusableActions.mouseHover(driver, "//*[contains(text(),'SOLUTIONS')]", "Solutions Dropdown");
        //or click on solutions dropdown
        Reusable_Actions.clickActionByIndex(driver, "//*[contains(text(),'SOLUTIONS')]", 0, "Solutions Link");
        //click on first dental link
        Reusable_Actions.clickAction(driver, "//*[text()='Dental']", "Dental link");
        //delay 2s
        Thread.sleep(2000);
        //capture the headline title
        String headlineTitle = Reusable_Actions.getTextAction(driver, "//*[@class = 'headline__title']/h2", "Headline Title");
        //print out title
        System.out.println("The headline title is " + headlineTitle);
        //quit driver
        driver.quit();

    }//end of main

}//end of java class
