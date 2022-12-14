package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Utility.CommenUtility;

public class NeoStoxHomePage {
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement okButton;
	@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement closeButton;
	@FindBy(id="lbl_username") private WebElement userName;
	@FindBy(id = "lbl_curbalancetop") private WebElement acBalance;
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
	public NeoStoxHomePage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	public void handlePopUp(WebDriver driver) throws InterruptedException
	{
	if(okButton.isDisplayed()) {
	CommenUtility.wait(driver, 1000);
	okButton.click();
	Reporter.log("Handeling popup",true);
	Reporter.log("clicking on OK button of Popup", true);
	CommenUtility.wait(driver, 1000);
	closeButton.click();
	Reporter.log("clicking on Close button of Popup", true);}
	
		
else {
			
			CommenUtility.wait(driver, 2000);
			Reporter.log("waiting for page loading");
		}
	}
	 
	public String getActualUserName(WebDriver driver)
	{
		
	CommenUtility.wait(driver, 1000);
	String actualUserName = userName.getText();
	Reporter.log("getting actual user name",true);
	String realUserName = actualUserName.substring(3);
	Reporter.log("Actual user name is "+realUserName, true);
	return actualUserName;}
		
	
	public String getAccBalance(WebDriver driver)
	{
	CommenUtility.wait(driver, 1000);
	String accBalance = acBalance.getText();
	Reporter.log("getting accBalance ", true);
	Reporter.log("Account Balance is "+accBalance,true);
	return accBalance;
	}
	public void logout(WebDriver driver)
	{
		CommenUtility.wait(driver, 1000);	
         userName.click();
         CommenUtility.wait(driver, 1000);	
		logOutButton.click();
	}

}
