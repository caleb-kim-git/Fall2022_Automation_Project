package letsPractice;

import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class practicecode extends Reusable_Annotations {
    @Test(priority = 1)
    public void tc001_verifyYahooPageTitle() throws InterruptedException {
        //first navigate to yahoo homepage
        driver.navigate().to("https://www.pnc.com/en/personal-banking/borrowing/private-student-loans/refinance-student-loans.html?lnksrc=topnav");
        Reusable_Actions_Loggers.scrollByView(driver,"//*[@id='lf_tool_frame']",logger,"UG");
        driver.switchTo().frame("lf_tool_frame");
        Thread.sleep(3000);
        Reusable_Actions_Loggers.clickActionByIndex(driver,"//*[@class='lf-step-field-box-label ng-binding']",1,logger,"UG");
        Thread.sleep(3000);
        ArrayList <String> numbers = new ArrayList<>();
        numbers.add("40000");
        numbers.add("4545");
        numbers.add("6.50%");
        for (int i = 0;i<3;i++) {
            WebElement something = driver.findElements(By.xpath("//*[@ng-repeat='field in steps[stepIndex].fields']//input")).get(i);
            something.sendKeys(Keys.CONTROL, "a");
            something.sendKeys(numbers.get(i));
        }
        Thread.sleep(5000);
    }//end of test 1


}
