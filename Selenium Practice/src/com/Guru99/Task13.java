package com.Guru99;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task13 {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/index.php/backendlogin/");
}

	@Test
	public void verifySortInvoiceDate() {
		//login to the App
		//ID
		driver.findElement(By.id("username")).sendKeys("user01");
				
		//password
		driver.findElement(By.id("login")).sendKeys("guru99com");
				
		//Login btn
		driver.findElement(By.xpath("//*[@value='Login']")).click();
		
		//close the Pop-Up
		driver.findElement(By.xpath("//*[@title='close']")).click();

		//click on Sales
		WebElement wb=driver.findElement(By.xpath("//span[text()='Sales']"));
				
				
		Actions act=new Actions(driver);
		act.moveToElement(wb).perform();
		
		//click on submenu link
		driver.findElement(By.xpath("//span[text()='Invoices']")).click();
		
		List<WebElement> lst=driver.findElements(By.xpath("//table[@id='sales_invoice_grid_table']/tbody/tr/td[3]"));
		
		
	}
}
