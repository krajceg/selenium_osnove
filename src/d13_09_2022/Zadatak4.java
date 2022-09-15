package d13_09_2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
	
	public static List<Character> convertStringToCharList(String formula) {
		List<Character> chars = new ArrayList<>();
		
		for (char ch : formula.toCharArray()) {
			if (ch == '-') {
				ch = '−';
			}
			else if (ch == '*') {
				ch = '×';
			}
			else if (ch == '/') {
				ch = '÷';
			}
			if (ch != ' ') {
				chars.add(ch);
			}
		}
		return chars;
	}

	public static void main(String[] args) throws InterruptedException {
		
		Scanner s = new Scanner(System.in);
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.calculatorsoup.com/calculators/math/basic.php");
		Thread.sleep(2000);
		
		System.out.println("Unesite formulu:");
		String formula = s.nextLine();
		
		List<Character> formulaChar = convertStringToCharList(formula);
		
		for (int i = 0; i < formulaChar.size(); i++) {
			driver.findElement(By.xpath("//form[@id='calculator']//input[@value='" + formulaChar.get(i) + "']")).click();
			Thread.sleep(500);
		}
		Thread.sleep(500);
		driver.findElement(By.xpath("//form[@id='calculator']//input[@name='calculate']")).click();
		Thread.sleep(5000);
		driver.quit();
				
	}

}
