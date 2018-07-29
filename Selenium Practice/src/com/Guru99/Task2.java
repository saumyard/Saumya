package com.Guru99;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/index.php/");
}
	
	@Test
	public void VerifyTheCostOfProduct() {
		
		//click on mobile link
		driver.findElement(By.xpath("//*[text()='Mobile']")).click();
		
		//read the cost of SONY EXPERIA mobile
		String actval=driver.findElement(By.xpath("//span[@id='product-price-1']/span")).getText();
		
		//click on SONY EXPERIA mobile
		driver.findElement(By.xpath("//*[@alt='Xperia']")).click();
		
		//read the cost of SONY EXPERIA from detail page
		String Price=driver.findElement(By.xpath("//*[@id='product-price-1']/span")).getText();
		
		Assert.assertEquals(actval, Price);
		
		
	}
	
	@AfterMethod
	public void logoutTest() {
		driver.close();
	}


}
