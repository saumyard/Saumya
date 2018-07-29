package com.WindowHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AlertPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://irctc.co.in/");
		
		//close the Popup
	    driver.findElement(By.xpath("//a[text()=' X ']")).click();
		
		//click to open an alert PopUp
		driver.findElement(By.id("loginbutton")).click();
		
		//pass a driver control to Alert Window
		Alert alt=driver.switchTo().alert();
		
		//capture the Alert msg
		System.out.println(alt.getText());
		
		//click on ok button
		alt.accept();
		
		//perform an Action on main Window
		driver.findElement(By.id("usernameId")).sendKeys("abcd");

	}

}
