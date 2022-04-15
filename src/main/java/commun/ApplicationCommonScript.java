package main.java.commun;


import main.java.utility.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import main.java.utility.ConfigFileReader;



public class ApplicationCommonScript extends ConfigFileReader {
	//=========================================================================================
	//DECLARATIONS
	//=========================================================================================

	//WebDriver
	protected  WebDriver driver;
	protected WebDriverWait wait;
	private Properties properties;
	private Properties data;
	//public static ThreadLocal<RemoteWebDriver> driver1 = new ThreadLocal<>();

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
		Log.info("Clic sur " + elementName);
		verifierVisibiliteElement(elementLocator);
		driver.findElement(elementLocator).click();
	}

	/**
	 * Cette fonction permet de saisir un texte dans un champ
	 *
	 * @param elementLocator
	 */
	public void saisirTexte(By elementLocator, String texte) {
		Log.info("Saisie de " + texte);
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
		Log.info("Ouverture de Chrome");
		driver.manage().window().maximize();

		//driver.get("https://tipoca-recette.sogelabs.com/login");
	}


	public   void SaisirCaractere (String xpath, String value){

		String val = value;
		WebElement element = driver.findElement(By.cssSelector(xpath));
		element.clear();

		for (int i = 0; i < val.length(); i++){
			char c = val.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
		}
	}

	/***
	 *
	 * cette fonction permet de generer des valeur par data provider
	 * @return
	 */


	/***
	 * cette fonction permet de lire charger un jeu de
	 * @return
	 */

	public ConfigFileReader  getAllData(String path){
		Properties data = new Properties();
		ConfigFileReader configFileReader = new ConfigFileReader(path);
		return configFileReader;

	}


		public static String getRandomString(int i)
		{
			String theAlphaNumericS;
			StringBuilder builder;

			theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
					+ "0123456789";

			//create the StringBuffer
			builder = new StringBuilder(i);

			for (int m = 0; m < i; m++) {

				// generate numeric
				int myindex
						= (int)(theAlphaNumericS.length()
						* Math.random());

				// add the characters
				builder.append(theAlphaNumericS
						.charAt(myindex));
			}

			return builder.toString();
		}

	}

	/*
	public static   Object[][]  dataLoad(){
		BufferedReader br = null;
		String txtSplitBy = ",";
		String[] dat= null;
		String returnObj[][] = null;
		ArrayList<String> content = new ArrayList<String>();
		try {

			String sCurrentLine;
			int datalength = 0;
			int listsize =0;

			br = new BufferedReader(new FileReader("C:\\users\\cnouba\\Documents\\SOGETI-TAC\\seleniumJava\\src\\test\\resources\\createNewAccount\\Pracauto-69-CreateAccountWithExistantEmail.txt"));
			//("user.dir")+"\\src\\test\\resources\\Pracauto-52-ValidUserPwd.txt")

			while ((sCurrentLine = br.readLine()) != null) {
				String []test = sCurrentLine.split(txtSplitBy);
				content.add(sCurrentLine);
			}
			for (String s : content) {
				System.out.println(s);
			}

			listsize = content.size();
			//recupere le nombre de parametre de la ligne (colone)
			datalength = content.get(0).split(txtSplitBy).length;
			returnObj = new String[listsize][datalength];

			for (int i = 0; i<listsize; i++) {

				dat = content.get(i).split(txtSplitBy);
				for (int j=0; j< datalength ; j++) {
					returnObj[i][j] = dat[j];
				}

			}

		} catch (
				IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

		return returnObj;
	}*/






