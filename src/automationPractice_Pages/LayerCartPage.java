package automationPractice_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LayerCartPage {

	private WebDriver driver;
	private WebDriverWait wait;

	public LayerCartPage(WebDriver driver, WebDriverWait wait) {
		super();
		this.driver = driver;
		this.wait = wait;
	}

	public WebElement getContinueShoppingButton() {
		return this.driver.findElement(By.xpath("//span[@title='Continue shopping']"));
	}

	public WebElement getCheckoutButton() {
		return this.driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
	}

	public WebElement getProductAttributesElement() {
		return this.driver.findElement(By.id("layer_cart_product_attributes"));
	}

	public WebElement getQuantityElement() {
		return this.driver.findElement(By.id("layer_cart_product_quantity"));
	}

	public WebElement getTotalPriceElement() {
		return this.driver.findElement(By.id("layer_cart_product_price"));
	}

	public void waitForCartDialogBoxVisibility() {
		this.wait.until(ExpectedConditions.visibilityOf(getContinueShoppingButton()));
	}

	public void waitForCartDialogBoxInvisibility() {
		this.wait.until(ExpectedConditions.invisibilityOf(getContinueShoppingButton()));
	}
}
