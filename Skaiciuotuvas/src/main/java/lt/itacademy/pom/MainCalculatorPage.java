package lt.itacademy.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//h2")
    private WebElement calculatorTitle;

    @FindBy(css = "#sk1")
    private WebElement firstNumberInput;

    @FindBy(css = "#sk2")
    private WebElement secondNumberInput;

    @FindBy(css = "select[name=\"zenklas\"]")
    private WebElement operationForNumbers;

    @FindBy(css = "select[name=\"zenklas\"] > option:nth-child(3)")
    private WebElement operationMultiply;

    @FindBy(css = "input[value=\"skaičiuoti\"]")
    private WebElement operationExecutionButton;

    @FindBy(css = "span[id=\"sk2.errors\"]")
    private WebElement validationErrorMsgForSecondNumber;

    @FindBy(css = "li > a")
    private WebElement performedOperationsTab;

    public MainCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public String getCalculatorTitle(){
        return calculatorTitle.getText();
    }

    public void sendFirstNumber(String firstNumber){
        firstNumberInput.click();
        firstNumberInput.sendKeys(Keys.CONTROL + "a");
        firstNumberInput.sendKeys(Keys.DELETE);
        firstNumberInput.sendKeys(firstNumber);
    }

    public void sendSecondNumber(String secondNumber){
        secondNumberInput.click();
        secondNumberInput.sendKeys(Keys.CONTROL + "a");
        secondNumberInput.sendKeys(Keys.DELETE);
        secondNumberInput.sendKeys(secondNumber);
    }

    public void clickToSelectOperation(){
        operationForNumbers.click();
    }

    public void clickToSelectMultiplication(){
        operationMultiply.click();
    }

    public void clickToExecuteOperation(){
        operationExecutionButton.click();
    }

    public String getValidationErrorMsgForSecondNumber(){
        return validationErrorMsgForSecondNumber.getText();
    }

    public void clickToOpenPerformedOperationsPage(){
        performedOperationsTab.click();
    }
}
