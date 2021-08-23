package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class CartTest extends BaseTest {

    public WebDriverWait wait;


    /**
     * Test 5- Successfully open cart page
     * Steps:
     * 1. Navigate to knjizare-vulkan.rs site
     * 2. Successfully login
     * 3. Hover 'Knjige' tab
     * 4. Choose 'Romani' option
     * 5. Choose second item from the list
     * 6. Change quantity to be 3
     * 7. Add products to a basket
     * 8. Open cart page
     *
     * Expected result:
     * 8.Verify that cart page is opened
     */
    @Test
    public void openCartPage() throws InterruptedException {
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
        CartPage cartPage = new CartPage(driver);
        cartPage.hoverBasket();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[string()='MOJA KORPA']"))));
        cartPage.myBasketButton();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[string()='Vaša korpa']"))));
        Assert.assertEquals(cartPage.verifyYourBasketText(),true);
        driver.quit();
    }

    /**
     * Test 6- Change quantity, from select list, to be 5
     * Steps:
     * 1. Navigate to knjizare-vulkan.rs site
     * 2. Successfully login
     * 3. Hover 'Knjige' tab
     * 4. Choose 'Romani' option
     * 5. Choose second item from the list
     * 6. Change quantity to be 3
     * 7. Add products to a basket
     * 8. Open cart page
     * 9. Change quantity to be 5
     *
     * Expected result:
     * 10.Verify that quantity is changed in basket icon
     */

    @Test
    public void changeQuantityTo5() throws InterruptedException {
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
        CartPage cartPage = new CartPage(driver);
        cartPage.hoverBasket();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[string()='MOJA KORPA']"))));
        cartPage.myBasketButton();
        cartPage.selectDifferentQuantity();
        Thread.sleep(4000);
        Assert.assertEquals(productDetail.fiveProductsInBasket(),"5");
        driver.quit();
    }

    /**
     * Test 7- Delete product from a cart
     * Steps:
     * 1. Navigate to knjizare-vulkan.rs site
     * 2. Successfully login
     * 3. Hover 'Knjige' tab
     * 4. Choose 'Romani' option
     * 5. Choose second item from the list
     * 6. Add product to a basket
     * 7. Open cart page
     * 8. Delete product from the cart
     *
     * Expected result:
     * 9.Verify that cart is empty
     */
    @Test
    public void deleteProductFromCart() throws InterruptedException {
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
        productDetail.addToBasket();
        Thread.sleep(3000);
        CartPage cartPage = new CartPage(driver);
        cartPage.hoverBasket();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[string()='MOJA KORPA']"))));
        cartPage.myBasketButton();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[string()='Izbrišite']"))));
        cartPage.deleteAction();
        cartPage.popUpConfirm();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("empty-cart-alert-wrapper"))));
        Assert.assertEquals(cartPage.emptyCart(),"Vaša korpa je prazna!");
        driver.quit();
    }
}
