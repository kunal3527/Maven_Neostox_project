package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Utility.CommenUtility;

public class NeostoxSignInPage {
@FindBy(xpath = "(//a[text()='Sign In'])[1]")private WebElement signInButton;

public NeostoxSignInPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}
public void clickonSignupButton(WebDriver driver)
{CommenUtility.wait(driver, 1000);
	
signInButton.click();
Reporter.log("cliking on signin button", true);
}
}
