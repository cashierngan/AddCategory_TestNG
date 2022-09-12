package Lesson17_POM.pages;

import ngan.xd.utils.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;

    //Hàm xây dựng


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

    public void login(String email, String password){
        WebUI.openURL( "https://hrm.anhtester.com/");
        WebUI.setText( inputEmail, email);
        WebUI.setText( inputPassword, password);
        WebUI.clickElement( buttonSignin);
    }

    public void resetPassword(String emailForgot){
        WebUI.openURL( "https://hrm.anhtester.com/");
        WebUI.clickElement( linkForgotPassword);
//        WebUI.verifyEquals();
        Assert.assertTrue(WebUI.getElementText(pageTextForgotPassword).equals("Reset your password"));
        WebUI.setText( inputEmaiForgotPassword, emailForgot );
        WebUI.clickElement( buttonReset);
        WebUI.clickElement(linkClickHere);

    }



}
