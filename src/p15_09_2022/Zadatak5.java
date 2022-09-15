package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/login");
		
		driver.findElement(By.id("userName")).sendKeys("itbootcamp");
		driver.findElement(By.id("password")).sendKeys("ITBootcamp2021!");
		Thread.sleep(5000);
		driver.findElement(By.id("login")).click();
		
		boolean elementPostoji = true;
		try {
			driver.findElement(By.id("submit"));
		} catch(NoSuchElementException error) {
			elementPostoji = false;
		}
		
		if (elementPostoji) {
			System.out.println("Korisnik se ulogovao");
		} else {
			System.out.println("Korisnik se nije ulogovao");
		}
		
		driver.findElement(By.id("submit")).click();
		
		driver.quit();
	}

}
