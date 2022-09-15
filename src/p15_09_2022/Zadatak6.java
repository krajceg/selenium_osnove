package p15_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demoqa.com/modal-dialogs");
		
		driver.findElement(By.id("showLargeModal")).click();
		
		boolean elementPostoji = true;
		try {
			driver.findElement(By.id("example-modal-sizes-title-lg"));
		} catch(NoSuchElementException error) {
			elementPostoji = false;
		}
		
		if (elementPostoji) {
			System.out.println("Dijalog postoji");
		} else {
			System.out.println("Dijalog ne postoji");
		}

		driver.quit();
	}

}
