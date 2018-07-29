package com.GenericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	//object declaration
	public static WebDriver driver;
	
	@BeforeClass
	public void congigBC() {
		System.out.println("== Launch the Browser==");
		driver=new FirefoxDriver();
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("Log in");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://soumya-pc:8888/login.do");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("logout");
		driver.findElement(By.xpath("//a[@class='logout']")).click();
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("==close the Browser==");
		driver.close();
	}

}
