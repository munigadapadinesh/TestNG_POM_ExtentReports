package tests.banking;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.banking.AddCustomerPage;
import pages.banking.LoginPage;

public class TestAddCustomer extends BaseTest {
	
	LoginPage obj_LoginPage;
	AddCustomerPage obj_AddCustomerPage;
	WebDriver driver;
	
	@Test
	public void testAddCustomer() throws InterruptedException
	{
		test=report.startTest("Test Add Customer", "Test to Check Add Customer Functionality ");
		driver=launchBrowser();
		obj_LoginPage=new LoginPage(driver);
		obj_LoginPage.performBankManagerLogin();
		obj_AddCustomerPage=new AddCustomerPage(driver);
		obj_AddCustomerPage.addCustomer();
		obj_AddCustomerPage.validateCustomerAdded();
		report.endTest(test);
		report.flush();
	}

}
