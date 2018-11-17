package com.iaf.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.iaf.base.BaseTest;
import com.iaf.base.CsvDataProvider;
import com.iaf.pages.LoginRenaissancePage;
import com.iaf.pages.RenaissanceLandingPage;

public class TestLoginToRenaissance extends BaseTest {
	String expectedPageTitle="Home";
	String correctProfileName="Richard Solly";
	
	@Test(priority=1, groups ={ "positive" })
	public void positiveLoginTest() {
		logTestName("positiveLoginTest");
		LoginRenaissancePage login=new LoginRenaissancePage(driver, log);
		//open Renaissance
		login.openURL();	
		//fill user and password
		login.loginToRenaissance("rsolly", "admin1");
		//click on login
		RenaissanceLandingPage landingPage=login.pushLogin();		
		//landingPage.waitForProfilePageToLoad();
		//verify page title		
		String actualTitle=landingPage.getTitle();		
		Assert.assertTrue(expectedPageTitle.equals(actualTitle),
				"Page title is not as expected \nExpected: "+expectedPageTitle+"\nActual: "+actualTitle);
		log.info("verifying Page Title");
		//verify user name	
		log.info("verifying User Name");	
		landingPage.verifyUserLink();
		Assert.assertTrue(landingPage.isCorrectProfileLoaded(correctProfileName),"Profile Name is not Expected");
			}
	@Test(priority=2)
	public void mathAppTest(){
		RenaissanceLandingPage r1=new RenaissanceLandingPage(driver, log);
		System.out.println("inside mathAppTest");
		//r1.clickOnMathApp();
	}
}
