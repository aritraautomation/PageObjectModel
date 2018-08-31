package com.get.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.get.qa.base.TestBase;
import com.get.qa.pages.Homepage;
import com.get.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	Homepage homepage;
	
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Edgepay - Login");		
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
		
	@AfterMethod
	public void tearDown() {		
		driver.quit();
	}	

}
