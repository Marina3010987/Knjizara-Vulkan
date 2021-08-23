package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

    ChromeDriver driver = null;
    public WebDriverWait wait;

    public PageObject(ChromeDriver driver) {
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }
}
