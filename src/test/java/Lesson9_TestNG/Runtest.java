package Lesson9_TestNG;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Runtest extends BaseTest {

    @Test
    public void AddCategory() throws InterruptedException {
        createDriver();

        driver.get("https://ecommerce.anhtester.com/users/login");

        String popup = "//button[@class = 'absolute-top-right bg-white shadow-lg btn btn-circle btn-icon mr-n3 mt-n3 set-session' ]";
        WebElement closepopup = driver.findElement(By.xpath(popup));
        closepopup.click();
        Thread.sleep(1000);


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




        closeDriver();
    }

}
