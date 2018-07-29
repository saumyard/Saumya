package com.BrowserControl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptureTilteUrlPageSourceOfGmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.get("https://gmail.com");
		//capture the title from the browser
		String actTitle=driver.getTitle();
		System.out.println(actTitle);
		String actUrl=driver.getCurrentUrl();
		System.out.println(actUrl);
		/*String pageHTMLcode=driver.getPageSource();
		System.out.println(pageHTMLcode);*/
		driver.close();

	}

}
