package poker;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

public class pokernowclub {

	public ChromeDriver driver;

	@BeforeMethod
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("src/main/resources/2.0.1_0.crx"));
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@Test
	public void main() {

		String url = "https://www.pokernow.club/start-game";
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
// 		open webpage
		driver.get(url);

		WebElement nicknameBox = driver.findElement(By.xpath("//*[@id='canvas']/div[2]/div/form/div[1]/input"));
		nicknameBox.sendKeys("EC");

		WebElement createGameBtn = driver.findElement(By.xpath("//*[@id='canvas']/div[2]/div/form/button"));
		createGameBtn.click();

		
		WebElement optionsBtn = driver.findElement(By.xpath("//*[@id='canvas']/div[1]/div[2]/div[2]/button"));
		optionsBtn.click();

		WebElement gameTabBtn = driver.findElement(By.xpath("//*[@id='canvas']/div[1]/div[3]/div[1]/button[3]"));
		gameTabBtn.click();

		WebElement addLevelBtn = driver.findElement(
				By.xpath("//*[@id='canvas']/div[1]/div[3]/div[2]/form/div[1]/div/div/table/tbody/tr[2]/td/button"));

		

		Actions act = new Actions(driver);

		// blinds and duration array
		String[] sb = { "10", "20", "30", "40", "50", "60", "80", "100", "125", "150", "175", "200", "300", "400" };
		String[] bb = { "20", "40", "60", "80", "100", "120", "160", "200", "250", "300", "350", "400", "600", "800" };
		String duration = "3";

		for (int i = 0; i < 13; i++) {
			act.moveToElement(addLevelBtn).click().build().perform();
			wait.until(ExpectedConditions.elementToBeClickable(addLevelBtn));
			act.sendKeys(Keys.ARROW_DOWN).build().perform();
			driver.findElement(By.xpath("//*[@id='canvas']/div[1]/div[3]/div[2]/form/div[1]/div/div/table/tbody/tr["
					+ (i + 1) + "]/td[2]/input")).sendKeys(sb[i]);
			driver.findElement(By.xpath("//*[@id='canvas']/div[1]/div[3]/div[2]/form/div[1]/div/div/table/tbody/tr["
					+ (i + 1) + "]/td[3]/input")).sendKeys(bb[i]);
			driver.findElement(By.xpath("//*[@id='canvas']/div[1]/div[3]/div[2]/form/div[1]/div/div/table/tbody/tr["
					+ (i + 1) + "]/td[4]/input")).sendKeys(duration);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		driver.findElement(By.xpath("//*[@id='canvas']/div[1]/div[3]/div[2]/form/div[1]/div/div/table/tbody/tr[14]/td[2]/input")).sendKeys(sb[sb.length -1]);
		driver.findElement(By.xpath("//*[@id='canvas']/div[1]/div[3]/div[2]/form/div[1]/div/div/table/tbody/tr[14]/td[3]/input")).sendKeys(bb[bb.length -1]);
		driver.findElement(By.xpath("//*[@id='canvas']/div[1]/div[3]/div[2]/form/div[3]/button")).click();
		
//		WebElement okButton = driver.findElement(By.xpath("//*[@id='canvas']/div[1]/div/div[2]/button"));
		WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='canvas']/div[1]/div/div[2]/button")));
//		act.moveToElement(okButton).click().build().perform();
		okButton.click();
		
		driver.findElement(By.xpath("//*[@id='canvas']/div[1]/div[3]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id='canvas']/div[1]/div[2]/div[4]/div[1]/input")).click();
	}

}
