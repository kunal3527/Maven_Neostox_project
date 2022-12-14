package Base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;

import Utility.UtilityforProperty;

public class NeoStoxBase {

	 public static WebDriver driver;
	
	public void launchchromebrowser() throws IOException 
	
	{
		
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAI\\Documents\\16th july A evnning//chromedriver.exe");
		    driver=new ChromeDriver();
		    driver.manage().window().maximize();
	        driver.get(UtilityforProperty.readDataFromProperties("Url"));
	        Reporter.log("Chrome is running",true);
		


	}
//		public void launchFirfoxbrowser() throws IOException
//		{
//			System.setProperty("webdriver.gecko.driver", "C:\\Users\\SAI\\Documents\\16th july A evnning\\geckodriver.exe");
//		    driver=new FirefoxDriver();
//		    driver.manage().window().maximize();
//		    driver.get(UtilityforProperty.readDataFromProperties("Url"));
//		    Reporter.log("Firefox is running",true);
//		}
	
	
	
}
