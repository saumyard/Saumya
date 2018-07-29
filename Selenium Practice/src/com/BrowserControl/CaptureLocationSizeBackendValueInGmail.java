package com.BrowserControl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Point;
public class CaptureLocationSizeBackendValueInGmail {

	public static void main(String[] args) {
		
		// Launch the Browser
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.navigate().to("https://gmail.com");
		
		//Verify the Email textbox
		WebElement ewb=driver.findElement(By.id("identifierId"));
		 //capture the backend value
		String backval=ewb.getAttribute("aria-label");
		System.out.println(backval);
		
		//capture the location of the Email Text Box
		Point p=ewb.getLocation();
		System.out.println("x-co-ordinate= "+p.getX());
		System.out.println("x-co-ordinate= "+p.getY());
		
		//capture the size of the Email text box
		Dimension dem=ewb.getSize();
		System.out.println("Height of the ele= "+dem.getHeight());
		System.out.println("Height of the ele= "+dem.getWidth());
		driver.close();

	}

}
