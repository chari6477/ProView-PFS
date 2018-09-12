package pfs.test.stepdefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pfs.util.helpers.AppLauncher;
import pfs.util.helpers.DriverFactory;
import pfs.util.pages.Fulfill;
import pfs.util.pages.PublishPage;
import pfs.util.pages.SignIn;

public class Publish extends DriverFactory{
	AppLauncher launcher = new AppLauncher(driver);
	SignIn signIn = new SignIn(driver);
	Fulfill fulfil = new Fulfill(driver); 
	PublishPage pp = new PublishPage(driver);

	@Given("^I launch PFS Application$")
	public void i_launch_PFS_Application() throws Throwable {
		launcher.launchPFS();
	}
	
	@Then("^I close the App$")
	public void i_close_the_app()
	{
		launcher.closePFS();
	}

	@When("^I relaunch PFS Application$")
	public void i_relaunch_PFS_Application() throws Throwable {
		launcher.launchPFS();
	}

	@When("^I sign in into Application$")
	public void he_signs_in_into_Application() throws Throwable {
		signIn.signInAction();
	}

	@Then("^I verify that i am in the Home Page$")
	public void i_verify_that_i_am_in_the_Home_Page() throws Throwable {
		fulfil.verifyElementToBePresented("publisher_dropdown_id");
	}

	@Then("^I verify that i am in the \"([^\"]*)\" Page$")
	public void i_verify_that_i_am_in_the_Page(String arg1) throws Throwable {
		Thread.sleep(10000);
		fulfil.verifyElementToBePresented(arg1);
	}
	
	
	@Then("^I verify that i am in the \"([^\"]*)\" page$")
	public void i_verify_that_i_am_in_the_page(String arg1) throws Throwable {
		Thread.sleep(10000);
		fulfil.verifyPublishElementToBePresented(arg1);
	}

	@When("^I click \"([^\"]*)\" Activity$")
	public void i_click_Activity(String arg1) throws Throwable {
		Thread.sleep(5000);
		fulfil.click_Activity(arg1);
	}

	@When("^I click \"([^\"]*)\" dropdown and select \"([^\"]*)\" option$")
	public void i_click_dropdown_and_select_option(String arg1, String arg2) throws Throwable {
		pp.selectOptionFromPageDropDown(arg1, arg2);
	}

	@When("^I enter text \"([^\"]*)\" in the TextBox \"([^\"]*)\"$")
	public void i_enter_text_in_the_TextBox(String arg1, String arg2) throws Throwable {
		pp.enterTextInTextfield(arg1, arg2);
	}

	@When("^I click \"([^\"]*)\" Button$")
	public void i_click_Button(String arg1) throws Throwable {
		Thread.sleep(4000);
		pp.clickAbutton(arg1);
	}
	
	@When("^I click the \"([^\"]*)\" Button$")
	public void i_click_the_Button(String arg1) throws Throwable {
		Thread.sleep(4000);
		pp.clickAbutton(arg1);
	}

	@When("^I upload file \"([^\"]*)\"$")
	public void i_upload_file(String arg1) throws Throwable {
		pp.uploadAfile(arg1);
	}

	@Then("^I verify that file upload error message contains \"([^\"]*)\"$")
	public void i_verify_that_file_upload_error_message_contains(String arg1) throws Throwable {
		pp.verifyErrorMessage(arg1);
	}

	@Then("^I verify \"([^\"]*)\" message displayed$")
	public void i_verify_message_displayed(String arg1) throws Throwable {
		pp.isTextDisplayed(arg1);
	}

	@Then("^I print error message$")
	public void i_print_error_message() throws Throwable {
		pp.printUploadErrorMessage();
	}

	Robot robot = null;
	@When("^I close the browser using ALT \\+ F(\\d+)$")
	public void i_close_the_browser_using_ALT_F(int arg1) throws Throwable {
		robot = new Robot();
		Thread.sleep(4000);

		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F4);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_F4);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		driver = null;
	}
	
	@When("^I close the browser$")
	public void i_close_the_browser() throws Throwable {
		robot = new Robot();
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_F4);
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_F4);
		driver = null;
	}

	@When("^select two files \"([^\"]*)\" and \"([^\"]*)\" then click on open$")
	public void select_two_files_and_then_click_on_open(String arg1, String arg2) throws Throwable {
	  pp.uploadTwofiles(arg1, arg2);
	}

	@Then("^User must see an Publishing error pop up with the System error$")
	public void user_must_see_an_Publishing_error_pop_up_with_the_System_error() throws Throwable {
	  
	}


}
