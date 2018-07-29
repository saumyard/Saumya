package com.Actitime;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateACustomerWithExistingName {

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
				
				//verify the error msg
				String actmsg=driver.findElement(By.xpath("//span[@class='errormsg']")).getText();
				String expmsg="already exists. Please choose other customer name.";
				if(actmsg.contains(expmsg)) {
					System.out.println("error mssg is verified==>pass");
				}else {
					System.out.println("error mssg is not verified==>fail");
				}
						

	}

}
