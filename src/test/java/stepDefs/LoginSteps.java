package stepDefs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import config.ConfigReader;
import driver.DriverFactory;
import hooks.Hooks;
import io.cucumber.java.en.*;
import pages.LoginPage;

public class LoginSteps {
	
	WebDriver driver = DriverFactory.getDriver();
	LoginPage loginPage;
	public LoginSteps()
	{
		loginPage = new LoginPage(driver);
	}
	@Given("User is on the login page")
	public void user_is_on_the_login_page() throws IOException {
		String websiteUrl = ConfigReader.getProperties("websiteUrl");
		driver.get(websiteUrl);
	}
	
	@When("User enters the {string} and {string}")
	public void user_enters_the_and(String userName, String password) {
		loginPage.enter_credentials(userName, password);
	}
	
	@When("User clicks on Add to cart button for {string}")
	public void user_clicks_on_add_to_cart_button_for(String product) {
		loginPage.clickAddToCart(product);
	}
	
	@Then("User should see the error message {string}")
	public void user_should_see_the_error_message(String errorMessage) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(loginPage.ValidateFailureLogin(errorMessage));
	}
	
	
	@Then("User should be logged in succesfully")
	public void user_should_be_logged_in_succesfully() {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertTrue(loginPage.ValidateSuccessfulLogin());
	}

}
