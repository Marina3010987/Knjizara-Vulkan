package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RomaniPage extends PageObject {

    @FindBy(className = "headding-wrapper")
    WebElement romaniTitle;

    @FindBy(className="wrapper-gridalt-view")
    List<WebElement> listOfRomans;

    public RomaniPage(ChromeDriver driver) {
        super(driver);
        // AUTO GENERATED CONSTRUCTOR
    }

    public String checkRomaniTitle() {
        return romaniTitle.getText();
    }

    public void chooseProduct() {
        listOfRomans.get(1).click();
        return;
    }

}
