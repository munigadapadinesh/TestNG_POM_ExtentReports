package pages.banking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Common;

public class LoginPage extends Common {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@ng-click='customer()']")
	public static WebElement CustomerLogin;
	
	@FindBy(xpath="//*[@ng-click='manager()']")
	public static WebElement BankManagerLogin;
	
	public LoginPage(WebDriver rdriver)
	{
		this.driver=rdriver;
		PageFactory.initElements(driver, this);
	}
	
	public void performCustomerLogin() throws InterruptedException
	{
		waitForElement(CustomerLogin,driver);
		click(CustomerLogin, "Customer Login");
	}
	
	public void performBankManagerLogin() throws InterruptedException
	{
		waitForElement(BankManagerLogin,driver);
		click(BankManagerLogin, "BankManager Login");
	}

}
