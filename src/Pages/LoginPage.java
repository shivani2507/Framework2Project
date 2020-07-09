package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utility.ConfigReader;

import Utility.Locators;
import Utility.dynamic_waits;

public class LoginPage 
{
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	Locators l = new Locators();
	ConfigReader reader = ConfigReader.func();
	dynamic_waits explicit_wait = new dynamic_waits();
	
	public void e()
	{
		WebElement element = driver.findElement(l.email_loc());
		explicit_wait.sendKeysMethod(driver, 5, element , reader.emailConfig());
		
		
	}
	
	public void p()
	{
		WebElement element = driver.findElement(l.password_loc());
		explicit_wait.sendKeysMethod(driver, 5, element , reader.PasswordConfigValid());
		
	}
	
	
	public void p(String pwd)
	{
		WebElement element = driver.findElement(l.password_loc());
		explicit_wait.sendKeysMethod(driver, 5, element , pwd);
		
	}
	
	
	public void b()
	{
		WebElement element = driver.findElement(l.button_loc());
		explicit_wait.onClickMethod(driver, 5, element);
		
	}
	
	
}

