package Lesson17_POM.testcase;

import Common.BaseTest;
import Lesson17_POM.pages.LoginPage;
import driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public LoginPage loginPage;

    @BeforeMethod
    public void LoginTest(){
        loginPage = new LoginPage(); //Truyền driver từ BaseTest sang các class Page
    }

    @Test
    public void testLoginValid01(){

        loginPage.login("admin01", "123456");
    }

    @Test
    public void testLoginValid02(){

        loginPage.login("client01", "123456");
    }

    @Test
    public void testLoginInValid03(){

        loginPage.login("leader01", "123456");
    }

    @Test
    public void testForgotPassword(){
        loginPage.resetPassword("client01@mailinator.com");
    }
}
