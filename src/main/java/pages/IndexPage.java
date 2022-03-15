package main.java.pages;
import main.java.commun.ApplicationCommonScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import main.java.ActionDriver.Action;


public class IndexPage extends ApplicationCommonScript {



    @FindBy(css = "#menu-item-50")
    private WebElement myaccountPageSelector;

    @FindBy(css = "#site-logo")
    private WebElement logoSelector;



    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Action action= new Action();

    public LoginPage clickOnMyAccount() throws Throwable {
        myaccountPageSelector.click();
        action.fluentWait(driver, logoSelector, 10);
        LoginPage loginPage = new LoginPage(driver);
        return loginPage;

    }
    public boolean validateLogo() throws Throwable {
        return logoSelector.isDisplayed();
    }


}








