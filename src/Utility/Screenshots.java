package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.google.common.io.Files;

public class Screenshots 
{
	
	public String f(WebDriver driver, String str)
	{ 
		DateFormat df = new SimpleDateFormat("dd-MM-yy");
		Date date = new Date();
		String str1 = df.format(date);
		
		Random rand = new Random();
		TakesScreenshot shot = (TakesScreenshot)driver;
		File fs = shot.getScreenshotAs(OutputType.FILE);
		//String dest = "./Screenshots/"+str+rand.nextInt(100)+".png";
		
		//String dest = "G:\\Reports\\"+str+rand.nextInt(100)+".png"; //optional
		
		String dest = "G:\\Reports\\"+str+rand.nextInt(10000)+"-"+str1+".png"; //optional
		
		File path = new File(dest);
		try {
			Files.copy(fs, path);
		} catch (IOException e) {
			System.out.println("Exception caught at 1");
		}
		
		
		FoldersCreation create_folder = new FoldersCreation();
		//String dest1 = folder.f1()+"/"+str+rand.nextInt(100)+".png";
		
		String dest1 = create_folder.screenshot_folder()+"/"+str+rand.nextInt(10000)+"-"+str1+".png";
		//String dest1 = "./Archives/screenshots/shivani123.png";
		System.out.println(dest1);
		File path11 = new File(dest1);
		try {
			Files.copy(fs, path11);
			//Files.copy(path, path11);
		} catch (IOException e) {
			System.out.println("Execption caught at 2");
		}
		return dest1;
		//return dest;
	}
	
	
	
}
