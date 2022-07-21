package Lesson12_ActionClass_RobotClass;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Learn_RobotClass extends BaseTest {

    @Test
    public void inputText() throws InterruptedException, AWTException {

        driver.get("https://anhtester.com/");

        Thread.sleep(1000);
        WebElement inputCourseElement = driver.findElement(By.name("key"));

        ((WebElement) inputCourseElement).click();

        Robot robot = new Robot();
        // Nhập từ khóa selenium
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_M);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(2000);
    }
    @Test
    public void openNewURL() throws AWTException, InterruptedException {
        driver.get("https://anhtester.com/");
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        Thread.sleep(1000);
        driver.navigate().to("https://crm.anhtester.com/");
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);

    }
}
