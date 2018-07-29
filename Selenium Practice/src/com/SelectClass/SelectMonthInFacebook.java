package com.SelectClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectMonthInFacebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://facebook.com");
		 
		 //identify the month dropdown in Gui
		 WebElement mwb=driver.findElement(By.id("month"));
		 
		 //create a object of select class & pass element mwb asargument
		 Select sel=new Select(mwb);
		 
		 //select the value from dropdown
		 sel.selectByVisibleText("Feb");
		 

	}

}
