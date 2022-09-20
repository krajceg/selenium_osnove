package katalonShop_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ProductPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getQuantityInput() {
		return this.driver.findElement(By.xpath("//input[@type = 'number']"));
	}
	
	public WebElement getAddToCartButton() {
		return this.driver.findElement(By.xpath("//button[@name='add-to-cart']"));
	}
	
	public WebElement getAlertMessage() {
		return this.driver.findElement(By.xpath("//div[@role='alert']/a"));
	}
	
	
}
