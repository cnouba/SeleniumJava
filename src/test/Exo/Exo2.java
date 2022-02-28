package test.Exo;


import org.testng.annotations.Test;

import main.java.commun.Constantes;
import main.java.commun.SetupTeardown;
import main.java.pages.PageIdentification;




public class Exo2 extends SetupTeardown{
	
	//Objectif : Controler les messages d'erreur d'authentification
	//Creer un test pour controler le message d'utilisateur invalide
	//Creer un test pour controler le message de mot de passe invalide
	
	
	
	public PageIdentification pIdentification;
	
	 
	@Test()
	public void test() throws InterruptedException {
		LOG.info("Exo 2.1");
		
		pIdentification = new PageIdentification(driver);		
		//Connexion	avec un login inexistant		
		pIdentification.connexionUtilisateurInexistant("invalide@yopmail.com", Constantes.loginMdp);
	}
	
	@Test()
	public void test2() throws InterruptedException {
		LOG.info("Exo 2.2");
		
		pIdentification = new PageIdentification(driver);
		
		//Connexion avec un mot de passe erroné	
		pIdentification.connexionMdpInvalide(Constantes.loginUser, "erreur");
		
	}	

	
	


}