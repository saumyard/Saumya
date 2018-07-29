package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class CreateUserTest {
	
	@Test
	public void CreateTest() {
		System.out.println("Create User");
	}
	
	@BeforeMethod
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

}
