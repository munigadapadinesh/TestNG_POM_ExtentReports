package tests.banking;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.banking.LoginPage;

public class TestManagerLogin extends BaseTest {
	
	LoginPage obj_LoginPage;
	WebDriver driver;
	
	@Test
	public void testManagerLogin() throws InterruptedException
	{
		test=report.startTest("Test Manager Login", "Test to check Manager Login ");
		driver=launchBrowser();
		obj_LoginPage=new LoginPage(driver);
		obj_LoginPage.performBankManagerLogin();
		report.endTest(test);
		report.flush();
	}

}
