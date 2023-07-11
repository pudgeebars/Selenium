package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class FirstAutomatedTest {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://www.lambdatest.com/selenium-playground/";
		driver.navigate().to(url);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void testTableSortAndSearch() {
		driver.navigate().to("https://www.lambdatest.com/selenium-playground/table-sort-search-demo");
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"example_filter\"]/label/input"));
		searchBox.sendKeys("A. Bennett");
		
	}
	
	@Test(priority = 2)
	public void testBootstrapDatePicker() {
		driver.navigate().to("https://www.lambdatest.com/selenium-playground/bootstrap-date-picker-demo");
		driver.findElement(By.id("birthday")).sendKeys("06/07/2008");
		
	}
}
