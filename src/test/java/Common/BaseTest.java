package Common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {


    public static WebDriver driver;
    @BeforeMethod
    public static void createDriver() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        driver.get("https://ecommerce.anhtester.com/users/login");

        String popup = "//button[@class = 'absolute-top-right bg-white shadow-lg btn btn-circle btn-icon mr-n3 mt-n3 set-session' ]";
        WebElement closepopup = driver.findElement(By.xpath(popup));
        closepopup.click();

        String login = "//a[@class = 'text-reset d-inline-block opacity-60 py-2' and normalize-space() = 'Login']";
        WebElement buttonLogin = driver.findElement(By.xpath(login));
        buttonLogin.click();
        Thread.sleep(1000);

        String email = "//input[@id = 'email']";
        String password = "//input[@id = 'password']";
        String submitLogin = "//button[normalize-space()='Login']";

        driver.findElement(By.xpath(email)).sendKeys("cashierngan002@gmail.com");
        driver.findElement(By.xpath(password)).sendKeys("123456");
        driver.findElement(By.xpath(submitLogin)).click();
        Thread.sleep(2000);
    }

    @AfterMethod
    public static void closeDriver(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null)
            driver.quit();
    }
}
