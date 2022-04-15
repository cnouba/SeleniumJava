package test.practiceauto;

import main.java.utility.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import main.java.pages.HomePage1;
import main.java.pages.LoginPage1;

public class BaseTest {
    public WebDriver driver;
    public HomePage1  homePage1;

    public WebDriver getDriver() {
        return this.driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests is starting!");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage1 = new HomePage1(driver);
    }

    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");
        driver.quit();
    }
}
