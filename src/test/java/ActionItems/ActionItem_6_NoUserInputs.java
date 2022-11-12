package ActionItems;

import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ActionItem_6_NoUserInputs extends Reusable_Annotations {

    @Test(priority=1)
    public void tc001_findWaysToWaiveMonthlyFee() throws InterruptedException {
        //navigate to Truist homepage
        driver.navigate().to("https://www.truist.com");
        //click on "Checking and Savings" header
        Reusable_Actions_Loggers.clickActionByIndex(driver, "//*[@class='truist-globalnav-header-linktext']",0,logger,"Checking Savings Header");
        //delay 1s
        Thread.sleep(1000);
        //click on "Truist One Checking" in the menu
        Reusable_Actions_Loggers.clickAction(driver,"//*[@data-wa-linkname='Truist One Checking']",logger,"Truist One Checking");
        //click on underlined text "five ways to waive"
        Reusable_Actions_Loggers.clickAction(driver, "//*[@data-wa-linkname='Here are five ways to waive the fee.']", logger, "Fee Waive Info");
        //delay 1s
        Thread.sleep(1000);
        //Check third bullet point
        String bulletPointThree = Reusable_Actions_Loggers.getTextAction(driver,"//*[contains(text(),'Having a personal')]",logger,"Third Bullet Point");
        //log the bullet point
        logger.log(LogStatus.INFO,"The Third Bullet point states: " + bulletPointThree);
        //close the popup box by clicking the "X"
        Reusable_Actions_Loggers.clickAction(driver, "//*[@data-name='Path 25']",logger, "X button");
    }//end of test case 1

    @Test (priority=2)
    public void tc002_customizeDebitCardImage() throws InterruptedException {
        //navigate to Truist homepage
        driver.navigate().to("https://www.truist.com");
        //click on "Checking and Savings" header
        Reusable_Actions_Loggers.clickActionByIndex(driver, "//*[@class='truist-globalnav-header-linktext']",0,logger,"Checking Savings Header");
        //delay 1s
        Thread.sleep(1000);
        //click on "Debit Cards"
        Reusable_Actions_Loggers.clickAction(driver,"//*[@data-wa-linkname='Debit cards']",logger,"Debit Cards");
        //click on Personalize your debit card
        Reusable_Actions_Loggers.clickAction(driver,"//*[@href='/checking/card-personalization']",logger,"Personalize link");
        //click on Start Designing Button
        Reusable_Actions_Loggers.clickAction(driver, "//*[@data-wa-component='Customize your debit card.']",logger,"Start Designing");
        //click on "Gallery" under Image Type
        Reusable_Actions_Loggers.clickAction(driver,"//*[@for='cardType-01']/p",logger,"Gallery");
        //click on Landscape button
        Reusable_Actions_Loggers.mouseClickAction(driver,"//*[@class='icon-card-h']",logger,"Landscape");
        //delay 1s
        Thread.sleep(1000);
        //select a category in the drop-down select element
        Reusable_Actions_Loggers.selectByText(driver,"//*[@id='imgLibrary']","Works of Art",logger,"Choose Category");
        //click on the 6th image
        Reusable_Actions_Loggers.clickActionByIndex(driver,"//*[@id='thumbnailbox']/div",5,logger,"Images");
        //click on continue button
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class='primary']",logger,"Continue button");
        //click on continue again
        Reusable_Actions_Loggers.clickAction(driver,"//*[@class='primary button conditional']",logger,"Continue button 2");
        //click on "No" radio button
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='clientNo']",logger,"No Button");
        //delay 1s
        Thread.sleep(1000);
        //Capture text of message when clicking "No"
        String noMessage = Reusable_Actions_Loggers.getTextAction(driver,"//*[@class='form-row']/p",logger,"No Message");
        //log the message
        logger.log(LogStatus.INFO, "User without bank account will be shown message: " + noMessage);
    }//end of test case 2

    @Test (priority=3)
    public void tc003_checkingAndSavingsDropDownFunction() throws InterruptedException {
        //navigate to Truist homepage
        driver.navigate().to("https://www.truist.com");
        //click on "Checking and Savings" header
        Reusable_Actions_Loggers.clickActionByIndex(driver, "//*[@class='truist-globalnav-header-linktext']",0,logger,"Checking Savings Header");
        //delay 1s
        Thread.sleep(1000);
        //Array List of each clickable link in that header
        ArrayList <WebElement> checkingSavingsLinks = Reusable_Actions_Loggers.arrayListOfElements(driver,"//*[@class='truist-globalnav-dropdown-menu show']//li/a",logger, "Checking and Savings Header Links");
        //re-click on "Checking and Savings" header
        Reusable_Actions_Loggers.clickActionByIndex(driver, "//*[@class='truist-globalnav-header-linktext']",0,logger,"Checking Savings Header");
        //for loop to click on each element in the dropdown menu
        for (int i=0;i<checkingSavingsLinks.size();i++){
            //click on "Checking and Savings" header
            Reusable_Actions_Loggers.clickActionByIndex(driver, "//*[@class='truist-globalnav-header-linktext']",0,logger,"Checking Savings Header");
            //delay 1s
            Thread.sleep(1000);
            //click on ith index link
            Reusable_Actions_Loggers.clickActionByIndex(driver,"//*[@class='truist-globalnav-dropdown-menu show']//li/a",i,logger,"Checking and Savings Header Link");
        }//end of for loop
    }//end of test case 3

    @Test (priority=4)
    public void tc004_goToQuickenWebsite() throws InterruptedException {
        //navigate to Truist homepage
        driver.navigate().to("https://www.truist.com");
        //click on "Checking and Savings" header
        Reusable_Actions_Loggers.clickActionByIndex(driver, "//*[@class='truist-globalnav-header-linktext']",0,logger,"Checking Savings Header");
        //delay 1s
        Thread.sleep(1000);
        //click on "Online and mobile banking"
        Reusable_Actions_Loggers.clickAction(driver,"//*[@data-wa-linkname='Online & mobile banking']",logger,"Online and Mobile");
        //scroll to "Manage your money like a pro" section
        Reusable_Actions_Loggers.scrollByView(driver,"//*[text()='Manage your money like a pro.']",logger,"Quicken Section");
        //click on Quicken tab
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='quicken']",logger,"Quicken Tab");
        //declare arraylist of quicken download links and another for the element name
        ArrayList <String> quickenDownloadLinks= new ArrayList<>();
        ArrayList <String> quickenDownloadLinksName= new ArrayList<>();
        //add xpaths to the first array list
        quickenDownloadLinks.add("//*[text()='Quicken for Mac']");
        quickenDownloadLinks.add("//*[text()='Quicken Deluxe for Windows']");
        //add element names for them
        quickenDownloadLinksName.add("Mac Link");
        quickenDownloadLinksName.add("Deluxe Link");
        //click on QuickBooks tab
        Reusable_Actions_Loggers.clickAction(driver,"//*[@id='quicken']",logger,"QuickBooks Tab");
        //declare arraylist of quickbooks download links and another for the element name
        ArrayList <String> quickBooksDownloadLinks= new ArrayList<>();
        ArrayList <String> quickBooksDownloadLinksName= new ArrayList<>();
        //add xpaths to the first array list
        quickBooksDownloadLinks.add("//*[contain(text(),'QuickBooks Desktop Pro 2021')]");
        quickBooksDownloadLinks.add("//*[contains(text(),'QuickBooks Desktop Premier')]");
        //add element names for them
        quickBooksDownloadLinksName.add("Desktop Pro Link");
        quickBooksDownloadLinksName.add("Desktop Premier Link");
        Thread.sleep(1000);
        //for loop to click a Quicken Tab
        for (int i =0;i<quickBooksDownloadLinks.size();i++) {
            //click the ith header
            Reusable_Actions_Loggers.clickActionByIndex(driver, "//*[@class='ori-tabs__list js-ori-tabs__list']/li", i, logger, "Quick Tabs");
            //for loop to click the links
            if (i == 0) {
                for (int j = 0; j < quickenDownloadLinks.size(); j++) {
                    //click the ith index link
                    Reusable_Actions_Loggers.clickAction(driver, quickenDownloadLinks.get(i), logger, quickenDownloadLinksName.get(i));
                    //switch to new tab
                    Reusable_Actions_Loggers.switchToTabByIndex(driver, 1, logger);
                    //click the continue button
                    Reusable_Actions_Loggers.clickAction(driver, "//*[@id='speedbump-continue']", logger, "Continue button");
                    //log that link was clicked
                    logger.log(LogStatus.INFO, "Sent to Quicken Website after clicking Continue");
                    //exit the tab
                    driver.close();
                    //switch back to tab index 0
                    Reusable_Actions_Loggers.switchToTabByIndex(driver, 0, logger);
                }//end of nested for loop
            } else {
                for (int j = 0; j < quickBooksDownloadLinks.size(); j++) {
                    //click the ith index link
                    Reusable_Actions_Loggers.clickAction(driver, quickBooksDownloadLinks.get(i), logger, quickenDownloadLinksName.get(i));
                    //switch to new tab
                    Reusable_Actions_Loggers.switchToTabByIndex(driver, 1, logger);
                    //click the continue button
                    Reusable_Actions_Loggers.clickAction(driver, "//*[@id='speedbump-continue']", logger, "Continue button");
                    //log that link was clicked
                    logger.log(LogStatus.INFO, "Sent to QuickBooks Website after clicking Continue");
                    //exit the tab
                    driver.close();
                    //switch back to tab index 0
                    Reusable_Actions_Loggers.switchToTabByIndex(driver, 0, logger);
                }//end of nested for loop
            }//end of conditional
        }//end of for loop
    }//end of test case 4

}//end of java class
