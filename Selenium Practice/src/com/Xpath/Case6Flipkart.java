package com.Xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Case6Flipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver=new FirefoxDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			//navigate to irctctourism.com
			driver.get("https://www.flipkart.com/");
			
			//close the login pop-up
			driver.findElement(By.xpath("//button[text()='✕']")).click();
			
			//search for 'nokia' product
			driver.findElement(By.name("q")).sendKeys("nokia");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			//capture the complete result from UI
			String x="//span[contains(text(),'Showing')]";
			String UIText=driver.findElement(By.xpath(x)).getText();
			
			//split the Data
			String []arr=UIText.split(" ");
			
			//capture the actual inventory count
			String Count=arr[5];
			
			//convert the String count to ==> Integer count
			int acount=Integer.parseInt(Count);
			System.out.println(acount);
			

	}

}
