package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    private final By firstNameField = By.id("FirstName");
    private final By lastNameField = By.id("LastName");
    private final By emailField = By.id("Email");
    private final By confirmEmailField = By.id("ConfirmEmail");
    private final By usernameField = By.id("Username");
    private final By countryDropDown = By.id("CountryId");
    private final By timeZoneDropDown = By.id("TimeZoneId");
    private final By newSletters = By.cssSelector(".custom-control-label");
    private final By passwordField = By.id("Password");
    private final By confirmPasswordField = By.id("ConfirmPassword");
    private final By companyPrimarilyDropDown = By.id("Details_CompanyIndustryId");
    private final By mainActivityInTheCompanyDropDown = By.id("Details_CompanyRoleId");
    private final By howManyPeopleWorkForYourCompanyDropDown = By.id("Details_CompanySizeId");
    private final By myCompanyWebsite = By.id("Details_CompanyWebsiteUrl");
    private final By registerButton = By.id("register-button");
    private final By developingExtensionsDropDown = By.id("Details_ExtensionsDevelopmentPeriodId");
    private final By selectYes = By.cssSelector(".custom-control-inline");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setConfirmEmail(String confirmEmail) {
        driver.findElement(confirmEmailField).sendKeys(confirmEmail);
    }

    public void setUsername(String userName) {
        driver.findElement(usernameField).sendKeys(userName);
    }

    public void selectCountry(String countryName) {
        WebElement country = driver.findElement(countryDropDown);
        Select option = new Select(country);
        option.selectByVisibleText(countryName);
    }

    public void selectTimeZone(int timeZoneIndex) {
        WebElement timeZone = driver.findElement(timeZoneDropDown);
        Select option = new Select(timeZone);
        option.selectByIndex(timeZoneIndex);
    }

    public void clickNewSettle() {
        driver.findElement(newSletters).click();
    }

    public void setPasswordAndConfirmPassword(String password, String confirmPassword) {
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void selectCompanyPrimarily(String value) {
        WebElement companyPrimarily = driver.findElement(companyPrimarilyDropDown);
        Select option = new Select(companyPrimarily);
        option.selectByValue(value);
    }

    public void selectMainActivityInTheCompany(int index) {
        WebElement mainActivity = driver.findElement(mainActivityInTheCompanyDropDown);
        Select option = new Select(mainActivity);
        option.selectByIndex(index);
    }

    public void selectHowManyPeopleWorkForYourCompany(int index) {
        WebElement people = driver.findElement(howManyPeopleWorkForYourCompanyDropDown);
        Select option = new Select(people);
        option.selectByIndex(index);
    }

    public void setMyCompanyWebsite(String url) {
        driver.findElement(myCompanyWebsite).sendKeys(url);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    public void selectDevelopingExtensions(int index) {
        WebElement developingExtensions = driver.findElement(developingExtensionsDropDown);
        Select option = new Select(developingExtensions);
        option.selectByIndex(index);

    }

    public void clickYes() {
        driver.findElement(selectYes).click();

    }

    public ResultPage register(String fName, String lName, String mail, String userName, String country, int timeZone,
                               String password, String companyPrimarily) {
        setFirstName(fName);
        setLastName(lName);
        setEmail(mail);
        setConfirmEmail(mail);
        setUsername(userName);
        selectCountry(country);
        selectTimeZone(timeZone);
        clickNewSettle();
        setPasswordAndConfirmPassword(password, password);
        selectCompanyPrimarily(companyPrimarily); // select by value
        clickRegisterButton();
        return new ResultPage(driver);
    }

    public String geturlOfPage() {
        return driver.getCurrentUrl();
    }

}
