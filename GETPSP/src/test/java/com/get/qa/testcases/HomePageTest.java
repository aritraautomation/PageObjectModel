package com.get.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.get.qa.base.TestBase;
import com.get.qa.pages.Homepage;
import com.get.qa.pages.LoginPage;
import com.get.qa.pages.TokenManagerPage;

public class HomePageTest extends TestBase{
	
	Homepage homepage;
	LoginPage loginpage; 
	TokenManagerPage tokenManagerPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		}
	
	
	@Test(priority=1)
	public void verifyDashboardTxtTest() {
	String Dashboardtxt=homepage.verifyDashboardTxt();
	Assert.assertEquals(Dashboardtxt, "Dashboard");
	}
	
	@Test(priority=2)
		public void clickTokenManagerLinkTest() throws InterruptedException {
			tokenManagerPage=homepage.tokenManagerPageLink();
		}
		
	
	
	@AfterMethod
	public void tearDown() {		
		driver.quit();
	}	

	
	

}
