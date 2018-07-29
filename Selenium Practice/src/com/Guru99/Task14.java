package com.Guru99;

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

public class Task14 {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/index.php/");
}
	
	@Test
	public void verifySearchFunctionality() {
		
		//click on Advance Search
		driver.findElement(By.xpath("//a[text()='Advanced Search']")).click();
		
		//in price field enter range 0-150
		driver.findElement(By.id("price")).sendKeys("0");
		driver.findElement(By.id("price_to")).sendKeys("150");
		
		//click on search btn
		driver.findElement(By.xpath("//div[@class='buttons-set']/button")).click();
		
		//get the product name
		List<WebElement> lst=driver.findElements(By.xpath("//ul/li/div/h2/a"));
		
		List<WebElement> lst1=driver.findElements(By.xpath("//ul/li/div/div[1]//span[@class='price']"));
		
		try {
		for(int i=0;i<lst.size();i++) {
			for(int j=0;j<lst1.size();j++) {
			String Pname=lst.get(i).getText();
			System.out.println(Pname);
			if(j==1) {
				j++;
			}
			String Price=lst1.get(j).getText();
			System.out.println(Price);
			i++;
			
			}
			
		}
		}
		catch(Exception e) {
			System.out.println("handled");
		}
		
		//modify the search
		driver.findElement(By.xpath("//a[text()='Modify your search']")).click();
		
		//in price field enter range 0-150
		driver.findElement(By.id("price")).sendKeys("151");
		driver.findElement(By.id("price_to")).sendKeys("1000");
				
		//click on search btn
		driver.findElement(By.xpath("//div[@class='buttons-set']/button")).click();
				
		//get the product name
		List<WebElement> lst2=driver.findElements(By.xpath("//ul/li/div/h2/a"));
				
		List<WebElement> lst3=driver.findElements(By.xpath("//ul/li/div/div[1]//span[@class='price']"));
	
		try {
		for(int i=0;i<lst2.size();i++) {
			for(int j=0;j<lst3.size();j++) {
			String Pname=lst2.get(i).getText();
			System.out.println(Pname);
			String Price=lst3.get(j).getText();
			System.out.println(Price);
			i++;
			if(j==1) {
				j++;
			}
			}
		}
		}
		catch(Exception e) {
			System.out.println("handled");
			
		}
		
	}
	@AfterMethod
	public void logoutTest() {
		driver.close();
	}
	

}
