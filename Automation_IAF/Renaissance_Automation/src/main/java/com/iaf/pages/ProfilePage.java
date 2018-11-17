package com.iaf.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.iaf.base.BasePageObject;

public class ProfilePage extends BasePageObject<ProfilePage>{
	
	private By inBoxLink=By.xpath("//a[text()='Inbox']");	
	private By profileCorrectNameLocator=By.xpath("//a[contains(text(),'Sanyasi das')]");

	public ProfilePage(WebDriver driver, Logger log) {
		super(driver, log);		
	}	
	public void waitForProfilePageToLoad(){
		waitForVisisbilityOf(inBoxLink,40);
	}
	public void verifyUserLink(){
		Assert.assertEquals(isElementPresent(profileCorrectNameLocator), true);
	}
	
	
	public boolean isCorrectProfileLoaded(String correctProfileName){		
		if(getText(profileCorrectNameLocator).equals(correctProfileName)){
			return true;
		}
		return false;
	}
}
