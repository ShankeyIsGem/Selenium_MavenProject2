package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxesAssignment {
     public static WebDriver driver;
	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://tizag.com/htmlT/htmlcheckboxes.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement block1=driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> itr2 = block1.findElements(By.name("sports"));
		for (WebElement itr1:itr2)
		{
			itr1.click();
		}
		
		
//	   WebElement block2=driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[6]"));
//	   
//	   for (int i=2;i<=3;i++)
//	   {
//		 block2.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[6]/input["+i+"]")).click();
//		 
//		   
//	   }
	 
//	   List<WebElement> Tags=block2.findElements(By.tagName("input"));
//	   for (WebElement tag:Tags)
//	   {  
//		   tag.click();
//	   }
	   WebElement block2=driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[6]"));
	   List<WebElement> Tags=block2.findElements(By.tagName("input"));
	   int count=0;
       for (WebElement tag:Tags)
       {  
		if (tag.isSelected()!=true)
		{
			tag.click();
			System.out.println(tag.getAttribute("value"));
			count ++;
			
		}
		 
       }
       System.out.println("Total Checked Checkboes count Is" +count);
	}

}
