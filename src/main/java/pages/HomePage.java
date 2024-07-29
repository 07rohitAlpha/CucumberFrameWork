package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement RegisterOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	
	public void clickMyAccount() {
		try {
		wait.until(ExpectedConditions.elementToBeClickable(myAccountDropMenu));
		myAccountDropMenu.click();
		
	}catch (Exception e) {
		e.printStackTrace();
		
	}
	}
	//==== two way one without optimize and second after optimize the code
	public void selectLoginOption() {
		loginOption.click();
	}
	
	//== Optimize code 
//	public LoginPage selectLoginOption() {
//		loginOption.click();
//		return new LoginPage(driver);
//	}
	
	//==== two way one without optimize and second after optimize the code	
	public void selectRegisterOption() {
		RegisterOption.click();
	}
	// == Options code 
//	public RegisterPage selectRegisterOption() {
//		RegisterOption.click();
//		return new RegisterPage(driver);
//	}
	
	
	public void enterProductIntoSearchBox(String ProductText) {
		searchBoxField.sendKeys(ProductText);
	}
	
	//==== two way one without optimize and second after optimize the code
	public void clickOnsearchButton() {
		searchButton.click();
	}
	
//	public SearchPage clickOnsearchButton() {
//		searchButton.click();
//		return new SearchPage(driver);
//	}
	
}
