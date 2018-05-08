// no policy for patient in internal client search 

package com.eHo.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.InternalClientSearch;
import com.eHo.pageobjects.NavigationPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_027 extends BaseTest {
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	@Test
	public void TC_027Test() // record level 
	{
		try
		{
		test=rep.startTest("TC_027 Test");
		test.log(LogStatus.INFO, "Starting the test case to check the basic flow of record level policy creation ");
		openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
		navigate("appURL");//to navigate to the application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
		test.log(LogStatus.INFO, "Clicked submit button");
		NavigationPage navigationPage=new NavigationPage(driver);
		navigationPage.clickConsent();
		navigationPage.clickResolvePCRChanges();
		navigationPage.clickInternalClientSearch();
		InternalClientSearch internalclientsearch= new InternalClientSearch(driver);
		internalclientsearch.clickinternalID();
		internalclientsearch.setTxtEcid("AUTO981");
		internalclientsearch.clickbtnSearch();
		// no policy for patient 
		String expectedMessage="This criteria results in 0 records found!";
		 String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);	
	
		System.out.println("EOT");
		
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

