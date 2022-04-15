package main.java.pages;

import main.java.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class HomePage1 extends BasePage {
    /**
     * Constructor
     */
    public HomePage1(WebDriver driver) {
        super(driver);
    }

    /**
     * Variables
     */
    String baseURL = "http://www.n11.com/";

    /**
     * Web Elements
     */
    By signInButtonClass = By.className("btnSignIn");

    /**
     * Page Methods
     */
    //Go to Homepage
    public HomePage1 goToN11() {
        Log.info("Opening N11 Website.");
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    public LoginPage1 goToLoginPage() {
        Log.info("Going to Login Page..");
        click(signInButtonClass);
        return new LoginPage1(driver);
    }
}
