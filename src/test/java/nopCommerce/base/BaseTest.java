package nopCommerce.base;

import nopCommerce.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
public class BaseTest {
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();//to solve problem of thread because of shared testng
    // class of tests in the same class and the value of driver.
    // make every tc have separate instance of this driver by using threadLocal from java
    protected HomePage homePage;

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public WebDriver getDriver() {
        return this.driver.get();
    }

    @BeforeMethod
    public void setUp() {
        WebDriver driver = new DriverFactory().initializeDriver();
        setDriver(driver);
        homePage = new HomePage(getDriver());
    }

    @AfterMethod
    public void tearDown() {
          getDriver().quit();
          //driver.quit();
    }
}
