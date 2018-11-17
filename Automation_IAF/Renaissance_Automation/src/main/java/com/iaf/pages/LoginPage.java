package com.iaf.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.iaf.base.BasePageObject;
import com.iaf.base.BaseTest;

public class LoginPage extends BasePageObject<LoginPage> {
	private static final String URL="http://www.rediff.com/";
	private By signInLink=By.xpath("//a[text()='Sign in']");	
	private By userField =By.xpath("//input[@name='login']");
	private By passwordField=By.xpath("//input[@name='passwd']");	
	private By goButton=By.xpath("//input[@value='Go']");	
    private By errorMessage=By.xpath("//div[contains(text(),'Please try again.')]//preceding-sibling::div[2]//following::div");
	    
    public LoginPage(WebDriver driver, Logger log) {
	super(driver,log);		
	}	
	public void openURL(){
		getPage(URL);
	}
	
	public void loginToRediff(String email ,String password){		
		log.info("Clicking Sign In link");
		click(signInLink);
		log.info("Entering Login Detail");
		type (email, userField);	
		type(password, passwordField);
		BaseTest b=new BaseTest();
				}
	
	public ProfilePage pushLogin(){
		log.info("Clicking Go Button");
		click(goButton);		
		return new ProfilePage(driver,log);		
	}
	
	public String getLoginErrorMessage() {
		waitForVisisbilityOf(errorMessage, 10);
		return getText(errorMessage);		
	}
	
	
}
