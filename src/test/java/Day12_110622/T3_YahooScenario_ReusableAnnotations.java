package Day12_110622;

import Reusable_Library.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3_YahooScenario_ReusableAnnotations extends Reusable_Annotations {

    @Test(priority=1)
    public void tc001_verifySignedInOptionIsChecked(){
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //next we need to click on sign in buttonz`
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='_yb_1933e']", logger, "Sign in button");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out boolean
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO, "The checkbox check condition is: " + isSignInChecked);
    }//end of test 1

    @Test(dependsOnMethods ="tc001_verifySignedInOptionIsChecked")
    public void tc002_verifySignedInOptionIsUnChecked() {
        //click the checkbox
        Reusable_Actions_Loggers.clickAction(driver, "//*[@class='stay-signed-in checkbox-container']", logger,"Sign in checkbox");
        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out boolean
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);
    }//end of test 2
}
