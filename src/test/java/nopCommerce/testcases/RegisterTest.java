package nopCommerce.testcases;

import nopCommerce.base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RegisterTest extends BaseTest {

    @Test(dataProvider = "registerData")
    public void testUserWithValidData(String fName, String lName, String mail, String userName, String country, int timeZone,
                                      String password, String companyPrimarily) {
        String expectedResult = "https://www.nopcommerce.com/en/register-result/2";
        homePage.load();
        var registerPage = homePage.clickRegisterButton();
        registerPage.register(fName,lName,mail,userName,country,timeZone,password,companyPrimarily);
        String actualResult = registerPage.geturlOfPage();
        assertEquals(actualResult,expectedResult);
    }
    @DataProvider
    public Object[][] registerData() {
        Object[][] data = new Object[3][8];
        data[0][0] = "mina10"; data[0][1] = "magdy10";  data[0][2] = "minazaref@example.com" ;data[0][3]=
                "mina_magdyy_habash";data[0][4]="Egypt";data[0][5]=3;data[0][6]="ERERmiNeweA123";data[0][7]="5";
        data[1][0] = "ali20"; data[1][1] = "ahmed10";  data[1][2] = "ahmed_zakariayelwardy@example.com" ;data[1][3]=
                "ali_roshdy_saad";data[1][4]="Argentina";data[1][5]=3;data[1][6]="miNA123";data[1][7]="5";
        data[2][0] = "khRERRERiad"; data[2][1] = "sad10";  data[2][2] = "amrSaidadel@example.com" ;data[2][3]=
                "amr_Said__Khalid";data[2][4]="Algeria";data[2][5]=3;data[2][6]="miNA123";data[2][7]="5";

        return data;
    }
    @Test
    public void testUserWithInvalidData() {
        String expectedResult = "https://www.nopcommerce.com/en/register?returnurl=%2Fen";
        homePage.load();
        var registerPage =homePage.clickRegisterButton();
        registerPage.register("adel","halim","khalilFarag@example.com","adelkamel"
                ,"Egypt",3,"Mina123", "5");
        String actualResult = registerPage.geturlOfPage();
        assertEquals(actualResult,expectedResult);
    }
}
