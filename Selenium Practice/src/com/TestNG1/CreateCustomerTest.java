package com.TestNG1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.GenericLibrary.BaseClass1;

public class CreateCustomerTest extends BaseClass1 {
	
	@Test(groups= {"Smoke Test"})
	public void CreateTest() {
		System.out.println("Create Customer");
	}
	
	/*@BeforeMethod
	public void ConfigBM() {
		System.out.println("Log in");
	}
	
	@AfterMethod
	public void ConfigAM() {
		System.out.println("Logout");
	}
	
	@BeforeClass 
	public void ConfigBC() {
		System.out.println("Launch browser");
	}
	
	@AfterClass 
	public void ConfigAC() {
		System.out.println("Close Browser");
	}
*/
}
