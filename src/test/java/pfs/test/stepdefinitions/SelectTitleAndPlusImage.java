package pfs.test.stepdefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pfs.util.helpers.DriverFactory;
import pfs.util.pages.Fulfill;

public class SelectTitleAndPlusImage extends DriverFactory{

	Fulfill ful = new Fulfill(driver);
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddmm");
	LocalDateTime now = LocalDateTime.now();

	@When("^I click the PLUS symbol at the bottom of title \"([^\"]*)\"$")
	public void i_click_the_PLUS_symbol_at_the_bottom_of_title(String arg1) throws Throwable {
		ful.verifyElementIsPresent("SearchTextBox_XPATH");
		ful.enterTextIntoTextBox("SearchTextBox_XPATH", arg1);
		try {
			ful.clickPlusSymbolOfTitle(arg1);
		}catch(Exception e)
		{
			ful.hoverElement("PlusIcon");
		}
	}

	@Then("^Verify the green plus icon turns to \"([^\"]*)\"$")
	public void verify_the_green_plus_icon_turns_to(String arg1) throws Throwable {
		ful.verifyElementBySikuli(arg1);
	}

	@Then("^Verify the selected title added to the cart$")
	public void verify_the_selected_title_added_to_the_cart() throws Throwable {
		ful.countAddedTitlesInCart();
	}
	
	@Then("^Verify a drawer will slide up from the bottom once the user selects the title in the Subscription type sale$")
	public void verify_a_drawer_will_slide_up_from_the_bottom_once_the_user_selects_the_title_in_the_Subscription_type_sale() throws Throwable {
		ful.verifyElementIsPresent("Title_Selected_XPATH");
	}
	
	@Then("^Verify warning popup must have two buttons \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_warning_popup_must_have_two_buttons_and(String arg1, String arg2) throws Throwable {
		ful.verifyElementIsPresent(arg1+"_XPATH");
		ful.verifyElementIsPresent(arg2+"_XPATH");
	}
	
	@When("^User will be navigated to Subscription detail page by clicking on the \"([^\"]*)\" button on the slider$")
	public void user_will_be_navigated_to_Subscription_detail_page_by_clicking_on_the_button_on_the_slider(String arg1) throws Throwable {
		ful.clickAnElement(arg1+"_XPATH");
	}
 
	@Then("^I verify that the title is available for sale or not$")
	public void i_verify_that_the_title_is_available_for_sale_or_not() throws Throwable {
		ful.countAddedTitlesInCart();
	}

	@When("^I click Cart icon$")
	public void i_click_Cart_icon() throws Throwable {
		ful.clickCart();
	}

	@Then("^Verify User can remove the titles from the cart by clicking on the \"([^\"]*)\"$")
	public void verify_User_can_remove_the_titles_from_the_cart_by_clicking_on_the(String arg1) throws Throwable {
		ful.clickAnElement(arg1+"_XPATH");
	}

	@Then("^User can able to see number of titles selected on the top of the cart$")
	public void user_can_able_to_see_number_of_titles_selected_on_the_top_of_the_cart() throws Throwable {
		ful.verifyElementIsPresent("TITLES_SELECTED_XPATH");
	}

	@When("^User can remove all the titles at once by clicking on \"([^\"]*)\"$")
	public void user_can_remove_all_the_titles_at_once_by_clicking_on(String arg1) throws Throwable {
		ful.clickAnElement(arg1+"_XPATH");
	}

	@When("^I click \"([^\"]*)\" Button in Cart page$")
	public void i_click_Button_in_Cart_page(String arg1) throws Throwable {
		ful.nextButton();
	}

	@When("^I click \"([^\"]*)\" button$")
	public void i_click_button(String arg1) throws Throwable {

		ful.hoverElement("NEXT_BTN");
	}

	@When("^I click on Submit button$")
	public void i_click_on_Submit_button() throws Throwable {
		ful.clickAnElement("Submit_XPATH");
	}

	@When("^Enter the Entitlement details \"([^\"]*)\"$")
	public void enter_the_Entitlement_details(String arg1) throws Throwable {
		ful.clickAnElement(arg1+"_Entitlement_XPATH");
		ful.clickAnElement("NEXT_XPATH");
	}

	String tokentypeRadio = null;
	@When("^I select Token Type \"([^\"]*)\" radio button$")
	public void i_select_Token_Type_radio_button(String arg1) throws Throwable {
		tokentypeRadio = arg1;
		ful.selectTokenTypeRadioButton(arg1);
	}

	@When("^User can edit the \"([^\"]*)\" filed and give input \"([^\"]*)\"$")
	public void user_can_edit_the_filed_and_give_input(String arg1, String arg2) throws Throwable {
		ful.enterTextIntoTextBox(arg1+"_XPATH", arg2);
	}
	
	@When("^I select Token Name \"([^\"]*)\" radio button$")
	public void i_select_Token_Name_radio_button(String arg1) throws Throwable {
		ful.selectTokenNameRadioButton(arg1);
	}
	
	@When("^User can can enter the token name \"([^\"]*)\" in custom token name field$")
	public void user_can_can_enter_the_token_name_in_custom_token_name_field(String arg1) throws Throwable {
		ful.enterTextIntoTextBox("Custom_Token_textbox_XPATH", arg1+dtf.format(now));
	}

	@When("^User can enter the NUMBER OF UNIQUE TOKENS \"([^\"]*)\" in the field$")
	public void user_can_enter_the_NUMBER_OF_UNIQUE_TOKENS_in_the_field(String arg1) throws Throwable {
		ful.enterTextIntoTextBox("Number_of_Uses_XPATH", arg1);
	}
	
	@When("^I select Token Expiration Date$")
	public void i_select_Token_Expiration_Date(DataTable expiryDate) throws Throwable {
		List<List<String>> date = expiryDate.raw();
		Thread.sleep(1000);
		ful.tokenExpiryDate(date.get(1).get(0) , date.get(1).get(1) , date.get(1).get(2));
		ful.selectTokenTypeRadioButton(tokentypeRadio);
	}

	@When("^I select Token Expiration Date as previous date$")
	public void i_select_Token_Expiration_Date_as_previous_date() throws Throwable {
		Thread.sleep(1000);
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String[] out = df.format(date).split("-");
		ful.tokenExpiryDate(out[0],out[1],out[2]);
	}

	@When("^I enter NUMBER OF UNIQUE TOKENS \"([^\"]*)\"$")
	public void i_enter_NUMBER_OF_UNIQUE_TOKENS(String arg1) throws Throwable {
		ful.enterTextIntoTextBox("NUMBER_OF_UNIQUE_TOKENS_XPATH", arg1);
	}

	@When("^I select Token Expiration Date as future date$")
	public void i_select_Token_Expiration_Date_as_future_date() throws Throwable {
		Thread.sleep(1000);
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String[] out = df.format(date).split("-");
		int dateOfDate = Integer.valueOf(out[1]);
		System.out.println(dateOfDate);
		int dateInInt = dateOfDate+1;
		System.out.println(dateInInt);
		String dateInString = String.valueOf(dateInInt);
		System.out.println(dateInString);
		ful.tokenExpiryDate(out[0],dateInString,out[2]);

	}
	
	@When("^I select Content Expiration Date as future date$")
	public void i_select_Content_Expiration_Date_as_future_date() throws Throwable {
		Thread.sleep(1000);
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String[] out = df.format(date).split("-");
		int dateOfDate = Integer.valueOf(out[1]);
		int dateInInt = dateOfDate+1;
		String dateInString = String.valueOf(dateInInt);
		ful.contentExpirationDate(out[0],dateInString,out[2]);
	}
	
	@When("^I select Content Expiration Date as prior date$")
	public void i_select_Content_Expiration_Date_as_prior_date() throws Throwable {
		Thread.sleep(1000);
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String[] out = df.format(date).split("-");
		ful.contentExpirationDate(out[0],out[1],out[2]);
	}
	
	@When("^I select SUBSCRIPTION START DATE$")
	public void i_select_SUBSCRIPTION_START_DATE() throws Throwable {
		Thread.sleep(1000);
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String[] out = df.format(date).split("-");
		ful.sUBSCRIPTIONSTARTDATE(out[0],out[1],out[2]);
	}
	
	@When("^I select SUBSCRIPTION END DATE as Start date$")
	public void i_select_SUBSCRIPTION_END_DATE_as_Start_date() throws Throwable {
		Thread.sleep(1000);
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String[] out = df.format(date).split("-");
		ful.sUBSCRIPTIONENDDATE(out[0],out[1],out[2]);
	}
	
	@When("^I select SUBSCRIPTION END DATE$")
	public void i_select_SUBSCRIPTION_END_DATE() throws Throwable {
		Thread.sleep(1000);
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();
		String[] out = df.format(date).split("-");
		int dateOfDate = Integer.valueOf(out[1]);
		int dateInInt = dateOfDate+1;
		String dateInString = String.valueOf(dateInInt);
		ful.sUBSCRIPTIONENDDATE(out[0],dateInString,out[2]);
	}

	@When("^I click Next Button$")
	public void i_click_Next_Button() throws Throwable {
		Thread.sleep(1000); 
		ful.nextButtonInEntitlementPage();
	}
	
	@Then("^Verify ENTITLEMENT DETAILS are displayed at right side of the modal$")
	public void verify_ENTITLEMENT_DETAILS_are_displayed_at_right_side_of_the_modal() throws Throwable {
	   ful.printEntitlementDetails();
	}

	@Then("^verify user will be able to see the token in Token redumption site$")
	public void verify_user_will_be_able_to_see_the_token_in_Token_redumption_site() throws Throwable {
	   Robot robo = new Robot();
	   robo.keyPress(KeyEvent.VK_CONTROL);
	   robo.keyPress(KeyEvent.VK_T);
	   robo.keyRelease(KeyEvent.VK_CONTROL);
	   robo.keyRelease(KeyEvent.VK_T);
	   Thread.sleep(4000); 
	   robo.keyPress(KeyEvent.VK_CONTROL);
	   robo.keyPress(KeyEvent.VK_V);
	   robo.keyRelease(KeyEvent.VK_CONTROL);
	   robo.keyRelease(KeyEvent.VK_V);
	   robo.keyPress(KeyEvent.VK_ENTER);
	   robo.keyRelease(KeyEvent.VK_ENTER);
	}

	@Then("^I verify \"([^\"]*)\" message is displayed$")
	public void i_verify_message_is_displayed(String arg1) throws Throwable {
		ful.verifyTextIsPresent(arg1);
	}

	@Then("^Error has to come up below the token expiration as \"([^\"]*)\"$")
	public void error_has_to_come_up_below_the_token_expiration_as(String arg1) throws Throwable {
		ful.verifyTextIsPresent(arg1);
	}
	
	@Then("^Verisy success message is displayed \"([^\"]*)\"$")
	public void verisy_success_message_is_displayed(String arg1) throws Throwable {
		ful.verifyTextIsPresent(arg1);
	}
	
	@Then("^Verify Subscription period has to show at the top$")
	public void verify_Subscription_period_has_to_show_at_the_top() throws Throwable {
	   ful.printSubscriptionPeriod();
	}

}
