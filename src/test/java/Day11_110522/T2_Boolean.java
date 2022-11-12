package Day11_110522;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_Boolean {

    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

    //verify that by default the signed in option is checked
    @Test(priority=1)
    public void tc001_verifySignedInOptionIsChecked(){
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //next we need to click on sign in buttonz`
        Reusable_Actions.clickAction(driver, "//*[@class='_yb_1933e']", "Sign in button");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out boolean
        System.out.println("The checkbox check condition is: " + isSignInChecked);

    }//end of test 1

    @Test(dependsOnMethods ="tc001_verifySignedInOptionIsChecked")
    public void tc002_verifySignedInOptionIsUnChecked() {
        //click the checkbox
        Reusable_Actions.clickAction(driver, "//*[@class='stay-signed-in checkbox-container']", "Sign in checkbox");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out boolean
        System.out.println("The checkbox check condition is: " + isSignInChecked);

    }//end of test 2

}//end of class
