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
	String correctProfileName="Sanyasi dash";
	
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
		
	@Test(dataProvider="CsvDataProvider", dataProviderClass=CsvDataProvider.class, priority=2, groups ={ "negative" })
		public void negativeLoginTest(Map<String, String>testData) {
		logTestName("negativeLoginTest");
		String expectedErrorMessage="Wrong username and password combination";
		String testno=testData.get("no");
		String email=testData.get("email");;
		String password=testData.get("password");;
		String description=testData.get("description");			
		log.info("Test no "+testno+" for"+description+" where\nEmail "+email+"\nPassword "+password);
		LoginPage loginPage=new LoginPage(driver, log);
		//open rediff.com
		loginPage.openURL();	
		//fill user and password
		loginPage.loginToRediff(email, password);
		//click on login
		loginPage.pushLogin();		
		log.info("Verifying Login error message");
		String actualEroorMessage=loginPage.getLoginErrorMessage();
		Assert.assertTrue(actualEroorMessage.contains(expectedErrorMessage) ,
				"Error message not as expected \nExpected: "+expectedErrorMessage+"\nActual: "+actualEroorMessage);
				}
	}
