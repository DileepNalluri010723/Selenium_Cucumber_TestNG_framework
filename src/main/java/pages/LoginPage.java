package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtils;

public class LoginPage extends BasePage {
	
	public WaitUtils wait;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.wait = new WaitUtils(driver, 15);
	}
	
	@FindBy(id="user-name")
	WebElement userNameEle;
	
	@FindBy(id="password")
	WebElement passwordEle;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	public void enter_credentials(String userName, String password)
	{
		this.wait.getVisibleElement(userNameEle).sendKeys(userName);
		this.wait.getVisibleElement(passwordEle).sendKeys(password);
		this.wait.getVisibleElement(loginButton).click();
	}
	
	public void clickAddToCart(String product)
	{
	    String xpath = String.format(
	        "//div[@class='inventory_item_name ' and contains(text(),'%s')]//ancestor::div[@class='inventory_item_label']//following-sibling::div[@class='pricebar']//button",
	        product
	    );

	    this.wait.getVisibleElement(driver.findElement(By.xpath(xpath))).click();
	}
	
	public boolean ValidateFailureLogin(String errorMessage)
	{
		return this.wait.IsElementPresent(driver.findElement(By.xpath("//h1[contains(text(),'"+errorMessage+"')]")));
	}
	
	public boolean ValidateSuccessfulLogin()
	{
		return this.wait.IsElementPresent(driver.findElement(By.cssSelector(".inventory_list")));
	}

}
