package test.practiceauto;

import static main.java.utility.extentReports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
    public void invalidLoginTest_InvalidUserNameInvalidPassword(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");

        homePage1
                .goToN11()
                .goToLoginPage()
                .loginToN11("onur@swtestacademy.com", "11122233444");

    }

    @Test(priority = 1, description = "Invalid Login Scenario with empty username and password.")
    public void invalidLoginTest_EmptyUserEmptyPassword(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Invalid Login Scenario with empty username and password.");

        homePage1
                .goToN11()
                .goToLoginPage()
                .loginToN11("", "")
                .verifyLoginUserName("Lütfen e-posta adresinizi girin.")
                .verifyLoginPassword("WRONG MESSAGE FOR FAILURE!");
    }
}
