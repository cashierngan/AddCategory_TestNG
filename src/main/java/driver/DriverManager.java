package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>(); // khởi tạo driver nạp nhiều luồng với dataType = Webdriver

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver.set(driver);
    }

    public static void quit() {
        DriverManager.driver.get().quit();
        driver.remove();
    }
}
