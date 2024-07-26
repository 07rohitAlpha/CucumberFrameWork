package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/resources/features",
		         glue= {"stepdefinitions","hooks"},
		         publish= true,
		         plugin = {"pretty","html:target/CucumberReports/CucumberReports.html"},
		         dryRun = false
		)
public class TestRunner extends AbstractTestNGCucumberTests{	
	


}
