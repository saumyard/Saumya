package com.Xpath;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.jna.platform.win32.Sspi.TimeStamp;

public class TimeStampInScreenshot {
	
	public static WebDriver driver;
	
	public static void takeScreenShots(String functionalityname) throws IOException
	{
		Date date=new Date();
	   // date.get
		
        //File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dstfile=new File("./Selenium Practice/Screenshot/myimage.png");
		
		//FileUtils.copyFile(srcfile, dstfile);
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		
		
		
		Thread.sleep(3000);

	}

}
