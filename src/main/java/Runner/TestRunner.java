package Runner;

import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		
		glue = {"StepDefinition"},//Your step definitions package.
		features = {"src/main/java/Features"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/main/java/extent-config.xml");
    }

}
