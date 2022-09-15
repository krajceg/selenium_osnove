package p15_09_2022;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://cms.demo.katalon.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		WebElement menu = driver.findElement(By.xpath("//nav[@id='site-navigation']/button"));
		
		if(menu.isDisplayed() == true) {
			System.out.println("Menu je vidljiv");
		}
		else {
			System.out.println("Menu nije vidljiv");
		}
		
		Dimension d = new Dimension(700, 700);
		driver.manage().window().setSize(d);
		
		if(menu.isDisplayed() == true) {
			System.out.println("Menu je vidljiv");
		}
		else {
			System.out.println("Menu nije vidljiv");
		}
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
