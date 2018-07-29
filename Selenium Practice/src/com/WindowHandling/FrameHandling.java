package com.WindowHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");
		
		//pass driver control to frame-2
		driver.switchTo().frame("classFrame");
		
		//click on "link" when link present in Frame-2
		driver.findElement(By.linkText("com.thoughtworks.selenium")).click();
		
		//pass driver control to main window
		driver.switchTo().defaultContent();
		
		//pass driver control to Frame-3
		driver.switchTo().frame("packageFrame");
		
		//click on "link" when link is present in Frame-3
		driver.findElement(By.linkText("Actions")).click();

	}

}
