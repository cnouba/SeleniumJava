package main.java.pages;

import main.java.ActionDriver.Action;
import main.java.commun.ApplicationCommonScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends ApplicationCommonScript {

    @FindBy(css = "#site-logo")
    private WebElement logoSelector;

    @FindBy(css = ".woocommerce-MyAccount-navigation")
    private WebElement burgerMenu;

    @FindBy(css = ".woocommerce-MyAccount-navigation")
    private WebElement homeElement;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link .woocommerce-MyAccount-navigation-link--customer-logout")
    private WebElement logout;


    By log = By.cssSelector(" li.woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--customer-logout > a");

    Action action = new Action();
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getCurrURL() throws Throwable {

        String homePageURL=action.getCurrentURL(driver);
        return homePageURL;
    }





    public boolean validateAcountCreatePage() throws Throwable {
        //return action.isDisplayed(driver, burgerMenu);
        System.out.println("hello");
        return burgerMenu.isDisplayed();
    }
    public String getLoginMenuElement(){
        return homeElement.getText();
    }

public void logout(){

        driver.findElement(log).click();

}

public  LoginPage logout2(){

    driver.findElement(log).click();
    LoginPage loginPage = new LoginPage(driver);
    return loginPage;
}


    //http://practice.automationtesting.in/my-account/
}
