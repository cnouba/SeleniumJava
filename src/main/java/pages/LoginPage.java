package main.java.pages;

import main.java.ActionDriver.Action;
import main.java.commun.ApplicationCommonScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ApplicationCommonScript {


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
        buttonLoginSelector.click();
        homePage= new HomePage(driver);
      return homePage;
    }

    public String getCurrURL() throws Throwable {

        String homePageURL=action.getCurrentURL(driver);
        return homePageURL;
    }

    public HomePage createNewAccount(String Email,String Pwd,HomePage homePage) throws Throwable {
        emailForNewAccount.sendKeys(Email);
        passwForNewAccount.sendKeys(Pwd);
        register.click();
        homePage = new HomePage(driver);
        return homePage;
    }


}
