package com.TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PlacingOrderTest {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com");
	driver.
	findElement(By.xpath("//*[text()='✕']")).click();
	
	}
	
	@Test
	public void PlacingOrderTest()  {
		
		WebElement wb=driver.findElement(By.name("q"));
		wb.sendKeys("Iphone7",Keys.ENTER);
		
		driver.findElement(By.xpath("//div[text()='Apple iPhone 7 (Rose Gold, 32 GB)']")).click();
		
		driver.findElement(By.xpath("//*[text()='ADD TO CART']")).click();
		
		driver.findElement(By.xpath("//*[@method='post']/button")).click();
		
		


	}
}
