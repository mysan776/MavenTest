package com.iaf.pages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.iaf.base.BasePageObject;


public class RenaissanceLandingPage extends BasePageObject<ProfilePage> {
	private By mathInFlashApp=By.xpath("//*[@alt='MathFacts in a Flash']");	
	private By profileCorrectNameLocator=By.xpath("//a[contains(text(),'Richard Solly')]");

	public RenaissanceLandingPage(WebDriver driver, Logger log) {
		super(driver, log);		
	}	
	public void waitForProfilePageToLoad(){
		implicitWait(40);
		waitForVisisbilityOf(mathInFlashApp,50);
	}
	public void verifyUserLink(){
		Assert.assertEquals(isElementPresent(profileCorrectNameLocator), true);
	}
		
	public void clickOnMathApp(){
	click(mathInFlashApp);
	}
	
	public boolean isCorrectProfileLoaded(String correctProfileName){		
		if(getText(profileCorrectNameLocator).equals(correctProfileName)){
			return true;
		}
		return false;
	}
	

}
