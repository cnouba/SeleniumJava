package main.java.pages;

import main.java.ActionDriver.Action;
import main.java.commun.ApplicationCommonScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ApplicationCommonScript {

    Action action = new Action();
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getCurrURL() throws Throwable {

        String homePageURL=action.getCurrentURL(driver);
        return homePageURL;
    }

    //http://practice.automationtesting.in/my-account/
}
