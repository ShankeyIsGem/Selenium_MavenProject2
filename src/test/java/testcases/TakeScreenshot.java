package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeScreenshot
{
 static WebDriver driver;
 public static void getScreenshot() throws IOException
 
 {  
	File screenshotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	Date d=new Date();
    String filename=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
	FileUtils.copyFile(screenshotFile, new File("./Screenshot/"+filename));
 }
 
public static void getScreenshotElement(WebElement element) throws IOException
 
 {  
	File screenshotFile=((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
	Date d=new Date();
    String filename="Element_"+d.toString().replace(":", "_").replace(" ", "_")+".jpg";
	FileUtils.copyFile(screenshotFile, new File("./Screenshot/"+filename));
 }
	public static void main(String[] args) throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.navigate().to("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Element=driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/ul[2]/li[2]/a/div[2]"));
		WebElement Element1 =driver.findElement(By.xpath("//*[@id=\"top-section-widgets.inventory-1.register-upload-cv-json-wdgt\"]/div[1]/div[2]/div/div[1]/button"));
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", Element);
		getScreenshot();
		getScreenshotElement(Element1);
		driver.quit();
}
}