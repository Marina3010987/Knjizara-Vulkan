package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends PageObject {
    @FindBy(xpath= "//span[string()='Prijavite se']")
    WebElement iconLoginButton;

    @FindBy(id = "login_email")
    WebElement emailField;

    @FindBy(id = "login_password")
    WebElement passwordField;

    @FindBy(xpath = "//span[string()='Prijava']")
    WebElement loginButton;

    public LoginPage(ChromeDriver driver) {
        super(driver);
        // AUTO GENERATED CONSTRUCTOR
    }

    public LoginPage clickOnIcon() {
        iconLoginButton.click();
        return this;
    }

    public LoginPage enterUserName(String userName) {
        emailField.sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitButtonSuccess() {
        loginButton.click();
        return this;
    }

    public LoginPage successfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get(Strings.LOGIN_URL);
        loginPage.clickOnIcon()
                .enterUserName(Strings.VALID_EMAIL)
                .enterPassword(Strings.VALID_PASSWORD)
                .clickSubmitButtonSuccess();
        return this;
    }

}