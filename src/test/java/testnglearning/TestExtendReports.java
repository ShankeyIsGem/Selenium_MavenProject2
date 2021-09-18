package testnglearning;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestExtendReports
{  
	public ExtentSparkReporter htmlreporter;//Creating the HTML file and Add configuration.
	public ExtentReports extent;//Attaching reporter and all configuration to the report.
	public ExtentTest test;//Creating Test case and add log status - Info, Fail, Pass, Debug.
	
	@BeforeTest()
	public void setReport()
	{
		
		htmlreporter = new ExtentSparkReporter("./Reports/Extent.html");
		htmlreporter.config().setEncoding("utf-8");
		htmlreporter.config().setDocumentTitle("W2A automation Reports");
		htmlreporter.config().setReportName("Automation Test Results");
		htmlreporter.config().setTheme(Theme.STANDARD);
		extent =new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Automtion Tester", "Shankey");
		extent.setSystemInfo("Organization", "Way2Automatino");
		extent.setSystemInfo("BuildNo", "1.1");
	}
	
	@Test
	public void doLogin()
	{  
	    test.info("Adding User Name");
	    test.info("Adding Password");
		System.out.println("This is doLogin");
	}
	
	@Test
	public void doUserReg()
	{
	    test.info("Executing douserReg test");
	    Assert.fail("User Reg Failed");
		
	}
	@Test
	public void isSkipTest()
	{   
	    
	    throw new SkipException("Skipping the test case");
	}
	
	@Test
	public void doLoginNew()
	{  
	    test.info("Adding User Name");
	    test.info("Adding Password");
		System.out.println("This is doLogin");
	}
	
	@Test
	public void doUserRegNew()
	{
	    test.info("Executing douserReg test");
	    Assert.fail("User Reg Failed");
		
	}
	@Test
	public void isSkipTestNew()
	{   
	    
	    throw new SkipException("Skipping the test case");
	}
	
	@AfterTest
	public void endReport()
	{   
		extent.flush();
	}
	
	@BeforeMethod
	public void startUp(Method m)
	{
		test=extent.createTest(m.getName());
	}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if (result.getStatus()==ITestResult.SKIP)
		{
			test.skip("Skipping the test case");
			 Markup m=MarkupHelper.createLabel("Test Skipped", ExtentColor.AMBER);
				test.skip(m);
		} else if (result.getStatus()==ITestResult.FAILURE) {
		   String screenshot="C:\\Users\\abc\\Desktop\\Xpath.jpg";
		   test.fail("<b><font color =red>"+"Screenshot of failureU"+"</font></b>",MediaEntityBuilder.createScreenCaptureFromPath(screenshot).build());
		   String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace()); 
		    test.fail(exceptionMessage);
			test.fail("Failing the test");
			Markup m=MarkupHelper.createLabel("Failed", ExtentColor.RED);
			test.fail(m);
		}else if (result.getStatus()==ITestResult.SUCCESS) {
			  test.pass("Passing the test case");
			  Markup m=MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN);
				test.pass(m);
			}
	}

}
