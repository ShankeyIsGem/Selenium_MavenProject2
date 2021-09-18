package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRightClick
{

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement img=driver.findElement(By.xpath("//img[@src='data-samples/images/popup_pic.gif']"));
        Actions action =new Actions(driver);
        action.contextClick(img).perform();
        //Clicking further into submenu.
        driver.findElement(By.xpath("//*[@id=\"dm2m1i1tdT\"]")).click();
        driver.findElement(By.xpath("//td[@id='dm2m2i1tdT']")).click();
        driver.findElement(By.xpath("//td[@id='dm2m3i0tdT']")).click();
	}

}
