package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionsTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://www.lambdatest.com/selenium-playground/";
		driver.navigate().to(url);
	}
	
	@Test
	public void checkBoxDemo() {
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"isAgeSelected\"]")).click();
		Assert.assertTrue(driver.findElement(By.id("age")).isDisplayed(), "Confirmation message not displayed");
	}
	
	@Test
	public void radioButtonTest() {
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div[1]/div/label[1]/input")).click();
		driver.findElement(By.id("buttoncheck")).click();
		WebElement radioButtonValue = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[2]/div/div/div/div[1]/div/p[2]"));
		Assert.assertTrue(radioButtonValue.getText().contains("Male"), "Radio button value is incorrect");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
