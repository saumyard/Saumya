package com.TestNG1;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount=2,priority=1)
	public void CreateCustomerTest() {
		System.out.println("execute create customer Test");
		System.out.println("hi");
	}
	
	@Test(invocationCount=3,priority=2)
	public void ModifyCustomerTest() {
		System.out.println("execute Modify customer Test");
		System.out.println("hello");
	}
	
	@Test(groups= {"Smoke Test"})
	public void DeleteCustomerTest() {
		System.out.println("execute Delete customer Test");
		System.out.println("bye");
	}


}
