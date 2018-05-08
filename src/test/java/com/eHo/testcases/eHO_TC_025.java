//Maintenance Page - Purpose of Use table

package com.eHo.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.NavigationPage;
import com.eHo.pageobjects.PurposeOfUsePage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_025 extends BaseTest{	
	
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	
	@Test
	public void TC_025Test() // record level 
	{
		try
		{
		test=rep.startTest("TC_0025 Test");
		test.log(LogStatus.INFO, "Starting the test case to check the basic flow of record level policy creation ");
		openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
		navigate("appURL");//to navigate to the application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
		test.log(LogStatus.INFO, "Clicked submit button");
		NavigationPage navigationPage=new NavigationPage(driver);
		
		navigationPage.clickAdministration();
		navigationPage.clickListMaintainance();
		navigationPage.clickConsentList();
		navigationPage.clickPurposeOfUse();
		PurposeOfUsePage purposeofusepage= new PurposeOfUsePage(driver);
		purposeofusepage.setCode("12345");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		purposeofusepage.setDescription("POU Description");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		purposeofusepage.clickSave();
	
				
	
		
		String actualSource=driver.getPageSource();
		boolean a= actualSource.contains("12345");
		boolean b= actualSource.contains("POU Description");
		
		if(a==true && b==true)
		{	
			System.out.println("Passed");
			softAssert.assertFalse(false);
		}	
		
		else
		{
			System.out.println("failed");
			softAssert.assertFalse(true);
			
		}
		
		
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
