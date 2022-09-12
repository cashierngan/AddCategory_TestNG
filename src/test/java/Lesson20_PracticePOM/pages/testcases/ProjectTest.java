package Lesson20_PracticePOM.pages.testcases;

import Common.BaseTest;
import Lesson19_PageNavigation.pages.DashboardPage;
import Lesson19_PageNavigation.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
//    public void setupTest(){
//        loginPage = new LoginPage(driver);
//    }
    @Test
    public void testOpenProject(){

        // Tạo sự liên kết trang thông qua gán dấu = từ đối tượng trang = hàm đã liên kết
        // Không cần khởi tạo lại DashboardPage = new DashboardPage(driver) -> Dashboard sẽ được khởi tạo sau khi login thành công
        dashboardPage = loginPage.login("admin01", "123456");
        dashboardPage.openProject();
    }
}
