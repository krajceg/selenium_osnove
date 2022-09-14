package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://s.bootsnipp.com/iframe/oV91g");
		
		List<WebElement> links = driver.findElements(By.xpath("//a[contains(@class, 'page_link')]"));
		
		for (int i = 0; i < links.size(); i++) {
			links.get(i).click();
			Thread.sleep(1000);
		}
		
		driver.quit();
	}

}
