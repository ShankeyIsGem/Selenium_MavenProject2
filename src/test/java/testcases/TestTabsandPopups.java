package testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsandPopups
{

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("https://www.way2automation.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Set<String> WindIds	= driver.getWindowHandles();
	    Iterator<String> Itr  = WindIds.iterator();
	    String First_window = Itr.next();
	    driver.findElement(By.xpath("//*[@id=\"wrapper\"]/header/div[2]/div/div[2]/div/a[1]")).click();
	    WindIds	= driver.getWindowHandles();
	    Itr  = WindIds.iterator();
	    Itr.next();
	    String Second_window = Itr.next();
	    driver.switchTo().window(Second_window);
		driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("trainer@way2automation.com");
		driver.close();
		
	}

}
