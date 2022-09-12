package Lesson14_JavascriptExecutor;

import Common.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LearnJSExecutor extends BaseTest {
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
    @Test
    public void jsExecutorDemo01() throws InterruptedException {
        // Creating the JavascriptExecutor interface object

        js = (JavascriptExecutor) DriverManager.getDriver();
        DriverManager.getDriver().get("https://anhtester.com/");
        Thread.sleep(2000);

        // Click on "Website Testing" module using JavascriptExecutor
        WebElement button = DriverManager.getDriver().findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
        js.executeScript("arguments[0].click();", button);
        Thread.sleep(1000);

        // Get pages title and Domain using JavascriptExecutor
        String titleText = js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: " + titleText);

        String domainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain is: " + domainName);

        js.executeScript("window.scrollBy(0,1500)");
        Thread.sleep(500);

        // Add Alert window using JavascriptExecutor
        js.executeScript("alert('Successfully Logged In');");

        Thread.sleep(2000);
    }

    //scroll
    @Test
    public void jsExecutorDemo02() throws InterruptedException {
        // Creating the JavascriptExecutor interface object

        js = (JavascriptExecutor) DriverManager.getDriver();
        DriverManager.getDriver().get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = DriverManager.getDriver().findElement(By.xpath("(//a[contains(text(),'Tất Cả Khóa Học')])[1]"));

        js.executeScript("arguments[0].scrollIntoView(true);", element); // scroll đến phần tử (nếu fail thì phần tử nằm dưới)
        Thread.sleep(1500);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(1500);
    }

    // highlight
    @Test
    public void jsExecutorDemo03() throws InterruptedException {
        // Creating the JavascriptExecutor interface object

        js = (JavascriptExecutor) DriverManager.getDriver();
        DriverManager.getDriver().get("https://anhtester.com/");
        Thread.sleep(2000);

        WebElement element1 = DriverManager.getDriver().findElement(By.xpath("//h2[contains(text(),'Gặp gỡ Anh Tester trực tuyến')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", element1);
        Thread.sleep(1000);
        WebElement element = DriverManager.getDriver().findElement(By.xpath("//div[@class='team-img-box']"));
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        Thread.sleep(2000);
    }
}
