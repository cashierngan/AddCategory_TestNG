package Lesson15_Wait;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LearnExplicitWait extends BaseTest {

    // hay hơn là điều kiện có được đáp ứng hay không
    // trường hợp page load nhanh nút hk hiển thị kịp
    // sử dụng cục bộ
    @Test(priority = 1)
    public void ExplicitWaitDemo1() throws InterruptedException {

        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://hrm.anhtester.com/");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

//        driver.findElement(By.xpath("//h3[contains(text(),'Website Testing')]")).click();

        driver.findElement(By.id("iusername")).sendKeys("admin01");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Đợi đến khi element tìm thấy trong DOM và sẵn sàng hiển thị để thao tác (đối tượng By chứ không phải driver.findElement)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Dự án')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();

        Thread.sleep(2000);
        driver.quit();
    }
}
