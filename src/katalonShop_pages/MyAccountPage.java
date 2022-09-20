package katalonShop_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public MyAccountPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getLogInButton() {
		return this.driver.findElement(By.xpath("//button[@name='login']"));
	}
	
	public WebElement getUsernameIsMissingMessage() {
		return this.driver.findElement(By.xpath("//ul[@role='alert']/li"));
	}
	
	public WebElement getUsernameInput() {
		return this.driver.findElement(By.id("username"));
	}
	
	public WebElement getPasswordInput() {
		return this.driver.findElement(By.id("password"));
	}
	
	public WebElement getPasswordIsMissingMessage() {
		return this.driver.findElement(By.xpath("//ul[@role='alert']/li"));
	}
	
	public WebElement getPasswordIsWrongMessage() {
		return this.driver.findElement(By.xpath("//ul[@role='alert']/li"));
	}
	
	public WebElement getUserDoesNotExistMessage() {
		return this.driver.findElement(By.xpath("//ul[@role='alert']/li"));
	}
	
	public WebElement getMyAccountHelloMessage() {
		return this.driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']"));
	}
}
