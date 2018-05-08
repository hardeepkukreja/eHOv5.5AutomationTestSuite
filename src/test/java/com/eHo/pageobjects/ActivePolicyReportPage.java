package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivePolicyReportPage {

	
	
public static WebDriver driver;
	
	@FindBy(id="report:j_id_4x")
	WebElement activePolicyReportTab;
	
	@FindBy(id="report:j_id_6f")
	WebElement btnSelectName;
	

	
	
	@FindBy(xpath=".//*[@id='resultData']/tbody/tr/td[1]/div/label")
	WebElement selectName;
	
	@FindBy(id="result:returnBtn")
	WebElement btnReturnName;
	
	@FindBy(id="generateReportBtn")
	WebElement btnGenerateReport;
	
	@FindBy(id="report:j_id_bh")
	WebElement btnPdfReport;
	
	
	
	// Scheduling parameters 
	
	@FindBy(id="ui-id-6")
	WebElement scheduleTab;
	
	@FindBy(id="report:schedReportDescription")
	WebElement scheduleDescr;
	
	
	@FindBy(id="scheduleReportBtn")
	WebElement btnSchedule;
		
	@FindBy(id="report:j_id_bq")
	WebElement btnSchedulePdf;
		
	
	
	
	public ActivePolicyReportPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	public void clickActivePolicyReportTab()
	{
		activePolicyReportTab.click();
	}
	
	
	public void clickBtnSelectName()
	{
		btnSelectName.click();
	}
	public void clickSelectName()
	{
		selectName.click();
	}
		
	public void clickReturnName()
	{
		btnReturnName.click();
	}
	
	
	public void clickGenerateReport()
	{
		btnGenerateReport.click();
	}
	
	public void clickPdfReport()
	{
		btnPdfReport.click();
	}
	
	
	public void clickScheduleTab()
	{
		scheduleTab.click();
	}
	
	
	public void txtScheduleDesc(String descri)
	{
		scheduleDescr.sendKeys(descri);
	}
	
	public void clickbtnSchedule()
	{
		btnSchedule.click();
	}
	
	public void clickbtnPdfSchedule()
	{
		btnSchedulePdf.click();
	}
	
	
	
	
	
}
