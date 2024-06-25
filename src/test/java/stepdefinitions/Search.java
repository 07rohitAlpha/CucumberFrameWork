package stepdefinitions;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.SearchPage;

public class Search {
	WebDriver driver;
	private HomePage homepage;
//	private SearchPage searchpage; // use this line optimize code  

	@Given("user opens the Application")
	public void user_opens_the_application() {
		
		driver = DriverFactory.getDriver();
	    
	}
	@When("user enter valid product {string} into Search box field")
	public void user_enter_valid_product_into_search_box_field(String validProductText) {
	    
		HomePage homepage = new HomePage(driver);
	    homepage.enterProductIntoSearchBox(validProductText);
		
	 
	}
	@When("user clicks on Search button")
	public void user_clicks_on_search_button() {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnsearchButton(); 
//		searchpage = homepage.clickOnsearchButton(); // use this line optimize code
	}
	
	@Then("user should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results() {
		SearchPage searchpage= new SearchPage(driver); // this line removed when we use optimize code 
	    Assert.assertTrue(searchpage.displayStatusOfValidProduct());
	}
	
	@When("user enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidproductText) {
		homepage = new HomePage(driver);
		homepage.enterProductIntoSearchBox(invalidproductText);
	}
	@Then("user should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
		SearchPage searchpage = new SearchPage(driver); // this line removed when we use optimize code 
		Assert.assertEquals("There is no product that matches the search criteria.", searchpage.getMessageText());	
	}
	@When("user dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
	    homepage = new HomePage(driver);
	}

	
	

	

	
	
}
