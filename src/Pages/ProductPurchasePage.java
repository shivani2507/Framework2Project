package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import Utility.Locators;
import Utility.dynamic_waits;

public class ProductPurchasePage
{
	WebDriver driver;
	WebElement element;
	
	Locators locator = new Locators();
	dynamic_waits wait = new dynamic_waits();
	
	public ProductPurchasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void signIn_button()
	{
		element = driver.findElement(locator.sign_In());
		wait.onClickMethod(driver, 5, element);
	}
	
	public WebElement select_chiffon_product()
	{
		return element = driver.findElement(locator.chiffon_purchase());
	}
	
	public WebElement select_blouse_product()
	{
		return element = driver.findElement(locator.blouse_purchase());
	}
	
	public void search_chiffon()
	{
		element = driver.findElement(locator.search_locator());
		wait.sendKeysMethod(driver, 10, element, "Printed Chiffon Dress");
	}
	
	public void search_blouse()
	{
		element = driver.findElement(locator.search_locator());
		wait.sendKeysMethod(driver, 10, element, "Blouse");
	}
	
	
	public void search_clear()
	{
		driver.findElement(locator.search_locator()).clear();
	}
	
	public void search_button()
	{
		element = driver.findElement(locator.search_button_locator());
		wait.onClickMethod(driver, 5, element);
	}
	
	public void add_cart()
	{
		element = driver.findElement(locator.add_cart_locator());
		wait.onClickMethod(driver, 5, element);
	}
	
	public void continue_shopping()
	{
		element = driver.findElement(locator.continue_shopping_locator());
		wait.onClickMethod(driver, 5, element);
	}
	
	public void proceed_checkout()
	{
		element = driver.findElement(locator.proceed_checkout_locator());
		wait.onClickMethod(driver, 5, element);
	}
	
	public void summary_checkout()
	{
		element = driver.findElement(locator.summary_checkout_locator());
		wait.onClickMethod(driver, 5, element);
	}
	
	public void agree()
	{
		driver.findElement(locator.agree_checkbox_locator()).click();
	}
	
	public void shipping_proceed()
	{
		element = driver.findElement(locator.shipping_proceed_locator());
		wait.onClickMethod(driver, 5, element);
	}
	
	
	public void payment()
	{
		element = driver.findElement(locator.payment_selector_locator());
		wait.onClickMethod(driver, 5, element);
	}
	
	public void confirm_order()
	{
		driver.findElement(locator.confirm_order_locator()).click();
	}
	
	
}
