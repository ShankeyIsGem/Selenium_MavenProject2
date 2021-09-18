package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTryIt
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (WebElement frame:frames)
		{
			System.out.println(frame.getAttribute("id"));
		}
			
//		driver.switchTo().frame("iframeResult");
//		driver.findElement(By.xpath("//button[normalize-space()='Try it']")).click();
//        To Execute Java sript --Directly it would click on 'TRyIt' button.
		 ((JavascriptExecutor) driver).executeScript("myFunction()");
	}
	
	

}
