package com.Guru99;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class Task4 {
		
	public static WebDriver driver;
		
		@BeforeMethod
		public void loginTest() {
		driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.guru99.com/index.php/");
	}
		
		@Test
		public void CompareTwoProduct() {
			
			//click on mobile link
			driver.findElement(By.xpath("//*[text()='Mobile']")).click();
			
			//click on Add to Compare button of 'SONY EXPERIA'
			driver.findElement(By.xpath("//*[text()='Sony Xperia']/../../div[3]/ul/li[2]")).click();
				
			//click on Add to Compare button of 'IPHONE'
			driver.findElement(By.xpath("//*[text()='IPhone']/../../div[3]/ul/li[2]")).click();
			/*List<WebElement> lst1=driver.findElements(By.xpath("//*[@class='separator']/../a"));
			
			for(int i=0;i<lst1.size()-1;i++) {
				lst1.get(i).click();
			}*/
			
			List<WebElement> lst3=driver.findElements(By.xpath("//p[@class='product-name']/a"));
			
			for(int i=0;i<lst3.size();i++) {
				System.out.println(lst3.get(i).getText());
			}
		   
			
			//click on compare button
			driver.findElement(By.xpath("//*[@title='Compare']")).click();
			
			//verify the Pop-up window
			//get all the window IDs dynamically
			Set<String> set=driver.getWindowHandles();
			
			//Capture the IDs from the SET of collections
			Iterator<String> it=set.iterator();
			
			String ParentID=it.next();
			String ChildID=it.next();
			
			//pass driver control to child window
			driver.switchTo().window(ChildID);
			
			//Capture the title 'COMPARE PRODUCTS' and Verify 
			String actTitle=driver.findElement(By.xpath("//*[@class='page-title title-buttons']/h1")).getText();
			String expTitle="COMPARE PRODUCTS";
			boolean stat=actTitle.equalsIgnoreCase(expTitle);
			Assert.assertTrue(stat);
			
			//verify the Selected products are present or not
			List<WebElement> lst2=driver.findElements(By.xpath("//*[@class='product-name']/a"));
			
			for(int j=0;j<lst2.size();j++) {
				System.out.println(lst2.get(j).getText());
			}
			
			for(int i=0;i<lst3.size();i++) {
				for(int j=0;j<lst2.size();j++) {
					Assert.assertEquals(lst3.get(i).getText(), lst2.get(j).getText());
				}
			}
			//close the pop up window
			driver.close();
		}
		
		@AfterMethod
		public void logoutTest() {
			driver.close();
		}

}
