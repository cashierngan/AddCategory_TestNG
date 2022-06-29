package Lesson11_Assert;

import Common.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Common.BaseTest.driver;

public class TestSoftAssert extends BaseTest {

    @Test(priority = 1)
    public void RunTest() {

        driver.get("https://anhtester.com");

        SoftAssert softassert = new SoftAssert();

        String expectedTitle = "Anh Tester";
        String originalTitle = driver.getTitle();

        System.out.println("*** Checking For The First Title ***");

        softassert.assertEquals(originalTitle, expectedTitle);

        System.out.println("*** Checking For The Second Title ***");

        softassert.assertEquals(originalTitle, "Anh Tester - Automation ");

        softassert.assertAll(); // Tổng kết các assert bắt buộc khai báo
    }
}
