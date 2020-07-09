package Pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.Locators;
import Utility.dynamic_waits;

public class NewsletterSubscriptionPage 
{

	WebDriver driver;
	WebElement element;
	Locators loc = new Locators();
	dynamic_waits dynamic = new dynamic_waits();
	Random rand = new Random(1000);
	
	public NewsletterSubscriptionPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void newsletterEmail()
	{
		element = driver.findElement(loc.newsletter_email_locator());
		dynamic.sendKeysMethod(driver, 10, element, "shiv"+rand.nextInt()+"@abc.com");
	}
	
	public void newsletterSubmit()
	{
		element = driver.findElement(loc.newsletter_submit_locator());
		dynamic.onClickMethod(driver, 10, element);
	}
	
	public void newsletterEmail(String email)
	{
		driver.findElement(loc.newsletter_email_locator()).sendKeys(email);
	}
	
}
