package nopCommerce.testcases;

import com.github.javafaker.Faker;
import nopCommerce.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    private String username;
    private String password;

    @Test
    public void testLoginWithValidUserNameAndPassword() {
        String expectedResult = "https://www.nopcommerce.com/en";

        homePage.load();
        var loginPage = homePage.clickLoginButton();
        loginPage.login("Mina_Magdy", "Mina123");

        String actualResult = loginPage.geturlOfPage();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLoginWithInvalidData() {
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        username = new Faker().name().fullName();
        password = new Faker().internet().password();
        homePage.load();
        var loginPage = homePage.clickLoginButton();
        loginPage.login(username, password);
        String actualResult = loginPage.getMessageErrorAfterInvalidLogin();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLoginWithInvalidUserName() {
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        username = new Faker().name().fullName();
        password = "Mina123";
        homePage.load();
        var loginPage = homePage.clickLoginButton();
        loginPage.login(username, password);

        String actualResult = loginPage.getMessageErrorAfterInvalidLogin();
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLoginWithInvalidPassword() {
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";

        username = "Mina_Magdy";
        password = new Faker().internet().password();
        homePage.load();
        var loginPage = homePage.clickLoginButton();
        loginPage.login(username, password);

        String actualResult = loginPage.getMessageErrorAfterInvalidLogin();
        assertEquals(actualResult, expectedResult);
    }
}
