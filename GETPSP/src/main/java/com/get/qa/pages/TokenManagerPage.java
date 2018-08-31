package com.get.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.get.qa.base.TestBase;

public class TokenManagerPage extends TestBase {
	
	TokenManagerPage tokenManagerPage;
	
	@FindBy(xpath="//h1[text()='Token Manager']")
	@CacheLookup
	WebElement tokenManagerTxt;
	
	@FindBy(xpath="//div[@id='header-mid']/button[2]")
	WebElement midDropdown;
	
	@FindBy(xpath="//div[@id='header-mid']/ul/li[*]/a[text()='9674134323 | Ankur']")
	WebElement midSelection;
	
	@FindBy(xpath="//input[@id='cardt_card_check']")
	WebElement cardTokenRadioButton;
	
	@FindBy(xpath="//input[@name='cardNumber']")
	WebElement cardTokenCardNumberTxt;
	
	@FindBy(xpath="//input[@name='cardExpiryDate']")
	WebElement cardTokenCardExpiryDateTxt;
	
	@FindBy(xpath="//*[text()='2020']")
	WebElement selectYear;
	
	@FindBy(xpath="//*[text()='Dec']")
	WebElement selectMonth;
	
	/*@FindBy(xpath="//input[@name='cardExpiryDate']/following-sibling::button")
	WebElement cardTokenSubmitButton;
	*/
	@FindBy(xpath="(//button[text()='Submit'])[1]")
	WebElement cardTokenSubmitButton;
	
	@FindBy(xpath="//input[@id='checkt_card_check']")
	WebElement checkTokenRadioButton;
	/*
	@FindBy(xpath="//div[@class='modal-body']/input[@id='requestTokenCopyInput']")
	WebElement cardTokenNumber;*/
	
	/*@FindBy(xpath="//input[@id='requestTokenCopyInput']")
	WebElement cardTokenNumberTxt;*/
	
	@FindBy(css="input[id='requestTokenCopyInput']")
	WebElement cardTokenNumberTxt;
	
	@FindBy(xpath="//button[text()='Copy']")
	WebElement copyCardTokenButton;
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement closeCardTokenButton;
	
	@FindBy(xpath="//input[@id='checkt_route']")
	WebElement checkTokenRoutingNumberTxt;
	
	@FindBy(xpath="//input[@id='checkt_account']")
	WebElement checkTokenAccountNumberTxt;
	
	/*@FindBy(xpath="//input[@id='checkt_account']/following-sibling::button[text()='Submit']")
	WebElement checkTokenSubmitButton;*/
	
	@FindBy(xpath="(//button[text()='Submit'])[2]")
	WebElement checkTokenSubmitButton;
	
	public TokenManagerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTokenManagerPageTxt() {		
		return tokenManagerTxt.getText();
	}
	
	public void selectMID() {
		Actions action=new Actions(driver);
		midDropdown.click();
		midSelection.click();
		action.moveToElement(midSelection).build().perform();
	}
	
	
	
	public void requestCardToken(Object cardNumber) throws InterruptedException {
		cardTokenRadioButton.click();
		cardTokenCardNumberTxt.sendKeys(String.valueOf(cardNumber));
		
		cardTokenCardExpiryDateTxt.click();
		selectYear.click();;
		selectMonth.click();
		cardTokenSubmitButton.click();
		Thread.sleep(6000);
		/*String getCardTokenNumber=cardTokenNumberTxt.getAttribute("Value");*/
/*		JavascriptExecutor js = (JavascriptExecutor) driver;
*//*		String getCardTokenNumber=document.querySelector(cardTokenNumberTxt).value;
*/		
/*		String getCardTokenNumber = (String) js.executeScript("arguments[0].value", cardTokenNumberTxt);
*/        
        
       /* 
		System.out.println(getCardTokenNumber);			
		return Integer.parseInt(getCardTokenNumber);*/
		
		copyCardTokenButton.click();
		closeCardTokenButton.click();
	}
	
	
	public void requestCheckToken(Object routingNo,Object acctNo) throws InterruptedException {
		checkTokenRadioButton.click();
		checkTokenRoutingNumberTxt.sendKeys(String.valueOf(routingNo));
		checkTokenAccountNumberTxt.sendKeys(String.valueOf(acctNo));
		checkTokenSubmitButton.click();
		Thread.sleep(6000);
		copyCardTokenButton.click();
		closeCardTokenButton.click();
	}

}
