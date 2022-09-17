package p16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("D:\\BootCamp\\Razno\\AdBlock_Plus.crx"));
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Thread.sleep(5000);
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		
		driver.navigate().to("https://crop-circle.imageonline.co/#circlecropresult");
		
		new Actions(driver).moveToElement(driver.findElement(By.id("photobutton"))).perform();
		
		
		driver.findElement(By.id("inputImage")).sendKeys("C:\\Users\\krajc\\Downloads\\500x500.jpg");
		
//		new Actions(driver).moveToElement(driver.findElement(By.id("photobutton"))).click().perform();
		driver.findElement(By.id("photobutton")).click();
		
	}

}
