package Failed;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class failedCases 
{
	public static void main(String[] args)
	{
		TestNG ng = new TestNG();
		
		List<String> suites = new ArrayList<String>();
		suites.add("C:\\TC\\SeleniumFramework2\\test-output\\testng-failed.xml");
		
		ng.setTestSuites(suites);
		ng.run();
	}
	
}
