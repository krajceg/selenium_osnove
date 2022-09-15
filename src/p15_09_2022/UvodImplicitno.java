package p15_09_2022;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UvodImplicitno {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://cms.demo.katalon.com/my-account/");
		driver.findElement(By.id("username")).sendKeys("Admin");
		
		boolean elementPostoji = true;
		try {
			driver.findElement(By.id("asd"));
		} catch(NoSuchElementException error) {
			elementPostoji = false;
		}
		
		if (elementPostoji) {
			System.out.println("Element postoji");
		} else {
			System.out.println("Element ne postoji");
		}
		
		driver.quit();
	}

}
