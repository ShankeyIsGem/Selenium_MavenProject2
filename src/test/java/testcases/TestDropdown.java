package testcases;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdown {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.navigate().to("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")).sendKeys("English");
		Select select=new Select(driver.findElement(By.xpath("//*[@id=\"searchLanguage\"]")));
		select.selectByValue("hi");
		List<WebElement> values = driver.findElements(By.tagName("Option"));
		System.out.println("Total Count is :" +values.size());
		System.out.println(values.get(9).getText());
		
		for (int i=0;i<values.size();i++)
		{
		  System.out.println(values.get(i).getText());
		}
		
//		List<WebElement> Links =driver.findElements(By.tagName("a"));
//		System.out.println(Links.size());
//		for(WebElement link:Links)
//			
//		{
//			System.out.println(link.getText()+"URL IS"+link.getAttribute("href"));
//		}
		System.out.println("-------------Block Links----------------");
		WebElement block=driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));
		List<WebElement> links=block.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (WebElement link :links)
		{
			System.out.println(link.getText()+"--URL IS--"+link.getAttribute("href"));
		}
		
		
}
}