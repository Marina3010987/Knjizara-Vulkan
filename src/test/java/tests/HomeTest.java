package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RomaniPage;

public class HomeTest extends BaseTest {

    /**
     * Test 2 - Successfully open Romani Page
     * Steps:
     * 1. Navigate to knjizare-vulkan.rs site
     * 2. Successfully login
     * 3. Hover 'Knjige' tab
     * 4. Choose 'Romani' option
     *
     *
     * Expected result:
     * 5.Verify that Romani Page is opened
     */

    @Test()
    public void openRomaniPage() throws InterruptedException {
        ChromeDriver driver =  openChromeDriver();
        LoginPage login = new LoginPage(driver);
        login.successfulLogin();
        HomePage homePage = new HomePage(driver);
        Thread.sleep(4000);
        homePage.hoverTabKnjige();
        homePage.clickRomaniOption();
        RomaniPage romaniPage = new RomaniPage(driver);
        Assert.assertEquals(romaniPage.checkRomaniTitle(), "ROMANI");
        driver.quit();
    }

}
