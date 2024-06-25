package factory;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

	
	static WebDriver driver  ;
	public static WebDriver initializeBrowser(String browserName) {
		
		
		
		if(browserName.equals("chrome")) {
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--start-maximized");
			option.addArguments("--disable-notifications");
			option.addArguments("--incognito");
		//	option.setPageLoadStrategy(PageLoadStrategy.EAGER);
			option.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
			driver = new ChromeDriver(option);
			
		}else if(browserName.equals("firefox")) {
			driver= new FirefoxDriver();
		}else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}else if(browserName.equals("safari")) {
			driver = new SafariDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}

	public static WebDriver getDriver() {
		
		return driver;
	}

}
