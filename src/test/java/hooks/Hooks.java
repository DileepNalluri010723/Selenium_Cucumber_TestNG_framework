package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static WebDriver driver;
	@Before
	public void setup()
	{
		DriverFactory.initDriver("chrome");
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(Scenario scenario)
	{
		if (scenario.isFailed())
		{
			byte[] screenshot = ((TakesScreenshot) driver)
	                .getScreenshotAs(OutputType.BYTES);
			
	        scenario.attach(screenshot, "image/png", scenario.getName());
		}
		DriverFactory.tearDown();
	}

}
