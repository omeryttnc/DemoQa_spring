package QA.utilities;

import QA.Enums.LINKS;
import QA.utilities.driver.DriverFactoryImplementation;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {
   static Faker faker;

    public static void visitURL(LINKS links) {
        DriverFactoryImplementation.getInstance().getDriver().get(links.getLinks());
        waitForPageToLoad(5);
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }


    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static Boolean waitForInVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForInVisibilityofWebElement(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeToWaitInSec);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForClickablilityAndClick(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        element.click();
    }


    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(DriverFactoryImplementation.getInstance().getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void wait(int secs) {
        try {
            Thread.sleep(1000L * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void cleanTextInBox(WebElement element) {
        String inputText = element.getAttribute("value");
        if (inputText != null) {
            for (int i = 0; i < inputText.length(); i++) {
                element.sendKeys(Keys.BACK_SPACE);
            }
        }
    }

    //ScrollDown by pixel
    public static void scrollDownByPixel(int times, String pixcel) {
        for (int i = 0; i < times; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //scrolling up
            JavascriptExecutor jse = (JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver();
            jse.executeScript("window.scrollBy(0," + pixcel + ")");
        }
    }

    public static boolean isExist(WebElement element) {
        boolean b;
        try {
            b = element.isDisplayed() || !element.isDisplayed();
        } catch (Exception var3) {
            b = false;
        }

        return b;
    }

    public static boolean isElementVisible(WebElement webElement) {
        try {
            webElement.isDisplayed();
            return true;
        } catch (NoSuchElementException var2) {
            return false;
        }
    }





    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) DriverFactoryImplementation.getInstance().getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * altta gelen reklami kapatmak icin resolution i degistirdim
     */
    public static void changeResoultion(){
        Dimension dimension = new Dimension(1200, 720);

        DriverFactoryImplementation.getInstance().getDriver().manage().window().setSize(dimension);
        ReusableMethods.wait(5);
    }
}