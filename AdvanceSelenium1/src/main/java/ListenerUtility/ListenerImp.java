package ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseTest.Base_Class;
import Generic.webdriverUtility.UtilityClassObject;

public class ListenerImp implements ITestListener, ISuiteListener {

	public ExtentSparkReporter spark;
	public static ExtentReports report;
	ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
        
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		ExtentSparkReporter spark = new ExtentSparkReporter("./Advancereport/report_"+time+".html");
		spark.config().setDocumentTitle("Ninja cRM test suites");
		spark.config().setReportName("Ninja report");
		spark.config().setTheme(Theme.DARK);

		// add envi info and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-10");
		report.setSystemInfo("BROWSER", "Chrome-100");

		System.out.println("Report configuration");
	}

	@Override
	public void onFinish(ISuite suite) {

		System.out.println("Report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("====" + result.getMethod().getMethodName() + "===START===");
		 test = report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test);
		 test.log(Status.INFO,result.getMethod().getMethodName()+">===STARTED==<" );

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("====" + result.getMethod().getMethodName() + "===END===");
		 test.log(Status.PASS,result.getMethod().getMethodName()+">===COMPLETED==<" );


	}

	@Override
	public void onTestFailure(ITestResult result) {

//	String time = new Date().toString().replace(" ","_").replace(":","_");
//
		// String testname = result.getMethod().getMethodName();
//    TakesScreenshot ts=(TakesScreenshot)Base_Class.sdriver;
//	File src = ts.getScreenshotAs(OutputType.FILE);
//	File des=new File("./Screenshot/"+testname+"+"+time+".png");
//	try {
//		FileUtils.copyFile(src, des);
//	} catch (IOException e) {
//
//		e.printStackTrace();
//	}
//	
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		String testname = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) Base_Class.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(filepath,testname+"_"+time);
     
		 test.log(Status.FAIL,result.getMethod().getMethodName()+">===FAILED==<" );


}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

}
