package com.DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CountNoOfRows {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		
		//create and read the file
		String path="./input data.xlsx";
				
		FileInputStream fis=new FileInputStream(path);
				
		//create workbook
		Workbook wb=WorkbookFactory.create(fis);
				
		//get the sheet
		Sheet sh=wb.getSheet("sheet1");
		
		//to get the no of rows in a Sheet
		int rn=sh.getLastRowNum();
		System.out.println(rn);

	}

}
