package lt.itacademy.pom.UserLoginTests;


import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({LoginPageTest.class, NewUserPageTest.class})


public class LoginSuite {
}
