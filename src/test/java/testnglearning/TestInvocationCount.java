package testnglearning;

import org.testng.annotations.Test;

public class TestInvocationCount
{
   @Test(invocationCount=5)
	public void doLogin()
	{
		System.out.println("Check for invocation count");
	}
}
