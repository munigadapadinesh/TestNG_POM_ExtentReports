package tests.banking;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.banking.LoginPage;

public class TestCustomerLogin extends BaseTest {
	
	LoginPage obj_LoginPage;
	WebDriver driver;
	
	@Test
	public void testCustomerLogin() throws InterruptedException
	{
		test=report.startTest("Test Customer Login", "Test to check Customer Login ");
		driver=launchBrowser();
		obj_LoginPage=new LoginPage(driver);
		obj_LoginPage.performCustomerLogin();
		report.endTest(test);
		report.flush();
		System.out.Println("TEST End");
	}

}
