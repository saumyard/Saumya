package com.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSuggestEditBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in");
		
		//pass data in to Auto-Suggest Edit box
		driver.findElement(By.name("q")).sendKeys("wipro j");
		driver.findElement(By.xpath("//b[text()='obs in bangalore']")).click();
		
		//identify the element where you want to perform right click
		WebElement wb=driver.findElement(By.linkText("Wipro Careers | Discover a World of Opportunities | Join Us Today!"));
        
		//create a object of Actions class
		Actions act=new Actions(driver);
		
		//perform right click operation on the specific element
		act.contextClick(wb).perform();
		
		//pass "short-cut" keys
		act.sendKeys("T").perform();
	}

}
