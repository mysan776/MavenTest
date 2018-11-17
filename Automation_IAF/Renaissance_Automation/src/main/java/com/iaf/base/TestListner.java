package com.iaf.base;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListner extends TestListenerAdapter {
	
	 @Override
	  public void onTestSuccess(ITestResult tr) {
		 System.out.println(tr.getTestContext().getCurrentXmlTest().getName()+" Test Success");
	  }

	  @Override
	  public void onTestFailure(ITestResult tr) {
		  System.out.println(tr.getTestContext().getCurrentXmlTest().getName()+" Test Failed");
		  System.out.println(tr.getMethod().getMethodName()+" failed" );
	  }
	  
	  @Override
	  public void onStart(ITestContext testContext) {
		  System.out.println(testContext.getCurrentXmlTest().getName()+" Test start");
	  }

	  @Override
	  public void onFinish(ITestContext testContext) {
		  System.out.println(testContext.getCurrentXmlTest().getName()+" Test finished");
	  }


}
