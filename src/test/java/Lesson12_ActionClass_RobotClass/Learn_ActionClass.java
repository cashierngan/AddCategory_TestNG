package Lesson12_ActionClass_RobotClass;

import Common.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Learn_ActionClass extends BaseTest {

    @Test
    public void TestSendKeys() throws InterruptedException {

        //driver kế thừa từ class SetupBrowser
        DriverManager.getDriver().get("https://www.google.com/");

        // Element search box
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//input[@name='q']"));

        // Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(DriverManager.getDriver());

        // Dùng action để gọi hàm sendkeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.sendKeys(element, "Anh Tester").build().perform();
        Thread.sleep(2000);
        action.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(2000);
        WebElement elementTitlePage = DriverManager.getDriver().findElement(By.xpath("//h3[normalize-space()='Anh Tester - Automation Testing']"));

        // Gọi hàm click để click element trên
        action.click(elementTitlePage).build().perform();

        Thread.sleep(2000);
    }
    @Test
    public void testClickAndHold() throws InterruptedException {
        DriverManager.getDriver().get("https://anhtester.com/");
        WebElement loginButton = DriverManager.getDriver().findElement(By.id("btn-login"));
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(loginButton).pause(Duration.ofSeconds(3)).click().build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void testRightClick() throws InterruptedException {
        DriverManager.getDriver().get("https://anhtester.com/");
        WebElement inputSearch = DriverManager.getDriver().findElement(By.xpath("//input[@placeholder='Bạn muốn học gì?']"));
        Actions action = new Actions(DriverManager.getDriver());
        action.contextClick(inputSearch).build().perform();
        Thread.sleep(2000);
    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        DriverManager.getDriver().get("http://demo.guru99.com/test/drag_drop.html");
        Thread.sleep(2000);
        // Element which needs to drag.
        WebElement From = DriverManager.getDriver().findElement(By.xpath("//*[@id='credit2']/a"));
        // Element on which need to drop.
        WebElement To = DriverManager.getDriver().findElement(By.xpath("//*[@id='bank']/li"));

        Actions action = new Actions(DriverManager.getDriver());

        // Gọi hàm dragAndDrop giữa Element
        action.dragAndDrop(From, To).build().perform();

        Thread.sleep(1000);

        // Drag and Drop by Pixel.
        WebElement from_5000 = DriverManager.getDriver().findElement(By.xpath("//*[@id='fourth']/a"));
        action.dragAndDropBy(from_5000, 168, 40).build().perform();

        Thread.sleep(2000);
    }

    @Test
    public void inputTextUppercase() throws InterruptedException {
        DriverManager.getDriver().get("https://www.google.com/");
        Thread.sleep(2000);
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//input[@name='q']"));

        Actions action = new Actions(DriverManager.getDriver());

        // Đè giữ phím SHIFT và nhập text -> Chữ in hoa
        action.keyDown(element, Keys.SHIFT).sendKeys("anh tester").keyUp(element, Keys.SPACE).sendKeys(Keys.SPACE).sendKeys("hoa").build().perform();

        Thread.sleep(2000);
    }

    @Test
    public void copyAndPaste() throws InterruptedException {
        DriverManager.getDriver().get("https://anhtester.com/blogs");
        Thread.sleep(2000);

        WebElement inputCourseElement = DriverManager.getDriver().findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm khóa học')]"));
        WebElement inputBlogElement = DriverManager.getDriver().findElement(By.xpath("//input[contains(@placeholder, 'Tìm kiếm bài viết')]"));

        Actions action = new Actions(DriverManager.getDriver());

        Thread.sleep(1000);
        // Nhập text vào ô search course
        inputCourseElement.sendKeys("Selenium");
        Thread.sleep(1000);
        //Ctrl + a để bôi đen
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //Ctrl + c để copy
        action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        Thread.sleep(1000);
        //click vào ô Blog search
        inputBlogElement.click();
        Thread.sleep(1000);
        //Ctrl + v để dán
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

        Thread.sleep(2000);
    }
}
