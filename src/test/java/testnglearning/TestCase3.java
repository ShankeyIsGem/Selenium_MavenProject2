package testnglearning;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3
{

	@Test(priority=2,dependsOnMethods="doReg", groups="high")
	public void doLogin()
	{
		System.out.println("This is simple Login Method");
	}
    @Test(priority=1,groups="high")
   	public void doReg()
   	{
   		System.out.println("This is simple Reg Method");
   		Assert.fail("failing the test case");
   	}
     @Test(priority = 3,groups= {"high", "low"})
    public void isSkip()
    {
    	throw new SkipException("Skipping the test case");
    }
}
