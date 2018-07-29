package com.SelectClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectExpectedValueInMultiSelectDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriver driver=new FirefoxDriver();
		
		driver.get("file:///C:/Users/SOUMYA/Desktop/sam/mypage1.html");
		
		//identify the multiselect webelement in UI
		WebElement wb=driver.findElement(By.xpath("//select[@multiple='true']"));
		
		String expval="java";
		
		//create an object of select class
		Select sel=new Select(wb);
		
		//capture all the option from Dynamic Dropdown
		List<WebElement> lst=sel.getOptions();
		System.out.println(lst.size());
		
		//iterate collection & find the Expected value from the Dropdown
		for(int i=0;i<lst.size();i++) {
			//capture the string data from the option webelement
			String actval=lst.get(i).getText();
		if(expval.equals(actval)) {
			sel.selectByVisibleText(expval);
			System.out.println(expval+"= value is available");
			break;
			}
		}


	}

}
