package Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FoldersCreation
{
	String path;
	File dir;
	
	public FoldersCreation()
	{
			
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String str = df.format(date);
		path = "./Archives/"+str;
		dir = new File(path);
		
	}
	
	public File return_dir()
	{
		return dir;
	}
	
	public String return_path()
	{
		System.out.println(path);
		return path;
	}
		
	
	public void creating_directory()
	{
		dir.mkdir();
	}
	
	
	public String screenshot_folder()
	{
		File screenshot = new File(path+"/screenshots");
		screenshot.mkdir();
		String screenshot_path = screenshot.getPath();
		System.out.println(screenshot_path);
		return screenshot_path;
	}
		
		
	public String report_folder()
	{
		File report = new File(path+"/reports");
		report.mkdir();
		String report_path = report.getPath();
		System.out.println(report_path);
		return report_path;
	}
	
}

