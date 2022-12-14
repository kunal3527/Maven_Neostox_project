package Utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import Base.NeoStoxBase;



public class Listerner_study extends NeoStoxBase implements ITestListener{

	
	public void onTestSuccess(ITestResult result) {
	   
	Reporter.log("Tc "+result.getName()+"======================is Successed",true);	
		
	}
	
	public void onTestFailure(ITestResult result) {
		Reporter.log("Tc "+result.getName()+"====================== is Failed",true);	
	   try {
		CommenUtility.Screenshot(driver, result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
	public void onTestSkipped(ITestResult result) {
		Reporter.log("TC "+result.getName()+" =====================is Skipped",true);
	}
}
