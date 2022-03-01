package SingleOrder;

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

public class SingleStepDefn {

	public WebDriver driver;
	public WebDriver wait;
	JavascriptExecutor js;

	@Given("^Launching ReliefFactor URL$")
	public WebDriver launching_ReliefFactor_URL() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Velammal\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://m2stage.relieffactor.com/");
		driver.manage().window().maximize();
		return driver;
	}

	@Given("^Click Order button$")
	public void click_Order_button() throws Throwable {
		WebElement scrollview = driver.findElement(By.id("get-started-today"));
		js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();", scrollview);

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement orderBtn = driver.findElement((By.xpath("(//button[text()='Order Now'])[3]")));
		if(orderBtn.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", orderBtn);

		}
		System.out.println("Order Button Clicked");
	}

	@When("^Entering \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void entering_and(String FirstName, String LastName, String Email, String Phone) throws Throwable {

		Thread.sleep(10000);
		driver.findElement(By.id("fname")).sendKeys(FirstName);
		driver.findElement(By.id("lname")).sendKeys(LastName);
		driver.findElement(By.id("customer-email")).sendKeys(Email);
		driver.findElement(By.id("phone-info")).sendKeys(Phone);
		
	}

	@When("^Clicking Contine to Shopping button$")
	public void clicking_Contine_to_Shopping_button() throws Throwable {
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

		System.out.println("Customer Details filled");
	}

	@When("^Clicking Contine to Payment button$")
	public void clicking_Contine_to_Payment_button() throws Throwable {
		//WebElement scrollBillAdd = driver.findElement(By.xpath("(//label[contains(text(),'Zip/Postal Code')])[1]"));
		//js.executeScript("arguments[0].scrollIntoView();", scrollBillAdd);
		WebElement contPayment = driver.findElement(By.id("continue-pay"));
		Actions a = new Actions(driver);
		a.moveByOffset(200, 150).click().perform();
		//a.moveToElement(contPayment).click().perform();

		if(contPayment.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", contPayment);
		}
		System.out.println("Continue to Payment");
	}

	@When("^Entering \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void entering(String CardNumber, String ExpiryMonth, String ExpiryYear, String CVV) throws Throwable {
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

	@Then("^Click Complete Order button$")
	public void click_Complete_Order_button() throws Throwable {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement completeOrderBtn = driver.findElement(By.id("completeOrder"));
		Thread.sleep(4000);
		js.executeScript("arguments[0].scrollIntoView();", completeOrderBtn);
	//	if(completeOrderBtn.isDisplayed()) {
	//		((JavascriptExecutor)driver).executeScript("arguments[0].click();", completeOrderBtn);

	//	}
		completeOrderBtn.click();
		Thread.sleep(10000);
		System.out.println("Order Placed");

		driver.close();
	}

}
