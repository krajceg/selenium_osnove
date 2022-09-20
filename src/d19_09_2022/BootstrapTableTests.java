package d19_09_2022;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class BootstrapTableTests {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get("https://s.bootsnipp.com");
	}
	
	@Test(priority = 10)
	public void editRow() throws InterruptedException {
		driver.navigate().to("https://s.bootsnipp.com/iframe/K5yrx");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actualTitle, expectedTitle, "Expected title should be: Table with Edit and Update Data - Bootsnipp.com");
		
		driver.findElement(By.xpath("//tr[@id='d1']//button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("up")));
		
		driver.findElement(By.id("fn")).clear();
		driver.findElement(By.id("ln")).clear();
		driver.findElement(By.id("mn")).clear();
		
		driver.findElement(By.id("fn")).sendKeys("Svetolik");
		driver.findElement(By.id("ln")).sendKeys("Kljajic");
		driver.findElement(By.id("mn")).sendKeys("Miroljub");
		driver.findElement(By.id("up")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("up")));
		
		String actualFirstNameR1 = driver.findElement(By.id("f1")).getText();
		String expectedFirstNameR1 = "Svetolik";
		Assert.assertEquals(actualFirstNameR1, expectedFirstNameR1, "Expected First Name in Row 1 should be Svetolik");
		
		String actualLastNameR1 = driver.findElement(By.id("l1")).getText();
		String expectedLastNameR1 = "Kljajic";
		Assert.assertEquals(actualLastNameR1, expectedLastNameR1, "Expected Last Name in Row 1 should be Kljajic");
		
		String actualMiddleNameR1 = driver.findElement(By.id("m1")).getText();
		String expectedMiddleNameR1 = "Miroljub";
		Assert.assertEquals(actualMiddleNameR1, expectedMiddleNameR1, "Expected Middle Name in Row 1 should be Miroljub");
	}
	
	@Test(priority = 20)
	public void deleteRow() throws InterruptedException {
		driver.navigate().to("https://s.bootsnipp.com/iframe/K5yrx");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actualTitle, expectedTitle, "Expected title should be: Table with Edit and Update Data - Bootsnipp.com");
		
		driver.findElement(By.xpath("//tr[@id='d1']//button[contains(@class, 'delete')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("del")));
		driver.findElement(By.id("del")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("del")));
		boolean d1Red = driver.findElement(By.id("d1")).isDisplayed();
		Assert.assertEquals(d1Red, false, "D1 row should be deleted");
	}
	
	@Test(priority = 30)
	public void takeAScreenshot() throws IOException {
		driver.navigate().to("https://s.bootsnipp.com/iframe/K5yrx");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Table with Edit and Update Data - Bootsnipp.com";
		Assert.assertEquals(actualTitle, expectedTitle, "Expected title should be: Table with Edit and Update Data - Bootsnipp.com");
		
		TakesScreenshot srcShot = ((TakesScreenshot)driver);
		File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\krajc\\eclipse-workspace\\selenium_osnove\\src\\paket_za_domaci\\Screenshot.png");
		FileHandler.copy(srcFile, destFile);
		
//		2 nacin
//		Screenshot screenshot = new AShot().takeScreenshot(driver);
//		ImageIO.write(screenshot.getImage(), "jpg", new File("C:\\Users\\krajc\\eclipse-workspace\\selenium_osnove\\src\\paket_za_domaci\\Screenshot2"));
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
