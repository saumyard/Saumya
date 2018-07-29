package com.WindowHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://redbus.in/");
		
		//click on calendar icon
		driver.findElement(By.xpath("//label[text()='Onward Date']")).click();
		
		String Date="//div[@id='rb-calendar_onward_cal']//td[text()='29']";
		
		String Next="//div[@id='rb-calendar_onward_cal']//button[text()='>']";
		
		while(true) {
			try {
				driver.findElement(By.xpath("//td[text()='Dec 2018']")).click();
				driver.findElement(By.xpath(Date)).click();
			}catch(Throwable t){
				driver.findElement(By.xpath(Next)).click();
				
			}
		}

	}

}
