package com.get.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.get.qa.base.TestBase;
import com.get.qa.pages.Homepage;
import com.get.qa.pages.LoginPage;
import com.get.qa.pages.TokenManagerPage;
import com.get.qa.util.TestUtil;

public class TokenManagerPageTest extends TestBase {
	
	Homepage homepage;
	LoginPage loginpage; 
	TokenManagerPage tokenManagerPage;
	
	String sheet1Name="CardToken";
	String sheet2Name="CheckToken";
	
	public TokenManagerPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		loginpage=new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		tokenManagerPage=homepage.tokenManagerPageLink();		
		}
	
	@Test(priority=1)
	public void verifyTokenManagerPageTest() {
		Assert.assertEquals(tokenManagerPage.verifyTokenManagerPageTxt(), "Token Manager");
	}
	
	@DataProvider
	public Object[][] getCardTokenTestData() {
		Object data[][]=TestUtil.getTestData(sheet1Name);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCardTokenTestData")
	public void requestCardTokenTest(Object cardNum) throws InterruptedException {
		tokenManagerPage.selectMID();
		tokenManagerPage.requestCardToken(cardNum);
	}
	
	@DataProvider
	public Object[][] getCheckTokenTestData() {
		Object data[][]=TestUtil.getTestData(sheet2Name);
		return data;
	}
	
	@Test(priority=3, dataProvider="getCheckTokenTestData")
	public void requestCheckTokenTest(Object routingNo, Object AcctNo) throws InterruptedException {
		tokenManagerPage.selectMID();
		//tokenManagerPage.requestCheckToken(123456789L,12345678901L);	
		tokenManagerPage.requestCheckToken(routingNo,AcctNo);
	}
	
	@AfterMethod
	public void tearDown() {		
		driver.quit();
	}

}
