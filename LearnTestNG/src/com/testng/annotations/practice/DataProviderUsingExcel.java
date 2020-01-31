package com.testng.annotations.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderUsingExcel {

	@DataProvider
	public static Object[][] getData() throws IOException {
		FileInputStream excelFile = new FileInputStream("/home/prajakta/Desktop/Resume/testng/testData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(0).getPhysicalNumberOfCells();

		Object obj[][] = new Object[totalRows][totalColumns];

		for (int i = 0; i < totalRows; i++) {
			for (int j = 0; j < totalColumns; j++)
				obj[i][j] = sheet.getRow(i + 1).getCell(j).toString();
		}

		return obj;
	}

	@Test(dataProvider = "getData")
	public void testgetData(String username, String Password, String Description) {

		System.out.println("Logine with username and passwrd: " + username + "\t :" + Password +"\t:"+Description);
	}
}
