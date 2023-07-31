package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoPage extends BasePage {

    private final By frontEndButton = By.xpath("//*[text()='Frontend']");

    public DemoPage(WebDriver driver) {
        super(driver);
    }

    public PurchasePage clickFrontEndButton() {
        driver.findElement(frontEndButton).click();
        return new PurchasePage(driver);
    }
}
