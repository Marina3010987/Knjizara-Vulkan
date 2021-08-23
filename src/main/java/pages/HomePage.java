package pages;

//import org.junit.Assert;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageObject {

    @FindBy(className = "item-username" )
    WebElement itemUsername;

    @FindBy(xpath = "//span[string()='Knjige']" )
    WebElement tabKnjige;

    @FindBy(xpath = "//h5[string()='ROMANI']" )
    WebElement romaniOption;

    public HomePage(ChromeDriver driver) {
        super(driver);
        // AUTO GENERATED CONSTRUCTOR
    }

    public String verifySuccessfulLogin() {
        return itemUsername.getText();
    }

    public void hoverTabKnjige() {
        Actions builder = new Actions(driver);
        Action hover = builder
                .moveToElement(tabKnjige)
                .build();
        hover.perform();
    }

    public void clickRomaniOption() {
        romaniOption.click();
    }

}

