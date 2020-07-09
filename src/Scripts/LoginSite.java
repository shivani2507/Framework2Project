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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPage;
import Utility.ConfigReader;
import Utility.Reporting;
import Utility.Screenshots;

public class LoginSite extends BaseClass
{
	/*
	WebDriver driver;
	/*
	ExtentReports reports;
	ExtentTest test;
	String log1 ="LoginPage";
	String log2 = "LoginPageReport";
	Reporting rep;
	
	@BeforeTest
	public void reporting_fun()
	{
		rep = new Reporting();
		rep.report(log1,log2);
	}
	
	@BeforeMethod
	public void before()
	{
		
		ConfigReader conf = ConfigReader.func();
		System.setProperty("webdriver.chrome.driver", conf.driverLoad());
		driver = new ChromeDriver();
		driver.get(conf.getUrl());
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account'][@title='Log in to your customer account']")).click();
		System.out.println("clicked on sign in");
		System.out.println("Before method executed");
		
	}*/


	@Test(priority=1)
	public void loginValidCredentials()
	{
		System.out.println("Test1 of login");
		Assert.assertEquals(10, 10);
	
		Logger logger = Logger.getLogger(LoginSite.class);
		PropertyConfigurator.configure("Log4j.properties");
		
		
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account'][@title='Log in to your customer account']")).click();
		
		LoginPage log1 = new LoginPage(driver);
		log1.e();
		log1.p();
		log1.b();
		
		logger.info("Successfully logged in");
		
		String actual = driver.findElement(By.xpath("//*[text()='Welcome to your account. Here you can manage all of your personal information and orders.']")).getText();
		Assert.assertEquals(actual, "Welcome to your account. Here you can manage all of your personal information and orders.");
		rep.info_test("Login with valid credentials test case");
		
		logger.info("User is logged in with valid credentials");
		
	}
	
	 
	@Test(priority=2)
	public void loginInvalidCredentials()
	{
		System.out.println("Test2 of login");
		Assert.assertEquals(10, 11);
		
		Logger logger = Logger.getLogger(LoginSite.class);
		PropertyConfigurator.configure("Log4j.properties");
		
		driver.findElement(By.xpath("//a[@href='http://automationpractice.com/index.php?controller=my-account'][@title='Log in to your customer account']")).click();
		
		LoginPage log1 = new LoginPage(driver);
		log1.e();
		log1.p("shiv@12");
		log1.b();
		
		logger.info("Unsuccessful logged in");
		
		String actual = driver.findElement(By.xpath("//*[text()='Authentication failed.']")).getText();
		rep.info_test("Login with invalid credentials test case");
		Assert.assertEquals(actual, "Welcome to your account. Here you can manage all of your personal information and orders.");
		
	 
	}

	/*
	@AfterMethod
	public void quitBrowser(ITestResult result) throws Exception
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
