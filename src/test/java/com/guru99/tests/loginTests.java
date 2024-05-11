package com.guru99.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.Status;

import junit.framework.Assert;

public class loginTests extends BaseTest{
	
	@Parameters({"username", "userPassword"})
	
	@Test
	public void verifyUserLoginWithCorrectCredentials(String username, String password) {
		
//		reportUtils.createATestCase("verify User Login With Correct Credentials");
//		
//		reportUtils.addTestLog(Status.INFO , "Performing Login");
		loginpage.loginToApplication(username, password);
		
		
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = cmnDriver.getTitleOfThePage();
		
//		reportUtils.addTestLog(Status.INFO , "Comparing actual & expected title");
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
}
