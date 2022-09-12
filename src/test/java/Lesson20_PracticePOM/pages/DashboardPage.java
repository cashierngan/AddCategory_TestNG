package Lesson20_PracticePOM.pages;

import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;


public class DashboardPage extends CommonPage {
    ProjectPage projectPage;

    private By menuProject = By.xpath("//span[contains(text(),'Dự án')]");
    private By menuTasks = By.xpath("//a[@href='https://hrm.anhtester.com/erp/tasks-list']");
    public By menuTrangchu = By.xpath("//span[contains(text(),'Trang chủ')]");

    public DashboardPage() {
        super();
    }


    public void openProject(){
        System.out.println("Đã mở project");
        WebUI.clickElement(menuProject);
    }

}
