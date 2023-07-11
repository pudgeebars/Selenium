package com.herokuapp.internet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExceptionsTests {

	private WebDriver driver;
	private String url = "https://practicetestautomation.com/practice-test-exceptions/";

	@Parameters({ "browser" })
	@BeforeMethod(alwaysRun = true)
	private void setup(@Optional("chrome") String browser) {
		// create driver
		switch (browser) {
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		case "firefox": {
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		default: {
			System.out.println("Do not know how to start " + browser + "starting chrome instead");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		}

		// maximize browser window
		driver.manage().window().maximize();

		// Implicit wait
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void noSuchElementExceptionTest() {
		// Test case 1
		// Open page
		// Click Add button
		// Verify Row 2 input field is displayed

		// open test website
		driver.get(url);
		System.out.println("Page has been opened");

		// Click Add button
		WebElement addButton = driver.findElement(By.id("add_btn"));
		addButton.click();

		// Verify Row 2 input field is displayed
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement row2Box = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
		Assert.assertTrue(row2Box.isDisplayed(), "no wait time");
	}

	@Test
	public void elementNotInteractableExceptionTest() {
		// Test case 2: ElementNotInteractableException
		// Open page
		// Click Add button
		// Wait for the second row to load
		// Type text into the second input field
		// Push Save button using locator By.name(“Save”)
		// Verify text saved

		// Open page
		driver.navigate().to(url);
		System.out.println("Page has been opened");

		// Click Add button
		WebElement addButton = driver.findElement(By.id("add_btn"));
		addButton.click();

		// Wait for the second row to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement row2Box = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
		Assert.assertTrue(row2Box.isDisplayed(), "no wait time");

		// Type text into the second input field
		row2Box.sendKeys("Hotdog");

		// Push Save button using locator By.name(“Save”)
		// WebElement saveButtonRow2 =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Save")));
		WebElement saveButtonRow2 = driver.findElement(By.xpath("//div[@id='row2']/button[@name='Save']"));
		saveButtonRow2.click();

		// Verify text saved
		WebElement row2ConfirmationBox = driver.findElement(By.id("confirmation"));
		Assert.assertEquals(row2ConfirmationBox.getText(), "Row 2 was saved",
				"Confirmation message text is not as expected");
	}

	// Test case 3: InvalidElementStateException
	// Open page
	// Clear input field
	// Type text into the input field
	// Verify text changed

	@Test
	public void invalidElementStateExceptionTest() {
		// Open page
		driver.navigate().to(url);
		System.out.println("Page has been opened");

		// Click Edit Button
		WebElement editBtn = driver.findElement(By.id("edit_btn"));
		editBtn.click();

		// Clear input field
		WebElement row1Box = driver.findElement(By.xpath("//*[@id='row1']/input"));
		row1Box.clear();

		// Type text into the input field
		String newText = "Hambruger";
		row1Box.sendKeys(newText);

		// Click Save Button
		WebElement saveBtn = driver.findElement(By.id("save_btn"));
		saveBtn.click();

		// Verify text changed
		Assert.assertEquals(row1Box.getAttribute("value"), newText);
		WebElement row1ConfirmationBox = driver.findElement(By.id("confirmation"));
		Assert.assertEquals(row1ConfirmationBox.getText(), "Row 1 was saved",
				"Confirmation message text is not as expected");

	}

	// Test case 4: StaleElementReferenceException
	// Open page
	// Find the instructions text element
	// Push add button
	// Verify instruction text element is no longer displayed
	@Test
	private void staleElementReferenceExceptionTest() {
		// Open page
		driver.navigate().to(url);
		System.out.println("Page opened");

		// Find the instructions text element
		WebElement instructionsText = driver.findElement(By.id("instructions"));
		Assert.assertTrue(instructionsText.isDisplayed());

		// Push add button
		WebElement addButton = driver.findElement(By.id("add_btn"));
		addButton.click();

		// Verify instruction text element is no longer displayed
		// Assert.assertFalse(instructionsText.isDisplayed(), "Instructions text is
		// still displayed");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("instructions"))),
				"Instructions are still displayed");
	}

	@Test
	// Test case 5: TimeoutException
	// Open page
	// Click Add button
	// Wait for 3 seconds for the second input field to be displayed
	// Verify second input field is displayed
	private void timeoutExceptionTest() {
		// Open page
		driver.navigate().to(url);
		System.out.println("Page opened");
		
		// Click Add button
		WebElement addButton = driver.findElement(By.id("add_btn"));
		addButton.click();
		
		// Wait for 3 seconds for the second input field to be displayed
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		WebElement row2Box = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='row2']/input")));
		
		// Verify second input field is displayed
		Assert.assertTrue(row2Box.isDisplayed(), "Row 2 input box not displayed");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		System.out.println("Browser closed");
		driver.quit();
	}

}
