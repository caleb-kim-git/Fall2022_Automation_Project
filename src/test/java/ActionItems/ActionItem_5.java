package ActionItems;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ActionItem_5 {

    WebDriver driver;

    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setUpDriver();
    }//end of set driver method

    @AfterSuite
    public void quitTheSession(){
        driver.quit();
    }//end of after suite

    @Test (priority = 1)
    public void employerAndPlan() throws InterruptedException{
        //navigate to UHC.com
        driver.navigate().to("https://www.UHC.com");
        //delay 2s
        Thread.sleep(2000);
        //click on "Find a doctor"
        Reusable_Actions.clickAction(driver,"//*[@aria-label='Find a doctor']","Find a Doctor");
        //close pop-up box
        Reusable_Actions.clickPopUpElement(driver, "//*[@id='ip-no']","Pop Up Box");
        //scroll into "Find a dentist" link
        Reusable_Actions.scrollByView(driver, "//*[text()='Find a dentist']", "Find a Dentist");
        //click the "Find a dentist" link
        Reusable_Actions.clickAction(driver,"//*[text()='Find a dentist']","Find a Dentist");
        //delay 2s
        Thread.sleep(2000);
        //switch into new tab
        Reusable_Actions.switchToTabByIndex(driver, 1);
        //click on "Employer and Individual Plans"
        Reusable_Actions.clickActionByIndex(driver,"//*[@class='imgBox']",0, "E and I plans");
    }

    @Test (dependsOnMethods = "employerAndPlan")
    public void zipCodeClick() throws InterruptedException{
        //enter a zip code in the input field
        Reusable_Actions.sendKeysAction(driver,"//*[@id='location']", "11358", "Zip Code Field");
        //delay for 2s
        Thread.sleep(2000);
        //click on the "Continue button"
        Reusable_Actions.clickAction(driver,"//*[@type='submit']","Continue Button");
        //click on National Options PPO
        Reusable_Actions.clickAction(driver,"//*[contains(text(),'National Options PPO 30')]","National Options PPO");
        //delay for 3s
        Thread.sleep(3000);
        //refresh the page because it's blank
        ArrayList<WebElement> displayedElement = new ArrayList<>(driver.findElements(By.xpath("//*[@data-test-id='GeneralDentists']")));
        while (displayedElement.size() == 0 ) {
            Thread.sleep(2000);
            driver.navigate().refresh();
            Thread.sleep(2000);
            displayedElement = new ArrayList<>(driver.findElements(By.xpath("//*[@data-test-id='GeneralDentists']")));

        }
        //delay for 3s

        //click on Change location
        Reusable_Actions.clickAction(driver,"//*[@id='changeLocationBtn']","Change Location");
        //type in zip code again
        Reusable_Actions.sendKeysAction(driver,"//*[@id='location']","11358","Zip Code Field Again");
        //delay for 2s
        Thread.sleep(2000);
        //click on Update Location
        Reusable_Actions.clickAction(driver,"//*[@cs-id='locationSubmit']","Update Location");
        //click on "General Dentists"
        Reusable_Actions.clickAction(driver,"//*[@data-test-id='GeneralDentists']","General Dentists");
        //delay for 2s
        Thread.sleep(2000);
    }

    @Test (dependsOnMethods = "zipCodeClick")
    public void getInformation() throws InterruptedException{
        //select a mile from dropdown menu
        Reusable_Actions.selectByText(driver, "//*[@data-test-id='radius-miles-dropdown']", "distanceDropDown", "Within 1 Mile");
        //get text of result number
        String numOfProviders = Reusable_Actions.getTextAction(driver, "//*[@data-test-id='total-search-results']","Number of Providers");
        //refresh until glitch resolves
        Reusable_Actions.loopUntilTextChanges(driver,numOfProviders,"//*[@data-test-id='total-search-results']");
        //click the first doctor
        Reusable_Actions.clickActionByIndex(driver, "//*[@data-test-id='provider-name-link']", 0, "First doctor name");
        //click on the save button
        Reusable_Actions.clickActionByIndex(driver, "//*[@data-test-id='saved-provider-button']",0, "Save");
        //delay for 2s
        Thread.sleep(2000);
        //capture text  of address, miles away, and network type (in/out)
        String addressValue = Reusable_Actions.getTextActionByIndex(driver,"//*[@data-test-id='provider-address']", 1,"Address");
        String milesValue = Reusable_Actions.getTextActionByIndex(driver, "//*[@data-test-id='distance-away']", 0, "Distance");
        String networkValue =  Reusable_Actions.getTextActionByIndex(driver,"//*[@class='status-label']", 2, "Network Type");
        //print out all three variables
        System.out.println("Address: " + addressValue + "\n" + "Miles: " + milesValue + "\n" + "Network: " + networkValue );
        //close the tab
        driver.close();
    }

    @Test (dependsOnMethods = "getInformation")
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
        System.out.println("Search Results: " + resultNumber);
    }

}//end of java class
