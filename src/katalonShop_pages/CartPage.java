package katalonShop_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CartPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement getRemoveButton(int row) {
		return this.driver.findElements(By.className("remove")).get(row);
	}
	
	public WebElement getForCouponInput() {
		return this.driver.findElement(By.id("coupon_code"));
	}
	
	public WebElement getForCouponButton() {
		return this.driver.findElement(By.name("apply_coupon"));
	}
	
	public WebElement getUpdateCartButton() {
		return this.driver.findElement(By.name("update_cart"));
	}
	
	public List<WebElement> getAllTableRows() {
		return this.driver.findElements(By.xpath("//tr[(@class='woocommerce-cart-form__cart-item cart_item')]"));
	}
	
	public WebElement getEmptyCartAlertMessage() {
		return this.driver.findElement(By.xpath("//p[@class='cart-empty woocommerce-info']"));
	}
}
