package Energy;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EnergyDefn {

	public WebDriver driver;
	public WebDriver wait;
	JavascriptExecutor js;
	Actions action;

	@Given("^Launching ReliefFactor URL$")
	public WebDriver launching_ReliefFactor_URL() throws Throwable {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Velammal\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://m2stage.relieffactor.com/");
		driver.manage().window().maximize();
		return driver;

	}

	@Given("^Click Products$")
	public void click_Products() throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement mouseOverProduct = driver.findElement(By.xpath("//span[normalize-space()='Products']"));	
		mouseOverProduct.click();
	}

	@Given("^Click Energy$")
	public void click_Energy() throws Throwable {

		WebElement energyClick = driver.findElement(By.xpath("//a[normalize-space()='Energy']"));
		if(energyClick.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", energyClick);
		}
	}

	@Given("^Click Order Now button$")
	public void click_Order_Now_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement orderNowBtn = driver.findElement(By.xpath("//a[@id='cost']//span[contains(text(),'Order Now')]"));
		orderNowBtn.click();
	}

	@Given("^Click (\\d+) Bottle Option button$")
	public void click_Bottle_Option_button(int arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement bottleOptionBtn = driver.findElement(By.xpath("(//span[text()='Options'])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", bottleOptionBtn);
		Thread.sleep(10000);
		if(bottleOptionBtn.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", bottleOptionBtn);
		}
		
		bottleOptionBtn.click();

	}

	@Given("^Click (\\d+) Bottle Radio button$")
	public void click_Bottle_Radio_button(int arg1) throws Throwable {
		Thread.sleep(2000);
		WebElement bottleRadioBtn = driver.findElement(By.xpath("//div[@id='js-option1']//div[@class='right-side']//input[@name='issub']"));
		js.executeScript("arguments[0].scrollIntoView();", bottleRadioBtn);
		if(bottleRadioBtn.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", bottleRadioBtn);
		}
	}

	@Then("^Click Order Now button again$")
	public void click_Order_Now_button_again() throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement orderBtnClick2 = driver.findElement(By.xpath("//div[@id='js-option1']//span[contains(text(),'Order Now')]"));
		if(orderBtnClick2.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", orderBtnClick2);
		}
	}

	@When("^Entering \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void entering(String FirstName, String LastName, String Email, String PhoneNumber) throws Throwable {
		Thread.sleep(10000);

		driver.findElement(By.id("fname")).sendKeys(FirstName);
		driver.findElement(By.id("lname")).sendKeys(LastName);
		driver.findElement(By.id("customer-email")).sendKeys(Email);
		driver.findElement(By.id("phone-info")).sendKeys(PhoneNumber);
	}

	@When("^Clicking Contine to shipping button$")
	public void clicking_Contine_to_shipping_button() throws Throwable {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		WebElement contShopping = driver.findElement(By.id("continue-shop"));
		if(contShopping.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", contShopping);
		}
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@When("^Entering \"([^\"]*)\"$")
	public void entering(String StreetAddress) throws Throwable {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Robot robot = new Robot();
		driver.findElement(By.id("shippingstreet")).sendKeys(StreetAddress);
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@When("^Clicking Contine to Payment button$")
	public void clicking_Contine_to_Payment_button() throws Throwable {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement contPayment = driver.findElement(By.id("continue-pay"));
		Actions a = new Actions(driver);
		a.moveByOffset(200, 150).click().perform();
		//a.moveToElement(contPayment).click().perform();

		if(contPayment.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", contPayment);
		}
	}

	@When("^Entering \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void entering_and(String CardNumber, String ExpiryMonth, String ExpiryYear, String CVV) throws Throwable {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.id("vd_elavon_cc_number")).sendKeys(CardNumber);
		driver.findElement(By.id("vd_elavon_expiration")).sendKeys(ExpiryMonth);
		driver.findElement(By.id("vd_elavon_expiration_yr")).sendKeys(ExpiryYear);
		driver.findElement(By.id("vd_elavon_cc_cid")).sendKeys(CVV);
	}

	@When("^Click Review your order button$")
	public void click_Review_your_order_button() throws Throwable {

		WebElement reviewOrder = driver.findElement(By.id("review"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		js.executeScript("arguments[0].scrollIntoView();", reviewOrder);

		if(reviewOrder.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", reviewOrder);
		}
	}

	@When("^Click CheckBox$")
	public void click_CheckBox() throws Throwable {

		WebElement checkBox = driver.findElement(By.id("terms_and_conditions"));
		boolean enabled = checkBox.isEnabled();
		System.out.println("enabled"+enabled);
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", checkBox);
	}

	@Then("^Click Complete Order button$")
	public void click_Complete_Order_button() throws Throwable {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement completeOrderBtn = driver.findElement(By.id("completeOrder"));
		Thread.sleep(4000);
		js.executeScript("arguments[0].scrollIntoView();", completeOrderBtn);
		if(completeOrderBtn.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", completeOrderBtn);

		}
		Thread.sleep(10000);
		System.out.println("Order Placed");

		driver.close();
	}

}
