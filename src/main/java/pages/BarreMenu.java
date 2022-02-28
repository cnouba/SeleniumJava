package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import main.java.commun.ApplicationCommonScript;

public class BarreMenu extends ApplicationCommonScript{
	
	//===========================================================================================================
	//DECLARATIONS
	//===========================================================================================================
	
	private By logoDashboard = By.xpath("//img[@src='/dashboard-icn.png']");
	private By logoCours = By.xpath("//img[@src='/cours-icn.png']");
	private By logoCursus = By.xpath("//img[@src='/cursus-icn.png']");
	private By logoDeconnexion = By.xpath("//img[@src='/logout-icn.png']");
	private By boutonDashboard = By.xpath("//img[@src='/dashboard-icn.png']/following-sibling::span");
	private By boutonCours = By.xpath("//img[@src='/cours-icn.png']/following-sibling::span");
	private By boutonCursus= By.xpath("//img[@src='/cursus-icn.png']/following-sibling::span");
	private By boutonDeconnexion = By.xpath("//ul[@class='logout']/li/a/img/following-sibling::span");
	
	//===========================================================================================================
	//METHODES
	//===========================================================================================================
	
	/**
	 * Constructeur de la barre menu
	 */
	public BarreMenu(WebDriver driver) {
		
		this.driver = driver;
		//verifierVisibiliteElement(logoDashboard);
		LOG.info("La barre menu est bien affichée");
	}
	
	/**
	 * Clic sur l'onglet Dashboard
	 * @return
	 */
	public PageDashboard cliquerOngletDashboard() {
		LOG.info("Redirection vers la page 'Dashboard'");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(logoDashboard)).click().build().perform();
		cliquerElement(boutonDashboard, "bouton dashboard");
		return new PageDashboard(driver);
	}
	
	/**
	 * Clic sur l'onglet Cours
	 * @return
	 */
	public PageCours cliquerOngletCours() {
		LOG.info("Redirection vers la page 'Cours'");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(logoCours)).click().build().perform();
//		cliquerElement(logoCours, "logo cours");
		cliquerElement(boutonCours, "bouton cours");
		return new PageCours(driver);
	}
	
	/**
	 * Clic sur l'onglet Cursus
	 * @return
	 */
	public PageCursus cliquerOngletCursus() {
		LOG.info("Redirection vers la page 'Cursus'");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(logoCursus)).click().build().perform();
		cliquerElement(boutonCursus, "bouton cursus");
		return new PageCursus(driver);
	}
	
	/**
	 * Deconnexion de l'application
	 * @return
	 */
	public PageIdentification deconnexion() {
		LOG.info("Se deconnecter de l'application");
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(logoDeconnexion)).click().build().perform();
		cliquerElement(boutonDeconnexion, "bouton deconnexion");
		return new PageIdentification(driver);
		
	}
	
}