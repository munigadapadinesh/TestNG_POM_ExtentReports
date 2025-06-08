package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common extends BaseTest {
	
	WebDriver driver;
	
	
	public void click(WebElement ele,String elementName)
	{
		try
		{
			if(ele.isDisplayed())
			{
				ele.click();
				reportPass(test, "User should click the <B> "+elementName+" </B> in UI", "User is clicked the <B> "+elementName+" </B> in UI");
				System.out.println("User should click the "+elementName+" in UI");

			}

		}
		catch(Exception e)
		{
			reportFail(test, "User should click the <B> "+elementName+" </B> in UI", "User is not clicked the <B> "+elementName+" </B> in UI");
			System.out.println("User is not able to click the "+elementName+" in UI");

		}
	}
	
	public void waitForElement(WebElement ele,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void enterText(WebElement ele,String data,String elementName)
	{
		try
		{
			if(ele.isDisplayed())
			{
				ele.sendKeys(data);
				reportPass(test, "User should enter the data into <B> "+elementName+" </B> as <B> "+data+" </B> in UI", "User is entered the data into <B> "+elementName+" </B> as <B> "+data+" </B> in UI");
				System.out.println("User is able to enter the data into "+elementName+" as "+data+" in UI");

			}

		}
		catch(Exception e)
		{
			reportFail(test, "User should enter the data into <B> "+elementName+" </B> as <B> "+data+" </B> in UI", "User is not able to  enter the data into <B> "+elementName+" </B> as <B> "+data+" </B> in UI");
			System.out.println("User is not able to enter the data into "+elementName+" as "+data+" in UI");

		}
	}


}
