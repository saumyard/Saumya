package com.BrowserControl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyErrorMsgInGmail {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().to("https://gmail.com");
		
		//Login to App
		driver.findElement(By.id("identifierId")).sendKeys("ranjan.saumya31@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(2000);
		//Verify Error msg should be Display
		String x="(//div[@class='dEOOab RxsGPe'])[1]";
		String actmsg=driver.findElement(By.xpath(x)).getText();
		String expmsg="Couldn't find your Google Account";
		System.out.println(actmsg);
		if(expmsg.equals(actmsg)) {
			System.out.println("Error mssg is verified==>pass");
		}else {
			System.out.println("Error mssg is not verified==>fail");
		}
		
		//verify the Error msg color
		String actclr=driver.findElement(By.xpath(x)).getCssValue("color");
		System.out.println(actclr);
		String expclr="rgba(213, 0, 0, 1)";
		if(actclr.equals(expclr)) {
			System.out.println("Error mssg color  is verified==>pass");
		}else {
			System.out.println("Error mssg color is not verified==>fail");
		}
		driver.close();

	}

}
