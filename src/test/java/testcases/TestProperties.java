package testcases;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties
{
    public static WebDriver driver;
    public static Logger log =Logger.getLogger(TestProperties.class);
    public static Properties pr= new Properties();
    public static Properties config= new Properties();
	public static FileInputStream fis; 
    public static void click (String locatorkey)
    
    {   
    	
        if (locatorkey.endsWith("XPATH"))
        {   log.info("Clicking on Element as ---"+locatorkey);
        	driver.findElement(By.xpath(pr.getProperty(locatorkey))).click();
        	
        }
    	
        else if (locatorkey.endsWith("ID"))
        {   log.info("Clicking on Element as ---"+locatorkey);
        	driver.findElement(By.id(pr.getProperty(locatorkey))).click();
        }
    	
    }

    public static void type(String locatorkey, String input)
    {   if (locatorkey.endsWith("XPATH"))
        {
    	 log.info("Typing for"+locatorkey+"as"+input);
    	 driver.findElement(By.xpath(pr.getProperty(locatorkey))).sendKeys(input);
        }
      else if (locatorkey.endsWith("ID"))
        {
    	  log.info("Typing for"+locatorkey+"as"+input);
    	  driver.findElement(By.id(pr.getProperty(locatorkey))).sendKeys(input);
        }
    }
    
	public static void main(String[] args) throws IOException
	{   PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
		pr.load(fis);
		fis =new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
	
		if (config.getProperty("browser_name").equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		
		else if (config.getProperty("browser_name").equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		driver.get(config.getProperty("testsite_url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		type("username_ID","Trainer@way2automation.com");
		click("nxt_button_XPATH");
		
	}

}
