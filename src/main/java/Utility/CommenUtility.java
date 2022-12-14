package Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class CommenUtility {

	
	public static  String readExcel(int row,int cell) throws EncryptedDocumentException, IOException 
	{
		 
		 File myfile=new File("C:\\Users\\DELL\\eclipse-workspace\\D1 16th JulyA Selenium Framework_Study\\TestData\\Excel_sheet4.xlsx"); 
		 String value = WorkbookFactory.create(myfile).getSheet("Sheet2").getRow(row).getCell(cell).getStringCellValue();
	     Reporter.log("Reading value from excel sheet", true);
	     return value;
	
	}
	public static void Screenshot(WebDriver driver, String ScreenshotName) throws IOException
	{
		wait(driver, 1000);
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
	File dest=new File("C:\\Users\\DELL\\eclipse-workspace\\D1 16th JulyA Selenium Framework_Study\\Screenshots\\Screenshot"+ScreenshotName+".png");	
	FileHandler.copy(src, dest);
	Reporter.log("Taking Screenshot",true);
	}
  
	public static void wait(WebDriver driver,int waittime)
	{
		
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waittime));	
	Reporter.log("taking wait for "+waittime+" ms",true);	
	}
	
	public static void Scrolling(WebDriver driver, WebElement element)
	{
		wait(driver, 1000);
	 	JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		Reporter.log("Scrolling in to view",true);
		
	}
	
	
	
	
	
	
	
}
