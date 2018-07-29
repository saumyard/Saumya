package com.TestNG;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.GenericLibrary.BaseClass1;

public class ParallelExecutionTest extends BaseClass1 {
	
	@Test
	public void Login() {
		
		//login to App
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
	}

}
