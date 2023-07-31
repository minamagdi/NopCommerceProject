package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By userNameField = By.id("Username");
    private final By passwordField = By.id("Password");
    private final By loginButton = By.xpath("//*[@type='submit']");
    private final By errorMessageText = By.cssSelector(".message-error");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public EnPage login(String username, String password) {
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
        return new EnPage(driver);
    }

    public String geturlOfPage() {
        return driver.getCurrentUrl();
    }

    public String getMessageErrorAfterInvalidLogin() {
        return driver.findElement(errorMessageText).getText();
    }

}
