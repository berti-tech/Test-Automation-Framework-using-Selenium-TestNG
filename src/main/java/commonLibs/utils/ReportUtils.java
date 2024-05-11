package commonLibs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

// All the logic to generate reports
public class ReportUtils {
	
	ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
	
	ExtentReports extentReports;
	
	ExtentTest extentTest;
	
	public ReportUtils(String htmlReportFilename) {
		
		htmlReportFilename = htmlReportFilename.trim();
		
		spark = new ExtentSparkReporter(htmlReportFilename);
		
		extentReports = new ExtentReports();
		
		extentReports.attachReporter(spark);
	}
	
	public void createATestCase(String testCaseName) {
		
		extentTest = extentReports.createTest(testCaseName);
	}
	
	public void addTestLog(Status status, String comment) {
		
		extentTest.log(status, comment);
	}
	
	public void flushReport() {
		extentReports.flush();
	}
}
