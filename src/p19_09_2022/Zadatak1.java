package p19_09_2022;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Zadatak1 {
	
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
		driver.get("https://cms.demo.katalon.com");
	}
	
	@Test(priority = 10)
	public void visitLoginPageFromNavBar() {
		
		driver.findElement(By.xpath("//div[@id='primary-menu']/ul/li[@class='page_item page-item-10']/a")).click();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "My account – Katalon Shop";
		
		Assert.assertEquals(actualTitle, expectedTitle, "Expected Title is: My account – Katalon Shop");
		
		String actualUrl = driver.getCurrentUrl();
		String nastavak = "/my-account/";
		
		Assert.assertTrue(actualUrl.contains(nastavak), "Expected URL must contain /my-account/");
	}
	

	
	@Test(priority = 20)
	public void checkInputTypes() {
		driver.navigate().to("https://cms.demo.katalon.com/my-account/");
		
		String actualType = driver.findElement(By.id("username")).getAttribute("type");
		String expectedType = "text";
		
		Assert.assertEquals(actualType, expectedType, "Expected type should be text!");
		
		String actualPasswordType = driver.findElement(By.id("password")).getAttribute("type");
		String expectedPasswordType = "password";
		
		Assert.assertEquals(actualPasswordType, expectedPasswordType, "Expected type should be password!");
		
		String actualCheckboxType = driver.findElement(By.id("rememberme")).getAttribute("type");
		String expectedCheckboxType = "checkbox";
		
		Assert.assertEquals(actualCheckboxType, expectedCheckboxType, "Expected type should be checkbox!");
		
		Assert.assertTrue(!driver.findElement(By.id("rememberme")).isSelected(), "Expected checkbox should not be checked!");
	}
	
	@Test(priority = 30)
	public void displayErrorWhenCredentialsAreWrong() {
		driver.navigate().to("https://cms.demo.katalon.com/my-account/");
		
		driver.findElement(By.id("username")).sendKeys("invalidemail@gmail.com");
		driver.findElement(By.id("password")).sendKeys("invalid123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		boolean postoji;
		try {
			driver.findElement(By.xpath("//ul[@role='alert']"));
			postoji = true;
		} catch (NoSuchElementException e) {
			postoji = false;
		}
		
		Assert.assertTrue(postoji, "Expected error message should be visible");
		
		String actualTextPoruke = driver.findElement(By.xpath("//ul[@role='alert']/li")).getText();
		String expectedTextPoruke = "ERROR: Invalid email address";
		
		Assert.assertTrue(actualTextPoruke.contains(expectedTextPoruke), "Expected message should contain: ERROR: Invalid email address");
		Assert.assertTrue(driver.getCurrentUrl().contains("/my-account"), "Expected URL should contain /my-account");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	

}
