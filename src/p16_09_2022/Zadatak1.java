package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://docs.katalon.com/");
		
		if (driver.findElement(By.tagName("html")).getAttribute("data-theme").equals("light")) {
			System.out.println("Sve ok");
		} else {
			System.out.println("Razmisli");
		}
		driver.findElement(By.xpath("//button[contains(@title, 'Switch between dark and light mode')]")).click();
		
		if (driver.findElement(By.tagName("html")).getAttribute("data-theme").equals("dark")) {
			System.out.println("Sve ok");
		} else {
			System.out.println("Razmisli dobro");
		}
		
		new Actions(driver).keyDown(Keys.CONTROL).sendKeys("k").perform();
		
		System.out.println(driver.findElement(By.xpath("//input[@id='docsearch-input']")).getAttribute("type"));
		
		driver.quit();

	}

}
