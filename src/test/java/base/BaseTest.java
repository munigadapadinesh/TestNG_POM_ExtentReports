package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class BaseTest {
	
	public static ExtentReports report;
	public static ExtentTest test;
	WebDriver driver;
	Properties prop=new Properties();
	
	@BeforeMethod
	public void config() throws IOException
	{
		File file=new File(".");
		String path=file.getCanonicalPath();
		FileInputStream fis=new FileInputStream(path+"/Config/config.properties");
		prop.load(fis);
		String dst=new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
		report=new ExtentReports(System.getProperty("user.dir")+"\\ExtentReports\\report_"+dst+"\\report.html");
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	public WebDriver launchBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url=prop.getProperty("appurl");
		driver.get(url);
		if(url.equals(driver.getCurrentUrl()))
		{
			reportInfo(test, "User should launch the browser", "User is able to launch the browser");
		}
		return driver;
	}
	
	public void reportPass(ExtentTest test,String Expected,String Actual)
	{
		test.log(LogStatus.PASS, "Expected Result: "+Expected+",Actual Result: "+Actual);
	}
	
	public void reportFail(ExtentTest test,String Expected,String Actual)
	{
		test.log(LogStatus.FAIL, "Expected Result: "+Expected+",Actual Result: "+Actual);
	}
	
	public void reportInfo(ExtentTest test,String Expected,String Actual)
	{
		test.log(LogStatus.INFO, "Expected Result: "+Expected+",Actual Result: "+Actual);
	}
	

}
