package Lesson15_Wait;

import Common.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

// Nếu có nhiều case sai sẽ đợi nhiều thời gian
public class LearnImplicitWait extends BaseTest {
    @Test(priority = 1)
    public void ImplicitWaitDemo1() throws InterruptedException {

        DriverManager.getDriver().get("https://hrm.anhtester.com/");

        DriverManager.getDriver().findElement(By.id("iusername")).sendKeys("admin01");
        DriverManager.getDriver().findElement(By.id("ipassword")).sendKeys("123456");
        DriverManager.getDriver().findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        DriverManager.getDriver().findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();

        Thread.sleep(2000);
        DriverManager.getDriver().quit();
    }

    @Test(priority = 2)
    public void ImplicitWaitDemo2() throws InterruptedException {
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        DriverManager.getDriver().get("https://hrm.anhtester.com/");

        DriverManager.getDriver().findElement(By.id("iusername")).sendKeys("admin01");
        DriverManager.getDriver().findElement(By.id("ipassword")).sendKeys("123456");
        DriverManager.getDriver().findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        DriverManager.getDriver().findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();

        Thread.sleep(2000);
        DriverManager.getDriver().quit();
    }
}
