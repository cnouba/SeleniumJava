package test.practiceauto;

import main.java.commun.SetupTeardown;
import main.java.pages.HomePage;
import main.java.pages.IndexPage;
import main.java.pages.ProductPage;
import main.java.pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static main.java.utility.extentReports.ExtentTestManager.startTest;

public class ShopPageTest  extends SetupTeardown {

    @Test(priority = 0)
    //practauto 85
    public void addArticleToCart(Method method) throws Throwable {

        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");

        String expectedArcticlePrice = "View Basket";
        IndexPage indexPage = new IndexPage(driver);
        ShopPage shopPage = indexPage.
                clickOnShopage()
                .addToCart();

        Assert.assertTrue(shopPage.getViewArticleMessage().contains(expectedArcticlePrice));
    }

    @Test()
    //practauto 85
    public void addArticleToCartByImage(Method method) throws Throwable {
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");

        String expectedArcticle = "Android";
        IndexPage indexPage = new IndexPage(driver);
        ProductPage productPage = indexPage.
                clickOnShopage()
                .addToCartByImage().addTocart();
        Assert.assertTrue(productPage.getArticleDescriptif().contains(expectedArcticle));
    }
    @Test()
    //practauto 84
    public void addArticleToCartFromShopage(Method method) throws Throwable {
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");
        String expectedArcticleMessage = "View Basket";
        IndexPage indexPage = new IndexPage(driver);
        ShopPage shopPage = indexPage.clickOnShopage();
        shopPage.addToCart().getViewArticleProductMessage();
        String actualArcticleMessage = shopPage.getViewArticleProductMessage();
        Assert.assertTrue(actualArcticleMessage.contains(expectedArcticleMessage));
    }

    @Test()
    //practauto 86
    public void addArticleToCartByLabel(Method method) throws Throwable {

        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");
        String expectedArcticleMessage = "has been added to your basket";
        IndexPage indexPage = new IndexPage(driver);
        ProductPage productPage = indexPage.
                clickOnShopage()
                .addToCartByLabel().addTocart();
        Assert.assertTrue(productPage.getAddArticleConfirmationMessage().contains(expectedArcticleMessage));
    }

    @Test()
    //practauto 87
    public void addArticleToCartByPrice(Method method) throws Throwable {
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");
        String expectedArcticleMessage = "has been added to your basket";
        String expectedArticleDetails = "This guide introduces the";
        IndexPage indexPage = new IndexPage(driver);
        ProductPage productPage = indexPage.
                clickOnShopage()
                .addToCartByPrice().addTocart();

        String actualArticleDetails = productPage.getArticleDescriptif();
        String actualArticleMessage = productPage.getAddArticleConfirmationMessage();

        Assert.assertTrue(actualArticleMessage.contains(expectedArcticleMessage));
        Assert.assertTrue(actualArticleDetails.contains(expectedArticleDetails));
    }

    @Test()

    //pracauto 88
    public void verifyFilterByTheme(Method method) throws Throwable {
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");

        String expectedAndroidCat = "Android";
        IndexPage indexPage = new IndexPage(driver);
        ShopPage shopPage = indexPage.clickOnShopage().shopFilterbyTheme();
        shopPage.getshopFilterbyTheme();
        Assert.assertTrue(shopPage.getshopFilterbyTheme().contains(expectedAndroidCat));

    }

    @Test()
    public void verifyFilterByPrice1(Method method) throws Throwable {
        startTest(method.getName(), "Invalid Login Scenario with invalid username and password.");


        int expectePprice = 30000;

        IndexPage  indexPage = new IndexPage(driver);
        ShopPage shopPage =  indexPage.clickOnShopage().shopFilterByPrice();
        shopPage.getFilterArticle(expectePprice);
        Assert.assertTrue(shopPage.getFilterArticle(expectePprice));

    }


   /* @Test()
    public void verifyViewBasket() throws Throwable {
        IndexPage indexPage = new IndexPage(driver);
        boolean istbasasketpresent = indexPage.clickOnShopage().isbasketPresent();
        Assert.assertTrue(istbasasketpresent);
    }*/







    /*@Test

    public void SaleArticlePresent () throws Throwable {

        String expectedFirsArticle = "Android Quick Start Guide";
        IndexPage indexPage = new IndexPage((driver));
        ShopPage shopPage = indexPage.clickOnShopage().addToCart();
        Assert.assertTrue(shopPage.getArticle().contains(expectedFirsArticle));

    }*/
}
