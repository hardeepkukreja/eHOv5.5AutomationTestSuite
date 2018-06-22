package com.eHo.testcases;

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
		test.log(LogStatus.INFO, "creation of System Directive");
		openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
		navigate("appURL");//to navigate to the application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
		test.log(LogStatus.INFO, "Clicked submit button");
		NavigationPage navigationPage=new NavigationPage(driver);
		logger.info("TC_026 code is s testcase began  ");
		
		navigationPage.clickConsent();
		navigationPage.clickSystemDirectives();
		SystemDirectivePage systemdirectivepage= new SystemDirectivePage(driver);
		systemdirectivepage.clickBtnNewDirective();
		systemdirectivepage.clickBtnAdvanced();
		systemdirectivepage.setTxtDirectiveTitle("Automation Title TC26");
		systemdirectivepage.clickBtnSave();
		systemdirectivepage.setTxtSaveComment("Comment from automation script");
		systemdirectivepage.clickBtnSaveContinue();
		logger.info("TC_026 System CD is saved  ");
		
		// information Message has been sent successfully to Consent Validation to reload the system directive cache.
		
		String expectedMessage="Message has been sent successfully to Consent Validation to reload the system directive cache.";
		String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		systemdirectivepage.clickBtnBack();
		
	
		String actualSource=driver.getPageSource();
		boolean a= actualSource.contains("Automation Title TC26");
		
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
		
		
		systemdirectivepage.clickActiveSD();
		systemdirectivepage.clickBtnRevoke();
		systemdirectivepage.clickBtnRevokeContinue();
		logger.info("TC_026 System CD is revoked  ");
		
		
		 expectedMessage="Message has been sent successfully to Consent Validation to reload the system directive cache.";
		 actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);	
		systemdirectivepage.clickBtnBack();
		
		logger.info("TC_026 System CD test is complete  ");
		
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

