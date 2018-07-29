package com.DataDriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.eclipse.jdt.internal.compiler.lookup.ProblemBinding;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetDataFromPropertyFile {

	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//get the file location
		FileInputStream fis=new FileInputStream("D:\\Workspace\\Selenium Practice\\common data.properties");
		
		//get the java representation object of the physical file
		Properties pobj=new Properties();
		
		//load all the keys in to java object
		pobj.load(fis);
		
		//read the data from properties file using "key"
		String urlval=pobj.getProperty("url");
		
		String usernameval=pobj.getProperty("username");
		String passwordval=pobj.getProperty("password");
		String browserval=pobj.getProperty("browser");
		
		System.out.println(urlval);
		System.out.println(usernameval);
		System.out.println(passwordval);
		System.out.println(browserval);
		
		//launch the browser based on properties file data
		if(browserval.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(browserval.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\Selenium Practice\\servers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.get(urlval);

		
		

	}

}
