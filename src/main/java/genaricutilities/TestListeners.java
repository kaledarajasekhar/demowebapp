package genaricutilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListeners implements ITestListener {

	/*
	 * JavaUtility jUtil = new JavaUtility(); String dateTimeStamp =
	 * jUtil.getCalendarDetails("dd-MM-YYYY hh-mm-ss"); ExtentReports reports;
	 * ExtentTest test;
	 * 
	 * @Override public void onTestStart(ITestResult result) { String methodName =
	 * result.getMethod().getMethodName(); test = reports.createTest(methodName); }
	 * 
	 * @Override public void onTestSuccess(ITestResult result) {
	 * System.out.println(result.getMethod().getMethodName() + "onTestSuccess");
	 * test.log(Status.PASS, result.getMethod().getMethodName() +
	 * "-Successfully executed"); }
	 * 
	 * @Override public void onTestFailure(ITestResult result) {
	 * test.log(Status.FAIL, result.getMethod().getMethodName() + "- failed");
	 * test.log(Status.INFO, result.getThrowable()); try { String screenshotName =
	 * result.getMethod().getMethodName() + "-" + dateTimeStamp; SeleniumUtility
	 * sUtil = new SeleniumUtility(DriverManager.getDriver()); String path =
	 * sUtil.captureWebpageScreenshot(screenshotName);
	 * test.addScreenCaptureFromPath(path); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * @Override public void onTestSkipped(ITestResult result) {
	 * test.log(Status.SKIP, result.getMethod().getMethodName() + "- skipped"); }
	 * 
	 * @Override public void onStart(ITestContext context) { ExtentSparkReporter
	 * reporter = new
	 * ExtentSparkReporter(".\\Extent Reports\\report-"+dateTimeStamp+".html");
	 * reporter.config().setDocumentTitle("Execution report");
	 * reporter.config().setReportName("Demowebshop report");
	 * reporter.config().setTheme(Theme.DARK);
	 * 
	 * reports = new ExtentReports(); reports.attachReporter(reporter);
	 * reports.setSystemInfo("Application", "demowebshop");
	 * reports.setSystemInfo("Base Env", "QA");
	 * reports.setSystemInfo("Base browser",
	 * context.getCurrentXmlTest().getParameter("browser"));
	 * reports.setSystemInfo("Test Engineer", "K Rajasekhar"); }
	 * 
	 * @Override public void onFinish(ITestContext context) { reports.flush(); }
	 */
}
