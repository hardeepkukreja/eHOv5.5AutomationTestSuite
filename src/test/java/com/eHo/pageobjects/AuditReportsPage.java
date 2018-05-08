package com.eHo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AuditReportsPage
{
	public static WebDriver driver;
	
	@FindBy(id="report:j_id_4r")
	WebElement frequentCriteria;
	
	
	
	@FindBy(id="report:patientOp1")
	WebElement client;
	
	
	@FindBy(id="report:userOp1")
	WebElement user;
	
	@FindBy(id="report:eventOp1")
	WebElement event;
	
	@FindBy(id="report:nodeOp1")
	WebElement node;
	
	@FindBy(id="report:startDateSel1")
	WebElement eventDate;
	

	@FindBy(id="generateReportBtn")
	WebElement btnGenerateReport;

	@FindBy(id="report:j_id_92")
	WebElement btnPdfReport;
	
	
	@FindBy(id="ui-id-6")
	WebElement scheduleTab;
	
	@FindBy(id="report:schedReportDescription")
	WebElement scheduleDescr;
	
	
	@FindBy(id="scheduleReportBtn")
	WebElement btnSchedule;
		
	@FindBy(id="report:j_id_9b")
	WebElement btnSchedulePdf;
	
	
	
	public AuditReportsPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	
	
	
	
	public void selectClient()
	{
		Select drop=new Select(client);
		
		try { 
		drop.selectByIndex(2);
			}
		catch(Exception e)
			{
			System.out.println("failed to assign client");
			
		   }
		
	}
	
	
	public void selectUser()
	{
		Select drop=new Select(user);
		
		try { 
		drop.selectByIndex(2);
			}
		catch(Exception e)
			{
			System.out.println("failed to assign user");
			
		   }
		
	}
		
		public void selectEvent()
		{
			Select drop=new Select(event);
			
			try { 
			drop.selectByIndex(0);
				}
			catch(Exception e)
				{
				System.out.println("failed to assign event");
				
				}
			}	
		
public void clickBtnGenerateReport()
		{
		btnGenerateReport.click();		
		}
		
public void clickfrequentCriteria()
{
	frequentCriteria.click();		
}
	
	
public void clickbtnPdfReport()
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
