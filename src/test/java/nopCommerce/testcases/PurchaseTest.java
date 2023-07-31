package nopCommerce.testcases;

import nopCommerce.base.BaseTest;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void buyMobilePhone() {
        homePage.load();
        homePage.clickLoginButton().login("Mina_Magdy", "Mina123");
        var purchasePage = homePage.clickStoreDemo().clickFrontEndButton();

        purchasePage.switchToTap("nopCommerce demo store");
        purchasePage.login("mina.m.halim642@gmail.com", "Mina123");
        purchasePage.clickCamera();
        purchasePage.clickAddToCart();
    }
}
