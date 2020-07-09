package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConfigReader 
{
	Properties pro;
	WebDriver driver;
	
	private ConfigReader()
	{
		
		try
		{
		File fil = new File("./Configuration/Config.property");
		
		FileInputStream fis = new FileInputStream(fil);
		
		pro = new Properties();
		
		pro.load(fis);
		
		}
		
		catch(Exception e)
		{
			System.out.println("Exception has been caught" + e.getMessage());
		}
		
	}
	
	
	public static ConfigReader func()
	{
		return new ConfigReader();
	}
	
	/*public WebDriver initializeDriver()
	{
		this.driver = driver;
		driver = new ChromeDriver();
		return driver;
	}*/
	
	public String driverLoad()
	{
		return pro.getProperty("ChromeDriver");
	}
	
	
	public String getUrl()
	{
		return pro.getProperty("URL");
	}

	
	public String emailConfig()
	{
		return pro.getProperty("Email");
		
	}
	
	public String PasswordConfigValid()
	{
		return pro.getProperty("Password");
		
	}
	
}
