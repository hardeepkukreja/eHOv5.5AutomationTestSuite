package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurityAlertSearchPage {

	
	
	
public static WebDriver driver;
	
	@FindBy(id="criteria:search")
	WebElement btnSearch;
	
	public SecurityAlertSearchPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void clickBtnSearch()
	{
		btnSearch.click();
	}
}
