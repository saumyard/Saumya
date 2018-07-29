package com.SelectClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new FirefoxDriver();
		
		driver.get("file:///C:/Users/SOUMYA/Desktop/sam/mypage1.html");
		
		//identify the multiselect webelement in UI
		WebElement wb=driver.findElement(By.xpath("//select[@multiple='true']"));
		
		//create an object of select class
		Select sel=new Select(wb);
		
		//check the dropdown is single select or multi select
		boolean stat=sel.isMultiple();
		
		if(stat) {
			//select all the value based on index
			for(int i=1;i<=7;i++) {
				sel.selectByIndex(i);
			}
		}else {
				System.out.println("Not a multiselect dropdown");
			
		}

	}

}
