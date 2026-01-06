package genaricutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer {

	int maxCount = 5;

	@Override
	public boolean retry(ITestResult result) {
		while (maxCount > 0) {
			maxCount--;
			return true;
		}
		return false;
	}

}
