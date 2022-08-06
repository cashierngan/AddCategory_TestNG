package Lesson18_PageFactory.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Factory {

    WebDriver driver;
    public LoginPage_Factory(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this); // this là tại page này luôn
        // kết nỗi giữa WebElement và Locator
        // không tìm kiếm liền, khi nào gọi tới mới tìm
    }

    //Object
    @FindBy(xpath = "//input[@id='ipassword']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='iusername']")
    private WebElement inputPw;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonLogin;

    public void Login(String email, String password){
        driver.get("https://hrm.anhtester.com/");
        inputEmail.sendKeys(email);
        inputPw.sendKeys(password);
        buttonLogin.click();
    }
}
