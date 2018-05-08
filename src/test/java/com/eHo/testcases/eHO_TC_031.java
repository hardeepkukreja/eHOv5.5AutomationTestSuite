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
import com.eHo.pageobjects.NavigationPage;
import com.eHo.pageobjects.SystemDirectivePage;
import com.eHo.pageobjects.TestPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_031 extends BaseTest 
{
	
	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	
	@Test
	public void TC_031Test()
	{
	try
	{
	test=rep.startTest("TC_031 Test");
	test.log(LogStatus.INFO, "Starting the test case to check the basic flow of record level policy creation ");
	openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
	navigate("appURL");//to navigate to the application
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
	test.log(LogStatus.INFO, "Clicked submit button");
	NavigationPage navigationPage=new NavigationPage(driver);
	ClientSearchPage clientSearch=new ClientSearchPage(driver);
	SystemDirectivePage systemdirectivepage= new SystemDirectivePage(driver);
	
	navigationPage.clickConsent();
	navigationPage.clickSystemDirectives();
	systemdirectivepage.clickBtnNewDirective();
	systemdirectivepage.clickBtnAdvanced();
	systemdirectivepage.setTxtDirectiveTitle("Default2");
	systemdirectivepage.ClickExecuteFirstNo();
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
		

	String actualSource=driver.getPageSource();
	boolean a= actualSource.contains("Default2");
	
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
	
	test.log(LogStatus.INFO, "CD is checked in the page");
	
	// logic for navigation 
	
	navigationPage.clickConsent();
	navigationPage.clickManagement();
	clientSearch.setID(prop.getProperty("id"));
	test.log(LogStatus.INFO, "Searching Id");
	clientSearch.clickSearch();
	clientSearch.clickClientName();
	ClientPolicies clientPolicies=new ClientPolicies(driver);
	AgentPolicyDetailPage agentPolicyDetailPage=new AgentPolicyDetailPage(driver);
	AgentSelectPage agentSelectPage=new AgentSelectPage(driver);
	
	// policy 
	clientPolicies.clickNewDirective();
	clientPolicies.clickAgent();
	agentPolicyDetailPage.selectDirectiveOutcome("Deny");
	agentPolicyDetailPage.setPolicyDescription("Agent Domain Deny Policy");
	agentPolicyDetailPage.clickDomainSpecify();
	
	agentPolicyDetailPage.selectDomainEqual();
	agentPolicyDetailPage.selectDomainType("CDR");
	agentPolicyDetailPage.clickAdd();
	agentSelectPage.clickManualEntry();
	agentSelectPage.setID("2.16.840.1.113883.3.239.18.14410003977");
	agentSelectPage.clickReturnSelected();
	agentPolicyDetailPage.clickSave();
	
	 expectedMessage="Policy was saved successfully.";
	 actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
	softAssert.assertEquals(expectedMessage, actualMessage);
	agentPolicyDetailPage.clickBack();

	actualMessage= driver.findElement(By.xpath(".//*[@id='policiesResult:j_id_6j:0:j_id_6l']")).getText();
	 expectedMessage="Agent Domain Deny Policy";			
	 softAssert.assertEquals(expectedMessage, actualMessage);
	
	
	
TestPage testpage= new TestPage(driver);
	
 testpage.clickTestTab();
 //testpage.clickpurposeOfUse("Emergency Care");
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
 testpage.clickBtnPerformCheck();
 // assertions
 /*
actualMessage= driver.findElement(By.xpath(".//*[@id='test:j_id_cd:tbody_element']/tr/td[4]/span")).getText();
System.out.println(" title of consent found" +actualMessage);
 expectedMessage ="Default2";
softAssert.assertEquals(expectedMessage, actualMessage);
 testpage.clickCloseResponse();
 navigationPage.clickConsent();
 navigationPage.clickSystemDirectives();
 test.log(LogStatus.INFO, "System Directive revoked");
	
	// revoke SD 
	systemdirectivepage.clickActiveDirective();
	systemdirectivepage.clickBtnRevoke();
	
	systemdirectivepage.clickBtnRevokeContinue();
	
	
	  expectedMessage="Message has been sent successfully to Consent Validation to reload the system directive cache.";
	  actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
	softAssert.assertEquals(expectedMessage, actualMessage);	
	systemdirectivepage.clickBtnBack();

	test.log(LogStatus.INFO, "Test case reached end of execution");
	*/
	
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

