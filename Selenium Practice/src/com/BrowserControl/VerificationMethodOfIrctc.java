package com.BrowserControl;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerificationMethodOfIrctc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Launch the Browser
				WebDriver driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				driver.navigate().to("https://irctc.co.in");
				
				//verify the logo image
				String x="//img[@src='/eticketing/javax.faces.resource/irctc_logo_en_IN.gif.jsf?ln=images']";
				boolean stat=driver.findElement(By.xpath(x)).isDisplayed();
				System.out.println(stat);
				if(stat) {
					System.out.println("image logo is Displayed==>pass");
				}else {
					System.err.println("image logo is not Displayed==>fail");
				}
				
				//verify the otp checkbox
				boolean cstat=driver.findElement(By.id("otpId")).isSelected();
				if(stat) {
					System.out.println("checkbox is Selected==>pass");
				}else {
					System.err.println("checkbox is not Selected==>fail");
				}
				driver.close();
				
				

	}

}
