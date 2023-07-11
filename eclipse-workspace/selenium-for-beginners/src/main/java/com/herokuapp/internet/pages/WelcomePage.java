package com.herokuapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePage{

	
	private String pageUrl = "https://the-internet.herokuapp.com";
	
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By checkboxesLink = By.linkText("Checkboxes");
	
	public WelcomePage(WebDriver driver, Logger log) {
		super(driver,log);
	}

	public void openPage() {
		log.info("Opening page: " + pageUrl );
		openUrl(pageUrl);
		log.info("Page opened");
	}
	
	public LoginPage clickFormAuthenticationLink() {
		log.info("Clicking Form Authentication link on Welcome");
		click(formAuthenticationLinkLocator);
		return new LoginPage(driver,log);
	}
	
	public CheckBoxPage clickCheckboxesLink() {
		log.info("Clicking Checkboxes Link on Welcome Page");
		click(checkboxesLink);
		return new CheckBoxPage(driver,log);
	}
}
