package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class PurchasePage extends BasePage {

    private final By loginButton = By.linkText("Log in");
    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By submitButton = By.cssSelector(".login-button");

    private final By electronicsButton = By.xpath("//*[text()='Electronics ']");
    private final By cameraButton = By.xpath("//*[text()='Camera & photo ']");
    private final By nikonCamera = By.cssSelector(".product-box-add-to-cart-button");

    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    public void switchToTap(String tapLink) {
        var windows = driver.getWindowHandles();
        System.out.println("Number of taps :" + windows.size());
        System.out.println("window handles :");
        windows.forEach(System.out::println);

        for (String window : windows) {
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);
            System.out.println("current window title: " + driver.getTitle());
            if (tapLink.equals(driver.getTitle())) {
                break;
            }
        }
    }


    public Set<String> getAllWindowHandles() {
        return driver.getWindowHandles();
    }

    public void login(String email, String password) {
        driver.findElement(loginButton).click();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        //driver.findElement(submitButton).click();
    }

    public void clickCamera() {
        WebElement electronic = driver.findElement(electronicsButton);
        WebElement phone = driver.findElement(cameraButton);

        Actions actions = new Actions(driver);
        actions.moveToElement(electronic).click(phone).build().perform();
    }


    public void clickAddToCart() {
        driver.findElement(nikonCamera).click();
    }


}
