package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readingWritingExcelFile 
{
	
	
	public void reading(String path) throws Exception
	{
		File file = new File(path);
		
		FileInputStream fin = new FileInputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		
	}
	
	public void writing(String path) throws Exception
	{
		File file = new File(path);
		
		FileOutputStream fout = new FileOutputStream(file);
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		wb.write(fout);
		
		
	}
}
