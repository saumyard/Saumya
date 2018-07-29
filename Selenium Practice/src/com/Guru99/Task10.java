package com.Guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task10 {
	
public static WebDriver driver;

	
	@BeforeMethod
	public void loginTest() {
	FirefoxProfile profile=new FirefoxProfile();
	profile.setPreference("browser.download.folderList", 0);
	profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");	
	driver=new FirefoxDriver(profile);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/index.php/backendlogin/");
}
	
	@Test
	public void ExportOrdersInCsv() {
		
		//login to the App
		//ID
		driver.findElement(By.id("username")).sendKeys("user01");
		
		//password
		driver.findElement(By.id("login")).sendKeys("guru99com");
		
		//Login btn
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		
		//close the Pop-Up
		driver.findElement(By.xpath("//*[@title='close']")).click();
		
		WebElement wb=driver.findElement(By.xpath("//span[text()='Sales']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(wb).perform();
		
		//click on submenu link
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		
		/*FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.download.folderList", 0);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv");*/
		
		//click on 'EXPORT' btn
		driver.findElement(By.xpath("//*[@title='Export']")).click();
		
		
	}
	
	/*@AfterMethod
	public void logoutTest() {
		driver.close();
	}*/

}
