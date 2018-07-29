package com.Xpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XpathCase4Flipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//navigate to irctctourism.com
		driver.get("https://www.flipkart.com/");
		
		//close the login pop-up
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		//search for Iphone X(space grey,256GB)
		driver.findElement(By.name("q")).sendKeys("Iphone x");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//capture the price of iphone x
		
		String x="//div[text()='Apple iPhone X (Space Gray, 256 GB)']/../following-sibling::div[@class='col col-5-12 _2o7WAb']/div[1]/div/div[1]";
		String Pprice=driver.findElement(By.xpath(x)).getText();
		System.out.println(Pprice.substring(1));

	}

}
