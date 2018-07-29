package com.Actitime;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateAndVerifyACustomerInActitime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch the Browser
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://soumya-pc:8888/login.do");
		
		//login to App
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		
		//Navigate to tasks Page
		driver.findElement(By.xpath("//div[text()='Tasks']")).click();
		
		//Navigate to Project&Customers Page
		driver.findElement(By.linkText("Projects & Customers")).click();
		
		//click on Create New Customer btn
		driver.findElement(By.xpath("//input[@value='Create New Customer']")).click();
		
		//Create new Customer By Giving details
		driver.findElement(By.name("name")).sendKeys("saumya453");
		driver.findElement(By.name("description")).sendKeys("chunguuu");
		
		//click on create customer btn
		driver.findElement(By.name("createCustomerSubmit")).click();
		
		//verify the customer created msg
		String expMsg="has been successfully created.";
		String actMsg=driver.findElement(By.xpath("//span[@class='successmsg']")).getText();
		if(actMsg.contains(expMsg)) {
			System.out.println("customer is Successfully created==>pass");
		}else {
			System.out.println("customer is not created==>fail");
		}
		
		//verify the clor of msg
		String actclr=driver.findElement(By.xpath("//span[@class='successmsg']")).getCssValue("color");
		String expclr="rgba(80, 109, 0, 1)";
		//System.out.println(actclr);
		if(actclr.contains(expclr)) {
			System.out.println("color is green==>pass");
		}else {
			System.out.println("color is not green==>fail");
		}

	}

}
