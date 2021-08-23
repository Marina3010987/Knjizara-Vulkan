package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    /**
     * Test 1- Successful login with valid credentials
     * Steps:
     * 1. Navigate to knjizare-vulkan.rs site
     * 2. Click on login icon
     * 3. Enter valid username
     * 4. Enter valid password
     * 5. Click login button
     *
     * Expected result:
     * 5.Verify that user is logged in
     */
    @Test()
    public void testSuccessfulLogIn() {
        ChromeDriver driver =  openChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin();
        HomePage homePage =new HomePage(driver);
        Assert.assertEquals(homePage.verifySuccessfulLogin(), "Marina Marcetic");
        driver.quit();
    }
}
