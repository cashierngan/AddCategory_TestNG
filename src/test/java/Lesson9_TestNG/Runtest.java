package Lesson9_TestNG;

import Common.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Runtest extends BaseTest {

    @Test(priority = 1, description = "Login to HRM")
    public void Login() throws InterruptedException {

        DriverManager.getDriver().get("https://ecommerce.anhtester.com/users/login");

        SoftAssert softAssert = new SoftAssert();

        String popup = "//button[@class = 'absolute-top-right bg-white shadow-lg btn btn-circle btn-icon mr-n3 mt-n3 set-session' ]";
        WebElement closepopup = DriverManager.getDriver().findElement(By.xpath(popup));
        closepopup.click();

        String login = "//a[@class = 'text-reset d-inline-block opacity-60 py-2' and normalize-space() = 'Login']";
        WebElement buttonLogin = DriverManager.getDriver().findElement(By.xpath(login));
        buttonLogin.click();
        Thread.sleep(1000);


        // Validate Login form
        System.out.println("*** Checking For The Content Of Login Form ***");
        softAssert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//h1[normalize-space() = 'Login to your account.']")).getText().trim().equals("Login to your account."), "Validate Title Login Form");

        softAssert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//input[@id = 'email']")).getAttribute("placeholder").equals("Email"), "Validate Email Placeholder");
        softAssert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//input[@id = 'password']")).getAttribute("placeholder").equals("Password"), "Validate Password Placeholder");
        softAssert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//button[@class= 'btn btn-primary btn-block fw-600']")).isEnabled(), "Validate Login button");

        String email = "//input[@id = 'email']";
        String password = "//input[@id = 'password']";
        String submitLogin = "//button[normalize-space()='Login']";

        // Login fail without email/ password
        DriverManager.getDriver().findElement(By.xpath(submitLogin)).click();
        String messageEmail = "//strong[text() = 'The email field is required when phone is not present.']";
        WebElement checkMessageEmail = DriverManager.getDriver().findElement(By.xpath(messageEmail));
        Assert.assertEquals(checkMessageEmail.getText().trim(), "The email field is required when phone is not present.", "Message valid Email");

        Thread.sleep(1000);
        DriverManager.getDriver().findElement(By.xpath(email)).sendKeys("cashierngan002@gmail.com");
        DriverManager.getDriver().findElement(By.xpath(password)).sendKeys("12345678");
        DriverManager.getDriver().findElement(By.xpath(submitLogin)).click();
        Thread.sleep(1000);

        System.out.println("*** Checking For Pasword ***");
        Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//span[normalize-space() = 'Invalid login credentials']")).getText().trim().equals("Invalid login credentials"), "Verify password fail");

        Thread.sleep(1000);
        DriverManager.getDriver().findElement(By.xpath(email)).sendKeys("cashierngan002@gmail.com");
        DriverManager.getDriver().findElement(By.xpath(password)).sendKeys("123456");
        DriverManager.getDriver().findElement(By.xpath(submitLogin)).click();
        Thread.sleep(1000);

        softAssert.assertAll();
    }

        @Test(priority = 2, description = "Add Category")
        public void addCategory () throws InterruptedException {
            String searchMenu = "//input[@class = 'form-control bg-soft-secondary border-0 form-control-sm text-white']";
            WebElement enterSearchMenu = DriverManager.getDriver().findElement(By.xpath(searchMenu));
            enterSearchMenu.sendKeys("Category");
            Thread.sleep(1000);

            Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//i[@class='las la-ellipsis-h aiz-side-nav-icon']")).isDisplayed(), "Validate Category Menu");
            String menuCategory = "//a[@class = 'aiz-side-nav-link'][normalize-space() = 'Category']";
            WebElement clickMenuCategory = DriverManager.getDriver().findElement(By.xpath(menuCategory));
            clickMenuCategory.click();
            Thread.sleep(1000);

            Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//span[normalize-space()='Add New category']")).getText().trim().equals("Add New category"), "Validate Add Category button");
            Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//span[normalize-space()='Add New category']")).isEnabled(), "Validate Add Category button Enabled");
            String addNewCategory = "//a[@class = 'btn btn-primary']";
            WebElement clickAddNewCategory = DriverManager.getDriver().findElement(By.xpath(addNewCategory));
            clickAddNewCategory.click();
            Thread.sleep(1000);

            Assert.assertTrue(DriverManager.getDriver().findElement(By.xpath("//h5[text() = 'Category Information']")).getText().trim().equals("Category Information"));
            DriverManager.getDriver().findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
            Thread.sleep(1000);
            WebElement requiredTextbox = DriverManager.getDriver().findElement(By.xpath("//input[@id='name' and @required]"));
            Assert.assertTrue(requiredTextbox.isDisplayed());

            String categoryName = "name";
            WebElement enterCategoryName = DriverManager.getDriver().findElement(By.id(categoryName));
            enterCategoryName.sendKeys("Ngan_Beer");
            Thread.sleep(1000);

            String categoryParent = "//div[normalize-space() = 'No Parent' and @class = 'filter-option-inner-inner']";
            WebElement selectCategoryParent = DriverManager.getDriver().findElement(By.xpath(categoryParent));
            selectCategoryParent.click();
            Thread.sleep(1000);

            String inputCategoryParent = "//div[@class = 'dropdown-menu show']//input[@class = 'form-control']";
            WebElement enterCategoryParent = DriverManager.getDriver().findElement(By.xpath(inputCategoryParent));
            enterCategoryParent.sendKeys("Brand PC", Keys.ENTER);
            Thread.sleep(1000);

            String orderingNumber = "//input[@id = 'order_level']";
            WebElement enterOrderingNumber = DriverManager.getDriver().findElement(By.xpath(orderingNumber));
            enterOrderingNumber.sendKeys("3");
            Thread.sleep(1000);

            String typeCategory = "//div[normalize-space() = 'Physical' and @class = 'filter-option-inner-inner']";
            WebElement clickTypeCategory = DriverManager.getDriver().findElement(By.xpath(typeCategory));
            clickTypeCategory.click();
            Thread.sleep(1000);


            String typePhisical = "//span[normalize-space() = 'Digital']";
            WebElement selectTypePhisical = DriverManager.getDriver().findElement(By.xpath(typePhisical));
            selectTypePhisical.click();
            Thread.sleep(1000);

            String bannerCategory = "(//div[@class='form-control file-amount' and normalize-space()='Choose File'])[1]";
            WebElement clickBannerCategory = DriverManager.getDriver().findElement(By.xpath(bannerCategory));
            clickBannerCategory.click();
            Thread.sleep(1000);


            String uploadNewBanner = "//a[@class = 'nav-link font-weight-medium text-dark']";
            WebElement clickUploadNewBanner = DriverManager.getDriver().findElement(By.xpath(uploadNewBanner));
            clickUploadNewBanner.click();
            Thread.sleep(1000);

            String inputFileUpload = "//input[@class='uppy-Dashboard-input']";
            DriverManager.getDriver().findElement(By.xpath(inputFileUpload)).sendKeys(System.getProperty("user.dir") + "/src/main/resources/download (1).jpg");
            Thread.sleep(2000);

            String selectFile = "//a[@class = 'nav-link font-weight-medium text-dark']";
            WebElement clickSelectFile = DriverManager.getDriver().findElement(By.xpath(selectFile));
            clickSelectFile.click();
            Thread.sleep(1000);

            String imgBanner = "//img[@src = '//ecommerce.anhtester.com/public/uploads/all/LhmZyvPNSxPenzpUJcXPTGvIKzEFmJt0daWN6RM8.jpg']";
            WebElement clickImgBanner = DriverManager.getDriver().findElement(By.xpath(imgBanner));
            clickImgBanner.click();
            Thread.sleep(1000);


            String addFile = "//button[@class = 'btn btn-sm btn-primary' and text() = 'Add Files']";
            WebElement clickAddfile = DriverManager.getDriver().findElement(By.xpath(addFile));
            clickAddfile.click();
            Thread.sleep(2000);

            String iconCategory = "//div[@class = 'form-control file-amount' and text() = 'Choose File']";
            DriverManager.getDriver().findElement(By.xpath(iconCategory)).click();
            Thread.sleep(1000);

            String imgIcon = "//img[@src = '//ecommerce.anhtester.com/public/uploads/all/khrA51eWmUMzFJxb4aHpBbpQsiktlBjnf2dMFX3j.jpg']";
            DriverManager.getDriver().findElement(By.xpath(imgIcon)).click();
            Thread.sleep(1000);


            String addFileIcon = "//button[@class = 'btn btn-sm btn-primary' and text() = 'Add Files']";
            WebElement clickAddfileIcon = DriverManager.getDriver().findElement(By.xpath(addFileIcon));
            clickAddfileIcon.click();
            Thread.sleep(2000);

            DriverManager.getDriver().findElement(By.xpath("//input[@name = 'meta_title']")).sendKeys("@@ NNN @@");
            Thread.sleep(1000);

            DriverManager.getDriver().findElement(By.xpath("//textarea[@name = 'meta_description']")).sendKeys("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s");
            Thread.sleep(1000);

            DriverManager.getDriver().findElement(By.xpath("//div[text() = 'Nothing selected']")).click();
            Thread.sleep(1000);

            DriverManager.getDriver().findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Size", Keys.ENTER);
            Thread.sleep(1000);

            DriverManager.getDriver().findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).clear();
            Thread.sleep(1000);

            DriverManager.getDriver().findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("Fabric", Keys.ENTER);
            Thread.sleep(1000);

            DriverManager.getDriver().findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
            Thread.sleep(2000);


        }

//    @Test (priority = 3, description = "Kiểm tra giá trị Category sau khi add đã tồn tại chưa")
//    public void searchCategory() throws InterruptedException {
//
////        DriverManager.getDriver().get("https://ecommerce.anhtester.com/users/login");
////
////        String popup = "//button[@class = 'absolute-top-right bg-white shadow-lg btn btn-circle btn-icon mr-n3 mt-n3 set-session' ]";
////        WebElement closepopup = DriverManager.getDriver().findElement(By.xpath(popup));
////        closepopup.click();
////
////        String login = "//a[@class = 'text-reset d-inline-block opacity-60 py-2' and normalize-space() = 'Login']";
////        WebElement buttonLogin = DriverManager.getDriver().findElement(By.xpath(login));
////        buttonLogin.click();
////        Thread.sleep(1000);
////
////        String email = "//input[@id = 'email']";
////        String password = "//input[@id = 'password']";
////        String submitLogin = "//button[normalize-space()='Login']";
////
////        DriverManager.getDriver().findElement(By.xpath(email)).sendKeys("cashierngan002@gmail.com");
////        DriverManager.getDriver().findElement(By.xpath(password)).sendKeys("123456");
////        DriverManager.getDriver().findElement(By.xpath(submitLogin)).click();
////        Thread.sleep(2000);
//
//
//
//
//
//
//
//
//
//        DriverManager.getDriver().findElement(By.xpath("//input[@class = 'form-control bg-soft-secondary border-0 form-control-sm text-white']")).sendKeys("Category");
//        Thread.sleep(1000);
//
//        DriverManager.getDriver().findElement(By.xpath("//a[@class = 'aiz-side-nav-link'][normalize-space() = 'Category']")).click();
//        Thread.sleep(1000);
//
//        DriverManager.getDriver().findElement(By.xpath("//input[@id='search']")).sendKeys("Ngan_Beer", Keys.ENTER);
//        Thread.sleep(2000);
//
//        System.out.println(DriverManager.getDriver().findElement(By.xpath("//td[normalize-space()='Ngan_Beer']")).getText());
//        Thread.sleep(1000);
//
//        String getTextNameCategory = "//td[normalize-space()='Ngan_Beer']";
//        WebElement getNameCategory = DriverManager.getDriver().findElement(By.xpath(getTextNameCategory));
//
//        if (getNameCategory.getText().equals("Ngan_Beer")) {
//            System.out.println(getNameCategory.getText());
//            System.out.println("True");
//        } else {
//            System.out.println("False");
//            System.out.println(getNameCategory.getText());
//        }
//    }

    }
