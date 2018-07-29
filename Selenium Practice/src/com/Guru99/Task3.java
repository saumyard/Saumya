package com.Guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class Task3 {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/index.php/");
}
	
	@Test
	public void VerifyTheCapacityOfCart() {
		
		//click on mobile link
		driver.findElement(By.xpath("//*[text()='Mobile']")).click();
		
		//click on 'ADD TO CART' for 'SONY EXPERIA' mobile
		driver.findElement(By.xpath("//*[@title='Xperia']/../div/div[3]/button")).click();
		
		//change quantity value to 1000
		String x="//*[@class='input-text qty']";
		
		driver.findElement(By.xpath(x)).clear();
		
		driver.findElement(By.xpath(x)).sendKeys("1000");
		
		//click on Update button
		driver.findElement(By.xpath("//*[@title='Update']")).click();
		
		//Verify the Error message
		String actval=driver.findElement(By.xpath("//*[@class='item-msg error']")).getText();
		
		String expval="* The maximum quantity allowed for purchase is 500.";
		
		Assert.assertEquals(actval, expval);
		
		//click on 'EMPTY CART' link
		driver.findElement(By.xpath("//*[@title='Empty Cart']")).click();
		
		//verify message 'SHOPPING CART IS EMPTY' shown
		String actmsg=driver.findElement(By.xpath("//*[@class='page-title']/h1")).getText();
		
		String expmsg="SHOPPING CART IS EMPTY";
		
		boolean stat=actmsg.equalsIgnoreCase(expmsg);
		
		Assert.assertTrue(stat);
	}
	
	@AfterMethod
	public void logoutTest() {
		driver.close();
	}

}
