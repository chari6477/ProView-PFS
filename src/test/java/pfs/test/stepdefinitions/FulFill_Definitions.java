package pfs.test.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pfs.util.helpers.DriverFactory;
import pfs.util.pages.Fulfill;

public class FulFill_Definitions extends DriverFactory{

	Fulfill ff = new Fulfill(driver);

	@When("^Click on the \"([^\"]*)\" on the top of the PFS publish page$")
	public void click_on_the_on_the_top_of_the_PFS_publish_page(String arg1) throws Throwable {
		ff.hoverElement(arg1);
	}

	@Then("^User should be able to see type of transaction on the Fulfill page \"([^\"]*)\"$")
	public void user_should_be_able_to_see_type_of_transaction_on_the_Fulfill_page(String arg1) throws Throwable {
		ff.verifyElementIsPresent(arg1+"_XPATH");
	}
	
	@Then("^A Radio button should be present next to \"([^\"]*)\"$")
	public void a_Radio_button_should_be_present_next_to(String arg1) throws Throwable {
		ff.verifyElementBySikuli(arg1+"_RadioBtn");
	}

	@Then("^A book icon with blue plus mark has to be present on the right side of the \"([^\"]*)\"$")
	public void a_book_icon_with_blue_plus_mark_has_to_be_present_on_the_right_side_of_the(String arg1) throws Throwable {
		ff.verifyElementBySikuli(arg1+"_BookIcon");
	}

	@When("^Click on \"([^\"]*)\" radio button$")
	public void click_on_radio_button(String arg1) throws Throwable {
	  ff.selectTransactionTypeRadioButton(arg1);
	}

	@Then("^Verify \"([^\"]*)\" button will be Enabled$")
	public void verify_button_will_be_Disabled(String arg1) throws Throwable {
		ff.verifyElementIsPresent(arg1+"_XPATH");
	}

	@Then("^User must be able to see two options \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_must_be_able_to_see_two_options_and(String arg1, String arg2) throws Throwable {
		ff.verifyElementBySikuli(arg1);
		ff.verifyElementBySikuli(arg2);
	}

	@When("^Click on \"([^\"]*)\" button$")
	public void click_on_button(String arg1) throws Throwable {
		ff.clickAnElement(arg1+"_XPATH");
	}

	@Then("^Verify user is able to navigate to \"([^\"]*)\" page$")
	public void verify_user_is_able_to_navigate_to_page(String arg1) throws Throwable {
		ff.verifyElementIsPresent(arg1+"_XPATH");
	}
	
	@When("^Enter the \"([^\"]*)\" address of the customer \"([^\"]*)\" who has already redeemed the tokens in the past$")
	public void enter_the_address_of_the_customer_who_has_already_redeemed_the_tokens_in_the_past(String arg1 , String arg2) throws Throwable {
		ff.enterTextIntoTextBox(arg1+"_XPATH", arg2);
	}
}
