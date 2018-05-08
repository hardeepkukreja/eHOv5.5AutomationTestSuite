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

public class eHO_TC_034 extends BaseTest  {

	String actualMessage, expectedMessage; 
	@BeforeMethod()
	public void setUp()
	{
		init();	
}

@Test (priority=1)
	
	public void TC_033Test()
	{
		
	try
	{
	test=rep.startTest("TC_033 Test");
	test.log(LogStatus.INFO, "Starting the test case to check the basic flow of record level policy creation ");
	openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
	navigate("appURL");//to navigate to the application
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
	test.log(LogStatus.INFO, "Clicked submit button");
	NavigationPage navigationPage=new NavigationPage(driver);
	ClientSearchPage clientSearch=new ClientSearchPage(driver);
	// SystemDirectivePage systemdirectivepage= new SystemDirectivePage(driver);
	ClientPolicies clientPolicies=new ClientPolicies(driver);
		RecordLevelPolicyDetailPage recordLevelPolicyDetailPage=new RecordLevelPolicyDetailPage(driver);
	
	navigationPage.clickConsent();
	navigationPage.clickManagement();
	clientSearch.setID(prop.getProperty("id"));
	test.log(LogStatus.INFO, "Searching Id");
	clientSearch.clickSearch();
	clientSearch.clickClientName();

clientPolicies.clickNewDirective();
	clientPolicies.clickRecordLevel();
	
	// put policy Deny 
	recordLevelPolicyDetailPage.selectDirectiveOutcome("Allow");  
	recordLevelPolicyDetailPage.setPolicyDescription("Record Level Policy-Automation");
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
	testpage.clickBtnPerformCheck();
//assertions 
 	 actualMessage= driver.findElement(By.xpath(".//*[@id='responseDialog']/div/span[1]")).getText();
	
System.out.println( actualMessage);
 expectedMessage ="Disclosure of PHI is allowed.";

softAssert.assertEquals(expectedMessage, actualMessage);

	String pageSource = driver.getPageSource();
	 expectedMessage ="Disclosure of PHI is allowed.";
	

    if(pageSource.contains(expectedMessage))
    {
        System.out.println( expectedMessage+"   present in the web page.");
        softAssert.assertFalse(false);
    }else{
        System.out.println(expectedMessage+"      is not present in the web page.");
        softAssert.assertFalse(true);
    }
	
	
	testpage.clickCloseResponse();
	
	
//revoke 
	clientPolicies.clickPolicyListTab();
	recordLevelPolicyDetailPage.clickPolicy();
	recordLevelPolicyDetailPage.clickRevoke();
	recordLevelPolicyDetailPage.clickYesConfirmation();
	expectedMessage="Policy was revoked successfully.";
	actualMessage=driver.findElement(By.xpath(".//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();		
	softAssert.assertEquals(expectedMessage, actualMessage);
	recordLevelPolicyDetailPage.clickCloseMessageBox();
	recordLevelPolicyDetailPage.clickBack();		
//back to test tab 		

	
	System.out.println("Passed TC _033");
	
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