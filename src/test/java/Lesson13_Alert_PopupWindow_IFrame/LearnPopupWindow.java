package Lesson13_Alert_PopupWindow_IFrame;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;

public class LearnPopupWindow extends BaseTest {

    @Test
    public void TestPopup01() throws InterruptedException {
        driver.get("http://demo.guru99.com/popup.php");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("btnLogin")).click();
        Thread.sleep(2000);
    }

    @Test
    public void TestPopup02() throws InterruptedException {
        driver.get("http://demo.guru99.com/popup.php");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
        Thread.sleep(1000);

        //Swith to new tab
        // 1. Lưu lại mã định danh cho tab đầu tiên
        String MainWindow = driver.getWindowHandle();
//        System.out.println(MainWindow);

        // 2. Lấy ra tất cả tab hiện hành đang mở (set lưu trữ các giá trị không trùng lặp)
        Set<String> windows = driver.getWindowHandles();
//        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()) ;
//        driver.switchTo().window(tabs.get(1));
//        System.out.println(tabs.get(0));
//        System.out.println(tabs.get(1));

        // 3. Duyệt for để kiểm tra từng tab
        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                //Switch to Child window
                driver.switchTo().window(window);
                Thread.sleep(2000);
                // get title của tab
                System.out.println(driver.switchTo().window(window).getTitle());
                if(driver.switchTo().window(window).getTitle().equals("Guru99 Bank Home Page")){
                    driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
                    driver.findElement(By.name("btnLogin")).click();
                    Thread.sleep(2000);
                    System.out.println("Đã chuyển đến lớp Window con" + window);}
            }}



    }
}
