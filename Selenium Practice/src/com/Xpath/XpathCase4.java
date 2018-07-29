package com.Xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XpathCase4 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//navigate to irctctourism.com
		driver.get("http://www.irctctourism.com/cgi-bin/dev1.dll/irctc/booking/bestSellerTrains.jsp?");
		 String x="//h1[text()='Bharat Darshan']/following-sibling::a[text()='Book Now']";
		 
		 // click on book now button of Bharat Darshan division
		 driver.findElement(By.xpath(x)).click();
	}

}
