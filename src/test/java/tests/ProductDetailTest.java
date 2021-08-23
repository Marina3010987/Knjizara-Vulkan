package tests;

//import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.junit.Assert;
//import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class ProductDetailTest extends BaseTest {

    public WebDriverWait wait;

    /**
     * Test 3- Successfully open one product
     * Steps:
     * 1. Navigate to knjizare-vulkan.rs site
     * 2. Successfully login
     * 3. Hover 'Knjige' tab
     * 4. Choose 'Romani' option
     * 5. Choose second item from the list
     *
     * Expected result:
     * 5.Verify that selected product is opened
     */
    @Test()
    public void chooseOneRoman() throws InterruptedException {
        ChromeDriver driver =  openChromeDriver();
        LoginPage login = new LoginPage(driver);
        login.successfulLogin();
        HomePage homePage = new HomePage(driver);
        Thread.sleep(4000);
        homePage.hoverTabKnjige();
        homePage.clickRomaniOption();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-listing-items")));
        RomaniPage romaniPage = new RomaniPage(driver);
        romaniPage.chooseProduct();
        ProductDetailPage productDetail = new ProductDetailPage(driver);
        Assert.assertEquals(productDetail.verifyPresenceOfElement(), true);
        driver.quit();
    }

    /**
     * Test 4- Change quantity and add to basket
     * Steps:
     * 1. Navigate to knjizare-vulkan.rs site
     * 2. Successfully login
     * 3. Hover 'Knjige' tab
     * 4. Choose 'Romani' option
     * 5. Choose second item from the list
     * 6. Change quantity to be 3
     * 7. Add products to a basket
     *
     * Expected result:
     * 8.Verify that three products are added
     */

    @Test()
    public void changeQuantityaddToBasket() throws InterruptedException {
        ChromeDriver driver =  openChromeDriver();
        LoginPage login = new LoginPage(driver);
        login.successfulLogin();
        HomePage homePage = new HomePage(driver);
        Thread.sleep(4000);
        homePage.hoverTabKnjige();
        homePage.clickRomaniOption();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("product-listing-items")));
        RomaniPage romaniPage = new RomaniPage(driver);
        romaniPage.chooseProduct();
        ProductDetailPage productDetail = new ProductDetailPage(driver);
        productDetail.changeQuantity("3");
        productDetail.addToBasket();
        Thread.sleep(3000);
        Assert.assertEquals(productDetail.threeProductsInBasket(),"3");
        driver.quit();
    }
}
