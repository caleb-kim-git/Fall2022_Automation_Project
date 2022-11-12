package Reusable_Library;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.openqa.selenium.By.xpath;

public class Reusable_Actions {
    static int timeout = 8;
    //reusable method to define and launch webdriver
    public static WebDriver setUpDriver(){

        //setup chromedriver with Web Driver Manager
        WebDriverManager.chromedriver().setup();
        //initialize chrome options
        ChromeOptions options = new ChromeOptions();
        //add arguments to chrome options
        options.addArguments("start-maximized");
        //mac use "start-fullscreen"
        //or options.addArguments("--kiosk")
        //initialize driver with chrome options
        WebDriver driver = new ChromeDriver(options);
        return driver;

    }//end of setupdriver method

    public static void clickAction (WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.click();
        } catch (Exception e){
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }
    }//end of click action

    public static void clickPopUpElement (WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        if (driver.findElements(By.xpath(xpath)).size() > 0) {
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.click();
        } catch (Exception e){
            System.out.println("Unable to click pop-up element: " + elementName + " for reason: " + e);
        }
        }//end of if statement
    }//end of click action

    public static void clickActionByIndex (WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath(xpath))).get(index).click();
        } catch (Exception e){
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
        }
    }//end of click action by index

    public static void mouseHover (WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e){
            System.out.println("Unable to hover over element: " + elementName + " for reason: " + e);
        }
    }//end of mouse hover

    public static void mouseClickAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            actions.moveToElement(element).click().perform();
        } catch (Exception e){
            System.out.println("Unable to click element: " + elementName + " for reason: " + e);
        }
    }//end of mouse click action

    public static void mouseClickActionByIndex(WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath(xpath))).get(index);
            actions.moveToElement(element).click().perform();
        } catch (Exception e){
            System.out.println("Unable to click element: " + elementName + " for reason: " + e);
        }
    }//end of mouse click action by index

    public static void sendKeysAction (WebDriver driver, String xpath, String userInput, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.sendKeys(userInput);
        } catch (Exception e) {
            System.out.println("Unable to send keys to: " + elementName + " for reason: " + e);
        }
    }//end of sendKeys action

    public static void submitAction (WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.submit();
        } catch (Exception e) {
            System.out.println("Unable to submit to: " + elementName + " for reason: " + e);
        }
    }//end of submit action

    public static String getTextAction(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            textOutput = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text from : " + elementName + " for reason: " + e);
        }
        return textOutput;
    }//end of get text action

    public static String getTextActionByIndex (WebDriver driver, String xpath, int index, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            textOutput = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to get text from: " + elementName + " for reason: " + e);
        }
        return textOutput;
    }//end of get text action by index

    public static void selectByText (WebDriver driver, String xpath, String elementName, String dropdownInput){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            Select elementDropDown = new Select(element);
            element.click();
            elementDropDown.selectByVisibleText(dropdownInput);
        } catch (Exception e) {
            System.out.println("Unable to click dropdown text in: " + elementName + " for reason: " + e);
        }
    }//end of select by text action

    public static void scrollByView (WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            System.out.println("Unable to scroll into view of: " + elementName + " for reason: " + e);
        }
    }//end of scroll by view action

    public static void switchToTabByIndex (WebDriver driver, int index){
        ArrayList <String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
    }//end of switch to tab by index action

    public static void loopUntilTextChanges (WebDriver driver, String wrongText, String xpath) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String elementText = wrongText;
            while (elementText.equals(wrongText)){
                Thread.sleep(6000);
                driver.navigate().refresh();
                try {
                    WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
                    elementText = element.getText();
                } catch (Exception e) {
                    System.out.println("Unable to refresh for text because: " + e);
                }
            }//end of while loop

    }//end of loop text change

}//end of class
