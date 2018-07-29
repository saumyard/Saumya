package com.Xpath;

import java.awt.Desktop.Action;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CaptureProductRatingAndPriceInAmazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriver driver=new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//navigate to irctctourism.com
		driver.get("https://www.amazon.in/");
		
		//search for Iphone x
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone x");
		driver.findElement(By.xpath("(//input[@class='nav-input'])[1]")).click();
		
		//capture the price of iphone x(silver,256GB)
		String x="//h2[text()='Apple iPhone X (Silver, 256GB)']/../../../../div[5]/div[1]/a/span";
		String Pprice=driver.findElement(By.xpath(x)).getText();
		System.out.println(Pprice.substring(1));
		
		//capture the rating of iphone x(silver,256GB)
		String y="//h2[text()='Apple iPhone X (Silver, 256GB)']/../../../../div[7]/span";
		
		//Scroll down opeartion by using java Script
		String BrowserScrollbar="window.scrollBy(0,500)";
		
		JavascriptExecutor jobj=(JavascriptExecutor)driver;
		jobj.executeScript(BrowserScrollbar);
		
		WebElement wb=driver.findElement(By.xpath(y));
		Thread.sleep(2000);
		
		//create a object of Action class
		Actions act=new Actions(driver);
		 act.moveToElement(wb).perform();;
		 
		 
		 String z="//table[@id='histogramTable']/tbody/tr/td[2]/a";
		 List<WebElement> Prating=driver.findElements(By.xpath(z));
		 
		 for(int i=0;i<Prating.size();i++) {
			 System.out.println("ratings are "+Prating.get(i).getAttribute("title"));
		 }
		
			
		
		
		
		

	}

}
