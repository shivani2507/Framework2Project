package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Utility.ConfigReader;

import Utility.Locators;
import Utility.dynamic_waits;

public class RegistrationPage 
{
	WebDriver driver;
	WebElement element;
	
	dynamic_waits wait1 = new dynamic_waits();
	Locators loc = new Locators();
	ConfigReader conf = ConfigReader.func();
	Select sel;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void gender()
	{
		element = driver.findElement(loc.gender_locator());
		wait1.onClickMethod(driver, 10, element);
	}
	
	public void firstName()
	{
		element = driver.findElement(loc.firstname_locator());
		wait1.sendKeysMethod(driver, 10, element, "shivani");
	}
	
	public void lastName()
	{
		element = driver.findElement(loc.lastname_locator());
		wait1.sendKeysMethod(driver, 10, element, "sharma");
	}
	
	public void password()
	{
		element = driver.findElement(loc.password_loc());
		wait1.sendKeysMethod(driver, 10, element, conf.PasswordConfigValid());
	}
	
	public void day()
	{
		element = driver.findElement(loc.day_locator());
		sel = new Select(element);
		sel.selectByValue("25");
	}
	
	public void month()
	{
		element = driver.findElement(loc.month_locator());
		sel = new Select(element);
		sel.selectByVisibleText("July ");
	}
	
	public void year()
	{
		element = driver.findElement(loc.year_locator());
		sel = new Select(element);
		sel.selectByVisibleText("1993  ");
	}
	
	public void signUp()
	{
		element = driver.findElement(loc.signup_locator());
		element.click();
		
	}
	
	public void uniform()
	{
		element = driver.findElement(loc.uniform_locator());
		element.click();
	}
	
	public void addressMethod()
	{
		element = driver.findElement(loc.address_locator());
		wait1.sendKeysMethod(driver, 5, element, "Shahabad Markanda");
	}
	
	public void cityMethod()
	{
		element = driver.findElement(loc.city_locator());
		wait1.sendKeysMethod(driver, 5, element, "Shahabad Markanda");	
	}
	
	public void stateMethod()
	{
		element = driver.findElement(loc.state_locator());
		sel = new Select(element);
		sel.selectByVisibleText("Alabama");
	}
	
	public void postalMethod()
	{
		element = driver.findElement(loc.postalCode_locator());
		wait1.sendKeysMethod(driver, 5, element, "13615");
	}
	
	public void phoneMethod()
	{
		element = driver.findElement(loc.phonenumber_locator());
		wait1.sendKeysMethod(driver, 5, element, "134567890");
	}
	
	public void aliasMethod()
	{
		element = driver.findElement(loc.alias_locator());
		wait1.sendKeysMethod(driver, 5, element, "ok");
	}
	
	public void submit()
	{
		element = driver.findElement(loc.submitButton_locator());
		wait1.onClickMethod(driver, 10, element);
	}
}
