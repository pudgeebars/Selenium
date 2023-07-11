package com.herokuapp.internet.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;
	protected Logger log;

	
	//Driver set up
	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	public void setup(@Optional("chrome") String browser, ITestContext ctx) {
		
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		
		DriverFactory factory = new DriverFactory(browser, log);
		driver = factory.createDriver(browser);
		

		// maximize browser window
		driver.manage().window().maximize();

//		// Implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		log.info("Executed after each test method");
		driver.quit();
	}
}
