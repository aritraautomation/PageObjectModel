package com.get.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.get.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 60;
	
	public static long IMPLICITLYWAIT_TIMEOUT = 20;
	
	public static long EXPLICITWAIT_TIMEOUT = 8000;
	
	
	
	
	public static String TESTDATA_SHEET_PATH="C:\\Users\\lenovo\\eclipse-workspace\\"
			+ "GETPSP\\src\\main\\java\\com\\get\\qa\\testdata\\TokenManger.xlsx";
	
	 static Workbook wb; 	 	
	 static Sheet sh;
	 
	 public static Object[][] getTestData(String sheetName){
		 FileInputStream file=null;
		 
		 try {
			 file=new FileInputStream(TESTDATA_SHEET_PATH);
		 }catch(FileNotFoundException e) {
			 e.printStackTrace();
		 }
		 try {
			 wb=WorkbookFactory.create(file);
		 }catch(InvalidFormatException e) {
			 e.printStackTrace();
		 }catch(IOException e) {
			 e.printStackTrace();
		 }
		 
		 sh=wb.getSheet(sheetName);
		 Object[][] data=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		 
		 for(int i=0;i<sh.getLastRowNum();i++) {
			 for(int k=0;k<sh.getRow(0).getLastCellNum();k++) {
				 
				 data[i][k]=sh.getRow(i+1).getCell(k);			 
				 }
		 }
		  return data;
	 }	
	
	 
	 public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
			
			}
	
}
