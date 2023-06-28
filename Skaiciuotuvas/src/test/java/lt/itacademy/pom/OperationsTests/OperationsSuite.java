package lt.itacademy.pom.OperationsTests;


import lt.itacademy.pom.UserLoginTests.LoginPageTest;
import lt.itacademy.pom.UserLoginTests.NewUserPageTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({MainCalculatorPageTest.class, PerformedOperationsPageTest.class})

public class OperationsSuite {
}
