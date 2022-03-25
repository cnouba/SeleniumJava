package main.java.pages;

import main.java.ActionDriver.Action;
import main.java.commun.ApplicationCommonScript;
import main.java.utility.TypeInField;
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




public class AccountCreationPage extends ApplicationCommonScript {

    private LoginPage loginPage;
    private IndexPage indexPage;
    private HomePage homePage;

    @FindBy(css = "#site-logo")
    private WebElement logoSelector;

    @FindBy(css = "#reg_email")
    private WebElement emailSelector;

    @FindBy(css = "#reg_password")
    private WebElement passSelector;

    @FindBy(css = "[name='register']")
    private WebElement registerLoginSelector;

    @FindBy(css = ".woocommerce-password-hint")
    private WebElement sstrongPasswordSelector;
    @FindBy(css = ".woocommerce-Button button disabled")
    private WebElement invalidPasswordSelector;
    @FindBy(css = ".woocommerce-error")
    private WebElement emptyPwd_validPassword_MessareErrorSelector;
    @FindBy(css = ".wpmenucartli")
    private WebElement basketiconeSelector;
//------------------Login account create selector-----------//
    @FindBy(css = "#reg_email")
    private WebElement emailForNewAccount;

    @FindBy(css = "#reg_password")
    private WebElement passwForNewAccount;

    @FindBy(css = "[name='register']")
    private WebElement register;
    //--home page--//

    @FindBy(css = ".woocommerce-MyAccount-navigation")
    private WebElement accountNavigateSelector;

    @FindBy(css = ".woocommerce-password-hint")
    private WebElement weakpassword;



    By accountNavigateSelector1 = By.cssSelector(".woocommerce-MyAccount-navigation");


    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Action action= new Action();

    @Test
    public void verifyLogo() throws Throwable {
        LOG.info("verifyLogo");
        indexPage= new IndexPage(driver);
        boolean result=indexPage.validateLogo();
        Assert.assertTrue(result);
        LOG.info("fin verifyLogo");
    }


    public HomePage createNewAccount(String Email, String Pwd) throws Throwable {
        emailForNewAccount.sendKeys(Email);

        SaisirCaractere("#reg_password",Pwd);
        register.click();
        homePage = new HomePage(driver);
        return homePage;
    }

    public AccountCreationPage invalidCreateNewAccount(String Email, String Pwd) throws Throwable {
        emailForNewAccount.sendKeys(Email);
        //TypeInField typeInField = new TypeInField();
        SaisirCaractere("#reg_password",Pwd);
        register.click();
       // homePage = new HomePage(driver);
        return this;
    }

    //cas de test 56
    public AccountCreationPage weakCreateNewAccount(String Email, String Pwd) throws Throwable {
        emailForNewAccount.sendKeys(Email);
        //TypeInField typeInField = new TypeInField();
        SaisirCaractere("#reg_password",Pwd);
        register.click();
        // homePage = new HomePage(driver);
        return this;
    }


    public boolean isInValidateAcountCreatePage() throws Throwable {
        //return action.isDisplayed(driver, burgerMenu);
        System.out.println("hello");
        return register.isEnabled();
    }

    public String getWeakPasswordMessage(){

        return weakpassword.getText();
    }

    public String getalreadyExistingAccount(){

        return emptyPwd_validPassword_MessareErrorSelector.getText();
    }

    public boolean getAdressAccount(){

        System.out.println("test");
        return register.isEnabled();
    }





}
