package lt.itacademy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PerformedOperationsPage extends AbstractPage {

    @FindBy(css = "tbody > tr:last-child > td:last-child > a:last-child")
    private WebElement openLastOperation;

    @FindBy(css = "tbody > tr:nth-child(2) > td:last-child")
    private WebElement firstNumberInOperationsPage;

    @FindBy(css = "tbody > tr:nth-child(3) > td:last-child")
    private WebElement operationSignInOperationsPage;

    @FindBy(css = "tbody > tr:nth-child(4) > td:last-child")
    private WebElement secondNumberInOperationsPage;

    @FindBy(css = "tbody > tr:last-child > td:last-child")
    private WebElement resultInOperationsPage;

    @FindBy(css = "tbody > tr> td:nth-child(4)")
    private List<WebElement> listOfResults;



    public PerformedOperationsPage(WebDriver driver) {
        super(driver);
    }


    public void clickToOpenLastOperation(){
        openLastOperation.click();
    }

    public String getFirstNumberInOperationsPage(){
        return firstNumberInOperationsPage.getText();
    }

    public String getOperationSignInOperationsPage(){
        return operationSignInOperationsPage.getText();
    }

    public String getSecondNumberInOperationsPage(){
        return secondNumberInOperationsPage.getText();
    }

    public String getResultInOperationsPage(){
        return resultInOperationsPage.getText();
    }

    public List<WebElement> listedResults(){
        return listOfResults;
    }

}
