package p15_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://cms.demo.katalon.com/my-account/");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='rememberme']")).click();
		
		Thread.sleep(1000);
		
		boolean isChecked = driver.findElement(By.xpath("//input[@id='rememberme']")).getAttribute("checked").equals("true");
		System.out.println("Is checked: " + isChecked);
		driver.quit();
	}

}
