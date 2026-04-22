package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
public static ExtentReports extent;
public static ExtentReports getReport() {
	if(extent==null) {
		ExtentSparkReporter reporter=new ExtentSparkReporter("test-output/ExtentReport.html");
		reporter.config().setReportName("AutomationReport");
		reporter.config().setDocumentTitle("Test Result");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","supriya");
	}
	return extent;
	}
}

