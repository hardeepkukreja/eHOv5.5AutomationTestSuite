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
		test.log(LogStatus.INFO, "Starting the test case to check the basic flow of record level policy creation ");
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
		
		 navigationPage.clickConsent();
		navigationPage.clickManagement();
		clientSearch.setID(prop.getProperty("id"));
		test.log(LogStatus.INFO, "Searching Id");
		clientSearch.clickSearch();
		clientSearch.clickClientName();
		clientPolicies.clickNewDirective();
		clientPolicies.clickRecordLevel();
// record level policy 
		recordLevelPolicyDetailPage.selectDirectiveOutcome("Deny");  
		recordLevelPolicyDetailPage.setPolicyDescription("Record Level, domain specific, operator equals Policy");
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
		expectedMessage="Record Level, domain specific, operator equals Policy";
		softAssert.assertEquals(expectedMessage, actualMessage);
//agent  level -2		
			AgentSelectPage agentSelectPage=new AgentSelectPage(driver);
		clientPolicies.clickNewDirective();
		clientPolicies.clickAgent();
		agentPolicyDetailPage.selectDirectiveOutcome("Deny");
		agentPolicyDetailPage.setPolicyDescription("Agent Domain specified , operator Equals, Deny Policy");
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
		expectedMessage="Agent Domain specified , operator Equals, Deny Policy";			
		softAssert.assertEquals(expectedMessage, actualMessage);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
//HIC Agent level 		
		HicAgentsPage hicAgentsPage= new HicAgentsPage(driver);			
		clientPolicies.clickNewDirective();
		clientPolicies.clickHICAgents();
		hicAgentsPage.selectDirectiveOutcome("Deny");
		hicAgentsPage.clickDomainSpecify();
		hicAgentsPage.selectDomainDD("CDR");
		hicAgentsPage.setPolicyDescription("HIC-Agent Domain specified, operator Not Equals, Deny Policy");
		hicAgentsPage.selectCustodiansExclude();
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
		expectedMessage="HIC-Agent Domain specified, operator Not Equals, Deny Policy";			
		softAssert.assertEquals(expectedMessage, actualMessage);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//hic records agent
		HicRecordsPage hicRecordsPage=new HicRecordsPage(driver);
		clientPolicies.clickNewDirective();
		clientPolicies.clickHICRecords();
		hicRecordsPage.selectDirectiveOutcome("Deny");
		hicRecordsPage.setPolicyDescription("HIC record Deny Policy");
		hicRecordsPage.clickDomainSpecify();
		hicRecordsPage.selectDomainDD("CDR");
		hicRecordsPage.selectCustodiansExclude();
		hicRecordsPage.selectCustodians("Hic Source 1");
		hicRecordsPage.clickSave();
		String expectedMessage4="Policy was saved successfully.";
		String actualMessage4=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage4, actualMessage4);
		hicRecordsPage.clickBack();
		actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:3:j_id_6l']")).getText();
		expectedMessage="HIC record Deny Policy";			
		softAssert.assertEquals(expectedMessage, actualMessage);
		
// Global level 				
		GlobalPage globalpage= new GlobalPage(driver);
		clientPolicies.clickNewDirective();
		clientPolicies.clickGlobal();
		globalpage.selectDirectiveOutcome("Deny");
		globalpage.setPolicyDescription("Global Domain specified,deny Policy");
		globalpage.clickDomainAll();
		globalpage.clickSave();
		expectedMessage="Policy was saved successfully.";
		actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		globalpage.clickBack();
		actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:4:j_id_6l']")).getText();
		expectedMessage="Global Domain specified,deny Policy";			
		softAssert.assertEquals(expectedMessage, actualMessage);
	
// 	System Directive 	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		navigationPage.clickConsent();
		System.out.println("clickConsent");
		navigationPage.clickSystemDirectives();
		System.out.println("clickSystemDirectives");
		systemdirectivepage.clickBtnNewDirective();
		systemdirectivepage.clickBtnAdvanced();
		systemdirectivepage.setTxtDirectiveTitle("Default1");
		systemdirectivepage.ClickExecuteFirstNo();
		systemdirectivepage.clickBtnSave();
		systemdirectivepage.setTxtSaveComment("Comment from automation script");
		systemdirectivepage.clickBtnSaveContinue();
		expectedMessage="Message has been sent successfully to Consent Validation to reload the system directive cache.";
		actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
		softAssert.assertEquals(expectedMessage, actualMessage);
		systemdirectivepage.clickBtnBack();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   
		Date date = new Date();   
		String currentDate= formatter.format(date);
		System.out.println(currentDate);
		boolean actualdate=driver.getPageSource().contains(currentDate);
		if(actualdate==true)
		{	
			System.out.println("Passed");
			softAssert.assertFalse(false);
		}	
		
		else
		{ 
			System.out.println(" else Passed");
			softAssert.assertFalse(true);
		}
		System.out.println(actualdate); 
		String actualSource=driver.getPageSource();
		boolean a= actualSource.contains("Default1");
		
		if(a==true)
		{	
			System.out.println("Passed");
		}	
		else
		{ 
			System.out.println(" else Passed");
			softAssert.assertFalse(true);
		}
		
// logic for Testpage 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		navigationPage.clickConsent();
		navigationPage.clickManagement();
		clientSearch.setID(prop.getProperty("id"));
		clientSearch.clickSearch();
		clientSearch.clickClientName();	
		TestPage testpage= new TestPage(driver);	
		testpage.clickTestTab();
		 testpage.clickBtnAdd();
		 testpage.clickBtnAgent();
		 testpage.setLastNameAgent("Smith");
		 testpage.clickbtnSearch();
		 testpage.clickIdAgentSelect();
		 testpage.clickBtnReturn();
		 testpage.clickBtnAdd();
		 testpage.clickbtnOrganisation();
		 testpage.setTxtOrgName("SomeValue");
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
		expectedMessage ="Record Domain specified , operator Not Equals, Deny Policy";
		softAssert.assertEquals(expectedMessage, actualMessage); 
		testpage.clickCloseResponse();
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
// back to test tab 		
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
		testpage.clickSpecifyPHI();
		testpage.clickBtnAddPHI();
		testpage.setdomainID("CDR");
		testpage.clickDonePHI();
		testpage.clickBtnPerformCheck();
		// assertion
		actualMessage= driver.findElement(By.xpath(".//*[@id='test:j_id_cd:tbody_element']/tr/td[4]/span")).getText();
		System.out.println(actualMessage);
		expectedMessage ="Agent Domain specified , operator Equals, Deny Policy";
		softAssert.assertEquals(expectedMessage, actualMessage); 
		testpage.clickCloseResponse();
		
// revoke agent level policy 
		clientPolicies.clickPolicyListTab();
		agentPolicyDetailPage.clickPolicy();
		agentPolicyDetailPage.clickRevoke();
		agentPolicyDetailPage.clickYesConfirmation();
		expectedMessage="Policy was revoked successfully.";
		actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
		softAssert.assertEquals(expectedMessage, actualMessage);
		agentPolicyDetailPage.clickCloseMessageBox();
		agentPolicyDetailPage.clickBack();
		// last revoke system Directive, 
		// create System Directive  initially 
		navigationPage.clickConsent();
		navigationPage.clickSystemDirectives();
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
		
