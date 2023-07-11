package com.herokuapp.internet.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	private String browser;
	private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	private Logger log;
	
	public DriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;
	}
	
	public WebDriver createDriver(String browser) {
		
		//Create driver
		log.info("Create driver:" + browser);
		switch (browser) {
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}
		case "firefox": {
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver.set(new FirefoxDriver());
			break;
		}
		default: {
			log.info("Do not know how to start " + browser + "starting chrome instead");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}

		}

//		// maximize browser window
//		driver.manage().window().maximize();

//		// Implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver.get();
	}
}
