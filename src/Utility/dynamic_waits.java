package Utility;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class dynamic_waits
{
	public void sendKeysMethod(WebDriver driver, int timeout, WebElement element, String value)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public void onClickMethod(WebDriver driver, int timeout, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public void fluent_wait(WebDriver driver, WebElement element1)
	{
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(30, TimeUnit.SECONDS)
			       .pollingEvery(1, TimeUnit.SECONDS)
			       .ignoring(NoSuchElementException.class);

			   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			     public WebElement apply(WebDriver driver) {
			       return element1;
			     }
			   });
			   
		if(element1.isDisplayed())
		{
			System.out.println("element is displayed using fluent wait");
		}
			 
	}

}
