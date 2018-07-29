package com.ScreenShot;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.GenericLibrary.SampleListener.class)
public class SampleScreenShotTest {
	
	
	public static WebDriver driver=new FirefoxDriver();
	
	@Test
	public void CreateCustomerTest() {
		System.out.println("Execute Create Customer Test");
		
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://soumya-pc:8888/login.do");
		Assert.assertEquals("A", "B");
		driver.close();
	}
	
	@Test
	public void CreateCustomerWithDescTest() {
		System.out.println("Execute Create Customer With Desc Test");
	}

}
