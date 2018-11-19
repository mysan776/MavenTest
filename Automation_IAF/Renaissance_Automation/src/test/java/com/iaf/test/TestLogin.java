package com.iaf.test;

import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.iaf.base.BaseTest;
import com.iaf.base.CsvDataProvider;
import com.iaf.pages.LoginPage;
import com.iaf.pages.ProfilePage;


public class TestLogin extends BaseTest{
	String expectedPageTitle="Rediffmail";
	String correctProfileName="Sanyasi das";
	
	@Test(priority=1, groups ={ "positive" })
	public void positiveLoginTest() {
		SoftAssert softAssertion= new SoftAssert();
		logTestName("positiveLoginTest");
		LoginPage loginPage=new LoginPage(driver, log);
		//open rediff.com
		loginPage.openURL();	
		//fill user and password
		loginPage.loginToRediff("testsan123", "San@123");
		//click on login
		ProfilePage profilePage=loginPage.pushLogin();		
		profilePage.waitForProfilePageToLoad();
		//verify page title		
		String actualTitle=profilePage.getTitle();		
		Assert.assertTrue(expectedPageTitle.equals(actualTitle),
				"Page title is not as expected \nExpected: "+expectedPageTitle+"\nActual: "+actualTitle);
		log.info("verifying Page Title");
		//verify user name	
		log.info("verifying User Name");	
		profilePage.verifyUserLink();
		softAssertion.assertTrue(profilePage.isCorrectProfileLoaded(correctProfileName),"Profile Name is not as Expected");
		softAssertion.assertAll();
	}
		
	
	}
