package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.util.Properties;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }


    private final By pictureIcon = By.cssSelector(".user-actions-ico");
    private final By registerButton = By.xpath("//*[text()='Register']");
    private final By loginButton = By.xpath("//*[text()='Log in']");
    private final By storeDemoButton = By.xpath("//*[text()='Store demo']");
    private final By productDropDown = By.xpath("//*[text()='Product']");


    public void moveToUserPicture() {


        WebElement picture = driver.findElement(pictureIcon);
        Actions actions = new Actions(driver);
        actions.moveToElement(picture).build().perform();
    }

    public RegisterPage clickRegisterButton() {
        moveToUserPicture();
        driver.findElement(registerButton).click();
        return new RegisterPage(driver);
    }

    public LoginPage clickLoginButton() {
        moveToUserPicture();
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public Properties loadProperties(String filePath) {
        File file = new File(filePath);
        try {
            InputStream inputStream = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("file not found");
        } catch (IOException e) {
            throw new RuntimeException("error loading property");
        }
    }

    public void load() {
        Properties property = loadProperties("src/test/java/nopCommerce/properties/Production" +
                ".properties");
        String url = property.getProperty("baseurl");
        driver.get(url);
        //driver.get("https://www.nopcommerce.com/en");
    }

    public DemoPage clickStoreDemo() {
        WebElement product = driver.findElement(productDropDown);
        WebElement storeDemo = driver.findElement(storeDemoButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(product).click(storeDemo).build().perform();
        return new DemoPage(driver);
    }

    public String getParentWindowHandle() {
        return driver.getWindowHandle();
    }

}

