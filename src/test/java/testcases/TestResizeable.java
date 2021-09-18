package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestResizeable
{

	public static void main(String[] args)
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();
		driver.navigate().to("https://jqueryui.com/resources/demos/resizable/default.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement Nob=driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		new Actions(driver).dragAndDropBy(Nob, 400, 400).perform();
		

	}

}
