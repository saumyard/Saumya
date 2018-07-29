package com.JavaScript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserScrollBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		driver.navigate().to("https://facebook.com");
		 String jsType="document.getElementById('email').value='saumya'";
		 
		 String jsclick="document.getElementById('u_0_a').click()";
		 
		 String jsbrowserscrollbar="window.scrollBy(0,500)";
		 
		 JavascriptExecutor jobj=(JavascriptExecutor)driver;
		 
		// jobj.executeAsyncScript(jsType, jsclick);
		 jobj.executeScript(jsType);
		 jobj.executeScript(jsclick);
		 jobj.executeScript(jsbrowserscrollbar);
		 
		 
		 

	}

}
