package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {

	public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String fileName = testName + "_" + System.currentTimeMillis() + ".png";
		String path = System.getProperty("user.dir") + "/target/screenshots" + fileName;
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}

}
