package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6_4 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://s.bootsnipp.com/iframe/z80en");

		int brojRed = driver.findElements(By.xpath("//div[@id='lorem']//tbody/tr")).size();
		int brojPoljaRed = driver.findElements(By.xpath("//div[@id='lorem']//tbody/tr[1]/td")).size();
		
		for (int i = 1; i <= brojRed; i++) {
			for (int j = 1; j <= brojPoljaRed; j++) {
				System.out.print(driver.findElement(By.xpath("//div[@id='lorem']//tbody/tr["+ i + "]/td[" + j + "]")).getText() + " ");
			}
			System.out.println();
		}
		driver.quit();

	}

}
