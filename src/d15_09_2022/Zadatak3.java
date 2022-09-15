package d15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak3 {
	
//	3.Zadatak (Za vezbanje)
//	Napisati program koji 
//	Ucitava https://seeds.sproutsocial.com/components/loader-button/
//	Odskrola do Loader buttons are used to display a loading indicator inside of a button. paragrafa. Koristan link
//	Klikce ne dugme 
//	Ceka da dugme zavrsi sa loadingom 
//	Ispisati poruku na ekranu
//	Zatvoriti pretrazivac
//	HINT: Koristite data-qa-button-isloading  atribut elementa za cekanje odredjenog stanja tog elementa

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://seeds.sproutsocial.com/components/loader-button/");
		Thread.sleep(5000);
		
		String a = driver.findElement(By.xpath("//div[contains(@class, 'CodeSandbox')]//button[contains(@class, 'styles__Container')]")).getAttribute("data-qa-button-isloading");
		
		System.out.println(a);
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[contains(@class, 'CodeSandbox')]//button[contains(@class, 'styles__Container')]"))).click().perform();;
		a = driver.findElement(By.xpath("//div[contains(@class, 'CodeSandbox')]//button[contains(@class, 'styles__Container')]")).getAttribute("data-qa-button-isloading");
		System.out.println(a);
		
		driver.quit();
		
	}

}
