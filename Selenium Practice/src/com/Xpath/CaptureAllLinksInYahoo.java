package com.Xpath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureAllLinksInYahoo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com");
		
		//identify all the links available in UI
		List<WebElement> lst=driver.findElements(By.xpath("//a"));
		
		//get al the link count
		System.out.println(lst.size());
		
		//display all the link name
		for(WebElement wb:lst) {
			String lnkname=wb.getText();
			System.out.println(lnkname);
		}

	}

}
