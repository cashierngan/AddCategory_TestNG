package Lesson20_PracticePOM.pages.testcases;

import Common.BaseTest;
import Lesson17_POM.pages.LoginPage;
import ngan.xd.utils.WebUI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    public Lesson20_PracticePOM.pages.LoginPage loginPage;

    @BeforeMethod
    public void LoginTest(){
      //Truyền driver từ BaseTest sang các class Page
        loginPage  = new Lesson20_PracticePOM.pages.LoginPage(driver);
    }

    @Test
    public void testLoginSuccess(){

        loginPage.login("admin01", "123456");
        loginPage.dangxuat();
        WebUI.sleep(3);
    }

    @Test
    public void loginWithUsernameInValid(){

        loginPage.loginWithUsernameInValid("client0431", "123456");
    }
}
