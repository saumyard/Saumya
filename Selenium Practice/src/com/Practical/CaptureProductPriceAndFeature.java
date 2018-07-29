package com.Practical;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CaptureProductPriceAndFeature {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com");
	driver.
	findElement(By.xpath("//*[text()='✕']")).click();
	
	}
	
	@Test
	public void CaptureProductPriceTest() {
		
		WebElement wb=driver.findElement(By.name("q"));
		wb.sendKeys("Iphone7",Keys.ENTER);
		
		String x="//div[text()='Apple iPhone 7 (Rose Gold, 32 GB)']/../../div[2]/div[1]/div/div[1]";
		
		String Pprice=driver.findElement(By.xpath(x)).getText();
		
		System.out.println(Pprice.substring(1));
	}
	
	@Test
	public void CaptureProductoffersTest() {
		
		WebElement wb=driver.findElement(By.name("q"));
		wb.sendKeys("Iphone7",Keys.ENTER);
		
		String x="//div[text()='Apple iPhone 7 (Rose Gold, 32 GB)']/../../div[2]/div[5]/ul/li";
		
		List<WebElement> offers=driver.findElements(By.xpath(x));
		
		for(int i=0;i<offers.size();i++) {
			System.out.println(offers.get(i).getText());
		}
	}
	
	@AfterMethod
	public void logoutTest() {
		driver.close();
	}

}
