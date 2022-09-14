package p13_09_2022;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		ArrayList<String> nizStranica = new ArrayList<String>();
		nizStranica.add("https://google.com/");
		nizStranica.add("https://youtube.com/");
		nizStranica.add("https://www.ebay.com/");
		nizStranica.add("https://www.kupujemprodajem.com/");
		
		for (int i = 0; i < nizStranica.size(); i++) {
			driver.get(nizStranica.get(i));
			System.out.println("Page title is : " + driver.getTitle());
		}
//		driver.quit();
		
		

	}

}
