package com.Guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task6 {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/index.php/");
}
	
	@Test
	public void PurchaseProduct() {
		
		//click on 'MY ACCOUNT' link
		driver.findElement(By.xpath("//*[@class='footer']/div[4]/ul/li[1]/a")).click();
		
		//Login to the Application using previous credentials 
		//Email ID
		driver.findElement(By.id("email")).sendKeys("rsaumya71@gmail.com");
		
		//PASSWORD
		driver.findElement(By.id("pass")).sendKeys("saumya4528");
		
		//click on Login btn
		driver.findElement(By.id("send2")).click();
		
		//click on 'MY WISHLIST' link
		driver.findElement(By.xpath("//a[text()='My Wishlist']")).click();
		
		//click on 'ADD TO CART' link
		driver.findElement(By.xpath("//*[@title='Add to Cart']")).click();
		
		//select the region from dropdown
		WebElement rwb=driver.findElement(By.xpath("//*[@id='region_id']"));
		
		Select sel2=new Select(rwb);
		sel2.selectByVisibleText("New York");
		
		//Enter ZIP
		driver.findElement(By.id("postcode")).sendKeys("542896");
		
		//click on 'ESTIMATE' link
		driver.findElement(By.xpath("//*[@title='Estimate']")).click();
		
		//verify Shipping cost generated
		String actval=driver.findElement(By.xpath("//label/span")).getText();
		
		String expval="$5.00";
		
		Assert.assertEquals(actval, expval);
		
		String actcost=driver.findElement(By.xpath("//strong/span[@class='price']")).getText();
		
		
		
		//Select shipping cost and update total
		driver.findElement(By.name("estimate_method")).click();
		
		//click on 'UPDATE TOTAL' btn
		driver.findElement(By.xpath("//*[@title='Update Total']")).click();
		
		//verify shipping cost is added to total
		//String totalcost=driver.findElement(By.)
		
		
		//click on 'PROCEED TO CHECKOUT' link
		driver.findElement(By.xpath("//*[@class='checkout-types bottom']/li/button")).click();
		
		//Enter Shipping information
		//Address
		driver.findElement(By.id("billing:street1")).sendKeys("ABC");
		
		//CITY
		driver.findElement(By.id("billing:city")).sendKeys("New York");
		
		//STATE
		WebElement swb=driver.findElement(By.xpath("//*[@id='billing:region_id']"));
		
		Select sel=new Select(swb);
		sel.selectByVisibleText("New York");
		
		//ZIP
		driver.findElement(By.id("billing:postcode")).sendKeys("542896");
		
		//TELEPHONE
		driver.findElement(By.id("billing:telephone")).sendKeys("12345678");
		
		//click on CONTINUE
		driver.findElement(By.xpath("//*[@id='billing-buttons-container']/button")).click();
		
		
		
	}

}
