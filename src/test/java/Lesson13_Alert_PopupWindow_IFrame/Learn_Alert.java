package Lesson13_Alert_PopupWindow_IFrame;

import Common.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Learn_Alert extends BaseTest {
    @Test
    public void testAlert_01() throws InterruptedException {
        DriverManager.getDriver().get("https://demo.anhtester.com/javascript-alert-box-demo.html");
        Thread.sleep(2000);
        DriverManager.getDriver().findElement(By.xpath("(//button[normalize-space()='Click me!'])[1]")).click();
        Thread.sleep(1000);
        System.out.println(DriverManager.getDriver().switchTo().alert().getText());
        Thread.sleep(2000);
        DriverManager.getDriver().switchTo().alert().accept(); //Nhấn nút Ok hoặc Yes hoặc Xác nhận hoặc Confirm

    }

    @Test
    public void testAlert_02() throws InterruptedException {
        DriverManager.getDriver().get("https://demo.anhtester.com/javascript-alert-box-demo.html");
        Thread.sleep(2000);
        DriverManager.getDriver().findElement(By.xpath("(//button[normalize-space()='Click me!'])[2]")).click();
        Thread.sleep(1000);
        System.out.println(DriverManager.getDriver().switchTo().alert().getText());
        Assert.assertEquals(DriverManager.getDriver().switchTo().alert().getText(), "Press a button!", "Text on Alert not match");
        Thread.sleep(2000);

        //Check nút Ok
        DriverManager.getDriver().switchTo().alert().accept();
        Thread.sleep(1000);
        WebElement textConfirmOK = DriverManager.getDriver().findElement(By.xpath("//p[@id='confirm-demo']"));
        Assert.assertEquals(textConfirmOK.getText(), "You pressed OK!", "Text không chính xác");

        //Check nút Cancel
        Thread.sleep(1000);
        DriverManager.getDriver().findElement(By.xpath("(//button[normalize-space()='Click me!'])[2]")).click();
        Thread.sleep(1000);
        System.out.println(DriverManager.getDriver().switchTo().alert().getText());
        Assert.assertEquals(DriverManager.getDriver().switchTo().alert().getText(), "Press a button!", "Text on Alert not match");
        Thread.sleep(2000);
        DriverManager.getDriver().switchTo().alert().dismiss();
        Thread.sleep(1000);
        WebElement textConfirmCancel = DriverManager.getDriver().findElement(By.xpath("//p[@id='confirm-demo']"));
        Assert.assertEquals(textConfirmCancel.getText(), "You pressed Cancel!", "Text không chính xác");

    }

    @Test
    public void testAlert_03() throws InterruptedException {
        DriverManager.getDriver().get("https://demo.anhtester.com/javascript-alert-box-demo.html");
        Thread.sleep(2000);
        DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Click for Prompt')]")).click();
        Thread.sleep(1000);
        System.out.println(DriverManager.getDriver().switchTo().alert().getText());
        Assert.assertEquals(DriverManager.getDriver().switchTo().alert().getText(), "Please enter your name", "Text on Alert not match");
        Thread.sleep(2000);

        //sendKeys một giá trị vài ô input
        DriverManager.getDriver().switchTo().alert().sendKeys("Anh Tester");
        Thread.sleep(1000);
        //Check nút Ok
        DriverManager.getDriver().switchTo().alert().accept();
        Thread.sleep(1000);
        WebElement prompt_demo = DriverManager.getDriver().findElement(By.xpath("//p[@id='prompt-demo']"));
        Assert.assertEquals(prompt_demo.getText(), "You have entered 'Anh Tester' !", "Data input not match");

    }
}
