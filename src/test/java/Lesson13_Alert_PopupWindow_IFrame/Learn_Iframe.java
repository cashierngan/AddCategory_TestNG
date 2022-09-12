package Lesson13_Alert_PopupWindow_IFrame;

import Common.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Learn_Iframe extends BaseTest {
    @Test
    public void handleIFrame01() throws InterruptedException {

        DriverManager.getDriver().navigate().to("https://anhtester.com/contact");
        Thread.sleep(15000);
        // 1/ Lấy ra tất cả thẻ iframe tồn tại trong trang
        System.out.println("iframe total: " + DriverManager.getDriver().findElements(By.tagName("iframe")).size());
        Thread.sleep(2000);

        // 2. Chuyền hướng theo vị trí của iframe
        //----Switch to content of Messenger--------
        // Đến iframe đầu tiên
        DriverManager.getDriver().switchTo().frame(0);
        System.out.println(DriverManager.getDriver().findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        // 3. Chuyển đến lớp đầu không phải iframe
        DriverManager.getDriver().switchTo().parentFrame();

        // 4. Chuyển đến iframe thứ 2
        DriverManager.getDriver().switchTo().frame(1);
        DriverManager.getDriver().findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        Thread.sleep(2000);
    }

}
