package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSlider
{

	public static void main(String[] args)
	{
	
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver =new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/slider/default.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement mainslider =driver.findElement(By.xpath("//*[@id=\"slider\"]"));
        int width= mainslider.getSize().width/2;
        System.out.println(width);
        WebElement slider =driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
        new Actions(driver).dragAndDropBy(slider, 1350,0).perform();
		
	}

}
