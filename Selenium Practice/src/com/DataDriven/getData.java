package com.DataDriven;

public class getData {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create and read the file
		String path="./input data.xlsx";
		
		//To get the data
		String data=GetDataUsingGenericMethod.getData(path,"sheet1",0,0);
		System.out.println(data);
		
		//to get the row count
		int rc=GetDataUsingGenericMethod.getrowCount(path, "sheet1");
		System.out.println(rc);
		
		//to get the cell count
		int cc=GetDataUsingGenericMethod.getcellCount(path,"sheet1",0);
		System.out.println(cc);
		

	}

}
