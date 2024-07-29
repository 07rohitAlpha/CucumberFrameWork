package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {

	WebDriver driver;
	WebDriverWait wait ;
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	
	
	public boolean displayStatusOfEditYourAccountInformation() {
	wait.until(ExpectedConditions.visibilityOf(editYourAccountInformationOption));
	return editYourAccountInformationOption.isDisplayed();
	}
		
	
	
}
