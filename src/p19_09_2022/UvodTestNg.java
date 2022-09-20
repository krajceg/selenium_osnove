package p19_09_2022;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UvodTestNg {
	
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
		driver.get("https://www.google.com/");
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@Test(priority = 100)
	public void openHomePage() {
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google Home";
		
		Assert.assertEquals(actualTitle, expectedTitle, "ERROR: Unexpected title.");

		driver.quit();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After class");
	}

}
