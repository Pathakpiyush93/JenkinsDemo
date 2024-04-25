package com.jenkins.JenkinsDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_For_Jenkins {
	
	@Parameters("Browser")
	@Test
	public void demo(String browserName) {
		WebDriver driver=null;
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.contains("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Assert.assertTrue(driver.getTitle().contains("Orange"), "Title does not match.");
//		driver.close();
	}
}
