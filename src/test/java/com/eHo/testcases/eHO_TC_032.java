package com.eHo.testcases;
		
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eHo.basetest.BaseTest;
import com.eHo.pageobjects.AgentPolicyDetailPage;
import com.eHo.pageobjects.AgentSelectPage;
import com.eHo.pageobjects.ClientPolicies;
import com.eHo.pageobjects.ClientSearchPage;
import com.eHo.pageobjects.GlobalPage;
import com.eHo.pageobjects.HicAgentsPage;
import com.eHo.pageobjects.HicRecordsPage;
import com.eHo.pageobjects.NavigationPage;
import com.eHo.pageobjects.RecordLevelPolicyDetailPage;
import com.eHo.pageobjects.SystemDirectivePage;
import com.eHo.pageobjects.TestPage;
import com.relevantcodes.extentreports.LogStatus;
		
		
		public class eHO_TC_032 extends BaseTest 
		{
			String actualMessage, expectedMessage; 
			@BeforeMethod()
			public void setUp()
			{
				init();	//this is the method of BaseTest class to perform initialization
		}
		
		@Test (priority=1)
		
		public void TC_032Test01()
		{
			
		try
		{
		test=rep.startTest("TC_032 Test");
		test.log(LogStatus.INFO, "Starting the test case to check the basic flow of  creation of all different types of policy and testing in the test tab ");
		openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
		navigate("appURL");//to navigate to the application
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
		test.log(LogStatus.INFO, "Clicked submit button");
		NavigationPage navigationPage=new NavigationPage(driver);
		ClientSearchPage clientSearch=new ClientSearchPage(driver);
		SystemDirectivePage systemdirectivepage= new SystemDirectivePage(driver);
		ClientPolicies clientPolicies=new ClientPolicies(driver);
		RecordLevelPolicyDetailPage recordLevelPolicyDetailPage=new RecordLevelPolicyDetailPage(driver);
		AgentPolicyDetailPage agentPolicyDetailPage=new AgentPolicyDetailPage(driver);
		TestPage testpage= new TestPage(driver);
		HicAgentsPage hicAgentsPage= new HicAgentsPage(driver);		
		HicRecordsPage hicRecordsPage=new HicRecordsPage(driver);
		AgentSelectPage agentSelectPage=new AgentSelectPage(driver);
		GlobalPage globalpage= new GlobalPage(driver);
//	 	System Directive 	
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
		logger.info("TC_032 System Directive is creation began  ");	
			navigationPage.clickConsent();
			navigationPage.clickSystemDirectives();
			System.out.println("clickSystemDirectives");
			systemdirectivepage.clickBtnNewDirective();
			systemdirectivepage.clickBtnAdvanced();
			systemdirectivepage.setTxtDirectiveTitle("Default System Directive");
			systemdirectivepage.ClickExecuteFirstNo();
			systemdirectivepage.clickBtnSave();
			systemdirectivepage.setTxtSaveComment("Comment from automation script");
			systemdirectivepage.clickBtnSaveContinue();
			expectedMessage="Message has been sent successfully to Consent Validation to reload the system directive cache.";
			actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
			softAssert.assertEquals(expectedMessage, actualMessage);
			systemdirectivepage.clickBtnBack();
			
			String actualSource=driver.getPageSource();
			boolean a= actualSource.contains("Default System Directive");
			
			if(a==true)
			{	
				System.out.println("Passed");
			}	
			else
			{ 
				System.out.println(" else Passed");
				softAssert.assertFalse(true);
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
			logger.info("TC_032 System Directive is creation ended  ");	
			
	// policy creation 	
			logger.info("TC_032policy creation 	 began ");	
			
		 navigationPage.clickConsent();
		navigationPage.clickManagement();
		clientSearch.setID(prop.getProperty("id"));
		test.log(LogStatus.INFO, "Searching Id");
		clientSearch.clickSearch();
		clientSearch.clickClientName();
	   clientPolicies.clickNewDirective();
		clientPolicies.clickRecordLevel();
// record level policy 
		logger.info("TC_032record level policy creation started  ");	
		
		recordLevelPolicyDetailPage.selectDirectiveOutcome("Deny");  
		recordLevelPolicyDetailPage.setPolicyDescription("Record domain Deny Policy");
		recordLevelPolicyDetailPage.selectDomainEqualNotEqual("Equal");
		recordLevelPolicyDetailPage.selectDomainType("CDR");
		recordLevelPolicyDetailPage.selectRecordEqualOrNot("Equal");
		recordLevelPolicyDetailPage.selectRecordType();
		recordLevelPolicyDetailPage.setRecordText("123");
		recordLevelPolicyDetailPage.clickSave();
		String expectedMessage="Policy was saved successfully.";
		String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		recordLevelPolicyDetailPage.clickBack();
		//checking if the policy is created 
		actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).getText();
		expectedMessage="Record domain Deny Policy";
		softAssert.assertEquals(expectedMessage, actualMessage);
		logger.info("TC_032record level policy ended ");	
		
//agent  level -2		
	System.out.println(" agent level policy  creation ");	
	logger.info("TC_032  agent level policy  creation  ");	
	
		clientPolicies.clickNewDirective();
		clientPolicies.clickAgent();
		agentPolicyDetailPage.selectDirectiveOutcome("Deny");
		agentPolicyDetailPage.setPolicyDescription("Agent Domain Deny Policy");
		agentPolicyDetailPage.clickDomainSpecify();
		agentPolicyDetailPage.selectDomainDD("CDR");
		agentPolicyDetailPage.clickAdd();
		agentSelectPage.setTxtLastName("Smith");
		agentSelectPage.clickbtnSearch();
		agentSelectPage.clickIdAgentSelect();
		agentSelectPage.clickBtnReturn();
		agentPolicyDetailPage.clickSave();
		expectedMessage="Policy was saved successfully.";
		actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		agentPolicyDetailPage.clickBack();
		actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:1:j_id_6l']")).getText();
		expectedMessage="Agent Domain Deny Policy";			
		softAssert.assertEquals(expectedMessage, actualMessage);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		logger.info("TC_032  agent level policy  ended  ");	
		
//HIC Agent level 		
		
		System.out.println(" HIC Agent level policy  creation ");		
		logger.info("TC_032  HIC agent level policy  creation  ");	
		
		clientPolicies.clickNewDirective();
		clientPolicies.clickHICAgents();
		hicAgentsPage.selectDirectiveOutcome("Deny");
		hicAgentsPage.clickDomainSpecify();
		hicAgentsPage.selectDomainDD("CDR");
		hicAgentsPage.setPolicyDescription("HIC-Agent Domain");
		//hicAgentsPage.selectCustodiansInclude();
		hicAgentsPage.clickAddCustodian();
		hicAgentsPage.txtOrganisationNameValue("Toronto");
		hicAgentsPage.txtMuncipalityValue("Toronto");
		hicAgentsPage.clickSearch();
		hicAgentsPage.clickSelectedCity();
		hicAgentsPage.clickReturnValue();
		hicAgentsPage.clickSave();
		String expectedMessage2="Policy was saved successfully.";
		String actualMessage2=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();				
		softAssert.assertEquals(expectedMessage2, actualMessage2);
		hicAgentsPage.clickBack();
		actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:2:j_id_6l']")).getText();
		expectedMessage="HIC-Agent Domain";			
		softAssert.assertEquals(expectedMessage, actualMessage);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("TC_032  HIC agent level policy ended  ");	
		
//hic records level
		System.out.println(" HIC Record level policy  creation ");		
		logger.info("TC_032  HIC agent level policy creation  ");	
				
		clientPolicies.clickNewDirective();
		clientPolicies.clickHICRecords();
		hicRecordsPage.selectDirectiveOutcome("Deny");
		hicRecordsPage.setPolicyDescription("HIC-Record Policy");
	//	hicRecordsPage.clickDomainSpecify();
	//	hicRecordsPage.selectDomainDD("CDR");
		hicRecordsPage.selectCustodiansEqual();
		hicRecordsPage.selectCustodians("Hic Source 1");
		hicRecordsPage.clickSave();
		String expectedMessage4="Policy was saved successfully.";
		String actualMessage4=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage4, actualMessage4);
		hicRecordsPage.clickBack();
		actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:3:j_id_6l']")).getText();
		expectedMessage="HIC-Record Policy";			
		softAssert.assertEquals(expectedMessage, actualMessage);
		logger.info("TC_032  HIC-Record Policy ended  ");	
		
		
// Global level 				
		System.out.println(" Global level policy  creation ");		
		logger.info("TC_032  Global level policy  creation  ");	
			
		clientPolicies.clickNewDirective();
		clientPolicies.clickGlobal();
		globalpage.selectDirectiveOutcome("Deny");
		globalpage.setPolicyDescription("Global Domain Policy");
		globalpage.clickDomainAll();
		globalpage.clickSave();
		expectedMessage4="Policy was saved successfully.";
		actualMessage4=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage4, actualMessage4);
		globalpage.clickBack();
		actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:4:j_id_6l']")).getText();
		expectedMessage="Global Domain Policy";			
		softAssert.assertEquals(expectedMessage, actualMessage);
	
		logger.info("TC_032  Global level policy  ended  ");	
		
// logic for Testpage 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		logger.info("TC_032  test page for policy record level  ");	
		
		testpage.clickTestTab();
		 testpage.clickBtnAdd();
		 testpage.clickBtnAgent();
		 testpage.setLastNameAgent("Smith");
		 testpage.clickbtnSearch();
		 testpage.clickIdAgentSelect();
		 testpage.clickBtnReturn();
		 testpage.clickBtnAdd();
		 testpage.clickbtnOrganisation();
		 testpage.setTxtOrgName("Toronto");
		 testpage.setTxtOrgMuncipality("Toronto");
		 testpage.clickbtnSearch();
		 testpage.clickIdOrgSelect();
		 testpage.clickBtnReturn();		 
		 //specify PHI 
		testpage.clickSpecifyPHI();
		testpage.clickBtnAddPHI();
		testpage.setdocumentID("DI");
		testpage.setdocumIDValue("123");
		testpage.setdomainID("CDR");
		testpage.clickDonePHI();
		testpage.clickBtnPerformCheck();
// assertions 
		 actualMessage= driver.findElement(By.xpath(".//*[@id='test:j_id_cd:tbody_element']/tr/td[4]/span")).getText();
		System.out.println(actualMessage);
		expectedMessage ="Record domain Deny Policy";
		softAssert.assertEquals(expectedMessage, actualMessage); 
		testpage.clickCloseResponse();
System.out.println("revoke record level started ");
//revoke record level policy 
		clientPolicies.clickPolicyListTab();
		recordLevelPolicyDetailPage.clickPolicy();
		recordLevelPolicyDetailPage.clickRevoke();
		recordLevelPolicyDetailPage.clickYesConfirmation();
		expectedMessage="Policy was revoked successfully.";
		actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
		softAssert.assertEquals(expectedMessage, actualMessage);
		recordLevelPolicyDetailPage.clickCloseMessageBox();
		recordLevelPolicyDetailPage.clickBack();	
System.out.println("revoke record level ended  ");	
logger.info("TC_032  test revoke record level ended  ");	

	// back to test tab 		
		testpage.clickTestTab();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("TC_032  test Agent Domain Deny Policy ");	

		testpage.clickBtnAdd();
		
		testpage.clickBtnAgent();
	
		testpage.setLastNameAgent("Smith");
		testpage.clickbtnSearch();
		testpage.clickIdAgentSelect();
		testpage.clickBtnReturn();
		testpage.clickBtnAdd();
		testpage.clickbtnOrganisation();
		testpage.setTxtOrgName("Toronto");
		testpage.setTxtOrgMuncipality("Toronto"); 
		testpage.clickbtnSearch();
		testpage.clickIdOrgSelect();
		testpage.clickBtnReturn();	
		testpage.clickBtnAddPHI();
		testpage.setdomainID("CDR");
		testpage.clickDonePHI();
		testpage.clickBtnPerformCheck();
		// assertion
		actualMessage= driver.findElement(By.xpath(".//*[@id='test:j_id_cd:tbody_element']/tr/td[4]/span")).getText();
		System.out.println(actualMessage);
		expectedMessage ="Agent Domain Deny Policy";
		softAssert.assertEquals(expectedMessage, actualMessage); 
		testpage.clickCloseResponse();
		System.out.println("revoke agent level started 2 ");
// revoke agent level policy 
		clientPolicies.clickPolicyListTab();
		agentPolicyDetailPage.clickPolicy();
		agentPolicyDetailPage.clickRevoke();
	// new change 	
		recordLevelPolicyDetailPage.clickYesConfirmation();
		
		
		
		expectedMessage="Policy was revoked successfully.";
		actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
		softAssert.assertEquals(expectedMessage, actualMessage);
		agentPolicyDetailPage.clickCloseMessageBox(); 
		agentPolicyDetailPage.clickBack();
		logger.info("TC_032  test Agent Domain Deny Policy ");	

		System.out.println("revoke agent level started 2 ");	
// test for hic agent  
		testpage.clickTestTab();
		testpage.clickBtnAdd();
		testpage.clickBtnAgent();
		testpage.setLastNameAgent("Smith");
		testpage.clickbtnSearch();
		testpage.clickIdAgentSelect();
		testpage.clickBtnReturn();
		testpage.clickBtnAdd();
		testpage.clickbtnOrganisation();
		testpage.setTxtOrgName("Toronto");
		testpage.setTxtOrgMuncipality("Toronto"); 
		testpage.clickbtnSearch();
		testpage.clickIdOrgSelect();
		testpage.clickBtnReturn();		
		testpage.clickBtnAddPHI();
		testpage.setdomainID("CDR"); 
		testpage.clickDonePHI();
		testpage.clickBtnPerformCheck();
// assertion
		actualMessage= driver.findElement(By.xpath(".//*[@id='test:j_id_cd:tbody_element']/tr/td[4]/span")).getText();
		System.out.println(actualMessage);
		expectedMessage ="HIC-Agent Domain";
		Thread.sleep(2000); // change 
		softAssert.assertEquals(expectedMessage, actualMessage); 
		testpage.clickCloseResponse();
		logger.info("TC_032  HIC-Agent Domain policy present ");	
	
// revoke hic agent
		logger.info("TC_032  HIC-Agent Domain policy revoking  ");	
		
		clientPolicies.clickPolicyListTab();
		 hicAgentsPage.clickPolicy();
		 hicAgentsPage.clickRevoke();
		 recordLevelPolicyDetailPage.clickYesConfirmation();
			
		expectedMessage="Policy was revoked successfully.";
		actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();			
		softAssert.assertEquals(expectedMessage, actualMessage);
		hicAgentsPage.clickCloseMessageBox();
		agentPolicyDetailPage.clickBack();
		

// test for hic record 
		logger.info("TC_032  HIC-record Domain policy revoking  ");	
			
		testpage.clickTestTab();
		testpage.clickBtnAdd();
		testpage.clickBtnAgent();
		testpage.setLastNameAgent("Smith");
		testpage.clickbtnSearch();
		testpage.clickIdAgentSelect();
		testpage.clickBtnReturn();
		testpage.clickBtnAdd();
		testpage.clickbtnOrganisation();
		testpage.setTxtOrgName("Toronto");
		testpage.setTxtOrgMuncipality("Toronto"); 
		testpage.clickbtnSearch();
		testpage.clickIdOrgSelect();
		testpage.clickBtnReturn();		
		
		testpage.clickBtnAddPHI();
		testpage.setHicSource("Hic Source 1");		
		testpage.clickDonePHI();
		testpage.clickBtnPerformCheck();
Thread.sleep(1000);



 

// assertion
		actualMessage= driver.findElement(By.xpath(".//*[@id='test:j_id_cd:tbody_element']/tr/td[4]/span")).getText();
		System.out.println(actualMessage);
		expectedMessage ="HIC-Record Policy";
		softAssert.assertEquals(expectedMessage, actualMessage); 
		testpage.clickCloseResponse();
		logger.info("TC_032  HIC-record Domain policy present in test tab  ");	
			
// revoke hic record page 		
		clientPolicies.clickPolicyListTab();
		 hicRecordsPage.clickPolicy();
		 hicRecordsPage.clickRevoke();
		 recordLevelPolicyDetailPage.clickYesConfirmation();
			
		// hicRecordsPage.clickYesConfirmation();	
		expectedMessage="Policy was revoked successfully.";
		actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
		softAssert.assertEquals(expectedMessage, actualMessage);
		hicRecordsPage.clickCloseMessageBox();
		agentPolicyDetailPage.clickBack();
		logger.info("TC_032  HIC-record Domain policy revoked ");	
				
			
// global policy test tab 
		logger.info("TC_032 global policy  Domain policy test  began ");	
		
					testpage.clickTestTab();
				testpage.clickBtnAdd();
				testpage.clickBtnAgent();
				testpage.setLastNameAgent("Smith");
				testpage.clickbtnSearch();
				testpage.clickIdAgentSelect();
				testpage.clickBtnReturn();
				testpage.clickBtnAdd();
				testpage.clickbtnOrganisation();
				testpage.setTxtOrgName("Toronto");
				testpage.setTxtOrgMuncipality("Toronto"); 
				testpage.clickbtnSearch();
				testpage.clickIdOrgSelect();
				testpage.clickBtnReturn();	
		//		testpage.clickSpecifyPHI(); // check this 
				testpage.clickBtnPerformCheck();
		// assertion
				actualMessage= driver.findElement(By.xpath(".//*[@id='test:j_id_cd:tbody_element']/tr/td[4]/span")).getText();
				System.out.println(actualMessage);
				expectedMessage ="Global Domain Policy";
				softAssert.assertEquals(expectedMessage, actualMessage); 
				testpage.clickCloseResponse();				
// revoke policy global 
				logger.info("TC_032 global policy  Domain policy revoke policy began ");	
				
				
				clientPolicies.clickPolicyListTab();
				
				globalpage.clickPolicy();
				globalpage.clickRevoke();
			//	globalpage.clickYesConfirmation();
				 recordLevelPolicyDetailPage.clickYesConfirmation();
				expectedMessage="Policy was revoked successfully.";
				actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();			
				softAssert.assertEquals(expectedMessage, actualMessage);
				globalpage.clickCloseMessageBox();
				agentPolicyDetailPage.clickBack();
				logger.info("TC_032 global policy  Domain policy revoked ");	
					
				
	// checking for System Directive 			
				logger.info("TC_032  checking for System Directive ");	
				
				testpage.clickTestTab();
				 testpage.clickBtnAdd();
				 testpage.clickBtnAgent();
				 testpage.setLastNameAgent("Smith");
				 testpage.clickbtnSearch();
				 testpage.clickIdAgentSelect();
				 testpage.clickBtnReturn();
				 testpage.clickBtnAdd();
				 testpage.clickbtnOrganisation();
				 testpage.setTxtOrgName("Toronto");
				 testpage.setTxtOrgMuncipality("Toronto");
				 testpage.clickbtnSearch();
				 testpage.clickIdOrgSelect();
				 testpage.clickBtnReturn();		 
				 //specify PHI 
			
				testpage.clickBtnAddPHI();
				testpage.setdocumentID("DI");
				testpage.setdocumIDValue("123");
				testpage.setdomainID("CDR");
				testpage.clickDonePHI();
				testpage.clickBtnPerformCheck();
	// assertions 
				logger.info("TC_032  System Directive test began ");	
				
				
				actualMessage= driver.findElement(By.xpath(".//*[@id='test:j_id_cd:tbody_element']/tr/td[4]/span")).getText();
				System.out.println(actualMessage);        
				expectedMessage ="Default System Directive";
				softAssert.assertEquals(expectedMessage, actualMessage); 
				testpage.clickCloseResponse();	
	// last revoke system Directive, 
						
		navigationPage.clickConsent();
		navigationPage.clickSystemDirectives();
			// revoke SD 
		//systemdirectivepage.clickActiveDirective();
		logger.info("TC_032  System Directive revoke began ");	
		
		systemdirectivepage.clickActiveSD();
		systemdirectivepage.clickBtnRevoke();
		systemdirectivepage.clickBtnRevokeContinue();
		 expectedMessage="Message has been sent successfully to Consent Validation to reload the system directive cache.";
		 actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);	
		systemdirectivepage.clickBtnBack();
		
		logger.info("TC_032  System Directive revoked");	
		

		logger.info("TC_032  testcase ended");	
		
		
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
		
