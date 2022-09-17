 package s16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.bu.edu/tech/services/cccs/websites/www/wordpress/how-to/sortable-searchable-tables/");
		new Actions(driver).scrollByAmount(0, 1000).perform();
		
		WebElement tabelaElement = driver.findElement(By.xpath("//table"));
		
		HtmlTable tabela = new HtmlTable(tabelaElement, driver);
		
//		System.out.println(tabela.getCellText(1, 0));
//		
//		for (int i = 0; i < tabela.getColumnsByName("Country").size(); i++) {
//			System.out.println(tabela.getColumnsByName("Country").get(i).getText());
//		}
		Thread.sleep(2000);
		tabela.sortDescending("Athlete");
		Thread.sleep(2000);
		tabela.sortAscending("Athlete");
		
		

	}

}
