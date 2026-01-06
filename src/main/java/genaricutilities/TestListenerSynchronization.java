package genaricutilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListenerSynchronization implements ITestListener {

	JavaUtility jUtil = new JavaUtility();
	String dateTimeStamp = jUtil.getCalendarDetails("dd-MM-YYYY hh-mm-ss");
	private static ExtentReports reports;

	// ThreadLocal to keep test node per thread
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onStart(ITestContext context) {

		ExtentSparkReporter reporter = new ExtentSparkReporter(
				".\\Extent Reports\\report-" + System.currentTimeMillis() + ".html");

		reporter.config().setDocumentTitle("Execution report");
		reporter.config().setReportName("Demowebshop report");
		reporter.config().setTheme(Theme.DARK);

		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Application", "Demowebshop");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Browser", context.getCurrentXmlTest().getParameter("browser"));
		reports.setSystemInfo("Tester", "K Rajasekhar");
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = reports.createTest(result.getMethod().getMethodName());
		test.set(extentTest); // Store per-thread test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().log(Status.PASS, result.getMethod().getMethodName() + " - Successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.get().log(Status.FAIL, result.getMethod().getMethodName() + " - Failed");
		test.get().log(Status.INFO, result.getThrowable());

		try {
			String screenshotName = result.getMethod().getMethodName() + "-" + dateTimeStamp;

			//  Use thread-safe driver (NO static)
			SeleniumUtility sUtil = new SeleniumUtility(DriverManager.getDriver());
			String path = sUtil.captureWebpageScreenshot(screenshotName);

			test.get().addScreenCaptureFromPath(path);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().log(Status.SKIP, result.getMethod().getMethodName() + " - Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}
}
