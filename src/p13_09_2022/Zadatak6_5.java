package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6_5 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://s.bootsnipp.com/iframe/z80en");

		List<WebElement> redovi = driver.findElement(By.xpath("//div[@id='lorem']//tbody")).findElements(By.tagName("tr"));
		
		for (int i = 0; i < redovi.size(); i++) {
			List<WebElement> celije = redovi.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < celije.size(); j++) {
				System.out.print(celije.get(j).getText() + " ");
			}
			System.out.println();
		}
		
		driver.quit();

	}

}
