package testnglearning;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExcelReader;

public class TestParametrization
{
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
   @Test (dataProvider="getData")
   public void doLogin (String username, String password)
   {
	   System.out.println(username+"-----"+password);
	   driver.get("http://www.facebook.com");
	   driver.findElement(By.id("email")).sendKeys(username);
	   driver.findElement(By.id("pass")).sendKeys(username);
   }
   
   @DataProvider
   public Object[][] getData()
   
   {   ExcelReader excel=new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
       String sheetname="LoginTest";
       int rowNum= excel.getRowCount(sheetname);
       int colNum=excel.getColumnCount(sheetname);
       System.out.println("Total Rows :" +rowNum+ " "+ "And Total Cols are :"+colNum);
       System.out.println(excel.getCellData(sheetname, 0, 2));
       System.out.println(excel.getCellData(sheetname, 1, 2));
	   Object[][] data =new Object[rowNum-1][colNum]; 
		/*
		 * data[0][0]=excel.getCellData(sheetname, 0, 2);
		 * data[0][1]=excel.getCellData(sheetname, 1, 2);
		 * 
		 * data[1][0]=excel.getCellData(sheetname, 0, 3);
		 * data[1][1]=excel.getCellData(sheetname, 1, 3);
		 * 
		 * data[2][0]=excel.getCellData(sheetname, 0, 4);
		 * data[2][1]=excel.getCellData(sheetname, 1, 4);
		 */
	   
	   for (int rows=2;rows<=rowNum;rows++)
		   
	   {
		   for (int cols=0;cols<colNum;cols++)
		   {  
			   
			   data[rows-2][cols]=excel.getCellData(sheetname, cols,rows);
		   }
	   }
	   
	   return data;
	   
   }
   
}
