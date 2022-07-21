package Lesson11_Assert;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssert extends BaseTest {

    @Test(priority = 1)
    public void RunTest() {

        driver.get("https://anhtester.com");

        String expectedTitle = "Anh Tester - Automation Testing";
        String actualTitle = driver.getTitle();

        System.out.println("*** Checking For The Title ***");

        Assert.assertEquals(actualTitle, expectedTitle);
         driver.findElement(By.id("btn-login"));
         Assert.assertTrue(driver.findElement(By.id("btn-login")).getText().trim().equals("LOG IN"), "Test assert true");

    }
}
