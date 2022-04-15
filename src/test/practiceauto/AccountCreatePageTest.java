package test.practiceauto;

import main.java.commun.ApplicationCommonScript;
import main.java.commun.SetupTeardown;
import main.java.dataprovider.DataProviders;
import main.java.pages.AccountCreationPage;
import main.java.pages.HomePage;
import main.java.pages.IndexPage;
import main.java.pages.LoginPage;
import main.java.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import main.java.utility.ConfigFileReader;
import main.java.utility.ConfigFileReader;

import java.util.Properties;

public class AccountCreatePageTest extends SetupTeardown {

    public LoginPage loginPage;
    public AccountCreationPage accountCreationPage;

    String pathCreateAccount = "src\\test\\resources\\data\\createAccountData\\Pracauto-US1.txt";
    ConfigFileReader getUs1Data = getAllData(pathCreateAccount);

    /*@BeforeMethod
    public void teardown(){
        driver.quit();
    }

    @AfterMethod
    public void cleanup(){
        driver.quit();
    }*/


    @Test(alwaysRun = true)//(dataProvider = "login", dataProviderClass = DataProviders.class)
    //pracauto-52
    public void validCreateAccount() throws Throwable {//String userToCreate, String pwdToCreate
        IndexPage indexPage = new IndexPage(driver);
        HomePage homePage = indexPage.
                clickOnMyAccountCreation()
                .createNewAccount( getUs1Data.getData("user")+getRandomString(2),getUs1Data.getData("pwd"));
        boolean result=homePage.validateAcountCreatePage();
        Assert.assertTrue(result);
    }

    @Test(alwaysRun = true)//(dataProvider = "login", dataProviderClass = DataProviders.class)
    //Pracauto-61
    public void nvUserNoPwdCreateAccount() throws Throwable {//String userToCreate, String pwdToCreate
        IndexPage indexPage = new IndexPage(driver);
        AccountCreationPage accountCreationPage =indexPage.
                clickOnMyAccountCreation()
                .invalidCreateNewAccount(getUs1Data.getData("user1"),getUs1Data.getData("pwd1"));
        boolean result=accountCreationPage.isInValidateAcountCreatePage();
        Assert.assertTrue(result);
    }

    @Test(alwaysRun = true)//(dataProvider = "invalidlogin", dataProviderClass = DataProviders.class)
    //pracauto-56
    public  void invUserPwdCreateAccount() throws Throwable {//String userToCreate, String pwdToCreate
        IndexPage indexPage = new IndexPage(driver);
        AccountCreationPage accountCreationPage =indexPage.
                clickOnMyAccountCreation()
                .invalidCreateNewAccount(getUs1Data.getData("user2"),getUs1Data.getData("pwd2"));
        String actualWeakPasswordMessage= accountCreationPage.getWeakPasswordMessage();
        String ExpectedWeakPasswordMessage = "The password should be at least seven";
        Assert.assertTrue(actualWeakPasswordMessage.contains(ExpectedWeakPasswordMessage));
    }

   @Test(alwaysRun = true)//(dataProvider = "alreadyLogin", dataProviderClass = DataProviders.class)
    //pracauto-69
    public  void exitLoginCreateAccount() throws Throwable {//String userToCreate, String pwdToCreate
        IndexPage indexPage = new IndexPage(driver);
        AccountCreationPage accountCreationPage =indexPage.
                clickOnMyAccountCreation()
                .invalidCreateNewAccount(getUs1Data.getData("user"),getUs1Data.getData("pwd"));
        String actualMessageError = accountCreationPage.getalreadyExistingAccount();
        String expectedMessageError= ("Error: An account is already registered");
        Assert.assertTrue(actualMessageError.contains(expectedMessageError));
    }
}
