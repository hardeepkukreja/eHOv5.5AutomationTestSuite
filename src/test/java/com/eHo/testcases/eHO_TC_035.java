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
import com.eHo.pageobjects.NavigationPage;
import com.eHo.pageobjects.RecordLevelPolicyDetailPage;
import com.eHo.pageobjects.TestPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_035 extends BaseTest 
	{
	String actualMessage, expectedMessage; 
	@BeforeMethod()
	public void setUp()
	{
		init();	
}

@Test (priority=1)
	
	public void TC_035Test()
	{
		
	try
	{
	test=rep.startTest("TC_035 Test");
	test.log(LogStatus.INFO, "Starting the test case to check the basic flow of over request in UI ");
	openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
	navigate("appURL");//to navigate to the application
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
	test.log(LogStatus.INFO, "Clicked submit button");
	NavigationPage navigationPage=new NavigationPage(driver);
	ClientSearchPage clientSearch=new ClientSearchPage(driver);
	ClientPolicies clientPolicies=new ClientPolicies(driver);
	RecordLevelPolicyDetailPage recordLevelPolicyDetailPage=new RecordLevelPolicyDetailPage(driver);		
	navigationPage.clickConsent();
	navigationPage.clickManagement();
	clientSearch.setID(prop.getProperty("id")); // need to change to a new id 
	test.log(LogStatus.INFO, "Searching Id");

	logger.info("TC_035  Searching id");	
	
	clientSearch.clickSearch();
	clientSearch.clickClientName();
    clientPolicies.clickNewDirective();
	clientPolicies.clickRecordLevel();
	// put policy Deny 
	recordLevelPolicyDetailPage.selectDirectiveOutcome("Deny");  
	recordLevelPolicyDetailPage.setPolicyDescription("Record Level Policy-Automation");
	recordLevelPolicyDetailPage.selectDomainEqualNotEqual("Equal");
	recordLevelPolicyDetailPage.selectDomainType("CDR");
	recordLevelPolicyDetailPage.selectRecordEqualOrNot("Equal");
	recordLevelPolicyDetailPage.selectRecordType();
	recordLevelPolicyDetailPage.setRecordText("123");
	recordLevelPolicyDetailPage.clickSave();
	logger.info("TC_035  Policy was saved successfully.");	
	
	String expectedMessage="Policy was saved successfully.";
	String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
	softAssert.assertEquals(expectedMessage, actualMessage);
	recordLevelPolicyDetailPage.clickBack();
	logger.info("TC_035  checking if the policy is created ");	
	
	//checking if the policy is created 
	actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).getText();
	expectedMessage="Record Level Policy-Automation";
	softAssert.assertEquals(expectedMessage, actualMessage);
	// test tab  
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
// override test 
	logger.info("TC_035  checking override test began ");	
	
	testpage.clickSpecifyOverride();
	testpage.setOverride_code(); // select index 2 
	testpage.setOverrideReason("Automation testing override");	
	testpage.clickBtnPerformCheck();
//assertions Temporary Override Requested";
	logger.info("TC_035  Temporary Override Requested ");	
	
	actualMessage= driver.findElement(By.xpath(".//*[@id='responseDialog']/div/span[1]")).getText();
	System.out.println( actualMessage);
	expectedMessage ="Disclosure of PHI is allowed.";
	softAssert.assertEquals(expectedMessage, actualMessage);
	actualMessage= driver.findElement(By.xpath(".//*[@id='test:j_id_cd:tbody_element']/tr/td[2]/span")).getText();
	expectedMessage= "Temporary Override Requested";
	softAssert.assertEquals(expectedMessage, actualMessage);
	testpage.clickBtnPerformCheck();
	testpage.clickBtnPerformCheck();
// over ride found 	
	actualMessage= driver.findElement(By.xpath(".//*[@id='test:j_id_cd:tbody_element']/tr/td[2]/span")).getText();
	expectedMessage="Temporary Override Found";
	logger.info("TC_035  Temporary Override Found ");	
	
	softAssert.assertEquals(expectedMessage, actualMessage);
	testpage.clickCloseResponse();
//revoke 
	clientPolicies.clickPolicyListTab();
	recordLevelPolicyDetailPage.clickPolicy();
	recordLevelPolicyDetailPage.clickRevoke();
	recordLevelPolicyDetailPage.clickYesConfirmation();
	expectedMessage="Policy was revoked successfully.";
	actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
	softAssert.assertEquals(expectedMessage, actualMessage);
	logger.info("TC_035  Policy was revoked successfully");	
	
	recordLevelPolicyDetailPage.clickCloseMessageBox();
	recordLevelPolicyDetailPage.clickBack();		
	System.out.println("Passed TC _035");
	logger.info("TC_035  Passed TC _035");	
	
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