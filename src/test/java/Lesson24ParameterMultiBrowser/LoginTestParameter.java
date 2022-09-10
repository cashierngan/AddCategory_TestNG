package Lesson24ParameterMultiBrowser;

import Common.BaseTest;
import ngan.xd.utils.WebUI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTestParameter extends BaseTest {
    public Lesson20_PracticePOM.pages.LoginPage loginPage;

    @BeforeMethod
    public void LoginTest(){
      //Truyền driver từ BaseTest sang các class Page
        loginPage  = new Lesson20_PracticePOM.pages.LoginPage(driver);
    }

    @Test (priority = 1)
    @Parameters({"username", "password"})
    public void testLoginSuccess(String username, String password){

        loginPage.login(username, password);
        loginPage.dangxuat();
        WebUI.sleep(3);
    }

    @Test (priority = 2)
    @Parameters({"username", "password"})
    public void loginWithUsernameInValid(String username, String password){

        loginPage.loginWithUsernameInValid(username, password);
    }
}
