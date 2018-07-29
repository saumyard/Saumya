package com.Guru99Bank;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericLibrary.TestUtil;

public class Task5 {
	public static WebDriver driver;
	
	String expmsg="User or Password is not valid";
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://www.demo.guru99.com/V4/index.php");
   }
	
	@Test(dataProvider="getLoginData")
	public void verifyLoginTest(String username,String password) {
	
		//login to app
		//id
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(username);
		
		//password
		driver.findElement(By.name("password")).sendKeys(password);
		
		//login btn
	    driver.findElement(By.name("btnLogin")).click();;
		
		try {
			//handle the alert pop-up
			Alert alt=driver.switchTo().alert();
			
			//capture the Alert msg
			String actmsg=alt.getText();
			
			//close the pop-up
			alt.accept();
			
			//verify the msg
			Assert.assertEquals(actmsg, expmsg);
		}
		catch(Exception e) {
			
			String mngrid=driver.findElement(By.xpath("//tr[@class='heading3']/td")).getText();
			String actmsg1=mngrid.substring(12);
			
			Assert.assertEquals(actmsg1, username);
		}
  }
	@DataProvider
	public Object[][] getLoginData() {
		Object data [][]=TestUtil.getTestData("Sheet1");
		System.out.println(data);
		return  data  ;
		/*return new Object[][] {
			{"mngr143994","vurUbeb"},
			{"mngr143994","dfhsiojf"},
			{"dhfuhfha","vurUbeb"},
			{"kapfkpkfp","dhdshid"}
			
		};*/
		
	}
	

	
	@AfterMethod
	public void logoutTest() {
		driver.close();
	}


}
