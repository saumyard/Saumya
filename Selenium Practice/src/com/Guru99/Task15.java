package com.Guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task15 {
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/index.php/backendlogin/");
}
	@Test
	public void verifyDisabledFields() {
		//login to the App
		//ID
		driver.findElement(By.id("username")).sendKeys("user01");
				
		//password
		driver.findElement(By.id("login")).sendKeys("guru99com");
				
		//Login btn
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		
		//close the Pop-Up
		driver.findElement(By.xpath("//*[@title='close']")).click();
		
		//move cursor to customers
		WebElement cwb=driver.findElement(By.xpath("//*[text()='Customers']"));
		Actions act=new Actions(driver);
		act.moveToElement(cwb).perform();
		
		//click on manage customers
		driver.findElement(By.xpath("//span[text()='Manage Customers']")).click();
		
		//click on 	EDIT link
		driver.findElement(By.xpath("//td[contains(text(),'19227')]/../td[11]/a")).click();
		
		//click on account information
		driver.findElement(By.xpath("//span[text()='Account Information']")).click();
		
	    Boolean stat=driver.findElement(By.id("_accountwebsite_id")).isEnabled();
	    
	    Assert.assertFalse(stat);
	    
	    boolean stat1=driver.findElement(By.id("_accountcreated_in")).isEnabled();
	    
	    Assert.assertFalse(stat1);
	    
	   String stat2= driver.findElement(By.id("_accountnew_password")).getAttribute("value");
	   //String expval="";
	   boolean  pwstat=stat2.isEmpty();
	  // Assert.assertEquals(stat2, expval);
	   Assert.assertTrue(pwstat);
	}

}
