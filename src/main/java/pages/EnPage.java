package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnPage extends BasePage {

    private final By messagePicture = By.cssSelector(".navigation-private-messages");
    private final By cartPicture = By.cssSelector(".navigation-shopping-cart");

    public EnPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnMessage() {
        driver.findElement(messagePicture).click();
    }

    public String geturlOfPage() {
        return driver.getCurrentUrl();
    }

    public void clickOnCart() {
        driver.findElement(cartPicture).click();
    }

}
