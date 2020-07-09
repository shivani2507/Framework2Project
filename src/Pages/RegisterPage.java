package Pages;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.ConfigReader;

import Utility.Locators;
import Utility.dynamic_waits;

public class RegisterPage 
{
	WebDriver driver;
	Locators l = new Locators();
	dynamic_waits explicit_wait = new dynamic_waits();
	
	
	Random rand = new Random();
	String email_var = "shivani"+rand.nextInt(1000)+"@abc.com";
	
	
	ConfigReader reader = ConfigReader.func();
		
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void email()
	{
		WebElement element = driver.findElement(l.email_reg_loc());
		explicit_wait.sendKeysMethod(driver, 5, element, email_var);
	
	}
	
	public void InvalidEmail()
	{
		WebElement element = driver.findElement(l.email_reg_loc());
		explicit_wait.sendKeysMethod(driver, 5, element, reader.emailConfig());
		
	}
	
	
	public void btn()
	{
		WebElement element = driver.findElement(l.btn_reg_loc());
		explicit_wait.onClickMethod(driver, 5, element);
		
	}
		
}
