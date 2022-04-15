package main.java.commun;


import main.java.utility.Log;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.Properties;


public class SetupTeardown extends ApplicationCommonScript{


	public static Properties prop;

	public WebDriver getDriver() {
		return driver;
	}


	//@Parameters("browser")

	@BeforeClass
	@BeforeMethod
	public void	setup() throws Exception {

		BasicConfigurator.configure();
		//load properties
		Properties prop=new Properties();
		FileInputStream objfile = new FileInputStream(
				System.getProperty("user.dir") + "\\Configuration\\Config.properties");
		prop.load(objfile);

		//browser
		String BrowserName = prop.getProperty("browser");

		if(BrowserName.equalsIgnoreCase("chrome")){
			//create chrome instance

			ChromeDriverService service = ChromeDriverService.createDefaultService();
			System.setProperty("webdriver.chrome.verboseLogging", "false");

			ChromeOptions options = new ChromeOptions();

			driver = new ChromeDriver(service,options);

		}
		else if(BrowserName.equalsIgnoreCase("firefox")){
			//create firefox instance
			driver = new FirefoxDriver();
		}else {
			System.out.println("erreur");
		}

		//Ouverture du navigateur
		Log.info("Ouverture de Chrome");
		driver.manage().window().maximize();

		driver.get(prop.getProperty("url"));
	}


	@AfterMethod
	public void cleanup(){
		driver.quit();
	}


	@AfterClass


		public void teardown(){
		driver.quit();
	}

}