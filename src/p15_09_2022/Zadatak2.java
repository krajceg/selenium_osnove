package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
		Thread.sleep(1000);
		
		Select drpSelectMenu = new Select (driver.findElement(By.xpath("//select[@id='gh-cat']")));
		drpSelectMenu.selectByValue("14339");
		Thread.sleep(2000);
		
		driver.quit();
	}

}
