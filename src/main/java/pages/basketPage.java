package main.java.pages;

import main.java.commun.ApplicationCommonScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class basketPage extends ApplicationCommonScript {

    public basketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
