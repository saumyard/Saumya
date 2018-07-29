package com.BrowserControl;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SetSizeofGmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://gmail.com");
		
		Dimension dim=new Dimension(100, 400);
		driver.manage().window().setSize(dim);
		//close the window
		driver.close();
		

	}

}
