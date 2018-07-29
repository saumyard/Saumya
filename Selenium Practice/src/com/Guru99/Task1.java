package com.Guru99;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	//driver=new FirefoxDriver();
	System.setProperty("webdriver.ie.driver", "./IEDriverServer.exe");
	driver=new InternetExplorerDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/index.php/");
}
	
	@Test
	public void verifyItemInMobileListPage() {
		
		//verify the title of Home Page
	    String expTitle="THIS IS DEMO SITE";
		
		String Title=driver.findElement(By.xpath("//*[@class='page-title']/h2")).getText();
		
		String [] arr=Title.split(" ");
		String actTitle=arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3];
		System.out.println(actTitle);
		Boolean stat=actTitle.equalsIgnoreCase(expTitle);
		Assert.assertTrue(stat);
		
		//click on mobile link
		driver.findElement(By.xpath("//*[text()='Mobile']")).click();
		
		//verify the title of 'MOBILE' page
		String expTitle1="MOBILE";
		
		String actTitle1=driver.findElement(By.xpath("//*[@class='page-title category-title']/h1")).getText();
		System.out.println(actTitle1);
		
		boolean stat1=actTitle1.equalsIgnoreCase(expTitle1);
		
		Assert.assertTrue(stat1);
		
		//verify all products sorted by name
		List<WebElement> lst1=driver.findElements(By.xpath("//*[@class='product-name']/a"));
	
		TreeSet<String> set=new TreeSet();
				 
		for(WebElement tmp:lst1) {
			 set.add(tmp.getText());
		}
				 
	    for(String tmp:set) {
			System.out.println(tmp);
		}
		
		//select from SORT BY dropdown
		
		WebElement wb=driver.findElement(By.xpath("//select[@title='Sort By']"));
		
		Select sel=new Select(wb);
		String expval="Name";
		List<WebElement> lst=sel.getOptions();
		
		for(int i=0;i<lst.size();i++) {
			String actval=lst.get(i).getText();
			
			if(expval.equals(actval)) {
				sel.selectByVisibleText(expval);
				break;
			}
		}
		
		List<WebElement> lst2=driver.findElements(By.xpath("//*[@class='product-name']/a"));
		
		for(int i=0;i<lst2.size();i++) { 
			System.out.println(lst2.get(i).getText());
		}
		
		for(int i=0;i<lst2.size();i++) {
			for(String tmp:set) {
				Assert.assertEquals(tmp, lst2.get(i).getText());
				i++;
			}
		}
		 
		 
	}
	
	
	@AfterMethod
	public void logoutTest() {
		driver.close();
	}


}
