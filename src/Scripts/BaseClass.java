package Scripts;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utility.ConfigReader;
import Utility.Reporting;
import Utility.Screenshots;
import Utility.SendingEmail;

public class BaseClass {

	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;

/* Random random_number = new Random();

	public String log1 = "Suite_Report";
	public String log2 = "E-Commerce Report";*/
	public Reporting rep;

	@BeforeSuite
	public void before_suite() throws IOException {
		System.out.println("Before suite executed");
		
		/*
		DateFormat df = new SimpleDateFormat("dd-MM-yy ");
		Date date = new Date();
		String current_date = df.format(date);

		rep = new Reporting();
		String name1 = log1 + random_number.nextInt(10000) + "-" + current_date;*/

		rep = new Reporting();
		String name1= rep.create_report_name_function();
		System.out.println(name1);
		rep.report(name1, "E-Commerce Report");
		
		SendingEmail email = new SendingEmail(name1);
	}

	@BeforeMethod
	public void before_method() {
		System.out.println("Before method executed");
		
		ConfigReader conf = ConfigReader.func();
		
		System.setProperty("webdriver.chrome.driver", conf.driverLoad());
		driver = new ChromeDriver();
		
		
		driver.get(conf.getUrl());

	}

	@AfterMethod
	public void after_method(ITestResult result) throws Exception {
		System.out.println("After method executed");
		
		if (ITestResult.FAILURE == result.getStatus()) {
			System.out.println("failed");
			
			Screenshots shots = new Screenshots();
			String screen = shots.f(driver, result.getName());
			String image = rep.screenshot_test(screen);

			rep.fail_test("Failed", image);
		}

		else if (ITestResult.SUCCESS == result.getStatus()) {
			System.out.println("success");
			rep.pass_test("Passed");

		}
		
		else if (ITestResult.SKIP == result.getStatus()) {

			System.out.println("skipped");
			rep.skip_test("Skipped");

		}

		System.out.println("Before quit");
		driver.quit();
		System.out.println("After quit");
	}

	@AfterSuite
	public void after_suite() throws InterruptedException {
		
		System.out.println("After suite executed");
		rep.tear();
		Thread.sleep(8000);
		SendingEmail.sentEmail();
		}

}
