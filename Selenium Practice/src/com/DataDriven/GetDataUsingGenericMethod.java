package com.DataDriven;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataUsingGenericMethod {
	
	//to get data from excel
	public static String getData(String filepath,String SheetName,int rn,int cn) {
		try {
			FileInputStream fis=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sh=wb.getSheet(SheetName);
			String data=sh.getRow(rn).getCell(cn).getStringCellValue();
			return data;
		}catch(Exception e) {
			return " ";
		}
	}
	
	//To get the number of rows
	public static int getrowCount(String filepath,String sheetName) {
		try {
			FileInputStream fis=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fis);
			int rc=wb.getSheet(sheetName).getLastRowNum();
			return rc;
		}catch(Exception e) {
			return 0;
		}
	}
	
	//To get the number of cells
		public static int getcellCount(String filepath,String sheetName,int rn) {
			try {
				FileInputStream fis=new FileInputStream(filepath);
				Workbook wb=WorkbookFactory.create(fis);
				int cc=wb.getSheet(sheetName).getRow(rn).getLastCellNum();
				return cc;
				
			}catch(Exception e) {
				return 0;
			}
		}

	

}
