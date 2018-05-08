package com.eHo.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import com.eHo.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class BaseTest {
	public   WebDriver driver;
	public  Properties prop;
	public  SoftAssert softAssert;
	public ExtentReports rep=ExtentManager.getInstance();
	public ExtentTest test;
	public  Logger logger;
	
	public void init()
	{
		//initialize the property
		if (prop==null)
		{
			prop=new Properties();
			try{
			FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//ProjectConfig.properties");
			prop.load(fs);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
		}
		softAssert=new SoftAssert();
		logger=Logger.getLogger("BaseTest");
		PropertyConfigurator.configure("log4j.properties");
						
	}
	
	public void openBrowser(String bType)
	{
		
		if(bType.equals("Mozilla"))
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//test//resources//geckodriver.exe");
			driver=new FirefoxDriver();
			logger.info("Initializing Mozilla browser");
		}
		else if(bType.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
			driver=new ChromeDriver();
			logger.info("Initializing Chrome browser");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("Browser launched");
		
	}
	
	public void navigate(String urlKey)
	{
		driver.get(prop.getProperty(urlKey));
		logger.info("Navigating to URL ...."+ urlKey);
		
	}
	
	public void takeScreenShot()
	{
		Date d=new Date();
		String fileName=d.toString().replace(":", "_").replace(" ", "_")+".png";
		System.out.println(fileName);
		System.out.println(System.getProperty("user.dir"));
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"//screenshots//"+fileName));
		}catch(Exception e){
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,"screenshots->" + test.addScreenCapture(System.getProperty("user.dir")+"//screenshots//"+fileName));
	}
	
	public void afterTest(ITestResult res)
	{
		System.out.println(res.getName());
		if(res.getStatus()==ITestResult.FAILURE)
		{
			takeScreenShot();
		
			test.log(LogStatus.FAIL, "Test Failed");
			test.log(LogStatus.INFO , "Unexpected mistake");
		}
		else
		{
			test.log(LogStatus.PASS, "Test Passed");
		}
		if(rep!=null){
			rep.endTest(test);
			rep.flush();
		}
		if(driver!=null)
		{
			driver.quit();
		}
	}

}
