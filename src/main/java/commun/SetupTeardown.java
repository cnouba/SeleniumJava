package main.java.commun;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;





public class SetupTeardown extends ApplicationCommonScript{



	@Parameters("browser")
	@BeforeTest

		public void	setup(@Optional("chrome")String browser) throws Exception {
		if(browser.equalsIgnoreCase("chrome")){
         //create chrome instance
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
           //create firefox instance
			driver = new FirefoxDriver();
		}


		BasicConfigurator.configure();
		
		//Ouverture du navigateur
		LOG.info("Ouverture de Chrome");
		driver.manage().window().maximize();
		
		driver.get("https://tipoca-recette.sogelabs.com/login");
	}
	
	@AfterTest
		public void teardown(){
		driver.quit();
	}
	
}