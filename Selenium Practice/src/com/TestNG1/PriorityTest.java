package com.TestNG1;

import org.testng.annotations.Test;

public class PriorityTest {
	
	@Test(priority=1)
	public void CreateCustomerTest() {
		System.out.println("execute create customer Test");
	}
	
	@Test(priority=3)
	public void ModifyCustomerTest() {
		System.out.println("execute Modify customer Test");
	}
	
	@Test(priority=2,groups= {"Smoke Test"})
	public void DeleteCustomerTest() {
		System.out.println("execute Delete customer Test");
	}

}
