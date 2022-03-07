package test.Exo;


import org.testng.annotations.Test;

import main.java.commun.Constantes;
import main.java.commun.SetupTeardown;
import main.java.pages.PageDashboard;
import main.java.pages.PageIdentification;




public class Exo1 extends SetupTeardown{
	
	//Objectif : Automatiser la connexion a Tipoca
	//Se déconnecter

	
	public PageIdentification pIdentification;
	
	 
	@Test()
	public void test() throws InterruptedException {
		LOG.info("Exo 1");
		
/*
		//Connexion	
		pIdentification = new PageIdentification(driver);		
		PageDashboard pDashboard = pIdentification.seConnecter(Constantes.loginUser, Constantes.loginMdp);
		
		//Deconnexion
		pIdentification = pDashboard.deconnexion();
	
*/
	}
	@Test()
	public void testz() throws InterruptedException {
		LOG.info("Exo 1");

		//Connexion
		pIdentification = new PageIdentification(driver);
		PageDashboard pDashboard = pIdentification.seConnecter(Constantes.loginUser, Constantes.loginMdp);

		//Deconnexion
		pIdentification = pDashboard.deconnexion();


	}
	
	


}