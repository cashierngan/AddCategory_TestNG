package Lesson9_TestNG;

import Common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientTest extends BaseTest {

    @Test(priority = 1)
    public void RunTest() {

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester";
        String originalTitle = driver.getTitle();

        System.out.println("*** Checking For The Title ***");

        Assert.assertEquals(originalTitle, expectedTitle);
    }
}
