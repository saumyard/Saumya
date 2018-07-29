package com.Guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task8 {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	//driver=new FirefoxDriver();
	System.setProperty("webdriver.ie.driver", "./IEDriverServer.exe");
	driver=new InternetExplorerDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/index.php/");
}

	@Test
	public void savePDFfile() {
		
		
		//click on 'MY ACCOUNT' link
		driver.findElement(By.xpath("//*[@class='footer']/div[4]/ul/li[1]/a")).click();
		
		//Login to the Application using previous credentials 
		//Email ID
		driver.findElement(By.id("email")).sendKeys("rsaumya71@gmail.com");
		
		//PASSWORD
		driver.findElement(By.id("pass")).sendKeys("saumya4528");
		
		//click on Login btn
		driver.findElement(By.id("send2")).click();
		
		//click on 'MY ORDERS' link
		driver.findElement(By.xpath("//a[text()='My Orders']")).click();
		
		//click on 'VIEW ORDER' Link
		driver.findElement(By.xpath("//a[text()='View Order']")).click();
		
		
		
		
		
		
	}

}
