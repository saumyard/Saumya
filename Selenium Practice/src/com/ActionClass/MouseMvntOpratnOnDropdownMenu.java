package com.ActionClass;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMvntOpratnOnDropdownMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		
		//identify the "Departments" dropdown menu in UI
		WebElement wb=driver.findElement(By.xpath("//span[text()='Departments']"));
		
		//create a object of Action class
		Actions act=new Actions(driver);
		
		//take mouse cursor on middle of the respective element & execute operations
		act.moveToElement(wb).perform();;
		
		//click on 'submenu link'
		driver.findElement(By.xpath("//span[text()='Full Store Directory']")).click();
		

	}

}
