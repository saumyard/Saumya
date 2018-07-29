package com.ActionClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardOprtnInActitime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://soumya-pc:8888/login.do");
		
		//login to App
		WebElement ewb=driver.findElement(By.name("username"));
		ewb.sendKeys("admin");
		
		Actions act=new Actions(driver);
		act.doubleClick(ewb).perform();
		
		//copy the username
		act.sendKeys(Keys.chord(Keys.CONTROL,"c")).perform();
		
		//press tab btn
		act.sendKeys(Keys.TAB).perform();
		
		//paste the username in password box
		act.sendKeys(Keys.chord(Keys.CONTROL,"v")).perform();
		
		
		

	}

}
