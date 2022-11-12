package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class Reusable_Annotations {

    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void setTheDriver() {
        driver = Reusable_Actions.setUpDriver();
        //set the report path here
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report.html",true);
    }//end of Before Suite

    @BeforeMethod
    public void captureTestName (Method testName){
        //before every test, this method will be called and take the name of your test,
        //and it will add your test method name to the html report
        logger = reports.startTest(testName.getName());

    }//end of Before Method

    @AfterMethod
    public void endLogger(){
        //
        reports.endTest(logger);
    }//end of After Method

    @AfterSuite
    public void quitSession() {
        driver.quit();
        //writing back to html report
        reports.flush();
    }//end of After Suite

}//end of java class
