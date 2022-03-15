package main.java.commun;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;






public class ApplicationCommonScript {
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
	 *
	 * @param elementLocator
	 * @return
	 */
	public WebElement verifierVisibiliteElement(By elementLocator) {
		WebElement element;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));

		} catch (TimeoutException t) {
			throw new NoSuchElementException("KO");
		}
		return element;
	}

	/**
	 * Cette fonction permet de cliquer sur un element
	 *
	 * @param elementLocator
	 */
	public void cliquerElement(By elementLocator, String elementName) {
		LOG.info("Clic sur " + elementName);
		verifierVisibiliteElement(elementLocator);
		driver.findElement(elementLocator).click();
	}

	/**
	 * Cette fonction permet de saisir un texte dans un champ
	 *
	 * @param elementLocator
	 */
	public void saisirTexte(By elementLocator, String texte) {
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
// TODO: 07/03/2022

	/**
	 * Cette fonction permet d'ouvrir depuis n'importe lequel des navigateurs
	 */

	public void setup1() throws Exception {
		Properties prop = new Properties();
		String browserName = prop.getProperty("browser");
		//public void	setup(@Optional("chrome")String browser) throws Exception
		if (browserName.equalsIgnoreCase("chrome")) {
			//create chrome instance
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			//create firefox instance
			driver = new FirefoxDriver();
		} else {
			System.out.println("erreur");
		}


		//Ouverture du navigateur
		LOG.info("Ouverture de Chrome");
		driver.manage().window().maximize();

		//driver.get("https://tipoca-recette.sogelabs.com/login");
	}


		/*
		//Maximize the screen
		getDriver().manage().window().maximize();
		//Delete all the cookies
		getDriver().manage().deleteAllCookies();
		//Implicit TimeOuts
		getDriver().manage().timeouts().implicitlyWait
				(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
		//PageLoad TimeOuts
		getDriver().manage().timeouts().pageLoadTimeout
				(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		//Launching the URL
		getDriver().get(prop.getProperty("url"));*/

	@BeforeSuite
	public static void loadConfig() throws IOException {

		Properties prop = new Properties();
		FileInputStream objfile = new FileInputStream(
				System.getProperty("user.dir") + "\\Configuration\\Config.properties");

		prop.load(objfile);
	}

}

