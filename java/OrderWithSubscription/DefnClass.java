package OrderWithSubscription;

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


public class DefnClass {
	public WebDriver driver;
	public WebDriver wait;
	JavascriptExecutor js;

	@Given("^Launching ReliefFactor URL$")
	public WebDriver launching_ReliefFactor_URL() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Velammal\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://m2stage.relieffactor.com/");
		driver.manage().window().maximize();
		return driver;
		
	}

	@Given("^Click Order button$")
	public void click_Order_button() throws InterruptedException {

		WebElement scrollview = driver.findElement(By.id("get-started-today"));
		js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView();", scrollview);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		WebElement orderBtn = driver.findElement((By.xpath("(//button[text()='Order Now'])[2]")));
		if(orderBtn.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", orderBtn);

		}
		System.out.println("Order Button Clicked");
	}

	@Given("^Click Vitamin C button$")
	public void click_Vitamin_C_button(){

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		WebElement radioBtn = driver.findElement(By.xpath("//span[text()=' Vitamin C ']"));
		if(radioBtn.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", radioBtn);

		}
		System.out.println("Navigated to the Offer page and Clicked Vitamin C");
	}

	@Given("^Clicking Contine button$")
	public void clicking_Contine_button() {

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		WebElement contButton = driver.findElement(By.xpath("//span[text()='Continue']"));
		if(contButton.isDisplayed()) {
			((JavascriptExecutor)driver).executeScript("arguments[0].click();", contButton);

		}
		System.out.println("Clicked Continued Button");
	}

	@When("^Entering \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
	public void entering_and(String FirstName, String LastName, String Email, String Phone) throws Throwable {

		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("continue-shop")))) ;
		Thread.sleep(10000);

		driver.findElement(By.id("fname")).sendKeys(FirstName);

		driver.findElement(By.id("lname")).sendKeys(LastName);

		driver.findElement(By.id("customer-email")).sendKeys(Email);

		driver.findElement(By.id("phone-info")).sendKeys(Phone);

	}

	@When("^Clicking Contine to Shopping button$")
	public void clicking_Contine_to_Shopping_button()  {
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
	public void clicking_Contine_to_Payment_button()  {
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
	public void entering(String CardNumber, String ExpiryMonth, String ExpiryYear, String CVV) {
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
	public void click_CheckBox()  {
		//WebElement checkBox = driver.findElement(By.xpath("//div[text()='I agree to the terms above']"));
		WebElement checkBox = driver.findElement(By.id("terms_and_conditions"));
		boolean enabled = checkBox.isEnabled();
		//boolean selected = checkBox.isSelected();
		System.out.println("enabled"+enabled);
		//System.out.println("selected"+selected);

		//if(selected==false) {

		((JavascriptExecutor)driver).executeScript("arguments[0].click();", checkBox);
		//checkBox.click();
		//}

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
