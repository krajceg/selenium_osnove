package d13_09_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner s = new Scanner(System.in);
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
		Thread.sleep(2000);
		
		ArrayList<String> nizName = new ArrayList<String>();
		ArrayList<String> nizDep = new ArrayList<String>();
		ArrayList<String> nizMob = new ArrayList<String>();
		
		nizName.add("Pera Peric");
		nizDep.add("Administracija");
		nizMob.add("111 111");
		
		nizName.add("Mika Mikic");
		nizDep.add("HR");
		nizMob.add("222 222");
		
		nizName.add("Marko Maric");
		nizDep.add("Customer Support");
		nizMob.add("333 333");
		
		nizName.add("Zika Zikic");
		nizDep.add("Tehnicka sluzba");
		nizMob.add("444 444");
		
		nizName.add("Svetolik Kljajic");
		nizDep.add("CEO");
		nizMob.add("555 555");
		
		for (int i = 0; i < nizName.size(); i++) {
			driver.findElement(By.xpath("//button[normalize-space()='Add New']")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys(nizName.get(i));
			driver.findElement(By.xpath("//input[@name='department']")).sendKeys(nizDep.get(i));
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(nizMob.get(i));
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]/a")).click();
			Thread.sleep(500);
		}
		
		driver.quit();
				
	}

}
