package com.WindowHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class FileDownloadPopUp {
	
	public static void main(String[] args) {
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 2);
		
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");
		profile.setPreference("browser.download.dir", "D:\\sam1");
		
		WebDriver driver=new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://maven.apache.org/download.cgi");
		 
		 //click on a link which open file download popup
		 driver.findElement(By.linkText("apache-maven-3.5.3-bin.zip")).click();
	
	}

}
