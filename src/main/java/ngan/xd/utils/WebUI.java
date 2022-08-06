package ngan.xd.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebUI {

    private static int TIMEOUT = 10;
    private static int STEP_TIME = 1;

    private static WebDriver driver;
    public WebUI(WebDriver driver){
        WebUI.driver = driver;
    }
    public static void sleep(long second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void clickElement( By by){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        driver.findElement(by).click();
        logConsole("Click element" + by);
    }

    public static void clickElement( By by, long timeout){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        driver.findElement(by).click();
    }

    public static void setText( By by, String value){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        driver.findElement(by).sendKeys(value);
    }

    public static void waitForElementClick( By by){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by));

    }

    public static void waitForElementVisible( By by){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public static void openURL( String URL){
        driver.get(URL);
        logConsole("Open URL: " + URL);
    }

    public static String getElementText( By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        sleep(STEP_TIME);
        return driver.findElement(by).getText(); // trả về 1 giá trị String
    }
    public static void logConsole (Object message){
        System.out.println(message);
    }

}
