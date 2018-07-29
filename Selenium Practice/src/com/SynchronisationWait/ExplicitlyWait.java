package com.SynchronisationWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitlyWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://foxnews.com");
		 
		 //wait for dynamic element
		 WebDriverWait wait=new WebDriverWait(driver, 20);
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Trump")));
		 
		 //click on dynamic element
		 driver.findElement(By.linkText("Trump")).click();

	}

}
