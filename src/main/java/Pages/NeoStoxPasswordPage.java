package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Utility.CommenUtility;

public class NeoStoxPasswordPage {
	@FindBy(id = "txt_accesspin")private WebElement password;
	@FindBy(xpath = "//a[text()='Submit']")private WebElement Submit;
	
	public NeoStoxPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterpassword( WebDriver driver,String pass)
	{
		
		password.sendKeys(pass);
		Reporter.log("Entering password",true);
	}
	
	public void entersubmitButton()
	{
		
	Submit.click();
	}
	
	
	
}
