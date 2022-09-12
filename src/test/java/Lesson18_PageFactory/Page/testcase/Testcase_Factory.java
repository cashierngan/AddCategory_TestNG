package Lesson18_PageFactory.Page.testcase;

import Common.BaseTest;
import Lesson18_PageFactory.Page.LoginPage_Factory;
import driver.DriverManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testcase_Factory extends BaseTest {
    private LoginPage_Factory loginPage_factory;
    @BeforeMethod
    public void setupTest(){
        loginPage_factory = new LoginPage_Factory(DriverManager.getDriver());
    }

    @Test
    public void testLogin(){
        loginPage_factory.Login("admin01", "123456");
    }
}
