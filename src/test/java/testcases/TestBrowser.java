package testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowser {
	public static String Browser="Chrome";
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	
	{   
		if (Browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		
		else if (Browser.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https:\\www.gmail.com");
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("trainer@way2automation.com");
	    driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))).sendKeys("asdfasdf");
	    driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
	    System.out.println(driver.findElement(By.xpath("//*[@id=\"view_container\"]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[2]/div[2]/span")).getText());
	     
	}

}
