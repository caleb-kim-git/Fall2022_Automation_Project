package Day8_102322;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class T2_ActionItem {

    public static void main(String[] args) throws InterruptedException {

        //setup chrome driver using wdm
        WebDriverManager.chromedriver().setup();
        //declare and define a new chrome options
        ChromeOptions options = new ChromeOptions();
        //start chrome maximized
        options.addArguments("start-maximized");
        //create new chromedriver and pass options
        WebDriver driver = new ChromeDriver(options);


        //create array list of states
        ArrayList<String> states = new ArrayList<>();
        states.add("New York");
        states.add("Florida");
        states.add("Pennsylvania");
        //array list of adults [integer]
        ArrayList<Integer> adults = new ArrayList<>();
        adults.add(2);
        adults.add(3);
        adults.add(4);
        //array list of child age
        ArrayList<String> childAge = new ArrayList<>();
        childAge.add("Under 1");
        childAge.add("1");
        childAge.add("2");


        for (int i=0;i<states.size();i++){
            //navigate to mortgage hotels website
            driver.navigate().to("https://hotels.com");
            //delay 1s
            Thread.sleep(1000);

            //click on travelers button
            try {
                driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on travelers button.. " + e);
            }//end of travelers button exception

            //delay 1s
            Thread.sleep(1000);

            //click the minus button
            try {
                driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click on decrease icon button.. " + e);
            }//end of decrease icon exception

            // delay 1s
            Thread.sleep(1000);

            //click the done button
            try {
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click the done button.. " + e);
            }//end of done button exception

            //find destination button
            try{
                driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click find destination button.. " + e);
            }//end of find destination button exception

            //enter ith index of states into field
            try {
                driver.findElement(By.xpath("//*[@id='destination_form_field']")).sendKeys(states.get(i));
            } catch (Exception e) {
                System.out.println("Unable to enter state in input field.. " + e);
            }//end of state input exception

            //delay 1s
            Thread.sleep(1000);

            //array list of search results for location
            try {
                ArrayList<WebElement> searchResults = new ArrayList<>(driver.findElements(By.xpath("//*[@class='is-subText truncate']")));
                //click on the first search result
                searchResults.get(0).click();
            } catch (Exception e) {
                System.out.println("Unable to click the first result.. " + e);
            }//end of search results location exception

            //click on travelers
            try {
                driver.findElement(By.xpath("//*[@data-stid='open-room-picker']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on travelers button.. " + e);
            }//end of travelers button exception

            //delay 1s
            Thread.sleep(1000);

            //for loop to iterate number of adults
            for (int j=0;j<(adults.get(i)-1);j++){

                try {
                    driver.findElements(By.xpath("//*[@class='uitk-icon uitk-step-input-icon uitk-icon-medium']")).get(1).click();
                } catch (Exception e) {
                    System.out.println("Unable to click increase button for adults.. " + e);
                }//end of increase adults exception

            }//end of adults for loop

            //delay 1s
            Thread.sleep(1000);

            //increase children number to 1 only
            try{
                driver.findElement(By.xpath("//*[@aria-label='Increase the number of children in room 1']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on increase button for children.. ");
            }//end of increase children exception

            //delay 1s
            Thread.sleep(1000);

            //select the age of child
            try {
                //web element of child age drop down
                WebElement childAgeDrop = driver.findElement(By.xpath("//*[@id='age-traveler_selector_children_age_selector-0-0']"));
                //declare and define select
                Select childAgeDropDown = new Select(childAgeDrop);
                //select the ith index value
                childAgeDropDown.selectByVisibleText(childAge.get(i));
            } catch (Exception e) {
                System.out.println("Unable to select child age.. " + e);
            }//end of child age exception

            //click the done button
            try {
                driver.findElement(By.xpath("//*[@id='traveler_selector_done_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click the done button.. " + e);
            }//end of done button exception

            //delay 1s
            Thread.sleep(1000);

            //submit
            try {
                driver.findElement(By.xpath("//*[@id='submit_button']")).click();
            } catch (Exception e) {
                System.out.println("Unable to press search button.. " + e);
            }//end of search button exception

            //delay 1s
            Thread.sleep(1000);

            //WebElement of links
            try {
                ArrayList<WebElement> resortLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='uitk-spacing uitk-spacing-margin-blockstart-three']")));
                //conditionals to click on proper links
                if (i == 0) {
                    resortLinks.get(0).click();
                } else if (i == 1) {
                    resortLinks.get(2).click();
                } else if (i == 2) {
                    resortLinks.get(1).click();
                }
            } catch (Exception e) {
                System.out.println("Unable to click on resort link.. " + e);
            }//end of resort link exception

            //delay 1s
            Thread.sleep(1000);

            //create new arraylist for multiple tabs
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            //switch to the new opened tab
            driver.switchTo().window(tabs.get(1));
            //use web element to store name of place
            try {
                WebElement nameOfPlace = driver.findElements(By.xpath("//*[@class='uitk-heading uitk-heading-3']")).get(0);
                //print name of place
                System.out.println("The name of the resort is: " + nameOfPlace.getText());
            } catch (Exception e) {
                System.out.println("Unable to get name of place.. " + e);
            }//end of name of place exception

            //delay 1s
            Thread.sleep(1000);

            //click reserve a room to scroll down
            try {
                driver.findElement(By.xpath("//*[@data-stid='sticky-button']")).click();
            }catch (Exception e) {
                System.out.println("Unable to click on reserve a room button.. " + e);
            }//end of reserve a room exception

            //delay 1s
            Thread.sleep(1000);

            //web element store the price
            try{
                WebElement pricePlace = driver.findElements(By.xpath("//*[@class='uitk-text uitk-type-600 uitk-type-bold uitk-text-emphasis-theme']")).get(0);
                //print out the price of the place
                System.out.println("The price per night is: " + pricePlace.getText());
            } catch (Exception e) {
                System.out.println("Unable to print the price of place.. " + e);
            }//end of price of place exception

            //delay 1s
            Thread.sleep(1000);

            //click on reserve
            try{
                driver.findElements(By.xpath("//*[@data-stid='submit-hotel-reserve']/span")).get(0).click();
            } catch (Exception e){
                System.out.println("Unable to click on reserve button.. " + e);
            }//end of reserve button exception

            //delay 4s
            Thread.sleep(4000);

            //handle pop up window with pay now button
            try {
                WebElement reserveNowPopUp = driver.findElement(By.xpath("//*[@class='uitk-toolbar-title-content']"));
                if (reserveNowPopUp.isDisplayed()) {
                    //if the pop up is displayed then click on pay now
                    driver.findElement(By.xpath("//span[text() = 'Pay now']")).click();
                }
            } catch (Exception e) {
                System.out.println("Unable to find pop up window " + e);
            }//end of popup exception

            //get check in date
            try{
                WebElement checkInDate = driver.findElements(By.xpath("//*[contains(@class,'check-in')]")).get(0);
                System.out.println("The Check-in date is: " + checkInDate.getText());
            } catch (Exception e) {
                System.out.println("Unable to print the check-in date.. "+e);
            }//end of check in date exception

            try {
                //get check out date
                WebElement checkOutDate = driver.findElements(By.xpath("//*[contains(@class,'check-out')]")).get(0);
                System.out.println("The Check-out date is: " + checkOutDate.getText());
            } catch (Exception e) {
                System.out.println("Unable to print the check-out date.. "+e);
            }//end of check out date exception

            //line break
            System.out.println(" ");
            //close current tab
            driver.close();
            //switch back to parent tab
            driver.switchTo().window(tabs.get(0));
            //delay 1s
            Thread.sleep(1000);

        }//end of states for loop

        //quit driver
        driver.quit();

    }//end of main

}//end of class

