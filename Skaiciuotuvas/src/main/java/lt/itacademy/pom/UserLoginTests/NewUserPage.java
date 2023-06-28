package lt.itacademy.pom.UserLoginTests;

import lt.itacademy.pom.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class NewUserPage extends AbstractPage {

    @FindBy(css = "#username")
    private WebElement newUserName;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "#passwordConfirm")
    private WebElement passwordConfirm;

    @FindBy(css = ".btn-lg")
    private WebElement createNewUserButton;

    @FindBy(css = "div > span")
    private WebElement badConfirmPasswordMsg;


    public NewUserPage(WebDriver driver) {
        super(driver);
    }


    public void sendUsername(String userName){
        newUserName.sendKeys(userName);
    }

    public void sendPassword(String userPassword){
        password.sendKeys(userPassword);
    }

    public void sendPasswordConfirm(String userPasswordConfirm){
        passwordConfirm.sendKeys(userPasswordConfirm);
    }

    public void clickToCreateNewUser(){
        createNewUserButton.click();
    }

    public String getBadConfirmPasswordMsg(){
        return badConfirmPasswordMsg.getText();
    }

    public int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(1000);
    }


}
