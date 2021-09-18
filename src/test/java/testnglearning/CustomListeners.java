package testnglearning;


import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListeners implements ITestListener, ISuiteListener
{

	public void onTestStart(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result)
	{

		Reporter.log("<a href=\"C:\\Users\\abc\\Desktop\\Xpath.jpg\" target=\"_blank\">capture screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a href=\"C:\\Users\\abc\\Desktop\\Xpath.jpg\" target=\"_blank\"><img src=\"C:\\Users\\abc\\Desktop\\Xpath.jpg\" height=200 width=200></a>");
		
		
	}

	public void onTestFailure(ITestResult result)
	{  
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=\"C:\\Users\\abc\\Desktop\\Xpath.jpg\" target=\"_blank\">capture screenshot</a>");
		Reporter.log("<br>");
		Reporter.log("<a href=\"C:\\Users\\abc\\Desktop\\Xpath.jpg\" target=\"_blank\"><img src=\"C:\\Users\\abc\\Desktop\\Xpath.jpg\" height=200 width=200></a>");
		
		
	}

	public void onTestSkipped(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context)
	{
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context)
	{
		System.out.println("TestSuite Finished");
		
	}

	public void onStart(ISuite suite)
	{
		System.out.println("TestSuite Started");
		
	}

	public void onFinish(ISuite suite)
	{
		// TODO Auto-generated method stub
		
	}

}
