package main.java.pages;

import main.java.ActionDriver.Action;
import main.java.commun.ApplicationCommonScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ShopPage extends ApplicationCommonScript {

    public IndexPage indexPage;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "li[id='menu-item-40'] a")
    private WebElement shopSelector;

    @FindBy(css = "#site-logo")
    private WebElement SelectLogo;

    @FindBy(xpath = "//*[@id='content']/ul/li[1]")
    private WebElement selecArticleListSelector;

    @FindBy(xpath = "//li[1]/a[. = 'Add to basket']")
    private WebElement addToCartSelector;

    @FindBy(xpath = "//*[@id=content]/ul/li[1]/a[3]")
    private WebElement articleviewSelector;

    @FindBy(css = "[class='added_to_cart wc-forward']")
    private WebElement articleAddtocartForwardSelector;


    @FindBy(css = ".wpmenucartli")
    private WebElement basketiconeSelector;

   /* @FindBy(xpath = "//a[. = 'Android']")
    private WebElement shopFilterThemeSelecter;*/

    @FindBy(css= "class=['cat-item cat-item-24 current-cat']")
    private WebElement shopfilterBythemeSelctor;

    @FindBy(xpath = "product-categories")
    private WebElement shopFilterThemeTitleSelecter;

    @FindBy(css = "[class='ui-slider-range ui-widget-header ui-corner-all']")
    private WebElement sliderSelector;

    @FindBy(css = "[class='button']")
    private WebElement filterButtonSelector;

    @FindBy(css = "[class='products masonry-done']")
    private WebElement filterProductSelector;

    @FindBy(css = "[class='woocommerce-Price-amount amount']")
    private WebElement filterAllArticlePrice;

    @FindBy(css = "[class='woocommerce-Price-amount amount']")
    private WebElement articlePriceSelector;

    @FindBy(css = "[title='Android Quick Start Guide']")
    private WebElement articleImageSelector;

    @FindBy(linkText = "View Basket")
    private WebElement productSelector1;

    @FindBy(css = "[class='amount']")
    private WebElement productSelector;

    @FindBy(css = "ul>li:nth-child(1)>a:nth-child(1)>h3")
    private WebElement productLabelSelector;




    By productviewMessage = By.cssSelector("[title='View Basket']");
    By shopFilterThemeSelecter = By.xpath("//a[. = 'Android']");
    By filterButtonSelector1 = By.cssSelector("[class='button']");
    By sliderBarSelector = By.cssSelector("[class='ui-slider-range ui-widget-header ui-corner-all']");
    By filterProductSelector1 = By.cssSelector("[class='products masonry-done']");
    By filterAllArticlePrice1 = By.cssSelector("[class='woocommerce-Price-amount amount']");
    By basketiconeSelector1 = By.cssSelector(".wpmenucartli");


    long timeout =10;











    Action action= new Action();


    public ShopPage addToCart() {

        addToCartSelector.click();
        action.fluentWait(driver,filterButtonSelector,5);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(productviewMessage));
        return this;

    }



    public ProductPage addToCartByImage() {
        articleImageSelector.click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }
    public ProductPage addToCartByLabel() {
        productLabelSelector.click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }

    public ProductPage addToCartByPrice() {
        articlePriceSelector.click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }

    public ShopPage shopFilterbyTheme() {

        driver.findElement(shopFilterThemeSelecter).click();
        return this;

    }

    public boolean isbasketPresent() {

        System.out.println(driver.findElement(basketiconeSelector1).isDisplayed());
        return driver.findElement(basketiconeSelector1).isDisplayed();
    }

    public ShopPage shopFilterByPrice() {

        //String url = "http://practice.automationtesting.in/shop/?min_price=0&max_price=200"
        Actions actions = new Actions(driver);
        WebElement slider = driver.findElement(sliderBarSelector);
        actions.dragAndDropBy(slider, 10, 150).build().perform();
        slider.click();
        driver.findElement(filterButtonSelector1).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(filterProductSelector1));

        List<WebElement> listeDeResultat = driver.findElements(filterButtonSelector1);
        listeDeResultat.get(0).getText();


        return this;
    }

    public String getshopFilterbyTheme() {

        List<WebElement> list = driver.findElements(shopFilterThemeSelecter);
        String themeText = list.get(0).getText();
        return themeText;

    }

    public Boolean getFilterArticle(int prix) {

        List<WebElement> listArticle = driver.findElements(filterAllArticlePrice1);
        //System.out.println(listArticle);

        String[] test = new String[5];


        int price = parseInt(driver.findElement(filterAllArticlePrice1).getText().replaceAll("[^a-zA-Z0-9]", ""));

        if (prix >= 420){
            return true;
        }


        return true;

    }

    public String getViewArticleMessage() {
        action.fluentWait(driver,addToCartSelector,5);
        return addToCartSelector.getText();
    }

    public String getViewArticleProductMessage() {
        //action.fluentWait(driver,productSelector1,5);
        String article1 = driver.findElement(productviewMessage).getText();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(productviewMessage));
        System.out.println(article1+"all message");
        return article1;
    }



    public String getArticle() {
        //List<WebElement> listeDeResultat = driver.findElements(selecArticleListSelector);

        //String article1 =listeDeResultat.get(1).getText();
        //System.out.println(listeDeResultat.get(1).getText());
        String article1 = selecArticleListSelector.getText();
        System.out.println(article1);
        return article1;
    }







}
