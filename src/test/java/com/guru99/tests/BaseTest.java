package com.guru99.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.guru99.pages.LoginPage;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.configUtils;


public class BaseTest {
	
	CommonDriver cmnDriver;
	String url;
	
	WebDriver driver;
	
	LoginPage loginpage;
	
	String configFileName;
	String currentWorkingDirectory;
	
	Properties configProperty;
	
	
	@BeforeSuite
	public void preSetup() throws Exception {
		currentWorkingDirectory = System.getProperty("user.dir");
		
		configFileName = currentWorkingDirectory + "/config/config.properties";
		configProperty = configUtils.readProperties(configFileName);
	}
	
	@BeforeClass
	public void setup() throws Exception {
		url = configProperty.getProperty("baseURL");
		
		String browserType = configProperty.getProperty("browserType");
		
		cmnDriver = new CommonDriver(browserType);
		
		driver = cmnDriver.getDriver();
		
		loginpage = new LoginPage(driver);
		
		cmnDriver.navigateToURL(url);
	}
	
	@AfterClass
	public void tearDown() {
		cmnDriver.closeAllBrowser();
	}
}
