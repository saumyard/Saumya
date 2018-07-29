package com.BrowserControl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyHomePageOfGmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().to("https://gmail.com");
		
		//login to app
		driver.findElement(By.id("identifierId")).sendKeys("ranjan.saumya355@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys("saumya4528");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(10000);
		
		//verify home page
		String expval="Inbox";
		String actUItitle=driver.getTitle();
		if(actUItitle.contains(expval)) {
			System.out.println("Home page is verified==>Pass");
		}else {
			System.out.println("Home page is not verified==>Fail");
		}
		//logout of app
		driver.findElement(By.xpath("//span[@class='gb_db gbii']")).click();
		driver.findElement(By.xpath("//a[@id='gb_71']")).click();
		driver.close();


	}

}
