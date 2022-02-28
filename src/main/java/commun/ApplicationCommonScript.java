package main.java.commun;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApplicationCommonScript{
	//=========================================================================================
	//DECLARATIONS
	//=========================================================================================
	
	//WebDriver
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	//Log
	protected static final Logger LOG = LoggerFactory.getLogger("ApplicationCommonScript");
	
	
	//=========================================================================================
	//METHODES
	//=========================================================================================
	
	
/**
 * Cette fonction permet de vérifier qu'un element est bien visible	
 * @param elementLocator
 * @return
 */
	public WebElement verifierVisibiliteElement(By elementLocator) {
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver,30);
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
			
		} catch (TimeoutException t) {
			throw new NoSuchElementException("KO");
		}
		return element;
	}

/**
 * Cette fonction permet de cliquer sur un element
 * @param elementLocator
 */
	public void cliquerElement(By elementLocator, String elementName){
		LOG.info("Clic sur " + elementName);
		verifierVisibiliteElement(elementLocator);
		driver.findElement(elementLocator).click();
	}

/**
 * Cette fonction permet de saisir un texte dans un champ
 * @param elementLocator
 */
	public void saisirTexte(By elementLocator, String texte){
		LOG.info("Saisie de " + texte);
		verifierVisibiliteElement(elementLocator);
		driver.findElement(elementLocator).clear();
		driver.findElement(elementLocator).sendKeys(texte);
		}

/**
 * Cette fonction permet au driver de changer de page
 */
	public void changerPage(WebDriver driver) {
		driver.switchTo().window(driver.getWindowHandle());
	}
}