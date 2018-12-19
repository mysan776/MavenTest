package com.iaf.base;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePageObject<T> {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Logger log;
	//commented
	protected BasePageObject(WebDriver driver,Logger log){
		this.driver=driver;
		this.log=log;
		wait=new WebDriverWait(driver,40);
	}
	protected BasePageObject(Logger log){
	
		this.log=log;
		
	}
	protected T getPage(String url){
		driver.get(url);
		return (T)this;
	}
	protected void implicitWait(int seconds){
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	
	protected void type(String value, By locator){
		System.out.println("Typed value "+value);		
		find(locator).sendKeys(value);
	}

	protected void click(By locator){	
		System.out.println("Clicked on "+locator);
		find(locator).click();
	}
	
	private WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	protected void waitForVisisbilityOf(By locator , Integer... timeOutInSecond){
		int attempts=0;
		while (attempts<2){
			try{
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),(timeOutInSecond.length>0 ? timeOutInSecond[0]:null));
			break;
			}
			catch(StaleElementReferenceException e){
				
			}
			attempts++;
		}
		
	}
	private void waitFor(ExpectedCondition<WebElement> condition,Integer timeOutInSeconds){
		timeOutInSeconds=timeOutInSeconds!=null ? timeOutInSeconds: 30;
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);			
	}
	
	public String getTitle(){
		return driver.getTitle();		
	}
	
	protected String getText(By element){
		return find(element).getText();	
	}
	protected boolean isElementPresent(By by) {
	    try {
	      driver.findElements(by);
	      return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	      return false;
	    }
	}

	
	
}
