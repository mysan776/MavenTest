package com.iaf.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.iaf.base.BasePageObject;
import com.iaf.base.BaseTest;
import com.iaf.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class FirstTest extends BasePageObject{	
	protected FirstTest(WebDriver driver, Logger log) {
		super(driver, log);
		// TODO Auto-generated constructor stub
	}
	private static final String URL="http://www.google.co.in";
	private By searchBox=By.xpath("//input[@id='lst-ib']");	
	private By goButton=By.xpath("//input[@name='btnK']");	
	private By seleniumLink=By.xpath("//a[contains(text(),'Selenium - Web Browser Automation')]");
	protected WebDriver driver;
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver=new ChromeDriver();
		//Open google.com	
		getPage(URL);
		}	
	@Test
	public void firstTestMethod() {		
		//enter "selenium" in search box
		type("selenium",searchBox);
		//driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("selenium");
		//click on search
		click(goButton);
		//driver.findElement(By.xpath("//input[@name='btnK']")).click();
	    Assert.assertEquals(isElementPresent(seleniumLink), true);
	
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
}
