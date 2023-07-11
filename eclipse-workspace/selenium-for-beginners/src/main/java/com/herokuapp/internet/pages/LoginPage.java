package com.herokuapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

	//constructor
		public LoginPage(WebDriver driver, Logger log) {
			super(driver,log);
		}
		
	private String pageUrl = "https://the-internet.herokuapp.com/login";
	
	//Element locators
	private By usernameBox = By.id("username");
	private By passwordBox = By.name("password");
	private By loginButton = By.tagName("button");
	private By flashMessage = By.id("flash");
	
	
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened");
	}
	
	public SecureAreaPage login(String username, String password) {
		log.info("Executing login with username [" + username + "] and password [" + password +"]");
		type(username, usernameBox);
		type(password, passwordBox);
		click(loginButton);
		return new SecureAreaPage(driver,log);
	}
	
	public void negativeLogin(String username, String password) {
		log.info("Executing login with username [" + username + "] and password [" + password +"]");
		type(username, usernameBox);
		type(password, passwordBox);
		click(loginButton);
	}
	
	public String getFlashMessage() {
		return find(flashMessage).getText();
	}
}