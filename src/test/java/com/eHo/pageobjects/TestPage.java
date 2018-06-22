package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TestPage
{

public static WebDriver driver;
	
// Click on test tab 

		@FindBy(id="detail:j_id_5j")
		WebElement testTab;

		@FindBy(id="test:purposeOfUse")
	 WebElement purposeOfUse;
	

	@FindBy(xpath=".//*[@id='test:appliesTo']/input")
	WebElement btnAdd;
	
	@FindBy(xpath="//input[@value='Add...']")
	WebElement btnAdd1;
	
	
	@FindBy(id="test:j_id_ao:0:j_id_aq")
	WebElement btnAgent;
	
	@FindBy(id="criteria:lastName")
	WebElement lastNameAgent;
	
	@FindBy(id="criteria:search")
	WebElement btnSearch; // for organization and agent 
	
	@FindBy(xpath=".//*[@id='resultData']/tbody/tr[1]/td[1]/div/label")
	WebElement idAgentSelect; // can be used for organization agent 
	
	
	@FindBy(id="result:returnBtn")
	WebElement btnReturn;  // can be used for organization  
	
	@FindBy(id="criteria:name3")
	WebElement txtOrgName;
	
	
	@FindBy(id="criteria:addrCity3")
	WebElement txtOrgMuncipality;
	
	@FindBy(xpath=".//*[@id='resultData']/tbody/tr/td[1]/div/label")
	WebElement idOrgSelect; // can be used for organization agent 
	
	@FindBy(id="test:j_id_ao:1:j_id_aq")
	WebElement btnOrganisation;
	
	@FindBy(id="test:checkBtn")
	WebElement btnPerformCheck;
	
	
	// response Type - consent 
	
	
	@FindBy(xpath=".//*[@id='test:j_id_cd:tbody_element']/tr/td[1]/span")
	WebElement txtResponseType;
	
	
	@FindBy(xpath=".//*[@id='test:j_id_cd:tbody_element']/tr/td[2]/span")
	WebElement txtResponseMessage;
	
	
	@FindBy(xpath=".//*[@id='test:j_id_cd:tbody_element']/tr/td[4]/span")
	WebElement txtResponseTitle;
	
	@FindBy(xpath="html/body/div[4]/div[1]/button")
	WebElement closeResponse;
	
	// specify PHI 
	
	
	@FindBy(id="ui-id-1")
	WebElement specifyPHI;
	
	@FindBy(xpath=".//*[@id='test:j_id_b6']")
	WebElement specifyPHI2;
	
	
	@FindBy(id="test:j_id_b6")
	WebElement btnAddPHI;
	
	@FindBy(id="result:j_id_4p:2:inputList")
	WebElement documentID; // document ID 
	
	@FindBy(id="result:j_id_4p:2:inputText")
	WebElement documentIDValue; // document ID value
	

	@FindBy(id="result:j_id_4p:4:inputList")
	WebElement domainID; //Domain ID 
	
	@FindBy(id="result:doneBtn")
	WebElement btnDonePHI; //done button in PHI 
	
	@FindBy(id="result:j_id_4p:0:inputList")
	WebElement hicSource; //hic source ID 
	
		
// over ride 
	@FindBy(id="ui-id-3")
	WebElement specifyOverride;
	
	 // override code 
	
	@FindBy(id="test:overrideCodeObj")
	WebElement override_code;
	
	@FindBy(id="test:overrideReason")
	WebElement override_Reason;
	
	
	
	public TestPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void clickTestTab()
	{
		testTab.click();
	}
	
	
	public void clickpurposeOfUse(String Value)
	{
		Select drop = new Select(purposeOfUse);
		drop.selectByIndex(3);
		
	}
	public void clickBtnAdd()
	{
		btnAdd.click();
	}
	
	public void clickBtnAdd1()
	{
		btnAdd1.click();
	}
	
	
	public void clickBtnAgent()
	{
		btnAgent.click();
	}
	
	public void setLastNameAgent(String value)
	{
		lastNameAgent.sendKeys(value);
	}
	
	public void clickbtnSearch()
	{
		btnSearch.click();		
	}
	
	public void clickIdAgentSelect()
	{
		idAgentSelect.click();		
	}
	
	public void clickBtnReturn()
	{
		btnReturn.click();		
	}
	
	public void clickbtnOrganisation()
	{
		btnOrganisation.click();		
	}
	
	
	public void setTxtOrgName(String value)
	{
		txtOrgName.sendKeys(value);
	}
	
	public void setTxtOrgMuncipality(String value)
	{
		txtOrgMuncipality.sendKeys(value);
	}
	
	
	
	public void clickIdOrgSelect()
	{
		idOrgSelect.click();		
	}
	public void clickBtnPerformCheck()
	{
		btnPerformCheck.click();		
	}
	
	
	
	
	
	public void clickCloseResponse()
	{
		closeResponse.click();
	}
	
	public void clickSpecifyPHI()
	{
		specifyPHI.click();
	}
	
	public void clickSpecifyPHI2()
	{
		specifyPHI2.click();
	}
	
	
	
	public void clickBtnAddPHI()
	{
		btnAddPHI.click();
	}
	
	public void setdocumentID(String value)
	{
		Select id= new Select(documentID);
		id.selectByValue(value);
	}
	
	public void setdocumIDValue(String value)
	{
		documentIDValue.sendKeys(value);
	}
	
	public void setdomainID(String value)
	{
		Select id= new Select(domainID);
		try { id.selectByValue(value); }
		catch(Exception e) {
			id.selectByVisibleText(value);
		}
	}
	
	
	public void setHicSource(String value)
	{
		Select id= new Select(hicSource);
		try { id.selectByVisibleText(value);  }
		catch(Exception e) {
			id.selectByValue(value);
			
		}
	}
	
	
	
	
	public void clickDonePHI()
	{
		btnDonePHI.click();
	}
	
	public void clickSpecifyOverride()
	{
		specifyOverride.click();
	}
	
	public void setOverride_code()
	{
		Select id= new Select(override_code);
		id.selectByIndex(1);
	}
	
	public void setOverrideReason(String value)
	{
		override_Reason.sendKeys(value);
	}
	
	
	
}
