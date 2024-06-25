package stepdefinitions;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.en.*;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


public class Login {
	
	WebDriver driver;
	private LoginPage loginpage;
	private AccountPage accountpage;
	private CommonUtils commonUtils;
	@Given("User navigate to login page")
	public void User_navigate_to_login_page() {
    	driver = DriverFactory.getDriver();
    	
    	HomePage homepage = new HomePage(driver);
    	homepage.clickMyAccount();
    	homepage.selectLoginOption();
  //  	loginpage = homepage.selectLoginOption();   optimize    	
	}
	
    @When("User enters valid email address {string} into email field")
    public void User_enters_valid_email_address_into_email_field(String emailText ) {
    	loginpage = new LoginPage(driver); // this line remove when we use optimize code 
    	loginpage.enterEmailAddress(emailText);
    	
    }
	
    @And("User enters valid password {string} into password field")
    public void user_enters_valid_password_into_password_field(String passwordText) {
    	loginpage.enterPassword(passwordText);
    	
    }
    
    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
    	loginpage.clickOnLoginButton();
//    	accountpage = loginpage.clickOnLoginButton(); // this line we use optimize code 
    }
    
    
    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
      accountpage= new AccountPage(driver); // this line remove when we use optimize code 
      Assert.assertTrue(accountpage.displayStatusOfEditYourAccountInformation());
    }

    @When("User enters invalid email address into email field")
    public void user_enters_invalid_email_address_into_email_filed() {
    	
    loginpage = new LoginPage(driver); // this line remove when we use optimize code 
    commonUtils = new CommonUtils();
    loginpage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
    
    }

    @When("User enters invalid password {string} into password field")
    public void user_enters_invalid_password_into_password_filed(String invalidPasswordText) {
    	loginpage.enterPassword(invalidPasswordText);
    }

   
    @Then("User should get a proper warning message about credentials mismatch")
    public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
       Assert.assertTrue(loginpage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
    }


    @When("User dont enters the email address into the email field")
    public void user_dont_enters_the_email_address_into_the_email_filed() {
    	loginpage = new LoginPage(driver); // this line remove when we use optimize code 
    	loginpage.enterEmailAddress("");
    	
    }

    @When("User dont enters the password into the passowrd field")
    public void user_dont_enters_the_password_into_the_passowrd_field() {
    	loginpage = new LoginPage(driver); // this line remove when we use optimize code 
    	loginpage.enterPassword("");
    }


}
