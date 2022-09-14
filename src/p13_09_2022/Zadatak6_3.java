package p13_09_2022;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6_3 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://s.bootsnipp.com/iframe/z80en");

		List<WebElement> lista = driver.findElements(By.xpath("//div[@id='lorem']//tbody/tr"));

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getText());
		}
		driver.quit();

	}

}
