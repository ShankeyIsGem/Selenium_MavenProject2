package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCheckboxes {
	static WebDriver  driver;
	public static boolean isElementPresent(By by)
	{
	
	  try
	   {
		driver.findElement(by);
		return true;
	    }
	catch (Throwable t) 
	    {
	    	return false;
	    }
	    
	}
	public static void main(String[] args) 
	
	{
		    WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("http://tizag.com/htmlT/htmlcheckboxes.php");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
		    }
		
//		for (int i=1;i<=4;i++)
//			
//		{  
//			driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input["+i+"]")).click();
//			
//		}
////		
		/*
		 * int i=1; int counter=0; while (isElementPresent(By.xpath(
		 * "/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input["+i+"]"
		 * ))) { driver.findElement(By.xpath(
		 * "/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input["+i+"]"
		 * )).click(); i++; counter++; System.out.println(counter); }
		 * 
		 * System.out.println("Total Checkboxes are :"+counter);
		 */
//		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[1]")).click();
//		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[2]")).click();
//		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[3]")).click();
//		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]/input[4]")).click();
//		
//       System.out.println(isElementPresent(By.name("sports")));
//       driver.quit();
		
	List<WebElement> checkboxes =driver.findElements(By.name("sports"));
	{
	for (WebElement checkbox:checkboxes)
	{
		checkbox.click();
	}
     System.out.println(checkboxes.size());
	}

}
