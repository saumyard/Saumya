package com.Practical;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CaptureProductRatingAndFeatureInFlipkart {
	
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
	public void CaptureProductRatingTest() throws InterruptedException {
		
		WebElement wb=driver.findElement(By.name("q"));
		wb.sendKeys("Iphone7",Keys.ENTER);
		
		/*//Scroll down opeartion by using java Script
	     String BrowserScrollbar="window.scrollBy(0,300)";
				
		 JavascriptExecutor jobj=(JavascriptExecutor)driver;
		 jobj.executeScript(BrowserScrollbar);*/
			
		
		//String pname="//div[text()='Apple iPhone 7 (Rose Gold, 32 GB)']";
		
		String rating =driver.findElement(By.xpath("//div[text()='Apple iPhone 7 (Rose Gold, 32 GB)']/../div[2]/span/div")).getText();
		Thread.sleep(3000);
		System.out.println("Rating of the product is "+rating.substring(0, 3));
		
	}
	
	
	
	@Test
	public void CaptureProductFeatureTest() {
		
		WebElement wb=driver.findElement(By.name("q"));
		wb.sendKeys("Iphone7",Keys.ENTER);
		
		String x="//div[text()='Apple iPhone 7 (Rose Gold, 32 GB)']/../div[3]/ul/li";
		
		List<WebElement> Features=driver.findElements(By.xpath(x));
		
		for(int i=0;i<Features.size();i++) {
			System.out.println(Features.get(i).getText());
		}
		
	}
	
	@AfterMethod
	public void logoutTest() {
		driver.close();
	}

}
