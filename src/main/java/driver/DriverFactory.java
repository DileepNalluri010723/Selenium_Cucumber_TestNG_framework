package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

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
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
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
