package main.java.pages;

import main.java.ActionDriver.Action;
import main.java.commun.ApplicationCommonScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPage extends ApplicationCommonScript {

    public HomePage homePage;
    public LoginPage loginPage;
    public IndexPage indexPage;

    @FindBy(css = "#site-logo")
    private WebElement logoSelector;

    @FindBy(css = "#username")
    private WebElement userName;

    @FindBy(css = "#password")
    private WebElement password;

    @FindBy(css = "[name=login]")
    private WebElement buttonLoginSelector;

    @FindBy(css = "#rememberme")
    private WebElement rememberMeSelector;

    @FindBy(css = "woocommerce-LostPassword lost_password")
    private WebElement lostPassword;

    @FindBy(css = "#reg_email")
    private WebElement emailForNewAccount;

    @FindBy(css = "#reg_password")
    private WebElement passwForNewAccount;

    @FindBy(css = "[name='register']")
    private WebElement register;

    @FindBy(css = "[name='disabled']")
    private WebElement register_disable;

    @FindBy(css = ".woocommerce .woocommerce-error")
    private WebElement invalidUsername;

    @FindBy(css = "p[class='woocommerce-LostPassword lost_password'] a")
    private WebElement loginfail;
    @FindBy(css = "#rememberme")
    private WebElement rememberme;



    By accountNavigateSelector1 = By.cssSelector(".woocommerce-MyAccount-navigation");
    By pw2 = By.cssSelector("#password");



    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Action action= new Action();


    public HomePage  login(String uname, String pswd, HomePage homePage){

        action.type(userName, uname);
        System.out.println(action.type(userName, uname)+"bien");
        userName.sendKeys(uname);
        password.sendKeys(pswd);
        action.fluentWait(driver,userName,10);
        buttonLoginSelector.click();
        homePage= new HomePage(driver);

      return homePage;
    }

    public String getCurrURL() throws Throwable {

        String homePageURL=action.getCurrentURL(driver);
        return homePageURL;

    }

    public HomePage loginValidUser(String Email, String Pwd) throws Throwable {


        emailForNewAccount.sendKeys(Email);
        passwForNewAccount.sendKeys(Pwd);
        passwForNewAccount.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(register));
        register.click();
        homePage = new HomePage(driver);
        return homePage;

    }
    public HomePage  rememberlogin(String uname, String pswd, HomePage homePage){

        action.type(userName, uname);
        System.out.println(action.type(userName, uname)+"bien");
        userName.sendKeys(uname);
        password.sendKeys(pswd);
        rememberme.click();
        buttonLoginSelector.click();
        homePage= new HomePage(driver);

        return homePage;
    }
    public LoginPage invLoginValidUser(String Email, String Pwd) throws Throwable {
        action.type(userName, Email);
        System.out.println(action.type(userName, Email)+"bien");
        userName.sendKeys(Email);
        password.sendKeys(Pwd);
        buttonLoginSelector.click();

       // action.fluentWait(driver,invalidUsername,10);

        return this;
    }


    public boolean isIdRemember(){

      return rememberme.isSelected();
    }




    public String getLoginFail(){

        return invalidUsername.getText();
    }










}
