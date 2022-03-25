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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import main.java.utility.ConfigFileReader;
import main.java.utility.ConfigFileReader;

import java.util.Properties;

public class AccountCreatePageTest extends SetupTeardown {

    public LoginPage loginPage;
    public AccountCreationPage accountCreationPage;
// DataProviders dataProviders = new DataProviders();


    @Test//(dataProvider = "login", dataProviderClass = DataProviders.class)
    //pracauto-52
    public void validCreateAccount() throws Throwable {//String userToCreate, String pwdToCreate
        IndexPage indexPage = new IndexPage(driver);
        HomePage homePage = indexPage.
                clickOnMyAccountCreation()
                .createNewAccount( getCreateAccountData().getData("user")+getRandomString(2),getCreateAccountData().getData("pwd"));
        boolean result=homePage.validateAcountCreatePage();
        Assert.assertTrue(result);
    }

    @Test//(dataProvider = "login", dataProviderClass = DataProviders.class)
    //Pracauto-61
    public void nvUserNoPwdCreateAccount() throws Throwable {//String userToCreate, String pwdToCreate
        IndexPage indexPage = new IndexPage(driver);
        AccountCreationPage accountCreationPage =indexPage.
                clickOnMyAccountCreation()
                .invalidCreateNewAccount(getCreateAccountData().getData("user1"),getCreateAccountData().getData("pwd1"));
        boolean result=accountCreationPage.isInValidateAcountCreatePage();
        Assert.assertTrue(result);
    }

    @Test//(dataProvider = "invalidlogin", dataProviderClass = DataProviders.class)
    //pracauto-56
    public  void invUserPwdCreateAccount() throws Throwable {//String userToCreate, String pwdToCreate
        IndexPage indexPage = new IndexPage(driver);
        AccountCreationPage accountCreationPage =indexPage.
                clickOnMyAccountCreation()
                .invalidCreateNewAccount(getCreateAccountData().getData("user2"),getCreateAccountData().getData("pwd2"));
        String actualWeakPasswordMessage= accountCreationPage.getWeakPasswordMessage();
        String ExpectedWeakPasswordMessage = "The password should be at least seven";
        Assert.assertTrue(actualWeakPasswordMessage.contains(ExpectedWeakPasswordMessage));
    }

    @Test//(dataProvider = "alreadyLogin", dataProviderClass = DataProviders.class)
    //pracauto-69
    public  void exitLoginCreateAccount() throws Throwable {//String userToCreate, String pwdToCreate
        IndexPage indexPage = new IndexPage(driver);
        AccountCreationPage accountCreationPage =indexPage.
                clickOnMyAccountCreation()
                .invalidCreateNewAccount(getCreateAccountData().getData("user"),getCreateAccountData().getData("pwd"));
        String actualMessageError = accountCreationPage.getalreadyExistingAccount();
        String expectedMessageError= ("Error: An account is already registered");
        Assert.assertTrue(actualMessageError.contains(expectedMessageError));
    }
}
