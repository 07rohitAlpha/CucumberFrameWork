package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver ;
	WebDriverWait wait;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordField;

	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterPassword(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
//	== two way one without optimize and second after optimize the code
	public void clickOnLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
		
	}
	// optimize the code 
//	public AccountPage clickOnLoginButton() {
//		loginButton.click();
//		return new AccountPage(driver);
//	}
	
	public String getWarningMessageText() {
		return warningMessage.getText();
	}

}
