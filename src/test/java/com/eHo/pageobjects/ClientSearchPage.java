package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientSearchPage {
	
	public static WebDriver driver;
	
	@FindBy(id="criteria:searchById")
	WebElement txtID;
	
	
	@FindBy(id="criteria:patId")
	WebElement byPCR_id;
	
	@FindBy(id="detail:j_id_4q")
	WebElement byPCR_idtab;
	
	@FindBy(id="criteria:search")
	WebElement btnSearch;
	
	@FindBy(id="criteria:clear")
	WebElement btnClear;
	
	@FindBy(id="result:j_id_6v:0:j_id_6x")
	WebElement clientName;
	
	public ClientSearchPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void setID(String id)
	{
		txtID.clear();
		txtID.sendKeys(id);
	}
	
	public void clickSearch()
	{
		btnSearch.click();
	}

	public void clickClear()
	{
		btnClear.click();
	}
	
	public void clickClientName()
	{
		clientName.click();
	}
	
	
	
	public void setPCR_ID(String value)
	{
		byPCR_id.clear();
		byPCR_id.sendKeys(value);
	}
	public void clickByPCR_idtab()
	{
		byPCR_idtab.click();
	}
	
}
