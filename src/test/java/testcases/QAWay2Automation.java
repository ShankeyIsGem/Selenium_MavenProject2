package testcases;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QAWay2Automation {

	public static void main(String[] args) 
	
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
        WebDriverWait wait =new WebDriverWait(driver, 20);
		driver.get("https://qa.way2automation.com/");
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"load_form\"]/fieldset[3]/input"))).sendKeys("shankeyisgem@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text'] [@name='name']"))).sendKeys("Shankey");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input [@type='tel'] [@name='phone']"))).sendKeys("979340330");
        driver.findElement(By.xpath("//input[@type='text'] [@name='city']")).sendKeys("Ghaziabad");
        driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[6]/input")).sendKeys("ShankeyIsGem");
        driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[7]/input")).sendKeys("password");
	    Select sel = new Select (driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[4]/select")));
	    sel.selectByValue("Albania");
//	    driver.findElement(By.xpath("//div[@id='load_box']//input[@value='Submit']")).click();
//	    String s1=driver.findElement(By.xpath("//*[@id=\"alert\"]")).getText();
//	    System.out.println("Alert Value is "+s1);
	    List<WebElement> Both = driver.findElements(By.xpath("//div[@id='load_box']//input[@value='Submit']"));
	    Both.get(1).click();
	}
	

}
