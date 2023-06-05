package com.herokuapp.internet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test
	public void loginTest() {
		System.out.println("Start login test");
		
//		create driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		open test page
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is opened");
		
		
//		sleep for 3 seconds
		sleep(3000);

// 		maximize browser window
		driver.manage().window().maximize();

//		enter username

//		enter password

//		click login button

//		new url

//		logout button is visible

//		successful login message

// 		close browser
		System.out.println("End login test");
		driver.quit();
	}

	public void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
