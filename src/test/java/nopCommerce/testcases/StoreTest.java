package nopCommerce.testcases;

import nopCommerce.base.BaseTest;
import org.testng.annotations.Test;

public class StoreTest extends BaseTest {

    @Test
    public void testProductStore(){
        homePage.load();
        var loginpage = homePage.clickLoginButton();
        loginpage.login("Mina_Magdy","Mina123");
        homePage.clickStoreDemo();
    }
}
