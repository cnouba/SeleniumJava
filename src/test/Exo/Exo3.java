package test.Exo;


import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

import main.java.commun.Constantes;
import main.java.commun.SetupTeardown;


public class Exo3 extends SetupTeardown{
	
	//Objectif : D�rouler un parcours sur plusieurs pages
	//Se connecter et aller sur la page Cours
	//Aller dans le d�tail du cours "java"
	//V�rifier les �l�ments de temps et de niveau
	//Retourner sur la page Cours
	//Aller dans le d�tail du cours "Cours de plus"
	//V�rifier les �l�ments de temps et de niveau
	//Se d�connecter et fermer l'application
	
	
	public PageIdentification pIdentification;
	
	 
	@Test()
	public void test() throws InterruptedException {
		LOG.info("Exo 3");
		
		String cours1 = "java";
		String niveau1 = "Facile";
		String duree1 = "4h";
		String cours2 = "Cours de plus";
		String niveau2 = "Moyen";
		String duree2 = "0h";
		
		try
		{
		pIdentification = new PageIdentification(driver);		
		//Connexion		
		PageDashboard pDashboard = pIdentification.seConnecter(Constantes.loginUser, Constantes.loginMdp);
		
		//Aller dans la page 'Cours'
		PageCours pCours = pDashboard.barreMenu().cliquerOngletCours();
		
		//Aller dans le d�tail du cours "java"
		PageCoursDetails pCoursDetails = pCours.cliquerCommencer(cours1);
		
		//V�rifier les �l�ments de temps et de niveau
		pCoursDetails.verifierDureeNiveau(duree1, niveau1);
		
		//Retourner sur la page Cours
		pCours = pCoursDetails.retourPageCours();
		
		//Aller dans le d�tail du cours "Cours de plus"
		pCoursDetails = pCours.cliquerCommencer(cours2);
		
		//V�rifier les �l�ments de temps et de niveau
		pCoursDetails.verifierDureeNiveau(duree2, niveau2);
		
		
		//Deconnexion
		pCoursDetails.barreMenu().deconnexion();
	
		}catch (WebDriverException e) {
			throw e;
	
		}catch (Exception e) {
			throw e;
		}
	
	}		

}