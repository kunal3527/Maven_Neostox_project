package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class UtilityforProperty {

	
	public static String readDataFromProperties(String key) throws IOException
	
	{
	Properties p=new Properties();
	FileInputStream myfile=new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\D1 16th JulyA Selenium Framework_Study\\Neostox.properties");
	p.load(myfile);
	Reporter.log("Reading "+key+" from property file",true);
	String value = p.getProperty(key);
	System.out.println(value);
	return value;
	}
	
	
	public static void Screenshot(WebDriver driver, String ScreenshotName) throws IOException
	{
		wait(driver, 1000);
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
	File dest=new File("C:\\Users\\DELL\\eclipse-workspace\\D1 16th JulyA Selenium Framework_Study\\Screenshots\\Screenshot\\"+ScreenshotName+".png");	
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
