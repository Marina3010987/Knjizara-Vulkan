package pages;

import com.google.common.collect.EnumBiMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CartPage extends PageObject{

    @FindBy(className="header-carthor-total")
    WebElement total;

    @FindBy(xpath="//a[string()='MOJA KORPA']")
    WebElement myBasket;

    @FindBy(id="quantity_1")
    WebElement selectQuantity;

    @FindBy(xpath="//a[string()='Izbrišite']")
    WebElement deleteProduct;

    @FindBy(xpath="//button[string()='POTVRDI']")
    WebElement confirmButton;

    @FindBy(className = "alert-danger")
    WebElement emptyCartMessage;


    public CartPage(ChromeDriver driver) {
        super(driver);
        // AUTO GENERATED CONSTRUCTOR
    }

    public void hoverBasket() {
        Actions builder = new Actions(driver);
        Action hover = builder
                .moveToElement(total)
                .build();
        hover.perform();
    }

    public void myBasketButton(){
        myBasket.click();
    }

    public Boolean verifyYourBasketText() {
        return driver.getPageSource().contains("Vaša korpa");
    }

    public void selectDifferentQuantity() {
        Select objSelect = new Select(selectQuantity);
        objSelect.selectByValue("5");
    }

    public void deleteAction() {
        deleteProduct.click();
    }

    public void popUpConfirm() {
        confirmButton.click();
    }

    public String emptyCart() {
        return emptyCartMessage.getText();
    }
}
