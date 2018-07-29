package com.Xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Case6Vodafone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//navigate to irctctourism.com
		driver.get("https://www.vodafone.in/home-mumbai");
		
		//close the Pop-Up
		driver.findElement(By.xpath("//a[@class='closeBtn mv_closeBtn']")).click();
		
	    driver.findElement(By.xpath("//h3[text()='121 Prepaid Offers']/following-sibling::a")).click();
	    
	    driver.findElement(By.id("mobileNum")).sendKeys("7263970069");
	    
	    String offers=driver.findElement(By.xpath("//div[@class='offersBoxes']")).getText();
		System.out.println(offers);

	}

}
