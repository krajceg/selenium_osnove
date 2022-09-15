package d15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
	
//	2.Zadatak
//	Napisati program koji ucitava stranicu https://geodata.solutions/
//	Bira Country, State i City po vasoj zelji
//	Pritom potrebno je izvrsiti cekanje da se povaje State-ovi nakon izbora Country-a
//	I takodje je potrebno izvrsiti cekanje da se ucitaju gradovi nakon izbora State-a
//	Izabrerit Country, State i City tako da imate podatke da selektujete!

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("");
		

	}

}
