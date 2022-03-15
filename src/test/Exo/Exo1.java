package test.Exo;


import main.java.pages.IndexPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.commun.SetupTeardown;


public class Exo1 extends SetupTeardown{

	//Objectif : Automatiser la connexion a Tipoca
	//Se déconnecter
private IndexPage indexPage;

	@Test()
	public void test() throws Throwable {

		LOG.info("Exo 1");
		IndexPage _indexPage = new IndexPage(driver);
		_indexPage.clickOnMyAccount();

	}

	@Test
	public void verifyLogo() throws Throwable {

		LOG.info("verifyLogo");
		indexPage= new IndexPage(driver);
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
		LOG.info("fin verifyLogo");

	}

	


}