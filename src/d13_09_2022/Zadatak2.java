package d13_09_2022;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner s = new Scanner(System.in);
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://s.bootsnipp.com/iframe/WaXlr");
		Thread.sleep(2000);
		
		List<WebElement> lista = driver.findElements(By.xpath("//*[contains(@id, 'rating-star')]"));
		System.out.println(lista.size());
		
		System.out.print("Broj rejtinga: ");
		int r = s.nextInt();
		
		lista.get(r-1).click();
		
		driver.quit();
				
	}

}
