package nopCommerce.testcases;

import nopCommerce.base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CartTest extends BaseTest {

    @Test
    public void testCart() {
        String expectedResult = "https://www.nopcommerce.com/en/cart";
        homePage.load();
        var loginPage = homePage.clickLoginButton();
        var enPage = loginPage.login("Mina_Magdy", "Mina123");
        enPage.clickOnCart();
        String actualResult = enPage.geturlOfPage();
        assertEquals(expectedResult, actualResult);
    }
}
