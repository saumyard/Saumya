package com.Guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Task5 {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/index.php/");
}

	@Test
	public void CreateAccount() {
		
		//click on My Account link
		driver.findElement(By.xpath("//*[@class='footer']/div[4]/ul/li[1]/a")).click();
		
		//click on create Account link 
		driver.findElement(By.xpath("//*[@title='Create an Account']")).click();
		
		//fill new user information
		//FIRST NAME
		driver.findElement(By.id("firstname")).sendKeys("saumya");
		
		//LAST NAME
		driver.findElement(By.id("lastname")).sendKeys("ranjan");
		
		//Email ID
		driver.findElement(By.id("email_address")).sendKeys("rsaumya71@gmail.com");
		
		//PASSWORD
		driver.findElement(By.id("password")).sendKeys("saumya4528");
		
		//CONFIRM PASSWORD
		driver.findElement(By.id("confirmation")).sendKeys("saumya4528");
		
		//click on REGISTER btn
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		//Verify the REGISTRATION is done
		
		String actmsg=driver.findElement(By.xpath("//li[@class='success-msg']/ul/li/span")).getText();
		
		String expmsg="Thank you for registering with Main Website Store.";
		
		Assert.assertEquals(actmsg, expmsg);
		
		//click on TV menu
		driver.findElement(By.xpath("//a[text()='TV']")).click();
		
		//ADD 'LG LCD' in your Wishlist
		driver.findElement(By.xpath("//a[text()='LG LCD']/../../div[3]/ul/li[1]")).click();
		
		//click on SHARE WISHLIST
		driver.findElement(By.xpath("//*[@title='Share Wishlist']")).click();
		
		//Enter email ID to share the Wishlist
		driver.findElement(By.id("email_address")).sendKeys("vicky4528@gmail.com");
		
		//Enter a message
		driver.findElement(By.id("message")).sendKeys("Wishlist is shared");
		
		//click on 'SHARE WISHLIST' btn
		driver.findElement(By.xpath("//*[@title='Share Wishlist']")).click();
		
		//Verify WISHLIST is shared
		String actmsg1=driver.findElement(By.xpath("//*[@class='success-msg']/ul/li/span")).getText();
		
		String expmsg1="Your Wishlist has been shared.";
		
		Assert.assertEquals(actmsg1, expmsg1);
		
	}
	
	@AfterMethod
	public void logoutTest() {
		driver.close();
	}

}
