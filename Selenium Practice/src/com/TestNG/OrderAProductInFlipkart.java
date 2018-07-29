package com.TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class OrderAProductInFlipkart  {
	
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
	public void VerifyTheProductNameTest() throws InterruptedException {
		
		WebElement wb=driver.findElement(By.name("q"));
		wb.sendKeys("Iphone7",Keys.ENTER);

		Thread.sleep(2000);
		
		String actval=wb.getAttribute("value");
		
		String act=actval.substring(0,1);
		String act1=actval.substring(1);
		String act2=act.toUpperCase();
		String act3=act2.concat(act1);
		System.out.println(act3);
	    String expval="Iphone7";
	    
		Assert.assertEquals(expval, act3);
		
	}
	
	@Test
	public void VerifyTheSearchResultsTest() {
		
		
		driver.findElement(By.name("q")).sendKeys("Iphone7",Keys.ENTER);
		
		String x="//*[@class='_1-2Iqu row']/div[1]/div[1]";
		
		List<WebElement> lst=driver.findElements(By.xpath(x));
		
		for(int i=1;i<lst.size();i++) {
			String actval=lst.get(i).getText();
			String expval="iPhone 7";
			//System.out.println(actval);
			if (actval.contains(expval)) {
				System.out.println("mobile is present");
				
			}else {
				System.out.println("mobile is not present");
			}
		}
	}
	
	@AfterMethod
	public void logoutTest() {
		driver.close();
	}
	

}
