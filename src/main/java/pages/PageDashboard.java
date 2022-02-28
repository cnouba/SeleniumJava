package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import main.java.commun.ApplicationCommonScript;

public class PageDashboard extends ApplicationCommonScript{
	
	//===========================================================================================================
	//DECLARATIONS
	//===========================================================================================================
	private BarreMenu pBarreMenu;
	
	private By titreDashboard = By.xpath("//h3[contains(.,Dashboard)]");
	private By boutonDeconnexion = By.xpath("//ul[@class='logout']/li/a/img/following-sibling::span");
	private By logoDeconnexion = By.xpath("//img[@src='/logout-icn.png']");
	
	//===========================================================================================================
	//METHODES
	//===========================================================================================================
	
	/**
	 * Constructeur de la page Dashboard
	 */
	public PageDashboard(WebDriver driver) {
		
		this.driver = driver;
		verifierVisibiliteElement(titreDashboard);
		pBarreMenu = new BarreMenu(driver);
		LOG.info("La connexion a bien été établie");
	}
	
	/**
	 * Init Barre Menu
	 * @return
	 */
	public BarreMenu barreMenu() {
		return pBarreMenu;
	}
	
	/**
	 * Deconnexion de l'application
	 * @return
	 */
	public PageIdentification deconnexion() {
		LOG.info("Se deconnecter de l'application");
		//cliquerElement(boutonBienvenue, "bouton bienvenue");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(logoDeconnexion)).click().build().perform();
		cliquerElement(boutonDeconnexion, "bouton deconnexion");
		return new PageIdentification(driver);
		
	}

}