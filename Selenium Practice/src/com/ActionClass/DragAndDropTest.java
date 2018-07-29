package com.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		
		//identify source & destination element in UI
		WebElement swb=driver.findElement(By.id("draggable"));
		
		WebElement dwb=driver.findElement(By.id("droptarget"));
		
		//create a object of Actions class
		Actions act=new Actions(driver);
		act.dragAndDrop(swb, dwb).perform();

	}

}
