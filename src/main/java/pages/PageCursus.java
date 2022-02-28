package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import main.java.commun.ApplicationCommonScript;

public class PageCursus extends ApplicationCommonScript{
	
	//===========================================================================================================
	//DECLARATIONS
	//===========================================================================================================
	private BarreMenu pBarreMenu;
	
	private By titreCursus = By.xpath("//h3[contains(.,Cursus)]");

	
	//===========================================================================================================
	//METHODES
	//===========================================================================================================
	
	/**
	 * Constructeur de la page Cursus
	 */
	public PageCursus(WebDriver driver) {
		
		this.driver = driver;
		verifierVisibiliteElement(titreCursus);
		pBarreMenu = new BarreMenu(driver);
		LOG.info("La page 'Cursus' s'est bien affichée");
	}
	
	
	public BarreMenu barreMenu() {
		return pBarreMenu;
	}

}