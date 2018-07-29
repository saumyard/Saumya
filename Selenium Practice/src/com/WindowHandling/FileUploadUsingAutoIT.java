package com.WindowHandling;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploadUsingAutoIT {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://my.naukri.com/account/createaccount");
		
		//click on "I am Fresher" button
		driver.findElement(By.name("userType")).click();
		
		//open file upload pop-up
		driver.findElement(By.name("uploadCV")).click();
		
		Thread.sleep(3000);
		
		//execute AutoIT code
		Runtime.getRuntime().exec("C:\\Users\\SOUMYA\\Desktop\\sam1.exe");


	}

}
