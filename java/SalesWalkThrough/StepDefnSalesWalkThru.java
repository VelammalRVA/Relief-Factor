package SalesWalkThrough;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefnSalesWalkThru {

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

	@Given("^click Sales button$")
	public void click_Sales_button() throws Throwable {
		WebElement salesBtn = driver.findElement(By.xpath("//body/div[@class='menu-wrapper _fixed']/nav[@class='admin__menu']/ul[@id='nav']/li[@id='menu-magento-sales-sales']/a[1]"));
		salesBtn.click();
	}

	@Given("^click Saleswalkthrough button$")
	public void click_Saleswalkthrough_button() throws Throwable {
		Thread.sleep(5000);
		WebElement salesWalkThru = driver.findElement(By.xpath("//span[normalize-space()='Sales walkthrough']"));
		if(salesWalkThru.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", salesWalkThru);

		}
	}

	@Given("^click ReliefFactor button$")
	public void click_ReliefFactor_button() throws Throwable {
		Thread.sleep(5000);
		WebElement reliefFactorBtn = driver.findElement(By.id("ReliefFactorQuickStart"));
		reliefFactorBtn.click();
	}

	@When("^Entering \"([^\"]*)\",\"([^\"]*)\"$")
	public void entering(String FirstName, String LastName) throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(By.id("firstname_12343rewrf")).sendKeys(FirstName);		
		driver.findElement(By.id("lastname_12343rewrf")).sendKeys(LastName);

	}

	@When("^click Save and Continue button$")
	public void click_Save_and_Continue_button() throws Throwable {
		WebElement saveandcontBtn = driver.findElement(By.id("customName"));
		saveandcontBtn.click();
	}

	@When("^Click First-time customer button$")
	public void click_First_time_customer_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement firstTimeCustomer = driver.findElement(By.id("first-time"));
		firstTimeCustomer.click();
	}

	@When("^click Week Quickstart$")
	public void click_Week_Quickstart() throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement weekQuickStart = driver.findElement(By.id("relifProducts"));
		weekQuickStart.click();
	}

	@When("^clicking Two Save and Continue button$")
	public void clicking_Two_Save_and_Continue_button() throws Throwable {
		Thread.sleep(5000);
		WebElement saveandcont1 = driver.findElement(By.id("offer-submit"));
		saveandcont1.click();
		Thread.sleep(2000);
		WebElement saveandcont2  = driver.findElement(By.xpath("(//button[@id='product-details-submits'])[2]"));
		saveandcont2.click();
	}

	@When("^click Checkbox button$")
	public void click_Checkbox_button() throws Throwable {
		Thread.sleep(5000);
		WebElement checkBox = driver.findElement(By.id("csremailverify"));
		checkBox.click();
	}

	@When("^clicking Double Save and Continue button$")
	public void clicking_Double_Save_and_Continue_button() throws Throwable {
		Thread.sleep(5000);
		WebElement saveandcont3 = driver.findElement(By.id("email-submit"));
		saveandcont3.click();
		Thread.sleep(2000);
		WebElement saveandcont4 = driver.findElement(By.id("email-submit"));
		saveandcont4.click();
	}

	@When("^Enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void enter(String StreetAddress, String City, String Country, String State, String PostalCode, String Telephone) throws Throwable {
		Thread.sleep(5000);

		driver.findElement(By.id("autocomplete")).sendKeys(StreetAddress);
		driver.findElement(By.id("locality")).sendKeys(City);
		driver.findElement(By.id("country")).sendKeys(Country);
		driver.findElement(By.id("administrative_area_level_1")).sendKeys(State);
		driver.findElement(By.id("postal_code")).sendKeys(PostalCode);		
		driver.findElement(By.id("telephone")).sendKeys(Telephone);

	}

	@When("^Click Three checkBox button$")
	public void click_Three_checkBox_button() throws Throwable {
		Thread.sleep(10000);
		WebElement checkBox1 = driver.findElement(By.id("addressSelected"));
		WebElement checkBox2 = driver.findElement(By.id("upsselected"));
		WebElement checkBox3 = driver.findElement(By.id("isBoxSelected"));

		checkBox1.click();
		checkBox2.click();
		checkBox3.click();
	}

	@When("^clicking Save & Continue button$")
	public void clicking_Save_Continue_button() throws Throwable {
		WebElement saveandcont5 = driver.findElement(By.id("shipping-submit"));
		saveandcont5.click();
	}

	@When("^Click CheckBox for Billing Address button$")
	public void click_CheckBox_for_Billing_Address_button() throws Throwable {
		Thread.sleep(5000);
		WebElement checkBox4 = driver.findElement(By.id("copy_address"));
		checkBox4.click();
	}

	@When("^clicking Save and Continue button$")
	public void clicking_Save_and_Continue_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement saveandcontBtn6 = driver.findElement(By.id("billing-submit"));
		saveandcontBtn6.click();
	}

	@When("^Entering \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void entering_and(String CardNumber, String ExpiryMonth, String ExpiryYear, String CVV) throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		driver.findElement(By.id("owner_number")).sendKeys(CardNumber);
		driver.findElement(By.id("payment-exp-month")).sendKeys(ExpiryMonth);		
		driver.findElement(By.id("payment-year")).sendKeys(ExpiryYear);
		driver.findElement(By.id("ccv-number")).sendKeys(CVV);

		Thread.sleep(5000);
		WebElement saveandcont7 = driver.findElement(By.id("payment-submit"));
		if(saveandcont7.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", saveandcont7);
		}
	}

	@When("^Click Save and Process button$")
	public void click_Save_and_Process_button() throws Throwable {
		Thread.sleep(10000);
		WebElement saveandprocessBtn = driver.findElement(By.id("submit_order_top_button"));
		if(saveandprocessBtn.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", saveandprocessBtn);
		}
	}

	@Then("^Click OrderNo button$")
	public void click_OrderNo_button() throws Throwable {
		Thread.sleep(10000);
		WebElement orderNoLink = driver.findElement(By.xpath("//*[@id=\"messages\"]/div/div/div/a[1]"));
		orderNoLink.click();

		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows); 

		Thread.sleep(1000);
		driver.quit();

	}
}
