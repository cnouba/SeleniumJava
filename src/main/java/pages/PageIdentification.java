package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import main.java.commun.ApplicationCommonScript;

public class PageIdentification extends ApplicationCommonScript{
	
	//===========================================================================================================
	//DECLARATIONS
	//===========================================================================================================
	private BarreMenu pBarreMenu;
	
	private By champEmail = By.xpath("//input[@type='email']");
	private By champMdp = By.xpath("//input[@type='password']");
	private By boutonConnexion = By.xpath("//button[@type='submit' and contains(.,'Se connecter')]");
	private By messageUtilisateurExistePas = By.xpath("//p[.=\"L'utilisateur n'existe pas\"]");
	private By messageMdpInvalide = By.xpath("//div[.='Le mot de passe est invalide']");
	
	//===========================================================================================================
	//METHODES
	//===========================================================================================================
	
	/**
	 * Constructeur de la page Identification
	 */
	public PageIdentification(WebDriver driver) {
		
		this.driver = driver;
		pBarreMenu = new BarreMenu(driver);
		verifierVisibiliteElement(champEmail);
	}
	
	/**
	 * Init Barre Menu
	 * @return
	 */
	public BarreMenu barreMenu() {
		return pBarreMenu;
	}
	
	/**
	 * Saisie des identifiants
	 * @param login
	 * @param mdp
	 */
	public void saisieIdentifiant(String login, String mdp){
		LOG.info("Saisie des identifiants");
		saisirTexte(champEmail,login);
		saisirTexte(champMdp,mdp);
	}
	
	/**
	 * Connexion a son compte
	 * @return
	 */
	public PageDashboard seConnecter() {
		LOG.info("Se connecter");
		cliquerElement(boutonConnexion, "bouton Se connecter");
		return new PageDashboard(driver);
	}
	
	/**
	 * Identification d'un compte
	 * @param login
	 * @param mdp
	 * @return
	 */
	public PageDashboard seConnecter(String login, String mdp){
		LOG.info("Identification");
		saisirTexte(champEmail,login);
		saisirTexte(champMdp,mdp);
		cliquerElement(boutonConnexion, "bouton Se connecter");
		return new PageDashboard(driver);
	}
	
	/**
	 * Saisie d'un login invalide
	 * @param login
	 * @param mdp
	 */
	public void connexionUtilisateurInexistant(String login, String mdp){
		LOG.info("Saisie des identifiants");
		saisirTexte(champEmail,login);
		saisirTexte(champMdp,mdp);
		cliquerElement(boutonConnexion, "bouton Se connecter");
		verifierVisibiliteElement(messageUtilisateurExistePas);
	}
	
	/**
	 * Saisie d'un login invalide
	 * @param login
	 * @param mdp
	 */
	public void connexionMdpInvalide(String login, String mdp){
		LOG.info("Saisie des identifiants");
		saisirTexte(champEmail,login);
		saisirTexte(champMdp,mdp);
		cliquerElement(boutonConnexion, "bouton Se connecter");
		verifierVisibiliteElement(messageMdpInvalide);
	}
}