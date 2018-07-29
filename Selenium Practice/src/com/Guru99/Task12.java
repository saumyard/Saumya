package com.Guru99;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task12 {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void loginTest() {
	driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("http://live.guru99.com/");
}
	@Test
	public void verifyProductReview() {
		driver.get("http://live.guru99.com/index.php/review/product/list/id/1/");
		
		//give the review
		driver.findElement(By.id("review_field")).sendKeys("NYC PRODUCT");
		
		driver.findElement(By.id("summary_field")).sendKeys("AWSMM");
		
		driver.findElement(By.id("nickname_field")).sendKeys("SAUMYA RANJAN");
		
		//submit review
		driver.findElement(By.xpath("//*[@title='Submit Review']")).click();
		
		driver.get("http://live.guru99.com/index.php/backendlogin/");
		
		//login to the App
		//ID
		driver.findElement(By.id("username")).sendKeys("user01");
						
		//password
		driver.findElement(By.id("login")).sendKeys("guru99com");
						
		//Login btn
		driver.findElement(By.xpath("//*[@value='Login']")).click();
				
		//close the Pop-Up
		driver.findElement(By.xpath("//*[@title='close']")).click();
		
		WebElement cwb=driver.findElement(By.xpath("//*[text()='Catalog']"));
		Actions act=new Actions(driver);
		act.moveToElement(cwb).perform();
		
		WebElement rwb=driver.findElement(By.xpath("//*[text()='Reviews and Ratings']"));
		act.moveToElement(rwb).perform();
		
		WebElement crwb=driver.findElement(By.xpath("//span[text()='Customer Reviews']"));
		act.moveToElement(crwb).perform();
		
		driver.findElement(By.xpath("//span[text()='Pending Reviews']")).click();
		
		driver.findElement(By.xpath("//td[contains(text(),'1237')]/following-sibling::td[8]/a")).click();
		
		WebElement  swb=driver.findElement(By.id("status_id"));
		Select sel=new Select(swb);
		sel.selectByVisibleText("Approved");
		
		//click on save review
		driver.findElement(By.id("save_button")).click();
		
		//go to home page
		driver.get("http://live.guru99.com/");
		
		//click on mobile menu
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		
		//click on sony experia image
		driver.findElement(By.xpath("//img[@alt='Xperia']")).click();
		
		driver.findElement(By.xpath("(//span[text()='Reviews'])[1]")).click();
		
		List<WebElement> lst=driver.findElements(By.xpath("//*[@id='customer-reviews']/dl/dt[1]/a"));
		
		String expval="AWSMM";
		
		for(int i=0;i<lst.size();i++) {
			String actval=lst.get(i).getText();
		
			Assert.assertEquals(actval, expval);
		}
		
		
		
		
	}
	

}
