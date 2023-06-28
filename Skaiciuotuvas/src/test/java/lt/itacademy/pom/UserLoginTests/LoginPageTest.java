package lt.itacademy.pom.UserLoginTests;

import lt.itacademy.pom.BaseTest;
import lt.itacademy.pom.MainCalculatorPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest {

    private String loginUsername = "Karlsonas";
    private String wrongUsername = "Karsonass";
    private String loginPassword = "passwordas";

    LoginPage loginPage;
    MainCalculatorPage mainCalculatorPage;


    @Test
    public void loginUserPositiveTest() {

        loginPage = new LoginPage(driver);
        mainCalculatorPage = new MainCalculatorPage(driver);

        loginPage.sendLoginUserName(loginUsername);
        loginPage.sendLoginPassword(loginPassword);
        loginPage.clickLoginButton();

        String expectedCalculatorTitle = "Galimos operacijos: sudėti, atimti, dauginti, dalinti";
        String displayedCalculatorTitle = mainCalculatorPage.getCalculatorTitle();

        Assertions.assertEquals(expectedCalculatorTitle, displayedCalculatorTitle, "Titles do not match");
    }


    @Test
    public void loginUserNegativeTestWrongUserName() {

        loginPage = new LoginPage(driver);
        mainCalculatorPage = new MainCalculatorPage(driver);

        loginPage.sendLoginUserName(wrongUsername);
        loginPage.sendLoginPassword(loginPassword);
        loginPage.clickLoginButton();

        String expectedNegativeLoginMsg = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String displayedNegativeLoginMsg = loginPage.getNegativeLoginMsg();

        Assertions.assertEquals(expectedNegativeLoginMsg, displayedNegativeLoginMsg, "Displayed messages for negative login do not match");
    }
}
