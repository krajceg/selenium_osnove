package p13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UvodSelenium {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/ncr");
//		
//		WebElement searchInput = driver.findElement(By.xpath("//*[@name='q']"));
//		
//		searchInput.sendKeys("IT Bootcamp");
		
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IT Bootcamp");
		
//		Thread.sleep(5000);		// 1s = 1000ms
		
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
		
//		searchInput.sendKeys(Keys.ENTER);
//		Thread.sleep(2000);		// 1s = 1000ms
//		searchInput.clear();
//		searchInput.sendKeys("1000");
		
		WebElement firstResult = driver.findElement(By.xpath("//div[contains(@id, 'search')]//link"));
		firstResult.click();
		
//		Thread.sleep(2000);		// 1s = 1000ms
//		driver.close();
//		driver.quit();
		
	}

}
