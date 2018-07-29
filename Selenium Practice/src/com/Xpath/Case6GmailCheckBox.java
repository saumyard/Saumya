package com.Xpath;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Case6GmailCheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		
		//login to app
		driver.findElement(By.id("identifierId")).sendKeys("rsaumya71@gmail.com");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		driver.findElement(By.name("password")).sendKeys("saumya4528");
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		//identify all the checkboxes in gmail
		String x="//table[@class='F cf zt']/tbody/tr[*]/td[2]/div";
		
		List<WebElement> lst=driver.findElements(By.xpath(x));
		
		//select all the checkbox
		for(WebElement wb:lst) {
			wb.click();
		}
		
		
		

	}

}
