package com.get.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.get.qa.base.TestBase;

public class Homepage extends TestBase{
	
	TokenManagerPage tokenpage;
	
	@FindBy(xpath= "//h1[contains(text(),'Dashboard')]")
	WebElement Dashboardtxt;
	
	@FindBy(xpath="//li[@id='tokenManager']/a")
	WebElement TokenManager;
	
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
		
	public String verifyDashboardTxt() {		
		return Dashboardtxt.getText();
	}
	
	
	public TokenManagerPage tokenManagerPageLink() throws InterruptedException {
		 TokenManager.click();
		 Thread.sleep(6000);
		 return new TokenManagerPage();
		
	}

}
