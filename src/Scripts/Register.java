package Scripts;

import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import org.apache.log4j.Logger;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Pages.RegisterPage;
import Utility.ConfigReader;
import Utility.Reporting;
import Utility.Screenshots;

public class Register extends BaseClass
{
	
	/*
	WebDriver driver;
	String log1 ="Registration";
	String log2 = "RegistrationPageReport";
	Reporting rep;
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	public void reporting_fun()
	{
		rep = new Reporting();
		rep.report(log1,log2);
	}
	
	@BeforeMethod
	public void before_Register()
	{
		ConfigReader reader = ConfigReader.func();
		System.setProperty("webdriver.chrome.driver", reader.driverLoad());
		driver = new ChromeDriver();
		driver.get(reader.getUrl());
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account'][@title='Log in to your customer account']")).click();
		System.out.println("clicked on sign in");
	}
	
	*/
	
	@Test(priority=1)
	public void RegisterValid()
	{
		System.out.println("Test1 of register");
		Assert.assertEquals(10, 10);
		
		Logger logger = Logger.getLogger(Register.class);
		PropertyConfigurator.configure("Log4j.properties");
			
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account'][@title='Log in to your customer account']")).click();
		
		RegisterPage r = new RegisterPage(driver);
		r.email();
		r.btn();
		
		logger.info("Trying to verify with valid email id");
		
		String actual = driver.findElement(By.xpath("//*[text()='Create an account']")).getText();
		Assert.assertEquals(actual, "CREATE AN ACCOUNT");
		rep.info_test("Register with valid email id");
		
		logger.info("Successfully verified the email id");
		
	}
	
	
	@Test(priority=2)
	public void InvalidRegister()
	{
		System.out.println("Test2 of register");
		Assert.assertEquals(10, 11);
		
		Logger logger = Logger.getLogger(Register.class);
		PropertyConfigurator.configure("Log4j.properties");
		
		
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account'][@title='Log in to your customer account']")).click();
		
		RegisterPage r = new RegisterPage(driver);
		r.InvalidEmail();
		r.btn();
		
		logger.info("Trying to verify email id already registered email");
		
		String actual = driver.findElement(By.xpath("//*[text()='An account using this email address has already been registered. Please enter a valid password or request a new one. ']")).getText();
		rep.info_test("Invalid email id");
		Assert.assertEquals(actual, "CREATE AN ACCOUNT");
		
	}
	
	/*
	@AfterMethod
	public void after_register(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE==result.getStatus())
		{

			Screenshots shots = new Screenshots();
			String screen = shots.f(driver, result.getName());
			System.out.println(screen);
			String image = rep.screenshot_test(screen);
			System.out.println(image);
			System.out.println("Screenshot captured");
			
			rep.fail_test("Failed", image);
		}
		
		else if (ITestResult.SUCCESS==result.getStatus())
		{
			rep.pass_test("Passed");
			
		}
		
		else 
			rep.skip_test("Skipped");
		
		driver.quit();
	}
	
	@AfterTest
	public void after()
	{
		rep.tear();
	}
	*/
}
