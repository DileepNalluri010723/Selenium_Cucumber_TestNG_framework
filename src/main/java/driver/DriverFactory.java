package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void initDriver(String browser)
	{
		if(driver.get() == null)
		{
			switch(browser.toLowerCase())
			{
			case "chrome":
			default:
				driver.set(new ChromeDriver());
			}
		}
	}
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	public static void tearDown()
	{
		if(driver.get()!=null)
		{
			driver.get().quit();
			driver.remove();
		}
	}
}
