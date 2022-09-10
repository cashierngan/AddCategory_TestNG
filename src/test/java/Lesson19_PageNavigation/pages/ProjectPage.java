package Lesson19_PageNavigation.pages;

import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage {
    WebDriver driver;
    public ProjectPage(WebDriver driver){
        this.driver = driver;
        new WebUI(driver);
    }

    private By buttonThemMoi = By.xpath("//a[normalize-space()='Thêm mới']");
    private By inputTitle = By.xpath("//input[@placeholder='Tiêu đề']");

    public void clickButtonThemMoi(){
        WebUI.clickElement(buttonThemMoi);
    }

    public void enterData(){
        WebUI.clickElement(buttonThemMoi);
    }

    public void AddProject(){
        clickButtonThemMoi();
        enterData();
    }
}
