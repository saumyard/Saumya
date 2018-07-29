package com.WindowHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploadUsingSendkeys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://my.naukri.com/account/createaccount");
		
		//click on "I am Fresher" button
		driver.findElement(By.name("userType")).click();
		
		//set a file path using sendkeys
		driver.findElement(By.name("uploadCV")).sendKeys("C:\\Users\\SOUMYA\\Desktop\\New Microsoft Office Word Document.docx");

	}

}
