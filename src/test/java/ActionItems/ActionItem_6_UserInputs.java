package ActionItems;

import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ActionItem_6_UserInputs extends Reusable_Annotations {


    @Test (priority=1)
    public void tc005_useSavingsCalculator() throws InterruptedException {
        //navigate to Truist homepage
        driver.navigate().to("https://www.truist.com");
        //click on "Checking and Savings" header
        Reusable_Actions_Loggers.clickActionByIndex(driver, "//*[@class='truist-globalnav-header-linktext']",0,logger,"Checking Savings Header");
        //delay 1s
        Thread.sleep(1000);
        //click on "Truist One Savings"
        Reusable_Actions_Loggers.clickAction(driver,"//*[@data-wa-linkname='Truist One Savings']",logger,"Truist One Savings");
        //scroll into view of Savings Calculator
        Reusable_Actions_Loggers.scrollByView(driver, "//*[text()='Savings calculator']", logger, "Savings Calculator");
        //switch to the calculator frame
        driver.switchTo().frame("calculator_frame");
        //delay 1s
        Thread.sleep(1000);
        ArrayList<String> inputValues = new ArrayList();
        inputValues.add("100000");
        inputValues.add("10000");
        inputValues.add("20");
        inputValues.add("6");
        inputValues.add("0.10");
        //for loop to enter something in each input field
        for (int i =0; i<inputValues.size();i++){
            //enter inputs in corresponding input fields
            Reusable_Actions_Loggers.clearAndSendKeysActionByIndex(driver,"//*[@class='lf-input-comma']",inputValues.get(i),i,logger,"Calculator Input Fields");
            //click on the chart to update the results
            if (i == (inputValues.size()-1)){
                Reusable_Actions_Loggers.clickAction(driver,"//*[@class='highcharts-root']",logger,"Chart");
            }//end of if statement
        }//end of for loop
        //delay 2s
        Thread.sleep(2000);
        //capture the monthly deposit to reach goal
        String monthlyDeposit = Reusable_Actions_Loggers.getTextAction(driver,"//*[@id='lf_answer_heading']",logger,"Monthly Deposit Number");
        //split to grab only the $amount
        String[] splitMD = monthlyDeposit.split(" ");
        //log this number should be equal to $361
        logger.log(LogStatus.INFO,"The monthly deposit needed to reach the goal based on the inputs is: "+ splitMD[5]);
    }//end of test case 2


    @Test (priority=2)
    public void tc006_appointmentScheduler() throws InterruptedException {
        //navigate to Truist homepage
        driver.navigate().to("https://www.truist.com");
        //click on "Checking and Savings" header
        Reusable_Actions_Loggers.clickActionByIndex(driver, "//*[@class='truist-globalnav-header-linktext']", 0, logger, "Checking Savings Header");
        //delay 1s
        Thread.sleep(1000);
        //click on "Premier Banking"
        Reusable_Actions_Loggers.clickAction(driver, "//*[@data-wa-linkname='Premier banking']", logger, "Premier Banking");
        //scroll into "Let's Talk" button
        Reusable_Actions_Loggers.scrollByView(driver,"//*[contains(text(),\"Let's talk\")]",logger, "Let's talk button");
        //click on "Let's Talk" button
        Reusable_Actions_Loggers.clickAction(driver,"//*[contains(text(),\"Let's talk\")]",logger,"Let's talk button");
        //switch into second tab
        Reusable_Actions_Loggers.switchToTabByIndex(driver,1,logger);
        //Array List of check box elements
        ArrayList <WebElement> appointmentCheckBoxes = new ArrayList<>(Reusable_Actions_Loggers.arrayListOfElements(driver,"//*[@class='slds-form-element__control']/span/label",logger,"Check Box Appointments"));
        //for loop to select all checkboxes
        for (int i =0; i<appointmentCheckBoxes.size();i++){
            //click on each check box
            Reusable_Actions_Loggers.clickActionByIndex(driver,"//*[@class='slds-form-element__control']/span/label",i,logger,"Check Box Appointment");
        }
        //Enter something in the "Other" input field
        Reusable_Actions_Loggers.clearAndSendKeysAction(driver,"//*[@class='slds-input']","Should I declare bankruptcy",logger,"Other Input");
        //Click the "Next" Button
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class='slds-button slds-button_brand']",logger,"Next Button");
        //Click the "Video Conference Option
        Reusable_Actions_Loggers.clickAction(driver,"//*[contains(@class,'slds-icon-utility-video')]",logger,"Video Conference Icon");
        //Click the "Next" Button
        Reusable_Actions_Loggers.clickAction(driver,"//*[contains(@class,'flow-button__NEXT')]",logger,"Next Button");
        //Enter zipcode into address field
        Reusable_Actions_Loggers.clearAndSendKeysActionByIndex(driver,"//*[@role='combobox']","New Jersey",0,logger,"Address Field");
        //Click the first option
        Reusable_Actions_Loggers.clickActionByIndex(driver,"//*[@class='lookup__list  visible']/li",0,logger,"First Location Option");
        //Click "Within" Dropdown
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class='slds-pill__label slds-form-element']",logger,"Within Dropdown");
        //Click "50 Miles" option
        Reusable_Actions_Loggers.clickAction(driver,"//*[@title='50 miles']",logger,"50 Miles Option");
        //Capture name of the first option
        String nameOfEmployee = Reusable_Actions_Loggers.getTextActionByIndex(driver,"//*[contains(@class,'x-small slds-truncate')]",0,logger,"First Option Name");
        //Capture address of first option
        String addressOfEmployee = Reusable_Actions_Loggers.getTextActionByIndex(driver,"//*[@class='slds-text-title']/lightning-formatted-address",0,logger,"First Option Address");
        //log all three variables
        logger.log(LogStatus.INFO,nameOfEmployee + " is located at: " + addressOfEmployee );
        //Click the first option
        Reusable_Actions_Loggers.clickActionByIndex(driver,"//*[contains(@class,'x-small slds-truncate')]",0,logger,"First Option");
        //Click the next button
        Reusable_Actions_Loggers.clickAction(driver,"//*[contains(@class,'flow-button__NEXT')]",logger,"Next Button");
        //Click Select Timezone Dropdown
        Reusable_Actions_Loggers.clickAction(driver,"//*[text()='Select an option']",logger,"Select Timezone Dropdown");
        //Click the one that is EST
        Reusable_Actions_Loggers.clickAction(driver,"//*[contains(@data-value,'Eastern Standard Time')]",logger,"EST Timezone");
        //delay 1s
        Thread.sleep(1000);
        //Click on Next Day
        Reusable_Actions_Loggers.clickAction(driver,"//*[@title='Next Day']",logger,"Next Day Button");
        //delay 1s
        Thread.sleep(1000);
        //Get text of the 2nd time slot
        String secondTimeSlot = Reusable_Actions_Loggers.getTextActionByIndex(driver,"//*[@class='slds-list__item slds-m-around_small']/button",1,logger,"2nd time slot");
        //log the time slot
        logger.log(LogStatus.INFO, "The second time slot is: " + secondTimeSlot);
        //click the 2nd time slot
        Reusable_Actions_Loggers.clickActionByIndex(driver,"//*[@class='slds-list__item slds-m-around_small']",1,logger,"2nd time slot");
        //Click the next button
        Reusable_Actions_Loggers.clickAction(driver,"//*[contains(@class,'flow-button__NEXT')]",logger,"Next Button");
        //Capture text of the form title
        String formTitle = Reusable_Actions_Loggers.getTextAction(driver,"//*[text()='Please enter your contact information']",logger,"Contact Information Form");
        //log that user has arrived at this form
        logger.log(LogStatus.INFO,"The title of the form is: "+ formTitle);
    }//end of test case 6

}//end of java class
