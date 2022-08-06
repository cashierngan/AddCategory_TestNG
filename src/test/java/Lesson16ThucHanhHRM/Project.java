package Lesson16ThucHanhHRM;

import Common.BaseTest;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Locale;

public class Project extends BaseTest {

    String tenDuAn = "Dự Án 2807B1";
    @Test
    public void createProject() throws InterruptedException {
        driver.get("https://hrm.anhtester.com");

        String loginPageText = driver.findElement(By.xpath("//h4[@class='mb-3 f-w-600']")).getText();
        System.out.println(loginPageText);
        Assert.assertEquals(loginPageText.trim(), "Welcome to HRM System", "Text không thuộc trang Login");

        WebUI.setText(By.id("iusername"), "admin01");
        WebUI.setText(By.id("ipassword"), "123456");
        WebUI.clickElement(By.xpath("//button[normalize-space()='Login']"));
        WebUI.clickElement(By.xpath("//span[contains(text(),'Dự án')]"));

//        driver.findElement(By.id("iusername")).sendKeys("admin01");
//        driver.findElement(By.id("ipassword")).sendKeys("123456");
//        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
//        driver.findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();

        String pageDuAnURL = driver.getCurrentUrl();
        System.out.println(pageDuAnURL);
        Assert.assertTrue(pageDuAnURL.contains("/projects-list"), "Không đúng URL của trang Dự Án");


        WebUI.clickElement(By.xpath("//a[normalize-space()='Thêm mới']"));
        WebUI.setText(By.xpath("//input[@placeholder='Tiêu đề']"), tenDuAn);

//        driver.findElement(By.xpath("//a[normalize-space()='Thêm mới']")).click();
//
//        driver.findElement(By.xpath("//input[@placeholder='Tiêu đề']")).sendKeys(tenDuAn);

        WebUI.clickElement(By.xpath("//span[@id='select2-client_id-container']"));
        WebUI.setText(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']"), "Lam Nguyen");
//        driver.findElement(By.xpath("//span[@id='select2-client_id-container']")).click();

//        driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")).sendKeys("Lam Nguyen");

        driver.findElement(By.xpath("//ul[@id='select2-client_id-results']//li[normalize-space()='Lam Nguyen']")).click();


        driver.findElement(By.name("budget_hours")).sendKeys("100");


        driver.findElement(By.xpath("//label[normalize-space()='Priority']/following-sibling::span")).click();

        driver.findElement(By.xpath("//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")).sendKeys("Cao");

        driver.findElement(By.xpath("//span[@class='select2-results']//li[normalize-space()='Cao nhất']")).click();


        driver.findElement(By.xpath("//label[contains(text(),'Ngày bắt đầu')]/following-sibling::div")).click();

        driver.findElement(By.xpath("//a[normalize-space()='21']")).click();

        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[1]")).click();


        driver.findElement(By.xpath("//label[contains(text(),'Ngày kết thúc')]/following-sibling::div")).click();

        driver.findElement(By.xpath("(//a[normalize-space()='25'])[2]")).click();

        driver.findElement(By.xpath("(//button[normalize-space()='OK'])[2]")).click();


        driver.findElement(By.id("summary")).sendKeys("Note");



        WebElement inputNHOM = driver.findElement(By.xpath("//div[@id='employee_ajax']//li"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);", inputNHOM);

        js.executeScript("arguments[0].click();", inputNHOM);

        driver.findElement(By.xpath("//div[@id='employee_ajax']//li//input")).sendKeys("Hai Mai");
        driver.findElement(By.xpath("//div[@id='employee_ajax']//li//input")).sendKeys(Keys.ENTER);


        //Nhấn nút Lưu
        driver.findElement(By.xpath("//span[normalize-space()='Lưu']")).click();


        //Tìm kiếm để kiểm tra lại
        js.executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("//div[@id='xin_table_wrapper']//input")));
        driver.findElement(By.xpath("//div[@id='xin_table_wrapper']//input")).sendKeys(tenDuAn);


//        WebDriverWait wait = new WebDriverWait(Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='"+tenDuAn+"']")));
//
        WebUI.waitForElementVisible(By.xpath("//td[normalize-space()='"+tenDuAn+"']"));

        String titleDuAn = driver.findElement(By.xpath("//table[@id='xin_table']//tbody//td[1]")).getText();
        Assert.assertEquals(titleDuAn.toLowerCase(Locale.ROOT), tenDuAn.toLowerCase(), "Tên dự án sai");
    }
}
