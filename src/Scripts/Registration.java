package Scripts;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ProductPurchasePage;
import Pages.RegisterPage;
import Pages.RegistrationPage;
import Utility.ConfigReader;
import Utility.Reporting;
import Utility.Screenshots;

public class Registration extends BaseClass
{
	/*
	WebDriver driver;
	
	ConfigReader config;
	Reporting reports;
	String log = "Registration";
	String logs = "RegistrationReport";
	
	@BeforeTest
	public void report()
	{
		reports = new Reporting();
		reports.report(log, logs);
	}
	
	@BeforeMethod
	public void before_registration()
	{
		config = ConfigReader.func();
		System.setProperty("webdriver.chrome.driver", config.driverLoad());
		driver = new ChromeDriver();
		
		driver.get(config.getUrl());
		
		
		
	}
	*/
	
	ProductPurchasePage page;
	@Test
	public void registration1()
	{
		Logger logger = Logger.getLogger(Registration.class);
		PropertyConfigurator.configure("Log4j.properties");
		
		
		page = new ProductPurchasePage(driver);
		page.signIn_button();
		
		logger.info("Sign in button is clicked");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		RegisterPage register = new RegisterPage(driver);
		register.email();
		register.btn();
		logger.info("Email id has been successfully verified");
		
		String actual = driver.findElement(By.xpath("//*[text()='Create an account']")).getText();
		Assert.assertEquals(actual, "CREATE AN ACCOUNT");
		logger.info("Successfully landed on the registration page");
		
		RegistrationPage reg_page = new RegistrationPage(driver);
		reg_page.gender();
		
		reg_page.firstName();
		
		reg_page.lastName();
		
		reg_page.password();
		
		reg_page.day();
		
		reg_page.month();
		
		reg_page.year();
		
		reg_page.signUp();
		
		reg_page.uniform();
		
		reg_page.addressMethod();
		
		reg_page.cityMethod();
		
		reg_page.stateMethod();
		
		reg_page.postalMethod();
		
		reg_page.phoneMethod(); 
		
		reg_page.aliasMethod();
		
		logger.info("Successfully uploaded all the information");
		
		reg_page.submit();
		
		logger.info("Successfully reigistered");
		
		String actual1 = driver.findElement(By.xpath("//p[@class='info-account']")).getText();
		Assert.assertEquals(actual1, "Welcome to your account. Here you can manage all of your personal information and orders.");

	}

	/*
	@AfterMethod
	public void after_registration(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Screenshots shots = new Screenshots();
			String screenshot = shots.f(driver, result.getName());
			String imagepath = reports.screenshot_test(screenshot);
			reports.fail_test("Failed", imagepath);
			
		}
		
		if(ITestResult.SUCCESS==result.getStatus())
		{
			reports.pass_test("Passed");
		}
		
		driver.quit();
	}
	
	@AfterTest
	public void after()
	{
		reports.tear();
	}
	
	*/
}
