package com.ScreenShot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

public class GmailScreenShotTest {
	
	@Test
	public void GmailTest() throws IOException {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("https://gmail.com");
		 
		 //create object to eventfiring webdriver 
		 EventFiringWebDriver edriver=new EventFiringWebDriver(driver);
		 
		 //take a Screen shot
		 File srcfile =edriver.getScreenshotAs(OutputType.FILE);
		 
		 //copy the screenshot in to local system
		 //create a new file in local driver
		 File dstfile=new File("C:/Users/SOUMYA/Desktop/myimage2.png");
		 
		 FileUtils.copyFile(srcfile, dstfile);
		 
		 
	}
	

}
