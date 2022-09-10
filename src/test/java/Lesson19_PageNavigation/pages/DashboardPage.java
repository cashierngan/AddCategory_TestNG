package Lesson19_PageNavigation.pages;

import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By menuProject = By.xpath("//span[contains(text(),'Dự án')]");
    private By menuTasks = By.xpath("//a[@href='https://hrm.anhtester.com/erp/tasks-list']");
    public void openProject(){
        System.out.println("Đã mở project");
        WebUI.clickElement(menuProject);
    }

}
