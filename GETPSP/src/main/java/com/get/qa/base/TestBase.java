package com.get.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.get.qa.util.TestUtil;
import com.get.qa.util.WebEventListner;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListner eventListner;

	
	public TestBase() {
		
		try {
			 prop=new Properties();		
			 FileInputStream fis=new FileInputStream("/Users/lenovo/eclipse-workspace/GETPSP/src/main/java/com/get/qa/config/config.properties");
			 prop.load(fis);
		
			} catch (FileNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
					e.printStackTrace();
			}
	}
		
		public static void initialization(){
			
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "/Users/lenovo/Downloads/chromedriver.exe");
				driver=new ChromeDriver();
			}
			
			else if(browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "/Users/lenovo/Downloads/geckodriver.exe");
				driver=new FirefoxDriver();
			}
			
			e_driver = new EventFiringWebDriver(driver);
			eventListner = new WebEventListner();
			e_driver.register(eventListner);
			driver = e_driver;
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLYWAIT_TIMEOUT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
		}	
		
		/*public static void waitForDasboard(){
			WebDriverWait wait = new WebDriverWait(driver, TestUtil.EXPLICITWAIT_TIMEOUT);
			wait.until(ExpectedConditions.presenceOfElementLocated((By) Dashboardtxt));
		}*/
	}

