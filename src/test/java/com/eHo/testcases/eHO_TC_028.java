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
import com.eHo.pageobjects.InternalClientSearch;
import com.eHo.pageobjects.NavigationPage;
import com.eHo.pageobjects.RecordLevelPolicyDetailPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_028 extends BaseTest {
	@SuppressWarnings("unused") 
	public void foo() {
		  String s;
		 }
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	@Test public void TC_028Test() // record level 
	{
		try
		{
		test=rep.startTest("TC_028 Test");
		test.log(LogStatus.INFO, "Starting the test case to check the basic flow of record level policy creation ");
		openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
		navigate("appURL");//to navigate to the application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
		test.log(LogStatus.INFO, "Clicked submit button");
		NavigationPage navigationPage=new NavigationPage(driver);
		
		// create a policy 
		
	
	
	ClientSearchPage clientSearch=new ClientSearchPage(driver);
		ClientPolicies clientPolicies=new ClientPolicies(driver);
		RecordLevelPolicyDetailPage recordLevelPolicyDetailPage=new RecordLevelPolicyDetailPage(driver);
		
		navigationPage.clickConsent();
		navigationPage.clickManagement();
	
		clientSearch.clickByPCR_idtab();
		clientSearch.setPCR_ID("AUTO99");
		test.log(LogStatus.INFO, "Searching by pcr Id");
		clientSearch.clickSearch();
		clientSearch.clickClientName();
		clientPolicies.clickNewDirective();
		logger.info("TC_028 record level policy creation began  ");
		
		clientPolicies.clickRecordLevel();
		recordLevelPolicyDetailPage.selectDirectiveOutcome("Deny"); 
		recordLevelPolicyDetailPage.setPolicyDescription("Record Level, domain specific, operator equals Policy");
		recordLevelPolicyDetailPage.selectDomainEqualNotEqual("Equal");
		recordLevelPolicyDetailPage.selectDomainType("CDR");
		recordLevelPolicyDetailPage.selectRecordEqualOrNot("Equal");
		recordLevelPolicyDetailPage.selectRecordType();
		recordLevelPolicyDetailPage.setRecordText("ABC");
		recordLevelPolicyDetailPage.clickSave();
		
		String expectedMessage="Policy was saved successfully.";
		String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		recordLevelPolicyDetailPage.clickBack();
		logger.info("TC_028 record level policy is created  ");
		
		//checking if the policy is created 

		 actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).getText();
		 expectedMessage="Record Level, domain specific, operator equals Policy";
		
		 softAssert.assertEquals(expectedMessage, actualMessage);
		
		 logger.info("TC_028 record level policy is created  in the policy table ");
			
		Thread.sleep(1000);
		 
		navigationPage.clickConsent();
		navigationPage.clickResolvePCRChanges();
		navigationPage.clickInternalClientSearch();
		InternalClientSearch internalclientsearch= new InternalClientSearch(driver);
		internalclientsearch.clickinternalID();
		internalclientsearch.setTxtEcid("AUTO99");
		 logger.info("TC_028 search by ecid value ");
			
		internalclientsearch.clickbtnSearch();
		String nameProp= prop.getProperty("name");
		System.out.println(nameProp);
		
		
		
		String actualSource=driver.getPageSource();
		boolean a= actualSource.contains(nameProp);
		
		System.out.println(a);
		
		
		
		
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
		
		// revoke the policy 
		navigationPage.clickConsent();
		navigationPage.clickManagement();
		
		clientSearch.clickByPCR_idtab();
		clientSearch.setPCR_ID("AUTO99");
		logger.info("TC_028 seaching by PCR  id ");
		
		
		test.log(LogStatus.INFO, "Searching Id");
		clientSearch.clickSearch();
		clientSearch.clickClientName();
		
		recordLevelPolicyDetailPage.clickPolicy();
		recordLevelPolicyDetailPage.clickRevoke();
		recordLevelPolicyDetailPage.clickYesConfirmation();
		
		 logger.info("TC_028 policy is revoked  ");
			
		  expectedMessage="Policy was revoked successfully.";
		 	actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
		
		softAssert.assertEquals(expectedMessage, actualMessage);
		recordLevelPolicyDetailPage.clickCloseMessageBox();
	
		logger.info("TC_028 policy execution reached end of execution  ");
		
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

