package Scripts;

import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.NewsletterSubscriptionPage;
import Utility.ConfigReader;

public class NewsletterSubscription extends BaseClass
{
	
	/*
	WebDriver driver;
	NewsletterSubscriptionPage np;
	@BeforeMethod
	public void before_meth()
	{
		ConfigReader config = ConfigReader.func();
		System.setProperty("webdriver.chrome.driver", config.driverLoad());
		
		driver = new ChromeDriver();
		driver.get(config.getUrl());
	}
	*/
	

	NewsletterSubscriptionPage np;
	
	@Test
	public void newsLetter_UnRegistered_Email()
	{
		
		Logger logger = Logger.getLogger(NewsletterSubscription.class);
		PropertyConfigurator.configure("Log4j.properties");
		
		np = new NewsletterSubscriptionPage(driver);
		np.newsletterEmail();
		np.newsletterSubmit();
		
		logger.info("Trying to get newsletter with new email id");
		
		String actual1 = driver.findElement(By.xpath("//p[text()='Newsletter : You have successfully subscribed to this newsletter.']")).getText();
		Assert.assertEquals(actual1, " Newsletter : You have successfully subscribed to this newsletter.");
		
		logger.info("Successfully got the newsletter");
	}
	
	@Test
	public void newsletter_Registered_Email()
	{
		
		Logger logger = Logger.getLogger(NewsletterSubscription.class);
		PropertyConfigurator.configure("Log4j.properties");
		
		np = new NewsletterSubscriptionPage(driver);
		np.newsletterEmail("qwerty1234@abc.com");
		np.newsletterSubmit();
		
		logger.info("Trying to get newsletter with already registered emailid");
		
		String actual = driver.findElement(By.xpath("//p[text()=' Newsletter : This email address is already registered.']")).getText();
		Assert.assertEquals(actual, "Newsletter : This email address is already registered.");
		
		
	
	}
	
	/*
	@AfterMethod
	public void after_meth()
	{
		driver.quit();
	}
	*/
}
