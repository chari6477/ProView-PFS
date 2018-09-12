package pfs.test.stepdefinitions;

import cucumber.api.java.en.When;
import pfs.util.helpers.DriverFactory;
import pfs.util.pages.PublishingHistory;

public class HistoryOfPublishing extends DriverFactory{

	PublishingHistory ph = new PublishingHistory(driver);
	
	@When("^I print all titles history details$")
	public void i_print_all_titles_history_details() throws Throwable {
	 
	}
}
