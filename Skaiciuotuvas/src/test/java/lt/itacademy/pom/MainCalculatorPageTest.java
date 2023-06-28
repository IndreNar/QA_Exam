package lt.itacademy.pom;

import lt.itacademy.pom.UserLogin.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainCalculatorPageTest extends BaseTest {
    private String loginUsername = "Karlsonas";
    private String loginPassword = "passwordas";
    private String firstNumber = "5";
    private String secondNumber = "11";
    private String secondNumberNegative = "-2";

    LoginPage loginPage;
    MainCalculatorPage mainCalculatorPage;
    PerformedSingleOperationPage performedSingleOperationPage;




    @Test
    public void createNewRecordPositiveTest(){

        loginPage = new LoginPage(driver);
        mainCalculatorPage = new MainCalculatorPage(driver);
        performedSingleOperationPage = new PerformedSingleOperationPage(driver);

        loginPage.sendLoginUserName(loginUsername);
        loginPage.sendLoginPassword(loginPassword);
        loginPage.clickLoginButton();

        mainCalculatorPage.sendFirstNumber(firstNumber);
        mainCalculatorPage.sendSecondNumber(secondNumber);
        mainCalculatorPage.clickToSelectOperation();
        mainCalculatorPage.clickToSelectMultiplication();
        mainCalculatorPage.clickToExecuteOperation();

        String expectedPerformedOperationResult = firstNumber + " * " + secondNumber + " = 55";
        String displayedPerformedOperationResult = performedSingleOperationPage.getPerformedOperationResult();

        Assertions.assertEquals(expectedPerformedOperationResult, displayedPerformedOperationResult, "Result messages do not match");
    }


    @Test
    public void createNewRecordNegativeTestWithNegativeNumber() {

        loginPage = new LoginPage(driver);
        mainCalculatorPage = new MainCalculatorPage(driver);

        loginPage.sendLoginUserName(loginUsername);
        loginPage.sendLoginPassword(loginPassword);
        loginPage.clickLoginButton();

        mainCalculatorPage.sendFirstNumber(firstNumber);
        mainCalculatorPage.sendSecondNumber(secondNumberNegative);

        mainCalculatorPage.clickToExecuteOperation();

        String expectedValidationMegForSecondNumber = "Validacijos klaida: skaičius negali būti neigiamas";
        String displayedValidationMegForSecondNumber = mainCalculatorPage.getValidationErrorMsgForSecondNumber();

        Assertions.assertEquals(expectedValidationMegForSecondNumber, displayedValidationMegForSecondNumber, "Result messages do not match");
    }
}
