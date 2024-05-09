package com.guru99.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import junit.framework.Assert;

public class loginTests extends BaseTest{
	
	@Parameters({"username", "userPassword"})
	
	@Test
	public void verifyUserLoginWithCorrectCredentials(String username, String password) {
		
		loginpage.loginToApplication(username, password);
		
		String expectedTitle = "Guru99 Bank Manager HomePage";
		String actualTitle = cmnDriver.getTitleOfThePage();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		
	}
}
