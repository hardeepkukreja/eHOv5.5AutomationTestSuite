package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InternalClientSearch 
{
	public static WebDriver driver;
	
	@FindBy(id="detail:j_id_4q")
	WebElement internalID;
	

	@FindBy(id="criteria:ecid")
	WebElement txtEcid;
	
	@FindBy(id="criteria:search")
	WebElement btnSearch;
	
	
	
	public InternalClientSearch(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}


	public void clickinternalID()
	{
		
		internalID.click();
		
	}
	
	public void setTxtEcid(String value)
	{
		
		txtEcid.clear();
		txtEcid.sendKeys(value);
		
	}


	public void clickbtnSearch()
	{
		
		btnSearch.click();
		
	}
	
	
		
	
	
	
}
