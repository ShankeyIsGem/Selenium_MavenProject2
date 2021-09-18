package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDragAndDrop
{    public static WebDriver driver;

	public static void main(String[] args)
	{
		WebDriverManager.firefoxdriver().setup();
	    WebDriver driver =new FirefoxDriver();
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement draggable=driver.findElement(By.xpath("//*[@id=\"draggable\"]/p"));
		WebElement droppable=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		Actions action =new Actions(driver);
		//1. Drag and drop on the 'droppable' webpage.
		//action.dragAndDrop(draggable, droppable).perform();
		//2. Drag and drop outside droppable on the webpage.
		action.dragAndDropBy(draggable, 393, 400).perform(); 
		
		

	}

}
