package com.iaf.base;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * This class is created to initialize the report and create a report with custom logs
 * 
 *
 */
public class Report {
	static ExtentReports extent;
	static ExtentTest log;
	private static Report report = null;
	private Report(){}
	
	/**
	 * This method will initialize the report.
	 * @return: Report
	 */
	public static Report getReport() {
		if(report==null)
			report = new Report();
		return report;
	}
	
	public ExtentReports startReport(){
		extent = new ExtentReports("src/test/resources/report/report_" +getTimeStamp() +".html", true);
		return extent;
	}
	
	/**
	 * This method will log the test configuration name in the report
	 * @return: ExtentTest
	 */
	public ExtentTest logTestName(String test_name) {
		log = extent.startTest(test_name, "");
		return log;
	}
	
	public void logPass(String msg) {
		log.log(LogStatus.PASS, msg);
	}
	
	public void logSkip(String msg) {
		log.log(LogStatus.SKIP, msg);
	}
	
	public void logFail(String msg) {
		log.log(LogStatus.FAIL, msg);
	}
	
	public ExtentTest getLog(){
		return log;
	}
	
	
	public void closeReport(){
		extent.endTest(log);
		extent.flush();
		extent.close();
	}
	
	private String getTimeStamp(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
		Date date = new Date();
		return dateFormat.format(date);
	}
}

