package com.iaf.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.iaf.base.BasePageObject;


public class LoginRenaissancePage extends BasePageObject<LoginRenaissancePage>  {	

	private static final String URL="https://hostedzone19.renlearn.com/qatest5/default.aspx";
	private By selectTeacher=By.xpath("//span[contains(text(),'Administrator')]");	
	private By userField =By.xpath("//*[contains(text(),'User Name')]//following::input");
	private By passwordField=By.xpath("//*[contains(@id,'tbPassword')]");	
	private By goButton=By.xpath("//*[contains(text(),'Log In  ')]");	
    private By errorMessage=By.xpath("//div[contains(text(),'Please try again.')]//preceding-sibling::div[2]//following::div");
  
    public LoginRenaissancePage(WebDriver driver, Logger log) {
	super(driver,log);		
	}	
	public void openURL(){
		getPage(URL);
	}
	
	public void loginToRenaissance(String email ,String password){		
		log.info("Clicking Sign In link");
		click(selectTeacher);
		log.info("Entering Login Detail");
		waitForVisisbilityOf(userField,20);
		type (email, userField);	
		type(password, passwordField);
		}

	
	public RenaissanceLandingPage pushLogin(){
		log.info("Clicking Go Button");
		click(goButton);		
		return new RenaissanceLandingPage(driver,log);		
	}
	
	public String getLoginErrorMessage() {
		waitForVisisbilityOf(errorMessage, 10);
		return getText(errorMessage);		
	}
	

}
