package main.java.commun;


import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import main.java.commun.ApplicationCommonScript;


public class SetupTeardown extends ApplicationCommonScript{


	public static Properties prop;


	//@Parameters("browser")

	@BeforeTest

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
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox")){
			//create firefox instance
			driver = new FirefoxDriver();
		}else {
			System.out.println("erreur");
		}

		//Ouverture du navigateur
		LOG.info("Ouverture de Chrome");
		driver.manage().window().maximize();

		driver.get(prop.getProperty("url"));
	}

	@AfterTest
		public void teardown(){
		driver.quit();
	}
	
}