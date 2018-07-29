package com.Assert;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericLibrary.BaseClass;

public class HardAssertTest extends BaseClass{
	
	@Test
	public void verifyHomePageTest() {
		String Expval="actiTIME - Enter Time-Track";
		
		//capture the Title from the HomePage
		String actTitle=driver.getTitle();
		
		/*//verify the HomePage
		Assert.assertEquals(actTitle, Expval);*/
		
		//create a object of Soft-Assert
		SoftAssert s=new SoftAssert();
		s.assertEquals(actTitle, Expval);
		s.assertAll();
		System.out.println("Home Page is verified==>Pass");
		System.out.println("====END====");
		
	}
	
	@Test
	public void verifyLogoTest() {
		boolean actStat=driver.findElement(By.xpath("//td[@class='logoCell']/div/div[3]/img")).isDisplayed();
		//Assert.assertTrue(actStat);
		
		//create a object of Soft-Assert
				SoftAssert s=new SoftAssert();
				s.assertTrue(actStat);;
				s.assertAll();
		
	}

}
