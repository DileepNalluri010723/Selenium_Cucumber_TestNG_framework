package seleniumRevision;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected static WebDriver driver;
	@BeforeSuite
	public void initSuite () { 
		System.out.println("BEfore suite");
		if(driver == null)
		{
		driver = new ChromeDriver();
		}
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	@AfterSuite
	public void tearUp()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
}
