package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Utility.CommenUtility;

public class NeostoxSignupPage {

	@FindBy(id = "MainContent_signinsignup_txt_mobilenumber")private WebElement MobileNumber;
	@FindBy(id = "lnk_signup1")private WebElement SignupButton;
	
	public NeostoxSignupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	public void entermob_no(WebDriver driver,String Mob_No) 
	{
		
		MobileNumber.sendKeys(Mob_No);
		Reporter.log("Entering Mobile Number",true);
	}
	
	public void clicksignupbutton(WebDriver driver)
	{
		
	    SignupButton.click();	
	    Reporter.log("Clicking on signup Button",true);
	}
	
	
	
	
	
	
}
