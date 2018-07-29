package com.Guru99Bank;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.GenericLibrary.FileData;

public class Task3 {
	
public static WebDriver driver;

String expmsg="User or Password is not valid";
FileData fLib = new FileData();
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://www.demo.guru99.com/V4/index.php");
}

	@Test
	public void verifyLoginWithValidData() throws InvalidFormatException, IOException, Throwable {
		
		String usrid=fLib.getExcelData("Sheet1", 1, 2);
		String passwrd=fLib.getExcelData("Sheet1", 1, 3);
		
		//ID
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(usrid);
		
		//password
		driver.findElement(By.name("password")).sendKeys(passwrd);
		
		//login btn
		driver.findElement(By.name("btnLogin")).click();
		
		Thread.sleep(2000);
		//verify login is successful
		String actval=driver.getTitle();
		//System.out.println(actval);
		String expval="Guru99 Bank Manager HomePage";
		Assert.assertEquals(actval, expval);
	}
	
	@Test
	public void verifyLoginWithInValidUserID() throws InvalidFormatException, IOException, Throwable {
		
		String usrid=fLib.getExcelData("Sheet1", 2, 2);
		String passwrd=fLib.getExcelData("Sheet1", 2, 3);
		
		//ID
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(usrid);
		
		//password
		driver.findElement(By.name("password")).sendKeys(passwrd);
		
		//login btn
		driver.findElement(By.name("btnLogin")).click();
		
		//handle the alert pop-up
		Alert alt=driver.switchTo().alert();
		
		//capture the Alert msg
		String actmsg=alt.getText();
		
		//close the pop-up
		alt.accept();
		
		//verify the msg
		Assert.assertEquals(actmsg, expmsg);
   }

	@Test
	public void verifyLoginTestWithInValidPassword() throws InvalidFormatException, IOException, Throwable {
		
		String usrid=fLib.getExcelData("Sheet1", 3, 2);
		String passwrd=fLib.getExcelData("Sheet1", 3, 3);
		
		//ID
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(usrid);
		
		//password
		driver.findElement(By.name("password")).sendKeys(passwrd);
		
		//login btn
		driver.findElement(By.name("btnLogin")).click();
		
		//handle the alert pop-up
		Alert alt=driver.switchTo().alert();
		
		//capture the Alert msg
		String actmsg=alt.getText();
		
		//close the pop-up
		alt.accept();
		
		//verify the msg
		Assert.assertEquals(actmsg, expmsg);

		
	}
	
	@Test
	public void verifyLoginTestWithInValidUserIDandPasswrd() throws InvalidFormatException, IOException, Throwable {
		
		String usrid=fLib.getExcelData("Sheet1", 4, 2);
		String passwrd=fLib.getExcelData("Sheet1", 4, 3);
		
		//ID
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(usrid);
		
		//password
		driver.findElement(By.name("password")).sendKeys(passwrd);
		
		//login btn
		driver.findElement(By.name("btnLogin")).click();
		
		//handle the alert pop-up
		Alert alt=driver.switchTo().alert();
		
		//capture the Alert msg
		String actmsg=alt.getText();
		
		//close the pop-up
		alt.accept();
		
		//verify the msg
		Assert.assertEquals(actmsg, expmsg);
   }
	
	@AfterMethod
	public void logoutTest() {
		driver.close();
	}



}
