package Lesson20_PracticePOM.pages;

import driver.DriverManager;
import ngan.xd.utils.WebUI;
import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {



    // Class chung
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProjectPage projectPage;

    // Object chung
    public By buttonDangXuat = By.xpath("//a[@class='btn btn-smb btn-outline-primary rounded-pill']");

    // Hàm chung để get Khởi tạo của các trang khai báo ở trên và các hàm xử lý chung
    public LoginPage getLoginPage(){
        if (loginPage == null)
        {
            loginPage = new LoginPage(DriverManager.getDriver());
        }
        return loginPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null)
        {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public ProjectPage getProjectPage() {
        if (projectPage == null)
        {
            projectPage = new ProjectPage();
        }
        return projectPage;
    }
    public void dangxuat(){
        WebUI.clickElement(buttonDangXuat);
    }

}
