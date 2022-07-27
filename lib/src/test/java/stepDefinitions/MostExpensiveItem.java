
package stepDefinitions;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import base.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LandingPage;



public class MostExpensiveItem extends Base {
	
	LandingPage landingPage = new LandingPage();
	
	@Given("^Redirect to \"([^\"]*)\"$")
	public void i_am_redirecting_to(String string) throws InterruptedException {
		navigateURL(string);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		landingPage.closePopUp();
	}

	@When("^Search an Item \"([^\"]*)\"$")
	public void search_an_item(String string) throws InterruptedException {
		landingPage.searchItem(string);
	}

	@When("Hit the search bar")
	public void hit_the_search_bar() throws InterruptedException {
		landingPage.hitSearch();
	}

	@Then("^Sort Item by slider -(\\d+) px$")
	public void sort_item_by_slider_px(Integer px) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		landingPage.slideMe(px);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Then("Make a List of Products on the Page")
	public void make_a_list_of_products_on_the_page() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		landingPage.makeList();
		assertTrue(true);
	}

	@Then("Find the Most Expensive Item Among Those")
	public void find_the_most_expensive_item_among_those() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    landingPage.expensiveItem();
	}
	
}

