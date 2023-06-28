package lt.itacademy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PerformedSingleOperationPage extends AbstractPage {

    @FindBy(xpath = "//h4")
    private WebElement operationResult;


    public PerformedSingleOperationPage(WebDriver driver) {
        super(driver);
    }

    public String getPerformedOperationResult(){
        return operationResult.getText();
    }
}
