package Lesson19_PageNavigation.pages;

import driver.DriverManager;
import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;


public class LoginPage {


    //Login
    private String pageText = "Welcome to HRM System";
    private By inputEmail = By.xpath("//input[@id='iusername']");
    private By inputPassword = By.xpath("//input[@id='ipassword']");
    private By buttonSignin = By.xpath("//button[@type='submit']");

    //ForgotPassword
    private By linkForgotPassword = By.xpath("//a[normalize-space()='Forgot password?']");
    private By pageTextForgotPassword = By.xpath("//h4[normalize-space()='Reset your password']");
    private By inputEmaiForgotPassword = By.xpath("//input[@placeholder='Email address']");
    private By buttonReset = By.xpath("//button[@type='submit']");
    private By linkClickHere = By.xpath("//a[normalize-space()='Click here']");


    public DashboardPage login(String email, String password){
        WebUI.openURL( "https://hrm.anhtester.com/");
        WebUI.setText( inputEmail, email);
        WebUI.setText( inputPassword, password);
        WebUI.clickElement( buttonSignin);
        return new DashboardPage(); // khởi tạo trang Dashboard
    }
}
