package test.practiceauto;

import com.aventstack.extentreports.ExtentTest;
import main.java.commun.SetupTeardown;
import main.java.pages.HomePage;
import main.java.pages.IndexPage;
import main.java.pages.LoginPage;
import main.java.utility.ConfigFileReader;
import main.java.utility.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import main.java.dataprovider.DataProviders;
import org.testng.asserts.SoftAssert;

import static main.java.utility.extentReports.ExtentTestManager.startTest;
import java.lang.reflect.Method;

public class LoginPageTest extends SetupTeardown {

    private LoginPage loginPage;
   // private IndexPage indexPage;
    private HomePage homePage;
   private   Method method;
    public ExtentTest getStart(Method method, String desc){
        this.method = method;
       return startTest(method.getName(), "Valid login with good user and wrong Password");

    }


    // get data from txt file

    String pathData = "src\\test\\resources\\data\\createAccountData\\Pracauto-US2.txt";
    ConfigFileReader getUs2Data = getAllData(pathData);


   // DataProviders dataProviders = new DataProviders();


    @Test(groups = {"priority"})//(dataProvider = "validLogin", dataProviderClass = DataProviders.class)
   // startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");
    public void  validLoginTest() throws Throwable {
        //startTest(method.getName(), "Valid login with good user and wrong Password");
        getStart(method, "Valid login with good user and wrong Password");
        System.out.println("hello");
        IndexPage indexPage = new IndexPage(driver);
       LOG.info("enter username and password");
       loginPage = indexPage.clickOnMyAccount();
       homePage = loginPage.login(getUs2Data.getData("user"),getUs2Data.getData("pwd"),homePage);
       String ExpectedLogin = "Dashboard";
       String ActualLogin = homePage.getLoginMenuElement();
       Assert.assertTrue(ActualLogin.contains(ExpectedLogin));
    }

    //pract auto 55 - login ivalide (ninexistant)

    @Test(groups = {"priority"})//(dataProvider = "invalidLogin", dataProviderClass = DataProviders.class)
    public void  invLoginTest(Method method) throws Throwable {
        //startTest(method.getName(), " ");
        getStart(method, "Valid login with good user and wrong Password");
        String expectedInvalidUsername= "Error: A user could not be found with this email address.";
        LOG.info("loginTest");
        IndexPage indexPage = new IndexPage(driver);
        LOG.info("practice.automationtestingisopen");
        Log.info("test");
        loginPage = indexPage.clickOnMyAccountLogin();
        loginPage.invLoginValidUser(getUs2Data.getData("user1"),getUs2Data.getData("pwd1"));
        String  ActualInvalidUsername = loginPage.getLoginFail();
        System.out.println(ActualInvalidUsername);
       Assert.assertTrue(ActualInvalidUsername.contains(expectedInvalidUsername),"invalid user name");


    }
    ////pract auto 57 - login user valide mot de passe incorect
    @Test(groups = {"priority"}) //
    public void  validUserWrongPwdLoginTest(Method method) throws Throwable {
        startTest(method.getName(), " ");
       // String expectedInvalidUsername= "Error: Please provide a valid email address.";
        getStart(method, "Valid login with good user and wrong Password");
        LOG.info("loginTest");
        IndexPage indexPage = new IndexPage(driver);
        LOG.info("practice.automationtestingisopen");
        Log.info("test");
        loginPage = indexPage.clickOnMyAccountLogin();
        loginPage.invLoginValidUser(getUs2Data.getData("user22"),getUs2Data.getData("pwd22"));
        String  ActualInvalidUsername = loginPage.getLoginFail();
        String ExpectedInvalidUsername = " is incorrect.";
        Assert.assertTrue(ActualInvalidUsername.contains(ExpectedInvalidUsername),"invalid user name");


    }

    @Test(groups = {"priority"}) //
    public void  sensibilityLoginTest(Method method) throws Throwable {
        //startTest(method.getName(), "");
        getStart(method, "Valid login with good user and wrong Password");
        String expectedInvalidUsername= "Error: Please provide a valid email address.";
        LOG.info("loginTest");
        IndexPage indexPage = new IndexPage(driver);
        LOG.info("practice.automationtestingisopen");
        Log.info("test");
        loginPage = indexPage.clickOnMyAccountLogin();
        loginPage.invLoginValidUser(getUs2Data.getData("user3"),getUs2Data.getData("pwd3"));
        // String  ActualInvalidUsername = loginPage.getLoginFail();
        // System.out.println(ActualInvalidUsername);
        // Assert.assertTrue(ActualInvalidUsername.contains(expectedInvalidUsername),"invalid user name");


    }
    @Test(groups = {"priority"})//(dataProvider = "validLogin", dataProviderClass = DataProviders.class)
    //Pracauto-67
    public void  verifierHomePage(Method method) throws Throwable {
     //   startTest(method.getName(), "");
        getStart(method, "Valid login with good user and wrong Password");

        System.out.println("Dashboard");
        IndexPage indexPage = new IndexPage(driver);
        LOG.info("enter username and password");
        loginPage = indexPage.clickOnMyAccount();
        homePage = loginPage.login(getUs2Data.getData("user67"),getUs2Data.getData("pwd67"),homePage);
        String ExpectedLogin = "Dashboard";
        String ActualLogin = homePage.getLoginMenuElement();
        homePage.logout();
        Assert.assertTrue(ActualLogin.contains(ExpectedLogin));

    }

    @Test(groups = {"priority"})
    //cas de test 68
    public void rememberMe(Method method)  throws Throwable{
        //startTest(method.getName(), "");
        getStart(method, "Valid login with good user and wrong Password");
        System.out.println("hello");
        IndexPage indexPage = new IndexPage(driver);
        LOG.info("enter username and password");
        loginPage = indexPage.clickOnMyAccount();
        homePage = loginPage.rememberlogin(getUs2Data.getData("user"),getUs2Data.getData("pwd"),homePage);
        homePage.logout2();
        Boolean ActualLogin = loginPage.isIdRemember();
        //Assert.assertTrue(ActualLogin);
        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertTrue(ActualLogin);





    }




}
