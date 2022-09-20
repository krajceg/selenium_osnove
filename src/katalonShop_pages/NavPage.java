package katalonShop_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public NavPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getCartLink() {
		return this.driver.findElement(By.xpath("//ul[@class=' nav-menu']/li[1]"));
	}
	
	public WebElement getCheckoutLink() {
		return this.driver.findElement(By.xpath("//ul[@class=' nav-menu']/li[2]"));
	}
	
	public WebElement getMyAccountLink() {
		return this.driver.findElement(By.xpath("//ul[@class=' nav-menu']/li[3]"));
	}
	
	public WebElement getSamplePageLink() {
		return this.driver.findElement(By.xpath("//ul[@class=' nav-menu']/li[4]"));
	}
	
	public WebElement getShopLink() {
		return this.driver.findElement(By.xpath("//ul[@class=' nav-menu']/li[5]"));
	}
	
}
