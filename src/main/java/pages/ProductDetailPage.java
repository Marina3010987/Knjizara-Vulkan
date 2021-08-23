package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends PageObject {

    @FindBy(className = "product-details-info")
    WebElement checkInfo;

    @FindBy(id="product_quantity")
    WebElement quantity;

    @FindBy(id="nb_addToCartButton")
    WebElement addToBasket;

    @FindBy(className="header-carthor-total")
    WebElement total;

    public ProductDetailPage(ChromeDriver driver) {
        super(driver);
        // AUTO GENERATED CONSTRUCTOR
    }

    public Boolean verifyPresenceOfElement() {
        return checkInfo.isDisplayed();
    }

    public ProductDetailPage changeQuantity(String number) {
        quantity.clear();
        quantity.sendKeys(number);
        return this;
    }

    public void addToBasket() {
        addToBasket.click();
    }

    public String threeProductsInBasket(){
        return total.getText();
    }

    public String fiveProductsInBasket(){
        return total.getText();
    }
}
