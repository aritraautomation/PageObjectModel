package com.get.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.get.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	Homepage homepage;
	
		
	@FindBy(xpath= "//input[@name='userName']")
	WebElement username;
	
	@FindBy(xpath= "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath= "//button[@id='loginButton']")
	WebElement loginButton;
		
	//Initialzing the pageobjects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Homepage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		//waitForDasboard();
		Thread.sleep(8000);
		return new Homepage();
	}
	
	
	

}
