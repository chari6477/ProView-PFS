package pfs.test.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"pfs.test.stepdefinitions"},
		plugin = {"json:target/cucumber.json" , "html:target/site/cucumber-pretty"},
		tags ={"@PFS , @PFS12"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}
