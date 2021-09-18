package testnglearning;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestParemetrizationXML
{  
	 WebDriver driver;
   @Parameters({"url", "browser"})
   @Test
   public void doLogin(String url, String browser) 
   {  
	 
	   if (browser.equals("chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   } 
	   else if (browser.equals("firefox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
		   driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);  
	   
	   }
	  
	   driver.get(url);
	   System.out.println(driver.getTitle());
	   Date d =new Date();
	   System.out.println("Navigating to :"+url+" in browser"+"--->"+browser+"  "+d.toString());
	   
	   
   }
}
