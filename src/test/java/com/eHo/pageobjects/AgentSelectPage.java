package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AgentSelectPage {

	public WebDriver driver;
	
	@FindBy(id="detail:j_id_4v")
	WebElement tabManualEntry;
	
	@FindBy(id="manualForm:idEntry")
	WebElement txtID;
	
	
	
	@FindBy(id="manualForm:returnEntry")
	WebElement btnReturnSelected;
	
	
	
	
	@FindBy(id="criteria:lastName")
	WebElement txtLastName;
	
	@FindBy(id="criteria:search")
	WebElement btnSearch;
	
	@FindBy(xpath=".//*[@id='resultData']/tbody/tr[1]/td[1]/div/label")
	WebElement idAgentSelect; // can be used for organization agent 
	
	
	@FindBy(id="result:returnBtn")
	WebElement btnReturn;  // can be used for organization  
	
	
	public AgentSelectPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void clickManualEntry()
	{
		tabManualEntry.click();
	}
	
	public void setID(String id)
	{
		txtID.sendKeys(id);
	}
	
	public void clickbtnSearch()
	{
		btnSearch.click();		
	}
	
	public void clickReturnSelected()
	{
		btnReturnSelected.click();	
	}
	public void setTxtLastName(String value)
	{
		txtLastName.sendKeys(value);
	}
	
	public void clickIdAgentSelect()
	{
		idAgentSelect.click();		
	}
	
	public void clickBtnReturn()
	{
		btnReturn.click();		
	}
}













