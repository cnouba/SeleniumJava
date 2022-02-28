package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import main.java.commun.ApplicationCommonScript;

public class PageCoursDetails extends ApplicationCommonScript{
	
	//===========================================================================================================
	//DECLARATIONS
	//===========================================================================================================
	private BarreMenu pBarreMenu;
	
	private By boutonRetour = By.xpath("//a[@class='creationmanager-retour']");
	private String titreCours(String cours) {
		return "//h3[@class='cour-title' and contains(.,'"+cours+"')]";
	}
	private String infoSpanDuree(String duree) {
		return "//img[@src='/_nuxt/img/picto-temps.4d63012.png']/following-sibling::span[@class='cours-infosspan' and contains(.,'"+duree+"')]";
	}
	private String infoSpanNiveau(String niveau) {
		return "//img[@src='/_nuxt/img/picto-difficulte.83cee5d.png']/following-sibling::span[@class='cours-infosspan' and contains(.,'"+niveau+"')]";
	}
	
	//===========================================================================================================
	//METHODES
	//===========================================================================================================
	
	/**
	 * Constructeur de la page Accueil
	 */
	public PageCoursDetails(WebDriver driver,String cours) {
		
		this.driver = driver;
		verifierVisibiliteElement(By.xpath(titreCours(cours)));
		pBarreMenu = new BarreMenu(driver);
		LOG.info("La page 'Cours' s'est bien affichée");
	}
	
	/**
	 * Init Barre Menu
	 * @return
	 */
	public BarreMenu barreMenu() {
		return pBarreMenu;
	}
	
	/**
	 * Verififcation de la duree et du niveau
	 * @param duree
	 * @param niveau
	 */
	public void verifierDureeNiveau(String duree, String niveau) {
		LOG.info("Verification de la duree du cours(" +duree+") et du niveau("+niveau+")");
		
		verifierVisibiliteElement(By.xpath(infoSpanDuree(duree)));
		verifierVisibiliteElement(By.xpath(infoSpanNiveau(niveau)));
	}
	/**
	 * Retour sur la page 'Cours'
	 * @return
	 */
	public PageCours retourPageCours() {
		LOG.info("Retour sur la page 'Cours'");
		
		cliquerElement(boutonRetour, "bouton retour");
		return new PageCours(driver);
	}

}