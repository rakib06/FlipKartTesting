package stepDefinitions;

import static org.junit.Assert.*;

import base.Base;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LoginPage;

public class UserLogin extends Base {
	
	LoginPage loginPage = new LoginPage();
	
	@When("Click on Login Button")
	public void click_on_Login_Button() throws InterruptedException {
		loginPage.clickLoginBar();
	}

	@Then("^Enter email - \"([^\"]*)\"$")
	public void enter_userMail(String string) throws InterruptedException {
		loginPage.enterEmail(string);
	}

	@When("^Enter password - \"([^\"]*)\"$")
	public void enter(String string) throws InterruptedException {
		loginPage.enterPassword(string);
	}

	@And("Hit the Login Button")
	public void hit_the_Login_Button() throws InterruptedException {
		loginPage.clickLoginBtn();
	}

	@Then("^Get Login Failed pop-up Message \"([^\"]*)\"$")
	public void get_Login_Failed_pop_up_Message(String string) {
		
		String actualValue = loginPage.getLogintext();
		String expectedValue = string;
		
		assertEquals(expectedValue, actualValue);
	}

}