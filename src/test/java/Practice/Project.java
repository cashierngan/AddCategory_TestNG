package Practice;

import Common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Project extends BaseTest {

    @Test(priority = 1)
    public void loginHRM() throws InterruptedException {

        driver.navigate().to("https://hrm.anhtester.com");
        Thread.sleep(2000L);

        System.out.println("Login Form");
        String loginPageText = driver.findElement(By.xpath("//h4[@class='mb-3 f-w-600']")).getText().trim();
        System.out.println(loginPageText);
        Assert.assertEquals(loginPageText, "Welcome to HRM System", "Validate Label login");
        System.out.println(driver.getTitle());
        String userName = "//input[@id = 'iusername']";
        String passWord = "//input[@id = 'ipassword']";
        String login = "//button[normalize-space() = 'Login']";
        WebElement inputUserName = driver.findElement(By.xpath(userName));
        WebElement inputPassword = driver.findElement(By.xpath(passWord));
        WebElement buttonLogin = driver.findElement(By.xpath(login));
        inputUserName.sendKeys("admin01");
        Thread.sleep(1000L);
        inputPassword.sendKeys("123456");
        Thread.sleep(2000L);
        buttonLogin.click();
        Thread.sleep(4000L);
    }

    @Test(priority = 2)
    public void openProject() throws InterruptedException {
            System.out.println("openDuAn");
            driver.findElement(By.xpath("//span[contains(text(),'Dự án')]")).click();
            Thread.sleep(2000);
            String pageDuAnURL = driver.getCurrentUrl();
            System.out.println(pageDuAnURL);
            Assert.assertTrue(pageDuAnURL.contains("/projects-list"), "Không đúng URL của trang Dự Án");


        }

    @Test(priority = 3)
    public void addNewProject() throws InterruptedException {
        System.out.println("Add new project");
        String addProject = "//a[@href = '#add_form' and @class = 'collapsed btn waves-effect waves-light btn-primary btn-sm m-0']";
        String titleProject = "//input[@name = 'title']";
        String clientProject = "//span[@id = 'select2-client_id-container']";
        String selectClientProject = "(//input[@role='searchbox'])[2]";
        String estimateHourProject = "//input[contains (@placeholder, 'Estimated Hour')]";
        String priorityProject = "(//span[@class='select2-selection__arrow'])[2]";
        String selectPriorityPJ = "//span[@class='select2-search select2-search--dropdown']/child::input";
        String startDatePJ = "//input[@placeholder = 'Start Date']";
        String submitStartDatePJ = "(//button[@class='dtp-btn-ok btn btn-flat btn-primary btn-sm' and text() = 'OK'])[1]";
        String endDatePJ = "//input[@placeholder = 'End Date']";
        String submitEndDatePJ = "(//button[@class='dtp-btn-ok btn btn-flat btn-primary btn-sm' and text() = 'OK'])[2]";
        String sumamryPJ = "//textarea[@placeholder = 'Summary']";
        String teamPJ = "//span[@class='select2-selection select2-selection--multiple']";
        String savePJ = "//button//span[@class='ladda-label' and normalize-space()='Save']";
        String iframe = "//iframe[@title = 'Editable area. Press F10 for toolbar.']";
        String description = "//html//body";

        WebElement buttonAddProject = driver.findElement(By.xpath(addProject));
        buttonAddProject.click();
        Thread.sleep(2000L);
        WebElement inputTitleProject = driver.findElement(By.xpath(titleProject));
        inputTitleProject.sendKeys(new CharSequence[]{"Touring Project"});
        Thread.sleep(2000L);
        WebElement droplistClientProject = driver.findElement(By.xpath(clientProject));
        droplistClientProject.click();
        Thread.sleep(2000L);
        WebElement inputClientProject = driver.findElement(By.xpath(selectClientProject));
        inputClientProject.sendKeys(new CharSequence[]{"Lam", Keys.ENTER});
        Thread.sleep(1000L);
        WebElement inputEstimateHourProject = driver.findElement(By.xpath(estimateHourProject));
        inputEstimateHourProject.sendKeys(new CharSequence[]{"6.5"});
        Thread.sleep(2000L);
        WebElement droplistPriorityProject = driver.findElement(By.xpath(priorityProject));
        droplistPriorityProject.click();
        Thread.sleep(2000L);
        WebElement inputPriorityPJ = driver.findElement(By.xpath(selectPriorityPJ));
        inputPriorityPJ.sendKeys(new CharSequence[]{"Normal", Keys.ENTER});
        Thread.sleep(1000L);
        WebElement datePicStartDatePJ = driver.findElement(By.xpath(startDatePJ));
        datePicStartDatePJ.click();
        Thread.sleep(2000L);
        WebElement buttonSubmitStartDatePJ = driver.findElement(By.xpath(submitStartDatePJ));
        buttonSubmitStartDatePJ.click();
        Thread.sleep(1000L);
        WebElement datePicEndDatePJ = driver.findElement(By.xpath(endDatePJ));
        datePicEndDatePJ.click();
        Thread.sleep(2000L);
        WebElement buttonSubmitEndDatePJ = driver.findElement(By.xpath(submitEndDatePJ));
        buttonSubmitEndDatePJ.click();
        Thread.sleep(1000L);
        WebElement inputSummaryPJ = driver.findElement(By.xpath(sumamryPJ));
        inputSummaryPJ.sendKeys(new CharSequence[]{"Testing automation"});
        Thread.sleep(2000L);
        WebElement inputTeamPJ = driver.findElement(By.xpath(teamPJ));
        inputTeamPJ.sendKeys(new CharSequence[]{"Admin 01", Keys.ENTER});
        Thread.sleep(2000L);
        driver.switchTo().frame(driver.findElement(By.xpath(iframe)));
        Thread.sleep(1000L);
        WebElement inputDescription = driver.findElement(By.xpath(description));
        inputDescription.sendKeys(new CharSequence[]{"testing"});
        Thread.sleep(2000L);
        driver.switchTo().defaultContent();
        WebElement buttonSavePJ = driver.findElement(By.xpath(savePJ));
        buttonSavePJ.click();
        Thread.sleep(4000L);
    }
}
