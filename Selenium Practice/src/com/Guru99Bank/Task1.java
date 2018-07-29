package com.Guru99Bank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://www.demo.guru99.com/V4/index.php");
}
	
	@Test
	public void verifyLogin() throws InterruptedException {
		//login to app
		//id
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("mngr143994");
		
		//password
		driver.findElement(By.name("password")).sendKeys("vurUbeb");
		
		//login btn
		driver.findElement(By.name("btnLogin")).click();
		
		Thread.sleep(2000);
		//verify login is successful
		String actval=driver.getTitle();
		//System.out.println(actval);
		String expval="Guru99 Bank Manager HomePage";
		Assert.assertEquals(actval, expval);
	}
	
	@AfterMethod
	public void logoutTest() {
		driver.close();
	}
	
	

}
