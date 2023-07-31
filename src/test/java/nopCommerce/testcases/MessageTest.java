package nopCommerce.testcases;

import nopCommerce.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MessageTest extends BaseTest {

    @Test
    public void testMessages() {
        String expectedResult = "https://www.nopcommerce.com/en/private-messages";
        homePage.load();
        var loginPage = homePage.clickLoginButton();
        var enPage = loginPage.login("Mina_Magdy", "Mina123");
        enPage.clickOnMessage();
        String actualResult = enPage.geturlOfPage();
        assertEquals(expectedResult, actualResult);
    }

}
