package com.GenericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass1 {
	
	//object declaration
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void configBC(String bName) {
		System.out.println("===launch Browser===");
		
		if(bName.equals("firefox")){
			driver=new FirefoxDriver();
		}else if(bName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "./Resource/chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://soumya-pc:8888/login.do");
		
	}

}
