package main.java.pages;

import main.java.ActionDriver.Action;
import main.java.commun.ApplicationCommonScript;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends ApplicationCommonScript {
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li[id='menu-item-40'] a")
    private WebElement shopSelector;
    @FindBy(css = "//*[@id='content']/ul/li[1]")
    private WebElement firstProductSelector;
    @FindBy(css = "[class='stock in-stock']")
    private WebElement articleStockNumberSelector;
    @FindBy(css = "[itemprop='description']")
    private WebElement articleDescription;
    @FindBy(css = "[itemprop='price']")
    private WebElement articlePrice;
    @FindBy(css = "[class='amount']")
    private WebElement articlePricebasketSelector;
    @FindBy(css = "name='quantity'")
    private WebElement articleQuantity;
    @FindBy(css = ".woocommerce-message")
    private WebElement addConfirmationMessage;
    @FindBy(css = "[class='single_add_to_cart_button button alt']")
    private WebElement addtoCartSelector;
    @FindBy(css = "[title='View Basket']")
    private WebElement articleviewSelector;
    @FindBy(css = ".wpmenucartli")
    private WebElement basketiconeSelector;

    @FindBy(css = "[min='1']")
    private WebElement minimumProduct;

    @FindBy(css = "[value='1']")
    private WebElement setQuantity;

    @FindBy(css = "[class='button wc-forward']")
    private WebElement forwardView;

    By forward1 = By.cssSelector(".button .wc-forward");
    By confirmationMessage2 = By.cssSelector(".woocommerce-message");






    Action action= new Action();

    public ProductPage addTocart(){
        addtoCartSelector.click();
        action.fluentWait(driver,basketiconeSelector,5);
        return this;
    }

    public ProductPage addTocart1(){
        setQuantity.sendKeys(Keys.chord(Keys.CONTROL, "0" + Keys.DELETE));
        setQuantity.sendKeys("0");
        addtoCartSelector.click();
        action.fluentWait(driver,basketiconeSelector,5);
        return this;
    }



    public ProductPage addTocart2(){
        setQuantity.sendKeys(Keys.chord(Keys.CONTROL, "0" + Keys.DELETE));
        setQuantity.sendKeys("2");
        addtoCartSelector.click();
        action.fluentWait(driver,basketiconeSelector,5);
        return this;
    }

    public ProductPage addTocartview(){
        addtoCartSelector.click();
        //action.fluentWait(driver,forwardView,5);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(confirmationMessage2));
        return this;
    }

    public  basketPage clickOnviewBasket(){

       // forwardView.click();
        forwardView.click();
        basketPage basketPage = new basketPage(driver);

        return basketPage;
    }

    public String  getHasBeenAddTOBasket(){

        return addConfirmationMessage.getText();

    }


    public String getArticePrice(){

        return articlePricebasketSelector.getText();
    }

    public  String getAricleStock(){

        String ArcticleStock = articleStockNumberSelector.getText();

        return ArcticleStock;

    }

    public  String getArticleDescriptif(){
System.out.println(articleDescription.getText()+"article test");
        return  articleDescription.getText();

    }
    public  String getAddArticleConfirmationMessage(){

        return  addConfirmationMessage.getText();

    }

    public String getArticleQuantity(){

        return articleQuantity.getText();
    }

    public  String getMinimumProduct(){

        System.out.println(minimumProduct+"produit minimum");
        return  minimumProduct.getText();

    }

    public  Boolean isMinimumProductClickable(){

        System.out.println(minimumProduct+"produit minimum");
        return  minimumProduct.isEnabled();

    }




}
