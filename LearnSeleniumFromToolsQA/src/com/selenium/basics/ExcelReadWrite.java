package com.selenium.basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {

	String filePath;
	XSSFWorkbook workbook;
	XSSFSheet worksheet;

	void setExcelFile(String path, String worksheetName) throws IOException {
		filePath = path;
		FileInputStream file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		worksheet = workbook.getSheet(worksheetName);
	}

	void readExcel() throws IOException {

		/* Hardcode
		String data = worksheet.getRow(1).getCell(1).getStringCellValue();
		System.out.println(data);*/
		
		int rowCount = worksheet.getLastRowNum() ;

		for (int i = 0; i < rowCount + 1; i++) {
			XSSFRow row = worksheet.getRow(i);

			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue() + "|| ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	void writeToExcel(String[] dataToWrite) throws IOException {

		/*XSSFRow newRow = worksheet.createRow(4);
		worksheet.getRow(4).createCell(0).setCellValue("pqr");

		FileOutputStream outFile = new FileOutputStream(filePath);
		workbook.write(outFile);
		outFile.close();*/
		
		int rowCount = worksheet.getLastRowNum();
		int totalCellInFirstRow= worksheet.getRow(0).getLastCellNum();
		
		//create new row and append it to sheet
		XSSFRow newRow = worksheet.createRow(rowCount+1);
		
		for(int i= 0; i< totalCellInFirstRow; i++){
			XSSFCell cell = newRow.createCell(i);
			cell.setCellValue(dataToWrite[i]);
		}
		
		//here we need to specify where you want to save file
		FileOutputStream outFile = new FileOutputStream(filePath);
		
		//Finally write the content
		workbook.write(outFile);
		outFile.close();
	}

	public static void main(String[] args) throws IOException {

		ExcelReadWrite obj = new ExcelReadWrite();
		obj.setExcelFile("/home/prajakta/Desktop/Resume/selenium/Excelfile.xlsx", "Sheet1");
		obj.readExcel();
		String[] valueToWrite = {"Mr. E","Noida"};
		obj.writeToExcel(valueToWrite);
		obj.readExcel();
		
	}

}
