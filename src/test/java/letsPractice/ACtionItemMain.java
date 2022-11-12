package letsPractice;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ACtionItemMain {

    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

    @Test(priority = 1)
    public void employerAndPlan() throws InterruptedException{
        //navigate to UHC.com
        driver.navigate().to("https://www.UHC.com");
        //delay 2s
        Thread.sleep(2000);
        //click on "Find a doctor"
        driver.findElement(By.xpath("//*[@aria-label='Find a doctor']")).click();
        //close pop-up box
        driver.findElement(By.xpath("//*[@id='ip-no']")).click();
        //click the "Find a dentist" link
        driver.findElement(By.xpath("//*[text()='Find a dentist']")).click();
        //delay 2s
        Thread.sleep(2000);
        //switch into new tab
        Reusable_Actions.switchToTabByIndex(driver, 1);
        //click on "Employer and Individual Plans"
        driver.findElement(By.xpath("//*[@class='imgBox']")).click();
    }

    @Test (priority = 2)
    public void zipCodeClick() throws InterruptedException{
        //enter a zip code in the input field
        driver.findElement(By.xpath("//*[@id='location']")).sendKeys("11803");
        //delay for 2s
        Thread.sleep(2000);
        //click on the "Continue button"
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        //delay for 2s
        Thread.sleep(2000);
        //click on National Options PPO
        driver.findElement(By.xpath("//*[text()='*National Options PPO 30']")).click();
        //delay for 20s
        Thread.sleep(10000);
        //refresh the page
        driver.navigate().refresh();
        //delay for 2s
        Thread.sleep(2000);
        //click on "General Dentists"
        driver.findElement(By.xpath("//*[@data-test-id='GeneralDentists']")).click();
        //delay for 2s
        Thread.sleep(2000);

    }

    @Test (priority = 3)
    public void getInformation() throws InterruptedException{
        //select a mile from dropdown menu
        Reusable_Actions.selectByText(driver, "//*[@data-test-id='radius-miles-dropdown']", "distanceDropDown", "Within 1 Mile");
        //delay for 10s
        Thread.sleep(10000);
        //refresh the page
        driver.navigate().refresh();
        //click the first doctor
        driver.findElements(By.xpath("//*[@data-test-id='provider-name-link']")).get(0).click();
        //click on the save button
        driver.findElements(By.xpath("//*[@data-test-id='provider-name-link']")).get(0).click();
        Thread.sleep(1000);
        //capture text  of address, miles away, and network type (in/out)
        String addressValue = Reusable_Actions.getTextActionByIndex(driver,"//*[@data-test-id='provider-address']", 1,"Address");
        String milesValue = Reusable_Actions.getTextActionByIndex(driver, "//*[@data-test-id='distance-away']", 0, "Distance");
        String networkValue =  Reusable_Actions.getTextActionByIndex(driver,"//*[@class='status-label']", 2, "Network Type");
        //print out all three variables
        System.out.println("Address: " + addressValue );
        System.out.println("Miles: " + milesValue );
        System.out.println("Network: " + networkValue );
        //close the tab
        driver.close();
    }
    @Test (priority = 4)
    public void searchNumber() {
        //switch to default tab
        Reusable_Actions.switchToTabByIndex(driver,0);
        //enter "doctor" in search field top right
        Reusable_Actions.sendKeysAction(driver, "//*[@id='search-desktop']", "doctor","Search Field");
        //submit the entry
        Reusable_Actions.submitAction(driver, "//*[@id='search__button-desktop']","Search Submit");
        //capture the text
        String searchResult = Reusable_Actions.getTextAction(driver, "//*[@id='search-results-count__header']", "Search Result");
        //split the results in linear array to isolate numbers
        String[] splitResult = searchResult.split("result");
        //get the 1st item, 0th index
        String resultNumber = splitResult[0];
        //print out the result number
        System.out.println(resultNumber);
    }

}
