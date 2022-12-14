package TestCases;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import Base.NeoStoxBase;
import Pages.NeoStoxHomePage;
import Pages.NeoStoxPasswordPage;
import Pages.NeostoxSignInPage;
import Pages.NeostoxSignupPage;
import Utility.CommenUtility;
import Utility.UtilityforProperty;


import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;




@Listeners(Utility.Listerner_study.class)
public class NeoStoxTestclass extends NeoStoxBase {

	
	NeostoxSignupPage signup;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	NeostoxSignInPage signin;
//	@Parameters("Browsername")
	@BeforeClass
 public void launchNeoStox() throws IOException 
 { 
	 launchchromebrowser();
//	 if(bname.equals("chrome"))	
//	 {	
//	 launchchromebrowser();
//	 }
//	 else if(bname.equals("firefox")){
//		 launchFirfoxbrowser();
//	   }
	 signup=new NeostoxSignupPage(driver); 
	 password=new NeoStoxPasswordPage(driver);
	 home=new NeoStoxHomePage(driver);
	 signin=new NeostoxSignInPage(driver);
 }
	
	@BeforeMethod
	public void LoginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
	{Thread.sleep(1000);
    signin.clickonSignupButton(driver);
    CommenUtility.wait(driver, 3000);
	signup.entermob_no(driver,UtilityforProperty.readDataFromProperties("Mob_No"));
	signup.clicksignupbutton(driver);
	// driver.navigate().refresh();
	CommenUtility.wait(driver, 2000);
	password.enterpassword(driver, UtilityforProperty.readDataFromProperties("password"));
    Thread.sleep(1000);
    password.entersubmitButton();
    
    Thread.sleep(5000);
    home.handlePopUp(driver);
   
    
	}
	@Test
	 public void validateUserID() throws EncryptedDocumentException, IOException
	{
	Assert.assertEquals(home.getActualUserName(driver), 
	UtilityforProperty.readDataFromProperties("username"),"TC is failed Actual and expected User Name are not matching");
	//CommenUtility.Screenshot(driver, home.getActualUserName(driver));
	}
	@Test
	public void validatebalance() throws IOException, InterruptedException
	{
		Assert.fail();
		Thread.sleep(1000);
		Assert.assertNotNull(home.getAccBalance(driver), "TC is failed unable to fetch balance");
	//	CommenUtility.Screenshot(driver, home.getAccBalance(driver));
	}
	@AfterMethod
	public void logOut()
	{
		
	home.logout(driver);
		
	}
	@AfterClass
	public void closebrowser(){
		
		driver.close();
		
	}
	
	
	
	
	
	
	
}
