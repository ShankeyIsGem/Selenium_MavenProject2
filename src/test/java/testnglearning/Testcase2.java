package testnglearning;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testcase2

   {  
	String actual_title="Shankey";
	String expected_title="Raja";
	
	@Test(groups="low")
	public void tc1()
   	
	{
   		System.out.println("This is TC1");
   		Assert.fail("This is hard assertion");
   	}

   @Test(groups="low")
	public void tc2()
   	{
	   
   		System.out.println("This is TC2");
   		SoftAssert soft =new SoftAssert();
   		soft.fail("This is soft assertion");
   		soft.assertEquals(actual_title, expected_title);
   		soft.assertAll();
	}
	   
   
   }
   		
  
   

   
	

