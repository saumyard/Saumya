package com.GenericLibrary;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ScreenShot.SampleScreenShotTest;

public class SampleListener implements ITestListener {
	

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult t) {
		// TODO Auto-generated method stub
		String fTestName=t.getMethod().getMethodName();
		System.out.println("====failed test===>"+fTestName);
		
		//convert driver object to Screenshot 
		TakesScreenshot srcshot=((TakesScreenshot)SampleScreenShotTest.driver);
		
		//take a screenshot
		File srcfile=srcshot.getScreenshotAs(OutputType.FILE);
		
		 //copy the screenshot in to local system
		 //create a new file in local driver
		 File dstfile=new File("C:/Users/SOUMYA/Desktop/myimage3.png");
		 
		 try {
			FileUtils.copyFile(srcfile, dstfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}



}
