package com.SynchronisationWait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWait1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://foxnews.com");
		 
		 //wait for dynamic element
		 FluentWait wait=new FluentWait(driver);
		 
		 wait.pollingEvery(5, TimeUnit.SECONDS);
		 wait.withTimeout(20, TimeUnit.SECONDS);
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Trump")));
		 
		 driver.findElement(By.linkText("Trump")).click();
		

	}

}
