package com.WindowHandling;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class NewTabPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://irctc.co.in/");
		
		//close the Popup
		driver.findElement(By.xpath("//a[text()=' X ']")).click();
		
		//click on E-BedRoll,which opens new window
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("Tourism"))).perform();
		driver.findElement(By.linkText("E-Bedroll")).click();
		
		//get all the window IDs dynamically
		Set<String> set=driver.getWindowHandles();
		
		//get the window count
		System.out.println(set.size());
		
		//capture the id from the set collection
		Iterator<String> it=set.iterator();
		
		String ParentID=it.next();
		String ChildID=it.next();
		
		//pass driver control to child window
		driver.switchTo().window(ChildID);
		
		//perform an action on new Window/Tab
		driver.findElement(By.name("pnrNumber")).sendKeys("12345");
		
		//close only one window where driver control is active
		driver.close();
		
		//pass driver control back to parent window
		driver.switchTo().window(ParentID);
		
		//perform an action on parent window
		driver.findElement(By.name("usernameId")).sendKeys("admin");

	}

}
