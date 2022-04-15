package main.java.pages;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import main.java.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage1 extends BasePage {
    /**
     * Constructor
     */
    public LoginPage1(WebDriver driver) {
        super(driver);
    }

    /**
     * Web Elements
     */
    By userNameId                = By.id("email");
    By passwordId                = By.id("password");
    By loginButtonId             = By.id("loginButton");
    By errorMessageUsernameXpath = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordXpath = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ");

    /**
     * Page Methods
     */
    public LoginPage1 loginToN11(String username, String password) {
        Log.info("Trying to login the N11.");
        writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonId);
        return this;
    }

    //Verify Username Condition
    public LoginPage1 verifyLoginUserName(String expectedText) {
        Log.info("Verifying login username.");
        waitVisibility(errorMessageUsernameXpath);
        assertEquals(readText(errorMessageUsernameXpath), expectedText);
        return this;
    }

    //Verify Password Condition
    public LoginPage1 verifyLoginPassword(String expectedText) {
        Log.info("Verifying login password.");
        waitVisibility(errorMessagePasswordXpath);
        assertEquals(readText(errorMessagePasswordXpath), expectedText);
        return this;
    }


}
