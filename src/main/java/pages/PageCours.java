package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import main.java.commun.ApplicationCommonScript;

public class PageCours extends ApplicationCommonScript{
	
	//===========================================================================================================
	//DECLARATIONS
	//===========================================================================================================
	private BarreMenu pBarreMenu;
	
	private By titreCours = By.xpath("//h3[contains(.,Cours)]");
	private String boutonCommencer(String cours) {
		return "//h6[@class='cours-titles' and contains(.,'"+cours+"')]/parent::a/parent::div/div/a/button[@class='cours-btn' and contains(.,'Commencer')]";
	}
	private By secondElement = By.xpath("//div[@class='col-sm-4 col-xl-3'][2]");
	
	//===========================================================================================================
	//METHODES
	//===========================================================================================================
	
	/**
	 * Constructeur de la page Cours
	 */
	public PageCours(WebDriver driver) {
		
		this.driver = driver;
		verifierVisibiliteElement(titreCours);
		pBarreMenu = new BarreMenu(driver);
		verifierVisibiliteElement(secondElement);
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(secondElement)).click().build().perform();
		LOG.info("La page 'Cours' s'est bien affich�e");
	}
	
	/**
	 * Init Barre Menu
	 * @return
	 */
	public BarreMenu barreMenu() {
		return pBarreMenu;
	}
	
	/**
	 * Ouvrir les d�tails d'un cours
	 * @return
	 */
	public PageCoursDetails cliquerCommencer(String cours) {
		LOG.info("Aller dans le d�tail du cours "+cours);
		LOG.info(boutonCommencer(cours));
		cliquerElement(By.xpath(boutonCommencer(cours)), "bouton Commencer");
		
		return new PageCoursDetails(driver, cours);
		
	}

}