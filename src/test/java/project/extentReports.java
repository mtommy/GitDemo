package project;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReports {
	static ExtentReports extent;
	public static ExtentReports getReportObject(){
	
	String path= System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter esr = new ExtentSparkReporter(path);
	
	//change name of report
	esr.config().setReportName("TestReport"); 
	
	//change name of browser
	esr.config().setDocumentTitle("Tommy");
	
	extent = new ExtentReports();
	extent.attachReporter(esr);
	return extent;

}
}