package lt.itacademy.pom.UserLoginTests;

import lt.itacademy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(css = "h4 > a")
    private WebElement createNewUser;

    @FindBy(css = "div > input[name=\"username\"]")
    private WebElement loginUsername;

    @FindBy(css = "div > input[name=\"password\"]")
    private WebElement loginPassword;

    @FindBy(css = ".btn-lg")
    private WebElement loginButton;

    @FindBy(css = "div :nth-child(4)")
    private WebElement negativeLoginMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickToCreateNewUser(){
        createNewUser.click();
    }

    public void sendLoginUserName(String usernameToLogin){
        loginUsername.sendKeys(usernameToLogin);
    }

    public void sendLoginPassword(String passwordToLogin){
        loginPassword.sendKeys(passwordToLogin);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getNegativeLoginMsg(){
        return negativeLoginMsg.getText();
    }
}
