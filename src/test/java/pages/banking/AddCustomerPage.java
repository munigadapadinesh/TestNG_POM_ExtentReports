package pages.banking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Common;

public class AddCustomerPage extends Common {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@ng-click='addCust()']")
	public static WebElement AddCustomer;
	
	@FindBy(xpath="//input[@ng-model='fName']")
	public static WebElement firstName;
	
	@FindBy(xpath="//input[@ng-model='lName']")
	public static WebElement lastName;
	
	@FindBy(xpath="//input[@ng-model='postCd']")
	public static WebElement postCode;
	
	@FindBy(xpath="//*[text()='Add Customer']")
	public static WebElement AddCustomerBtn;
	
	String msg;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		this.driver=rdriver;
		PageFactory.initElements(driver, this);
	}
	
	public void addCustomer()
	{
		waitForElement(AddCustomer, driver);
		click(AddCustomer, "Add Customer");
		waitForElement(firstName, driver);
		enterText(firstName, "Dinesh", "FirstName");
		enterText(lastName, "Kumar", "LastName");
		enterText(postCode, "123456", "postcode");
		click(AddCustomerBtn, "Add Customer Button");
	}
	
	public void validateCustomerAdded()
	{
		try
		{
			msg=driver.switchTo().alert().getText();
			if(msg.contains("Customer added successfully with customer id :"))
			{
				reportPass(test, "User should see validation message after Creating Customer ", "User is able to see validation message <B> "+msg+" </B> after Creating Customer ");
			}
		}
		catch(Exception e)
		{
			reportFail(test, "User should see validation message after Creating Customer ", "User is not able to see validation message after Creating Customer ");

		}
	}
	
	
	
	

}
