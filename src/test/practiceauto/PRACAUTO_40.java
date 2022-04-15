package test.practiceauto;

import main.java.commun.SetupTeardown;
import main.java.pages.IndexPage;
import main.java.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static main.java.utility.extentReports.ExtentTestManager.startTest;

public class PRACAUTO_40 extends SetupTeardown {

    @Test()
    //practauto 87
    public void addArticleToCartBySetO(Method method) throws Throwable {
        startTest(method.getName(), "Minimum article to add");
        //String expectedMinimumArticleDetails = "1";
        IndexPage indexPage = new IndexPage(driver);
        ProductPage productPage = indexPage.
                clickOnShopage()
                .addToCartByPrice().addTocart1();
        Boolean lArticleDetails = productPage.isMinimumProductClickable();
        //Assert.assertTrue(actualArticleDetails.contains(expectedMinimumArticleDetails));
        Assert.assertTrue(lArticleDetails);
    }


    @Test()
    //practauto 84
    public void addArticleToCartFromProductPpage(Method method) throws Throwable {
        startTest(method.getName(), "Add Article from Product Page.");

        String expectedArcticleMessage = "has been added to your basket";

        IndexPage indexPage = new IndexPage(driver);
        ProductPage productPage = indexPage.
                clickOnShopage()
                .addToCartByPrice().addTocartview();

        String ActualArticleConfirmationMessage = productPage.getAddArticleConfirmationMessage();
        productPage.clickOnviewBasket();
        Assert.assertTrue(ActualArticleConfirmationMessage.contains(expectedArcticleMessage));

    }


}


