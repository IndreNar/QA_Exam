package lt.itacademy.pom.OperationsTests;

import lt.itacademy.pom.BaseTest;
import lt.itacademy.pom.MainCalculatorPage;
import lt.itacademy.pom.PerformedOperationsPage;
import lt.itacademy.pom.UserLoginTests.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Optional;

public class PerformedOperationsPageTest extends BaseTest {

    private String loginUsername = "Karlsonas";
    private String loginPassword = "passwordas";
    private String firstNumber = "5";
    private String secondNumber = "11";

    LoginPage loginPage;
    MainCalculatorPage mainCalculatorPage;
    PerformedOperationsPage performedOperationsPage;


    @Test
    public void findRecordPositiveTest() {

        loginPage = new LoginPage(driver);
        mainCalculatorPage = new MainCalculatorPage(driver);
        performedOperationsPage = new PerformedOperationsPage(driver);

        loginPage.sendLoginUserName(loginUsername);
        loginPage.sendLoginPassword(loginPassword);
        loginPage.clickLoginButton();

        mainCalculatorPage.clickToOpenPerformedOperationsPage();
        performedOperationsPage.clickToOpenLastOperation();


        String expectedFirstNumber = "5";
        String actualFirstNumber = performedOperationsPage.getFirstNumberInOperationsPage();
        Assertions.assertEquals(expectedFirstNumber, actualFirstNumber, "First Numbers do not match");

        String expectedOperationSign = "*";
        String actualOperationSign = performedOperationsPage.getOperationSignInOperationsPage();
        Assertions.assertEquals(expectedOperationSign, actualOperationSign, "Operation signs do not match");

        String expectedSecondNumber = "11";
        String actualSecondNumber = performedOperationsPage.getSecondNumberInOperationsPage();
        Assertions.assertEquals(expectedSecondNumber, actualSecondNumber, "Second numbers do not match");

        String expectedResult = "55";
        String actualResult = performedOperationsPage.getResultInOperationsPage();
        Assertions.assertEquals(expectedResult, actualResult, "Results do not match");

    }


    @Test
    public void findRecordNegativeTest() {

        loginPage = new LoginPage(driver);
        mainCalculatorPage = new MainCalculatorPage(driver);
        performedOperationsPage = new PerformedOperationsPage(driver);

        loginPage.sendLoginUserName(loginUsername);
        loginPage.sendLoginPassword(loginPassword);
        loginPage.clickLoginButton();

        mainCalculatorPage.clickToOpenPerformedOperationsPage();

        String expectedResultInResultList = "99";

        List<WebElement> displayedResults = performedOperationsPage.listedResults();

        Optional<WebElement> matchingResult = displayedResults.stream().filter(r -> r.getText().equals(expectedResultInResultList)).findFirst();
        Boolean isResultInTheList = false;
        if (matchingResult.isPresent()){
            isResultInTheList = true;
        } else {
            isResultInTheList = false;
        }

        Assertions.assertFalse(isResultInTheList, "Result is in the list");

    }

}
