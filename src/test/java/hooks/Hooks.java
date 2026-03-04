package hooks;

import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

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
	public void tearDown()
	{
		DriverFactory.tearDown();
	}

}
