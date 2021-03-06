package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("https://way2automation.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement menu=driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/a"));
		Actions action=new Actions(driver);
		action.moveToElement(menu).perform();
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/ul/li[1]/a")).click();
		
	}

}
