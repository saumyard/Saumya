package com.Guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task11 {
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/index.php/backendlogin/");
}
	
	@Test
	public void VerifyInvoiceIsPrinted() throws InterruptedException {
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
		driver.findElement(By.xpath("//span[text()='Orders']")).click();
		
		//select status dropdown
		WebElement swb=driver.findElement(By.xpath("//select[@name='status']"));
		
		Select sel=new Select(swb);
		sel.selectByVisibleText("Canceled");
		
		//click on search button
		driver.findElement(By.xpath("//*[@title='Search']")).click();
		
		//select the first check box
		driver.findElement(By.xpath("//table[@id='sales_order_grid_table']/tbody/tr[1]/td[1]/input")).click();
		
		//select status dropdown
		WebElement awb=driver.findElement(By.id("sales_order_grid_massaction-select"));
				
		Select sel1=new Select(awb);
	    sel1.selectByVisibleText("Print Invoices");
	    
	    //click on submit button
	    driver.findElement(By.xpath("//*[@title='Submit']")).click();
	    
	    //verify the ERROR message
	    String actmsg=driver.findElement(By.xpath("//li[@class='error-msg']/ul/li/span")).getText();
	    String expmsg="There are no printable documents related to selected orders.";
	    
	    Assert.assertEquals(actmsg, expmsg);
	    
	    //select from status dropdown
       WebElement s2wb=driver.findElement(By.xpath("//select[@name='status']"));
		
		Select sel2=new Select(s2wb);
	    sel2.selectByVisibleText("Complete");
	    
	    String jsscroll="window.scrollTo(500,0)";
	     JavascriptExecutor jobj=(JavascriptExecutor)driver;
	     jobj.executeScript(jsscroll);
	    
	   //click on search button
	   driver.findElement(By.xpath("//*[@title='Search']")).click();
	  	
	   //select the first check box
	   driver.findElement(By.xpath("//tbody/tr/td/input[@type='checkbox']")).click();
	   
	   //select print invoices
	   WebElement a1wb=driver.findElement(By.id("sales_order_grid_massaction-select"));
		
		Select sel3=new Select(a1wb);
	    sel3.selectByVisibleText("Print Invoices");
	   
	   Thread.sleep(2000);
	  //click on submit button
	   driver.findElement(By.xpath("//*[@title='Submit']")).click();
	   
	   
	    
	}
	

}
