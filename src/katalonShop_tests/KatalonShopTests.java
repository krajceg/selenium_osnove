package katalonShop_tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import katalonShop_pages.CartPage;
import katalonShop_pages.MyAccountPage;
import katalonShop_pages.NavPage;
import katalonShop_pages.ProductPage;

public class KatalonShopTests {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://cms.demo.katalon.com";
	private NavPage navPage;
	private ProductPage productPage;
	private CartPage cartPage;
	private SoftAssert softAssert;
	private MyAccountPage myAccountPage;

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		navPage = new NavPage(driver, wait);
		productPage = new ProductPage(driver, wait);
		cartPage = new CartPage(driver, wait);
		softAssert = new SoftAssert();
		myAccountPage = new MyAccountPage(driver, wait);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	
	@Test(priority = 10)
	public void addingProductWithQuantityToTheCart() {
		driver.get(baseUrl + "/product/flying-ninja/");
		
		productPage.getQuantityInput().clear();
		productPage.getQuantityInput().sendKeys("3");
		productPage.getAddToCartButton().click();
		
		softAssert.assertTrue(productPage.getAlertMessage().getText().contains("Flying Ninja"), "Alert Message should contain Flying Ninja");
		
		navPage.getCartLink().click();
		
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/cart/");
		Assert.assertEquals(cartPage.getAllTableRows().size(), 1, "The number of rows should be 1");	
	}
	
	@Test(priority = 20)
	public void removingProductFromCart() {
		navPage.getCartLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/cart/");
		Assert.assertEquals(cartPage.getAllTableRows().size(), 1, "The number of rows should be 1");
		cartPage.getRemoveButton(0).click();
		Assert.assertTrue(cartPage.getEmptyCartAlertMessage().getText().contains("Your cart is currently empty")
				, "Cart should be empty");
	}
	
	@Test(priority = 30)
	public void verifyErrorIsDisplayedWhenUsernameIsMissing () {
		navPage.getMyAccountLink().click();
		myAccountPage.getLogInButton().click();
		Assert.assertTrue(myAccountPage.getUsernameIsMissingMessage().getText().contains("Error: Username is required.")
				, "Alert message should be Error: Username is required.");
	}
	
	@Test(priority = 40)
	public void verifyErrorIsDisplayedWhenPasswordIsMissing() {
		navPage.getMyAccountLink().click();
		myAccountPage.getUsernameInput().sendKeys("customer");
		myAccountPage.getLogInButton().click();
		Assert.assertTrue(myAccountPage.getPasswordIsMissingMessage().getText().contains("ERROR: The password field is empty.")
				, "Alert message should be ERROR: The password field is empty.");
	}
	
	@Test(priority = 50)
	public void verifyErrorIsDisplayedWhenPasswordIsWrong() {
		navPage.getMyAccountLink().click();
		myAccountPage.getUsernameInput().sendKeys("customer");
		myAccountPage.getPasswordInput().sendKeys("invalidpassword");
		myAccountPage.getLogInButton().click();
		
		Assert.assertTrue(myAccountPage.getPasswordIsWrongMessage().getText().contains("ERROR: The password you entered for the username "
				+ "customer is incorrect. Lost your password?"), "Alert message should be ERROR: The password you entered for the username "
						+ "customer is incorrect. Lost your password?");
	}
	
	@Test(priority = 60)
	public void verifyErrorIsDisplayedWhenUserDoesNotExist() {
		navPage.getMyAccountLink().click();
		myAccountPage.getUsernameInput().sendKeys("invaliduser");
		myAccountPage.getPasswordInput().sendKeys("pass1234");
		myAccountPage.getLogInButton().click();
		
		Assert.assertTrue(myAccountPage.getUserDoesNotExistMessage().getText().equals("ERROR: Invalid username. Lost your password?")
				, "Alert message should be ERROR: Invalid username. Lost your password?");
	}
	
	@Test(priority = 70)
	public void verifySuccessfulLogin() {
		navPage.getMyAccountLink().click();
		myAccountPage.getUsernameInput().sendKeys("customer");
		myAccountPage.getPasswordInput().sendKeys("crz7mrb.KNG3yxv1fbn");
		myAccountPage.getLogInButton().click();
		
		Assert.assertTrue(myAccountPage.getMyAccountHelloMessage().getText().contains("Hello Katalon Parlitul_Changed")
				, "Hello message should contain Hello Katalon Parlitul_Changed");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
