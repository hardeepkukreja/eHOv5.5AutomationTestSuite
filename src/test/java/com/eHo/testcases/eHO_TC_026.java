package com.eHo.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.NavigationPage;
import com.eHo.pageobjects.SystemDirectivePage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_026 extends BaseTest{
	
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	@Test
	public void TC_026Test() // record level 
	{
		try
		{
		test=rep.startTest("TC_026 Test");
		test.log(LogStatus.INFO, "Starting the test case to check the basic flow of record level policy creation ");
		openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
		navigate("appURL");//to navigate to the application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
		test.log(LogStatus.INFO, "Clicked submit button");
		NavigationPage navigationPage=new NavigationPage(driver);
		
		navigationPage.clickConsent();
		navigationPage.clickSystemDirectives();
		SystemDirectivePage systemdirectivepage= new SystemDirectivePage(driver);
		systemdirectivepage.clickBtnNewDirective();
		systemdirectivepage.clickBtnAdvanced();
		systemdirectivepage.setTxtDirectiveTitle("Automation Title for directive");
		systemdirectivepage.clickBtnSave();
		systemdirectivepage.setTxtSaveComment("Comment from automation script");
		systemdirectivepage.clickBtnSaveContinue();
		
		
		// information Message has been sent successfully to Consent Validation to reload the system directive cache.
		
		String expectedMessage="Message has been sent successfully to Consent Validation to reload the system directive cache.";
		String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		systemdirectivepage.clickBtnBack();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   
		Date date = new Date();   
		String currentDate= formatter.format(date);
		System.out.println(currentDate);
		String actualDate=driver.findElement(By.xpath(".//*[@id='0']/td[3]")).getText();	
		System.out.println(actualDate); 
		softAssert.assertEquals(currentDate, actualDate);	
			
	/*	 if(currentDate==actualDate)
		{
			
			System.out.println("Passed date");
			softAssert.assertFalse(false);
		}
		else
		{ softAssert.assertFalse(true);
		}
			
			*/
		String actualSource=driver.getPageSource();
		boolean a= actualSource.contains("Automation Title for directive");
		
		if(a==true)
		{	
			System.out.println("Passed");
			softAssert.assertFalse(false);
		}	
		else
		{ 
			System.out.println(" else Passed");
			softAssert.assertFalse(true);
		}
		
		
		// revoke SD 
		systemdirectivepage.clickActiveDirective();
			systemdirectivepage.clickBtnRevoke();
		
		systemdirectivepage.clickBtnRevokeContinue();
		
		
		 expectedMessage="Message has been sent successfully to Consent Validation to reload the system directive cache.";
		 actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);	
		systemdirectivepage.clickBtnBack();
		
		}
		catch(Exception ex)
		{
			
			softAssert.assertFalse(true);
			test.log(LogStatus.FAIL, "Test case for record level is failed");
			test.log(LogStatus.INFO, ex.getLocalizedMessage());
		}		
	softAssert.assertAll();
}
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		afterTest(result);
	} 
	}

