package Scripts;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ProductPurchasePage;
import Utility.ConfigReader;
import Utility.Locators;
import Utility.Reporting;
import Utility.Screenshots;
import javafx.beans.property.ReadOnlyBooleanProperty;

public class ProductPurchase extends BaseClass
{
	/*
	WebDriver driver;
	Reporting report_obj;
	
	@BeforeTest
	public void product_test()
	{
		report_obj = new Reporting();
		report_obj.report("ProductPurchase", "ProductPurchaseReport");
	}
	
	@BeforeMethod
	public void before()
	{
		ConfigReader config = ConfigReader.func();
		System.setProperty("webdriver.chrome.driver", config.driverLoad());
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get(config.getUrl());
		
		ProductPurchasePage product_purchase1 = new ProductPurchasePage(driver);
		
		product_purchase1.signIn_button();
		
		LoginPage login = new LoginPage(driver);
		login.e();
		login.p();
		login.b();
	}
	*/
	@Test
	public void ProductAvailable()
	{
		Logger logger = Logger.getLogger(ProductPurchase.class);
		PropertyConfigurator.configure("Log4j.properties");
		
		ProductPurchasePage product_purchase1 = new ProductPurchasePage(driver);
		logger.info("entered in product purchasepage");
		product_purchase1.search_chiffon();	
		product_purchase1.search_button();
		
		Actions action = new Actions(driver);
		action.moveToElement(product_purchase1.select_chiffon_product()).perform();
		logger.info("Purchasing chiffon product Success");
		rep.info_test("Purchasing chiffon product Success");
		
		product_purchase1.add_cart();
		logger.info("Added Chiffon Product to cart Success");
		rep.info_test("Added Chiffon Product to cart Success");
		
		product_purchase1.continue_shopping();
		rep.info_test("Continued Shopping");
		logger.info("Continued Shopping");
		
		product_purchase1.search_clear();
		rep.info_test("Clearing old search");
		logger.info("Clearing old search");
		
		product_purchase1.search_blouse();
		rep.info_test("Searching Blouse product");
		logger.info("Searching Blouse product");
		
		product_purchase1.search_button();
		rep.info_test("Search Button Clicked");
		
		action.moveToElement(product_purchase1.select_blouse_product()).perform();
		rep.info_test("Hovering on product is done");
		
		product_purchase1.add_cart();
		rep.info_test("Added Blouse Product to cart successfully");
	
		product_purchase1.proceed_checkout();
		rep.info_test("Proceed to checkout");
		logger.info("Proceed to checkout");
		
		product_purchase1.summary_checkout();
		rep.info_test("Proceed to checkout2");
		
		product_purchase1.summary_checkout();
		rep.info_test("Proceed to checkout3");
		
		//WebElement element51 = driver.findElement(By.xpath("//textarea[@name='message']"));
		//explicit_wait.sendKeysMethod(driver, 10, element51, "Love the products");
		
		//System.out.println("Added Text");

		product_purchase1.agree();
		rep.info_test("Agreed to terms and policies");
		logger.info("Agreed to terms and policies");
		
		product_purchase1.shipping_proceed();
		rep.info_test("Proceed to checkout4");
		
		product_purchase1.payment();
		logger.info("Selected the payment method");
		
		product_purchase1.confirm_order();
		rep.info_test("Confirmed order");
		
	}
	
	/*
	@AfterMethod
	public void after(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Screenshots shots = new Screenshots();
			String image = shots.f(driver, result.getName());
			
			String screen = report_obj.screenshot_test(image);
			
			report_obj.fail_test("Failed Test case", screen);
		}
		
		else if (ITestResult.SUCCESS==result.getStatus()) 
		{
			report_obj.pass_test("Passed Test Case");
		}
		
		else
			report_obj.skip_test("Skipped Test case");
		
		
		//driver.quit();
	}
	
	
	@AfterTest
	public void afterTest()
	{
		report_obj.tear();
	}
	*/
}
