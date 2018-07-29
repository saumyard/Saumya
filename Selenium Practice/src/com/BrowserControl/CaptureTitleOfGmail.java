package com.BrowserControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureTitleOfGmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://gmail.com");
		//capture the title from the browser
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		if(actTitle.equals("Gmail")) {
			System.out.println("Navigate to gmail app==>pass");
		}else {
			System.out.println("Gmail app is not available==>fail");
			
		}
		driver.close();
		

	}

}
