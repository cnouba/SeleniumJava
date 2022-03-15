package test.practiceauto;

import main.java.commun.SetupTeardown;
import main.java.pages.HomePage;
import main.java.pages.IndexPage;
import main.java.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import main.java.dataprovider.DataProviders;

public class LoginPageTest extends SetupTeardown {

    private LoginPage loginPage;
    private IndexPage indexPage;
    private HomePage homePage;

    @BeforeMethod
    public void setup1() throws Exception {
      setup();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    DataProviders dataProviders = new DataProviders();

    @Test(dataProvider = "login", dataProviderClass = DataProviders.class)
    public void  loginTest(String user,String pwd) throws Throwable {

       indexPage = new IndexPage(driver);
       LOG.info("enter username and password");
       loginPage = indexPage.clickOnMyAccount();
       homePage = loginPage.login(user,pwd,homePage);

    }



}
