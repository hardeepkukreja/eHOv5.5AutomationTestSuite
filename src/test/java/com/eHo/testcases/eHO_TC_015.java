package com.eHo.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.ClientPolicies;
import com.eHo.pageobjects.ClientSearchPage;
import com.eHo.pageobjects.HicRecordsPage;
import com.eHo.pageobjects.NavigationPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_015 extends BaseTest{

	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	@Test
	public void TC_015Test()
	{
		try
		{
			test=rep.startTest("TC_015Test");
			test.log(LogStatus.INFO, "Starting the test case to check the basic flow of HIC record level policy creation ");
			openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
			navigate("appURL");//to navigate to the application
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
			test.log(LogStatus.INFO, "Clicked submit button");
			NavigationPage navigationPage=new NavigationPage(driver);
			ClientSearchPage clientSearch=new ClientSearchPage(driver);
			ClientPolicies clientPolicies=new ClientPolicies(driver);
			HicRecordsPage hicRecordsPage=new HicRecordsPage(driver);
			navigationPage.clickConsent();
			navigationPage.clickManagement();
			clientSearch.setID(prop.getProperty("id"));
			test.log(LogStatus.INFO, "Searching Id");
			clientSearch.clickSearch();
			clientSearch.clickClientName();
			clientPolicies.clickNewDirective();
			clientPolicies.clickHICRecords();
			hicRecordsPage.selectDirectiveOutcome("Deny");
			hicRecordsPage.setPolicyDescription("Record Domain specified , operator Not Equals, Deny Policy");
			hicRecordsPage.clickDomainAll();
			hicRecordsPage.selectCustodiansExclude();
			hicRecordsPage.selectCustodians("HIC Source 1");
			hicRecordsPage.clickSave();
			String expectedMessage="Policy was saved successfully.";
			String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
			softAssert.assertEquals(expectedMessage, actualMessage);
			hicRecordsPage.clickBack();
			actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).getText();
			 expectedMessage="Record Domain specified , operator Not Equals, Deny Policy";			
			 softAssert.assertEquals(expectedMessage, actualMessage);
			
			 hicRecordsPage.clickPolicy();
			 hicRecordsPage.clickRevoke();
			 hicRecordsPage.clickYesConfirmation();
				
			expectedMessage="Policy was revoked successfully.";
			actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
				
				softAssert.assertEquals(expectedMessage, actualMessage);
				hicRecordsPage.clickCloseMessageBox();
			
				System.out.println("Passed TC _015");
		
				}		
		catch(Exception ex)
		{
			softAssert.assertFalse(true);
			test.log(LogStatus.FAIL, "Test case is fail");
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
	




