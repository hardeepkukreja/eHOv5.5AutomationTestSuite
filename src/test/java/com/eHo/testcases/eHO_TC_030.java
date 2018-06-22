
/*
 * 
 * 
 * CD 
 * 
 * 
 * */


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
import com.eHo.pageobjects.NavigationPage;
import com.eHo.pageobjects.SystemDirectivePage;
import com.eHo.pageobjects.TestPage;
import com.relevantcodes.extentreports.LogStatus;

public class eHO_TC_030 extends BaseTest 
{


	@BeforeMethod()
	public void setUp()
	{
		init();	//this is the method of BaseTest class to perform initialization
	}
	
	@Test
	public void TC_030Test()
	{
	try
	{
	test=rep.startTest("TC_030 Test");
	test.log(LogStatus.INFO, "Starting the test case to check the basic flow of System CD creation ");
	openBrowser(prop.getProperty("browser"));//this is the method from BaseTest class that opens up the browser based upon the parameter
	navigate("appURL");//to navigate to the application
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(prop.getProperty("loginSubmit"))).click();
	test.log(LogStatus.INFO, "Clicked submit button");
	NavigationPage navigationPage=new NavigationPage(driver);
	ClientSearchPage clientSearch=new ClientSearchPage(driver);
	SystemDirectivePage systemdirectivepage= new SystemDirectivePage(driver);
	logger.info("TC_030 System CD creation and testing in test tab  ");
	
	navigationPage.clickConsent();
	navigationPage.clickSystemDirectives();
	
	systemdirectivepage.clickBtnNewDirective();
	systemdirectivepage.clickBtnAdvanced();
	systemdirectivepage.setTxtDirectiveTitle("Default1");
	systemdirectivepage.ClickExecuteFirstYes();
	systemdirectivepage.clickBtnSave();
	systemdirectivepage.setTxtSaveComment("Comment from automation script");
	systemdirectivepage.clickBtnSaveContinue();
	
	
	// information Message has been sent successfully to Consent Validation to reload the system directive cache.
	
	String expectedMessage="Message has been sent successfully to Consent Validation to reload the system directive cache.";
	String actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
	softAssert.assertEquals(expectedMessage, actualMessage);
	systemdirectivepage.clickBtnBack();
/* 	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");   
	Date date = new Date();   
	String currentDate= formatter.format(date);
	System.out.println(currentDate);
	String actualDate=driver.findElement(By.xpath(".//*[@id='0']/td[3]")).getText();	
	System.out.println(actualDate); 
	softAssert.assertEquals(currentDate, actualDate);	
	logger.info(" TC _30 current date is present in the column  ");
		
*/
	String actualSource=driver.getPageSource();
	boolean a= actualSource.contains("Default1");
	
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
	
	
	// logic for navigation 
	
	navigationPage.clickConsent();
	
	navigationPage.clickManagement();
	
	clientSearch.setID(prop.getProperty("id"));
	clientSearch.clickSearch();
	clientSearch.clickClientName();
	ClientPolicies clientPolicies=new ClientPolicies(driver);
	AgentPolicyDetailPage agentPolicyDetailPage=new AgentPolicyDetailPage(driver);
	AgentSelectPage agentSelectPage=new AgentSelectPage(driver);
	logger.info(" TC _30 deny all policy is created   ");
	
	// policy 
	clientPolicies.clickNewDirective();
	clientPolicies.clickAgent();
	agentPolicyDetailPage.selectDirectiveOutcome("Deny");
	agentPolicyDetailPage.setPolicyDescription("Agent Domain specified , operator Equals, Deny Policy");
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
	 expectedMessage="Agent Domain specified , operator Equals, Deny Policy";			
	 softAssert.assertEquals(expectedMessage, actualMessage);
	
	
TestPage testpage= new TestPage(driver);
logger.info(" TC _30 test page logic began    ");
	
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
 testpage.clickBtnPerformCheck();
 
 logger.info(" TC _30 test page System Directive is returned    ");

  actualMessage= driver.findElement(By.xpath(".//*[@id='test:j_id_cd:tbody_element']/tr/td[4]/span")).getText();
System.out.println(" title of consent found" +actualMessage);
  expectedMessage ="Default1";
softAssert.assertEquals(expectedMessage, actualMessage);
 testpage.clickCloseResponse();
 navigationPage.clickConsent();
 navigationPage.clickSystemDirectives();
	// revoke SD 
 logger.info(" TC _30 revoke SD began   ");
 systemdirectivepage.clickActiveSD();

 //systemdirectivepage.clickActiveDirective();
	systemdirectivepage.clickBtnRevoke();
	systemdirectivepage.clickBtnRevokeContinue();
	  expectedMessage="Message has been sent successfully to Consent Validation to reload the system directive cache.";
	  actualMessage=driver.findElement(By.xpath("//*[@id='infoMessagesDialog']/table/tbody/tr/td")).getText();
	softAssert.assertEquals(expectedMessage, actualMessage);	
	systemdirectivepage.clickBtnBack();
	
	 logger.info(" TC _30 passed ");

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

