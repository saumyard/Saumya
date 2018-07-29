package com.DataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CountNoOfColumn {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		
		//create and read the file
		String path="./input data.xlsx";
				
		FileInputStream fis=new FileInputStream(path);
				
		//create workbook
		Workbook wb=WorkbookFactory.create(fis);
				
		//get the sheet
		Sheet sh=wb.getSheet("sheet1");
		
		//get the row
		Row r=sh.getRow(0);
		
		//to get the no of cells in a row
		int cn=r.getLastCellNum();
		System.out.println(cn);

	}

}
