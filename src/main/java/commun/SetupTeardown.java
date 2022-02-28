package main.java.commun;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SetupTeardown extends ApplicationCommonScript{
	

	
	@BeforeTest
		public void	setup(){
		driver = new ChromeDriver();
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