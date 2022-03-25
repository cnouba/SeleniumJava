package test.practiceauto;

import main.java.commun.SetupTeardown;
import main.java.pages.HomePage;
import main.java.pages.IndexPage;
import main.java.pages.LoginPage;
import main.java.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import main.java.dataprovider.DataProviders;

public class LoginPageTest extends SetupTeardown {

    private LoginPage loginPage;
   // private IndexPage indexPage;
    private HomePage homePage;



    DataProviders dataProviders = new DataProviders();

    @Test//(dataProvider = "validLogin", dataProviderClass = DataProviders.class)
    public void  validLoginTest() throws Throwable {

        System.out.println("hello");
        IndexPage indexPage = new IndexPage(driver);
       LOG.info("enter username and password");
       loginPage = indexPage.clickOnMyAccount();
       homePage = loginPage.login(getLoginData().getData("user"),getLoginData().getData("pwd"),homePage);
       String ExpectedLogin = "Dashboard";
       String ActualLogin = homePage.getLoginMenuElement();
       Assert.assertTrue(ActualLogin.contains(ExpectedLogin));
    }

    //pract auto 55 - login ivalide (ninexistant)

    @Test//(dataProvider = "invalidLogin", dataProviderClass = DataProviders.class)
    public void  invLoginTest() throws Throwable {
        String expectedInvalidUsername= "Error: A user could not be found with this email address.";
        LOG.info("loginTest");
        IndexPage indexPage = new IndexPage(driver);
        LOG.info("practice.automationtestingisopen");
        Log.info("test");
        loginPage = indexPage.clickOnMyAccountLogin();
        loginPage.invLoginValidUser(getLoginData().getData("user1"),getLoginData().getData("pwd1"));
        String  ActualInvalidUsername = loginPage.getLoginFail();
        System.out.println(ActualInvalidUsername);
       Assert.assertTrue(ActualInvalidUsername.contains(expectedInvalidUsername),"invalid user name");


    }
    ////pract auto 57 - login user valide mot de passe incorect
    @Test //
    public void  validUserWrongPwdLoginTest() throws Throwable {
        String expectedInvalidUsername= "Error: Please provide a valid email address.";
        LOG.info("loginTest");
        IndexPage indexPage = new IndexPage(driver);
        LOG.info("practice.automationtestingisopen");
        Log.info("test");
        loginPage = indexPage.clickOnMyAccountLogin();
        loginPage.invLoginValidUser(getLoginData().getData("user22"),getLoginData().getData("pwd22"));
        String  ActualInvalidUsername = loginPage.getLoginFail();
        String ExpectedInvalidUsername = " is incorrect.";
        Assert.assertTrue(ActualInvalidUsername.contains(ExpectedInvalidUsername),"invalid user name");


    }

    @Test //
    public void  sensibilityLoginTest() throws Throwable {
        String expectedInvalidUsername= "Error: Please provide a valid email address.";
        LOG.info("loginTest");
        IndexPage indexPage = new IndexPage(driver);
        LOG.info("practice.automationtestingisopen");
        Log.info("test");
        loginPage = indexPage.clickOnMyAccountLogin();
        loginPage.invLoginValidUser(getLoginData().getData("user3"),getLoginData().getData("pwd3"));
        // String  ActualInvalidUsername = loginPage.getLoginFail();
        // System.out.println(ActualInvalidUsername);
        // Assert.assertTrue(ActualInvalidUsername.contains(expectedInvalidUsername),"invalid user name");


    }
    @Test//(dataProvider = "validLogin", dataProviderClass = DataProviders.class)
    //Pracauto-67
    public void  verifierHomePage() throws Throwable {

        System.out.println("Dashboard");
        IndexPage indexPage = new IndexPage(driver);
        LOG.info("enter username and password");
        loginPage = indexPage.clickOnMyAccount();
        homePage = loginPage.login(getLoginData().getData("user67"),getLoginData().getData("pwd67"),homePage);
        String ExpectedLogin = "Dashboard";
        String ActualLogin = homePage.getLoginMenuElement();
        homePage.logout();
        Assert.assertTrue(ActualLogin.contains(ExpectedLogin));

    }

    @Test
    //cas de test 68
    public void rememberMe()  throws Throwable{

        System.out.println("hello");
        IndexPage indexPage = new IndexPage(driver);
        LOG.info("enter username and password");
        loginPage = indexPage.clickOnMyAccount();
        homePage = loginPage.rememberlogin(getLoginData().getData("user"),getLoginData().getData("pwd"),homePage);
        homePage.logout2();
        Boolean ActualLogin = loginPage.isIdRemember();
        Assert.assertTrue(ActualLogin);


    }




}
