package stepdefinitions;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;
import org.testng.asserts.SoftAssert;



public class Register {
	WebDriver driver;
	private RegisterPage registerpage;
	private SoftAssert softAssert = new SoftAssert(); 
	//private CommonUtils commonUtils;
//	private AccountSuccessPage accountsuccesspage; // use this line optimize code 

	@Given("User navigates to Register into below fields")
	public void user_navigates_to_register_into_below_fields() {
		driver = DriverFactory.getDriver();
		HomePage homepage= new HomePage(driver);
		homepage.clickMyAccount();
		homepage.selectRegisterOption();
		
//		registerpage = homepage.selectRegisterOption(); // once you called this object don't create a object below this line we use Optimize code
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		registerpage = new RegisterPage(driver); // this line removed when we use Optimize code 
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));;
		registerpage.enteremail(CommonUtils.getEmailWithTimeStamp());
		registerpage.enterTelephoneNo(dataMap.get("telephone"));
		registerpage.enterpassword(dataMap.get("password"));
		registerpage.enterconfirmpassword(dataMap.get("password"));
		}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		registerpage = new RegisterPage(driver); // this line removed when we use optimize code 
		registerpage.enterFirstName(dataMap.get("firstName"));
		registerpage.enterLastName(dataMap.get("lastName"));
		registerpage.enteremail(dataMap.get("email"));
		registerpage.enterTelephoneNo(dataMap.get("telephone"));
		registerpage.enterpassword(dataMap.get("password"));
		registerpage.enterconfirmpassword(dataMap.get("password"));
	
		}
	@When("user selects Privacy Policy")
	public void user_selects_privacy_policy() {
		registerpage.selectPrivacyPolicy();
		}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		registerpage = new RegisterPage(driver);
		registerpage.clickoncontinuebutton();
//		accountsuccesspage = registerpage.clickoncontinuebutton(); this line we use Optimize
		}
	
	
	
	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);// this line removed when we use Optimize code 
		softAssert.assertEquals("Your Account Has Been Created!",accountsuccesspage.getPageHeading());
				
	}
	
	@When("user selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		registerpage.selectYesNewsletterOption();
		}
	

	@Then("user should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		softAssert.assertTrue(registerpage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("user dont enter any details into fileds")
	public void user_dont_enter_any_details_into_fileds() {
		
		registerpage = new RegisterPage(driver); // this line removed when we use Optimize code 
//		registerpage.enterFirstName("");         // these all committed line code we use in Optimize code 
//		registerpage.enterLastName("");
//		registerpage.enteremail("");
//		registerpage.enterTelephoneNo("");
//		registerpage.enterpassword("");
//		registerpage.enterconfirmpassword("");
//		
	}
	

	@Then("user should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
	//	RegisterPage registerpage = new RegisterPage(driver);
		
		softAssert.assertTrue(registerpage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		softAssert.assertEquals("First Name must be between 1 and 32 characters!",registerpage.getFirstNameWarning());
		softAssert.assertEquals("Last Name must be between 1 and 32 characters!",registerpage.getLastNameWarning());
		softAssert.assertEquals("E-Mail Address does not appear to be valid!",registerpage.getEmailWarning());
		softAssert.assertEquals("Telephone must be between 3 and 32 characters!",registerpage.getTelephoneWarning());
		softAssert.assertEquals("Password must be between 4 and 20 characters!",registerpage.getPasswordWarning());

	}

	

}
