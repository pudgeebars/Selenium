package com.secured.tfxi;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CoinSettlement {

	WebDriver driver;
	
	@BeforeMethod
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("src/main/resources/2.0.1_0.crx"));
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Parameters({"username","password"})
	@Test
	public void automatedCoinSettlement(@Optional ("123") String username, @Optional ("123") String password) {
		
		String url = "https://secured.tfxi.com/account/coins-settlement/create";
		driver.get(url);
		
		//login
		driver.findElement(By.id("login")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
//		driver.findElement(By.id("requestCoinAmountInput")).sendKeys("100");
//		//captcha issue
//		driver.findElement(By.id("submitCoinSettlementButton")).click();
	}
}
