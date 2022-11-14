package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Logger;

import static org.openqa.selenium.By.xpath;

public class Reusable_Actions_Loggers {
    static int timeout = 10;

    //reusable method to define and launch webdriver
    public static WebDriver setUpDriver() {
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

    public static void clickPopUpElement(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        if (driver.findElements(By.xpath(xpath)).size() > 0) {
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
                element.click();
                logger.log(LogStatus.PASS, "Successfully clicked on element " + elementName);
            } catch (Exception e) {
                System.out.println("Unable to click pop-up element: " + elementName + " for reason: " + e);
                logger.log(LogStatus.FAIL, "Unable to click on element: " + elementName + " for reason: " + e);
            }
        }//end of if statement
    }//end of click pop up element

    public static void clickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element: " + elementName + " for reason: " + e);
            getScreenShot(driver,elementName,logger);
        }
    }//end of click action


    public static void clickActionByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath(xpath))).get(index);
            element.click();
            logger.log(LogStatus.PASS, "Successfully clicked on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element: " + elementName + " for reason: " + e);
        }
    }//end of click action by index

    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully hovered on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover over element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to hover on element: " + elementName + " for reason: " + e);
        }
    }//end of mouse hover

    public static void mouseClickAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            actions.moveToElement(element).click().perform();
            logger.log(LogStatus.PASS, "Successfully clicked on element" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element: " + elementName + " for reason: " + e);
        }
    }//end of mouse click action

    public static void mouseClickActionByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        //declare mouse actions
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath(xpath))).get(index);
            actions.moveToElement(element).click().perform();
            logger.log(LogStatus.PASS, "Successfully clicked on element" + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click element: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on element: " + elementName + " for reason: " + e);
        }
    }//end of mouse click action by index

    public static void sendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.sendKeys(userInput);
            //verify the element is successful
            logger.log(LogStatus.PASS, "Successfully entered a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys to: " + elementName + " for reason: " + e);
        }
    }//end of sendKeys action

    public static void sendKeysActionByIndex(WebDriver driver, String xpath, String userInput, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath(xpath))).get(index);
            element.sendKeys(Keys.CONTROL, "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(userInput);
            //verify the element is successful
            logger.log(LogStatus.PASS, "Successfully entered a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys to: " + elementName + " for reason: " + e);
        }
    }//end of sendKeys action

    public static void clearAndSendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.sendKeys(Keys.CONTROL, "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(userInput);
            //verify the element is successful
            logger.log(LogStatus.PASS, "Successfully entered a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys to: " + elementName + " for reason: " + e);
        }
    }//end of clear and sendKeys action

    public static void clearAndSendKeysActionByIndex(WebDriver driver, String xpath, String userInput, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath(xpath))).get(index);
            element.sendKeys(Keys.CONTROL, "a");
            element.sendKeys(Keys.DELETE);
            element.sendKeys(userInput);
            //verify the element is successful
            logger.log(LogStatus.PASS, "Successfully entered a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys to: " + elementName + " for reason: " + e);
        }
    }//end of clear and sendKeys action

    public static void clickAndSendKeysAction(WebDriver driver, String xpath, String userInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.click();
            element.sendKeys(userInput);
            //verify the element is successful
            logger.log(LogStatus.PASS, "Successfully entered a value on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to send keys to: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to send keys to: " + elementName + " for reason: " + e);
        }
    }//end of clickAndSendKeys action

    public static void submitAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            element.submit();
            logger.log(LogStatus.PASS, "Successfully submit on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit to: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to submit to: " + elementName + " for reason: " + e);
        }
    }//end of submit action

    public static ArrayList arrayListOfElements(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        ArrayList arrayElement = new ArrayList<>();
        try {
            arrayElement = new ArrayList<>(wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(xpath(xpath))));
            logger.log(LogStatus.PASS, "Successfully created array list of " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to create array list of: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to create array list of: " + elementName + " for reason: " + e);
        }
        return arrayElement;
    }//end of array list of elements

    public static String getTextAction(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            textOutput = element.getText();
            logger.log(LogStatus.PASS, "Successfully captured text on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text from : " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to get text from : " + elementName + " for reason: " + e);
        }
        return textOutput;
    }//end of get text action

    public static String getTextActionByIndex(WebDriver driver, String xpath, int index, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String textOutput = null;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index);
            textOutput = element.getText();
            logger.log(LogStatus.PASS, "Successfully captured text on " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to get text from: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to get text from : " + elementName + " for reason: " + e);
        }
        return textOutput;
    }//end of get text action by index

    public static void selectByText(WebDriver driver, String xpath, String dropdownInput, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            Select elementDropDown = new Select(element);
            elementDropDown.selectByVisibleText(dropdownInput);
            logger.log(LogStatus.PASS, "Successfully selected " + dropdownInput + " in " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click dropdown text in: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to select " + dropdownInput + " in " + elementName + " for reason: " + e);
        }
    }//end of select by text action

    public static void scrollByView(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
            logger.log(LogStatus.PASS, "Successfully scrolled into view of " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to scroll into view of: " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to scroll into view of : " + elementName + " for reason: " + e);
        }
    }//end of scroll by view action

    public static void switchToTabByIndex(WebDriver driver, int index, ExtentTest logger) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        logger.log(LogStatus.PASS, "Successfully switched into tab number " + (index + 1));
    }//end of switch to tab by index action

    public static void loopUntilTextChanges(WebDriver driver, String wrongText, String xpath) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        String elementText = wrongText;
        while (elementText.equals(wrongText)) {
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

    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

    public static void compareExpectedAndActualText(String expectedText, String actualText, ExtentTest logger) {
        if (actualText.equals(expectedText)) {
            logger.log(LogStatus.PASS, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " match");
        }
        else{
            logger.log(LogStatus.FAIL, "Expected Text: " + expectedText + " and Actual Text: " + actualText + " does not match");
        }
    }//end of compareExpectedAndActualText

}//end of java class
