package com.herokuapp.internet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage{
	
	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver,log);
	}

	private String pageUrl = "https://the-internet.herokuapp.com/secure";
	
	private By logoutButton = By.xpath("//*[@id='content']/div[1]/a[1]") ;
	private By flashMessage = By.id("flash");
	
	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened");
	}
	
	public void logout() {
		click(logoutButton);
	}
	
	public String getPageUrl() {
		return pageUrl;
	}
	
	public boolean isLogOutButtonVisible() {
		return find(logoutButton).isDisplayed();
	}
	
	public String getSuccessMessageText() {
		return find(flashMessage).getText();
	}
}
