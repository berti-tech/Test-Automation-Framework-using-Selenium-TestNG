package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// We will define all the webElements 
public class LoginPage extends BasePage{
	
	@CacheLookup
	@FindBy(name="uid")
	private WebElement userId;
	
	@CacheLookup
	@FindBy(name="password")
	private WebElement userPasswd;
	
	@CacheLookup
	@FindBy(name="btnLogin")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		// To initialize all the webElements, we have pageFactory
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String username, String password) {
		
		elementControl.setText(userId, username);

		elementControl.setText(userPasswd, password);
		
		elementControl.clickElement(loginButton);
	}
	
	
}



