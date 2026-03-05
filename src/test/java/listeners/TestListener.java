package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import driver.DriverFactory;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener{
	@Override
	public void onTestFailure(ITestResult testResult)
	{
		String testName = testResult.getName();
		WebDriver driver = DriverFactory.getDriver();
		String screenshotPath = "";
		try {
			screenshotPath = ScreenshotUtils.captureScreenshot(driver, testName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot is saved at"+ screenshotPath);
	}

}
