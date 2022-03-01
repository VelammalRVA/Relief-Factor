package SalesOrder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class StepDefnSalesOrder {
	public WebDriver driver;
	public WebDriver wait;

	@Given("^Launching ReliefFactor URL$")
	public WebDriver launching_ReliefFactor_URL() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Velammal\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://m2stage.relieffactor.com/admin");
		driver.manage().window().maximize();
		return driver;
	}

	@When("^Entering \"([^\"]*)\",\"([^\"]*)\" and click Login button$")
	public void entering_and_click_Login_button(String UserName, String Password) throws Throwable {
		driver.findElement(By.id("username")).sendKeys(UserName);		
		driver.findElement(By.id("login")).sendKeys(Password);

		WebElement signBtn = driver.findElement(By.xpath("//span[text()='Sign in']"));
		signBtn.click();
	}

	@When("^click Sales button$")
	public void click_Sales_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement salesBtn = driver.findElement(By.xpath("//body/div[@class='menu-wrapper _fixed']/nav[@class='admin__menu']/ul[@id='nav']/li[@id='menu-magento-sales-sales']/a[1]"));
		salesBtn.click();
	}

	@When("^click Orders button$")
	public void click_Orders_button() throws Throwable {
		Thread.sleep(3000);
		WebElement ordersBtn = driver.findElement(By.xpath("//li[@data-ui-id='menu-magento-sales-sales-order']//a"));
		ordersBtn.click();
	}

	@When("^click Create New Order button$")
	public void click_Create_New_Order_button() throws Throwable {
		Thread.sleep(5000);
		WebElement createNewOrder = driver.findElement(By.xpath("//span[normalize-space()='Create New Order']"));
		createNewOrder.click();
	}

	@When("^click Create New Customer button$")
	public void click_Create_New_Customer_button() throws Throwable {
		Thread.sleep(5000);
		WebElement createNewCustomer = driver.findElement(By.xpath("//span[normalize-space()='Create New Customer']"));
		createNewCustomer.click();
	}

	@When("^click Add products and Selected button$")
	public void click_Add_products_and_Selected_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement addProducts = driver.findElement(By.xpath("//span[normalize-space()='Add Products']"));
		addProducts.click();
		WebElement product1 = driver.findElement(By.id("id_113"));
		product1.click();
		WebElement product2 = driver.findElement(By.id("id_111"));
		product2.click();
		WebElement selectProducts = driver.findElement(By.xpath("//span[normalize-space()='Add Selected Product']"));
		selectProducts.click();

	}

	@When("^Entering \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void entering(String Email, String FirstName, String LastName, String StreetAdress, String Country, String State, String City, String PostalCode, String PhoneNumber, String CreditCardType, String CreditCardNo, String ExpiryMonth, String ExpiryYear, String CVV) throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("order-billing_address_firstname")).sendKeys(FirstName);
		driver.findElement(By.id("order-billing_address_lastname")).sendKeys(LastName);
		driver.findElement(By.id("order-billing_address_street0")).sendKeys(StreetAdress);
		driver.findElement(By.id("order-billing_address_country_id")).sendKeys(Country);
		driver.findElement(By.id("order-billing_address_region_id")).sendKeys(State);
		driver.findElement(By.id("order-billing_address_city")).sendKeys(City);
		driver.findElement(By.id("order-billing_address_postcode")).sendKeys(PostalCode);
		driver.findElement(By.id("order-billing_address_telephone")).sendKeys(PhoneNumber);
		Thread.sleep(5000);
		driver.findElement(By.id("vd_elavon_cc_type")).sendKeys(CreditCardType);
		driver.findElement(By.id("vd_elavon_cc_number")).sendKeys(CreditCardNo);
		driver.findElement(By.id("vd_elavon_expiration")).sendKeys(ExpiryMonth);
		driver.findElement(By.id("vd_elavon_expiration_yr")).sendKeys(ExpiryYear);
		driver.findElement(By.id("vd_elavon_cc_cid")).sendKeys(CVV);
	}

	@When("^click Shipping Method$")
	public void click_Shipping_Method() throws Throwable {
		Thread.sleep(3000);
		WebElement shippingMethods = driver.findElement(By.xpath("//span[normalize-space()='Get shipping methods and rates']"));
		shippingMethods.click();

		WebElement selectMethod = driver.findElement(By.xpath("//label[@for='s_method_freeshipping_freeshipping']"));
		selectMethod.click();
	}

	@When("^Submit button$")
	public void submit_button() throws Throwable {
		Thread.sleep(5000);
		WebElement submitBtn = driver.findElement(By.xpath("(//span[text()='Submit Order'])[2]"));
		submitBtn.click();
		
		Thread.sleep(10000);
		WebElement successMsg = driver.findElement(By.xpath("//div[@data-ui-id='messages-message-success']"));
		System.out.println(successMsg.getText());
		driver.quit();
	}


}
