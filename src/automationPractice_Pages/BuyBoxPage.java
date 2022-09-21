package automationPractice_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyBoxPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public BuyBoxPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getQuantityInput() {
		return this.driver.findElement(By.id("quantity_wanted"));
	}
	
	public WebElement getSizeSelect() {
		return this.driver.findElement(By.id("group_1"));
	}
	
	public WebElement getAddToCartButton() {
		return this.driver.findElement(By.xpath("//button[@name='Submit']"));
	}
	
	public WebElement getWishlistButton() {
		return this.driver.findElement(By.id("wishlist_button"));
	}
	
	public String getColorSelectedName() {
		return this.driver.findElement(By.xpath("//ul[@id='color_to_pick_list']/li[@class = 'selected']/a")).getAttribute("name");
	}
	
	public WebElement getLinkBasedOnColor(String color) {
		return this.driver.findElement(By.xpath("//ul[@id='color_to_pick_list']//a[@title='" + color +"']"));
	}
	
	public void getScrollToTableElement() {	//scrollTo is not working properly
		new Actions(this.driver).moveToElement(driver.findElement(By.xpath("//table[@class='table-data-sheet']"))).perform();
	}
	
	public WebElement getPriceForOnePieceElement() {
		return this.driver.findElement(By.id("our_price_display"));
	}
}
