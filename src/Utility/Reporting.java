package Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting 
{
	ExtentReports reports,reports2;
	ExtentTest test;
	
	public void report(String name, String module) throws IOException
	{
		
		FoldersCreation create_folder = new FoldersCreation();
		
		File directory = create_folder.return_dir();
		String path_directory = create_folder.return_path();
		System.out.println(path_directory);
		
		if(directory.exists())
		{
			reports = new ExtentReports("./"+path_directory+"/reports/"+name+".html");
			reports2 = new ExtentReports("G:\\Reports\\"+name+".html");
			
			System.out.println("Folder already exist");
		}
		
		
		else
		{
			create_folder.creating_directory();
			
			reports = new ExtentReports(create_folder.report_folder()+"/"+name+".html");
			reports2 = new ExtentReports("G:\\Reports\\"+name+".html");
			System.out.println("Creating new folder");
			
		}
			//File file1 = new File(folder.f1()+"/screenshot.png");
			//file1.createNewFile();
			
			//File file2 = new File(folder.f2()+"/report.png");
			//file2.createNewFile();
			
			
			//reports = new ExtentReports(report_path+".html");
			//reports = new ExtentReports("G:\\Reports\\"+name+".html");
			test = reports.startTest("Creating Report for "+module);
		
	}
	
	public String create_report_name_function()
	{
		Random random_number = new Random();

		String log1 = "Suite_Report";
		String log2 = "E-Commerce Report";
		
		DateFormat df = new SimpleDateFormat("dd-MM-yy ");
		Date date = new Date();
		String current_date = df.format(date);

		String name1 = log1 + random_number.nextInt(10000) + "-" + current_date;
		return name1;
		
	}
	
	
	public void info_test(String detail)
	{
		test.log(LogStatus.INFO, detail);
	}
	
	public void pass_test(String detail)
	{
		test.log(LogStatus.PASS, detail);
	}
	
	
	public void fail_test(String detail, String shot_name)
	{
		test.log(LogStatus.FAIL, detail, shot_name);
	}
	
	public void skip_test(String detail)
	{
		test.log(LogStatus.SKIP, detail);
	}
	
	
	public String screenshot_test(String imagePath)
	{
		String capture = test.addScreenCapture(imagePath);
		return capture;
	}
	
	
	public void tear()
	{
		reports2.endTest(test);
		reports.endTest(test);
		reports.flush();
		reports2.flush();
	}
}
