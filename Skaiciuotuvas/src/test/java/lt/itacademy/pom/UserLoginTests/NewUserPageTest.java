package lt.itacademy.pom.UserLoginTests;

import lt.itacademy.pom.BaseTest;
import lt.itacademy.pom.MainCalculatorPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewUserPageTest extends BaseTest {

    private String newUserName = "Karlsonas";
    private String userPassword = "passwordas";
    private String userPasswordConfirm = "passwordas";
    LoginPage homePage;
    NewUserPage newUserPage;
    MainCalculatorPage mainCalculatorPage;


    @Test
    public void CreateNewUserPositiveTest(){

        homePage = new LoginPage(driver);
        newUserPage = new NewUserPage(driver);
        mainCalculatorPage = new MainCalculatorPage(driver);

        homePage.clickToCreateNewUser();
        newUserPage.sendUsername(newUserName + newUserPage.generateRandomNumber());
        newUserPage.sendPassword(userPassword);
        newUserPage.sendPasswordConfirm(userPasswordConfirm);
        newUserPage.clickToCreateNewUser();

        String expectedCalculatorTitle = "Galimos operacijos: sudėti, atimti, dauginti, dalinti";
        String displayedCalculatorTitle = mainCalculatorPage.getCalculatorTitle();

        Assertions.assertEquals(expectedCalculatorTitle, displayedCalculatorTitle, "Titles do not match");

    }


    @Test
    public void CreateNewUserNegativeTestWithEmptyConfirmPassword() {

        homePage = new LoginPage(driver);
        newUserPage = new NewUserPage(driver);

        homePage.clickToCreateNewUser();
        newUserPage.sendUsername(newUserName + newUserPage.generateRandomNumber());
        newUserPage.sendPassword(userPassword);
        newUserPage.clickToCreateNewUser();

        String expectedPasswordWarningMessage = "Įvesti slaptažodžiai nesutampa";
        String displayedPasswordWarningMessage = newUserPage.getBadConfirmPasswordMsg();

        Assertions.assertEquals(expectedPasswordWarningMessage, displayedPasswordWarningMessage, "Bad Confirm password messages do not match");
    }
}
