package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	private WebDriver driver;
	int timeout;
	WebDriverWait wait;
	public WaitUtils(WebDriver driver, int timeout)
	{
		this.driver = driver;
		this.timeout = timeout;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeout));
	}
	
	public WebElement getVisibleElement(WebElement locator)
	{
		return this.wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public boolean IsElementPresent(WebElement locator)
	{
		return this.wait.until(ExpectedConditions.visibilityOf(locator)).isDisplayed();
	}
}
