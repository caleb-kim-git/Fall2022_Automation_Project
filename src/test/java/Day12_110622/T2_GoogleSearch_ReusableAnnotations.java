package Day12_110622;

import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class T2_GoogleSearch_ReusableAnnotations extends Reusable_Annotations {

    @Test
    public void searchForBMW(){
        //navigate to google.com
        driver.navigate().to("https://www.google.com");
        //search for BMW in the search field
        Reusable_Actions_Loggers.sendKeysAction(driver,"//*[@name='q']","BMW",logger,"Search Field");
        //hit submit on google search button
        Reusable_Actions_Loggers.submitAction(driver,"//*[@name='btnK']",logger,"Google Search Button");
    }//end of test 1

    @Test (dependsOnMethods = "searchForBMW")
    public void captureSearchNumber(){
        //capture the search results test
        String results = Reusable_Actions_Loggers.getTextAction(driver,"//*[@id='result-stats']",logger,"Search Results");
        String[] arrayResult = results.split(" ");
        //print back to html by using log info
        logger.log(LogStatus.INFO,"Search number for BMW is " + arrayResult[1]);
    }//end of Test 2

}
