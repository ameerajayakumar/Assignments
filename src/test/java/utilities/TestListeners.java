package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import assignment1.BaseTest;

public class TestListeners extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestSuccess(ITestResult result) {
		String method = result.getMethod().getMethodName().trim();
		try {
			testUtil.captureScreenshot(method+"_PASS_");
		} catch (Exception e) {
			System.out.println("Failed to capture the screenshot! ");
			e.printStackTrace();
		}	}

	public void onTestFailure(ITestResult result) {
		String method = result.getMethod().getMethodName().trim();
		try {
			testUtil.captureScreenshot(method+"_FAIL_");
		} catch (Exception e) {
			System.out.println("Failed to capture the screenshot! ");
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
