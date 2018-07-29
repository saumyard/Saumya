package com.Guru99;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class FileDownload {
	
	WebDriver driver;
	File folder;
	
	@BeforeMethod
	public void setUp() {
		folder =new File(UUID.randomUUID().toString());
		
		folder.mkdir();
		
		//chrome
		System.setProperty("webdriver.chrome.driver", "./Selenium Practice/Resource/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		
		Map<String, Object> prefs=new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.defaullt_directory", folder.getAbsolutePath());
		
		options.setExperimentalOption("perfs", prefs);
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		driver=new ChromeDriver(cap);
		
		
	}
	
	@Test
	public void downloadFileTest() throws InterruptedException {
		driver.get("http://the-internet.herokrupp.com/download");
		driver.findElement(By.linkText("some-file.txt")).click();
		
		//wait for 2 secs to load the file
		Thread.sleep(2000);
		
		
		File listoffiles[]=folder.listFiles();
		
		//make sure the directory is not empty
		Assert.assertEquals(listoffiles.length, is(not(0)));
		
		for(File file:listoffiles) {
			//make sure that downloaded file is not empty
			Assert.assertEquals(file.length(), is(not((long)0)));
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		for(File file:folder.listFiles()) {
			file.delete();
		}
		folder.delete();
	}
}
