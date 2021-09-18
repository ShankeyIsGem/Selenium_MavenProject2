package testnglearning;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1
{   @BeforeTest
	public void openDBConn()
	{
		System.out.println("Opening DB Connection");
	}
 
  @AfterTest
	public void clossDBConn()
	{
		System.out.println("Closing DB Connection");
	}
	
    @Test(priority=2, groups="low")
	public void doLogin()
	{   Reporter.log("Inside doLogin");
		System.out.println("This is simple Login Method");
	}
    @Test(priority=1, groups="low")
   	public void doReg()
   	{   Reporter.log("Inside doReg");
   		System.out.println("This is simple Reg Method");
   	}
    
    @AfterMethod
  	public void closingBrowser()
   	{
   		System.out.println("closing the Browser");
   	}
    @BeforeMethod
  	public void openBrowser()
   	{
   		System.out.println("Opening the browser");
   	}
}
