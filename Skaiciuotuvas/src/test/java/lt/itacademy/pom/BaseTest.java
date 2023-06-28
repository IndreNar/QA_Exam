package lt.itacademy.pom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    @BeforeEach
    public void createDriverOpenBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/prisijungti");
     }

    @AfterEach
    public void quitBrowser(){
        driver.quit();

    }
}
