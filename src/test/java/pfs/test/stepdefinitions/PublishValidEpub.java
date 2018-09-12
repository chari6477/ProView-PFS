package pfs.test.stepdefinitions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Set;

import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pfs.util.helpers.DriverFactory;
import pfs.util.pages.Fulfill;
import pfs.util.pages.PublishPage;
import pfs.util.pages.PublishingHistory;
import pfs.util.pages.SignIn;

public class PublishValidEpub extends DriverFactory{

	SignIn signIn = new SignIn(driver);
	PublishPage pp = new PublishPage(driver);
	Fulfill fulfil = new Fulfill(driver); 
	PublishingHistory ph = new PublishingHistory(driver);
	Screen screen = new Screen();

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddmm");
	LocalDateTime now = LocalDateTime.now();

	@When("^I Click on \"([^\"]*)\" dropdown and select the publisher \"([^\"]*)\" from the dropdown$")
	public void i_Click_on_dropdown_and_select_the_publisher_from_the_dropdown(String arg1, String arg2) throws Throwable {
		pp.selectOptionFromPageDropDown(arg1, arg2);
	}

	@When("^I Click on \"([^\"]*)\" text box and enter the product line \"([^\"]*)\"$")
	public void i_Click_on_text_box_and_enter_the_product_line(String arg1, String arg2) throws Throwable {

		pp.enterTextInTextfield(arg2+dtf.format(now), arg1);
	}

	@When("^I Click on \"([^\"]*)\" text box and enter the product code \"([^\"]*)\"$")
	public void i_Click_on_text_box_and_enter_the_product_code(String arg1, String arg2) throws Throwable {
		pp.enterTextInTextfield(arg2+dtf.format(now), arg1);
	}

	@When("^I Click on \"([^\"]*)\" and enter the version of the book \"([^\"]*)\"$")
	public void i_Click_on_and_enter_the_version_of_the_book(String arg1, String arg2) throws Throwable {
		pp.enterTextInTextfield(arg2+dtf.format(now), arg1);
	}

	@When("^I Click on next button to navigate to next page$")
	public void i_Click_on_next_button_to_navigate_to_next_page() throws Throwable {
		pp.clickAbutton("Next");
	}

	@Then("^I verify that navigated to Upload file page$")
	public void i_verify_that_navigated_to_Upload_file_page() throws Throwable {

	}

	@When("^I should choose an valid epub(\\d+) file \"([^\"]*)\" for publishing using Browse option$")
	public void i_should_choose_an_valid_epub_file_for_publishing_using_Browse_option(int arg1, String arg2) throws Throwable {

	}

	@Then("^I Verify that the user is navigated to publish \"([^\"]*)\" page$")
	public void i_Verify_that_the_user_is_navigated_to_publish_page(String arg1) throws Throwable {
		pp.isTextDisplayed(arg1);
	}

	@Then("^I verify that spinning wheel for the upload process\\.$")
	public void i_verify_that_spinning_wheel_for_the_upload_process() throws Throwable {
		pp.spinningWheelWhileUploading();
	}

	@Then("^I verify that the \"([^\\\"]*)\" of the book on the publish page$")
	public void i_verify_that_message_with_the_artwork_of_the_book_on_the_publish_page(String arg1) throws Throwable {
		Thread.sleep(10000);
		//pp.checkRimageOntheTitle(arg1).isDisplayed();
	}

	@Then("^I verify that \"([^\"]*)\" tag on the right bottom of the artwork\\.$")
	public void i_verify_that_tag_on_the_right_bottom_of_the_artwork(String arg1) throws Throwable {
		//	pp.checkRimageOntheTitle(arg1).isDisplayed();
		Pattern textToNote = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\ReviewTitle.PNG");
		if(screen.exists(textToNote) != null)
		{
			System.out.println("Right bottom of the artwork image is displayed.");
		}
		else
		{
			System.err.println("Right bottom of the artwork image is not displayed.");
		}

	}
	String parent;
	String child_window;
	@When("^I Click on \"([^\"]*)\" button and user should be navigated to \"([^\"]*)\" tab\\.$")
	public void i_Click_on_button_and_user_should_be_navigated_to_tab(String arg1, String arg2) throws Throwable {	
		pp.reviewInProviewBtn(arg1);

		parent=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator();
		while(I1.hasNext())
		{
			child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());	 
			}
		}
	}

	@When("^I Select the \"([^\"]*)\" option and click on \"([^\"]*)\" button\\.$")
	public void i_Select_the_option_and_click_on_button(String arg1, String arg2) throws Throwable {
		signIn.cookieTermsAcceptance();
		signIn.webBrowserProviewLaunch();
		signIn.launchProviewBtn();
	}

	@When("^I Select \"([^\"]*)\" and click on \"([^\"]*)\" button$")
	public void i_Select_and_click_on_button(String arg1, String arg2) throws Throwable {
		signIn.cookieTermsAcceptance();
		signIn.loginWithMyOnepassAccount();
		signIn.launchProviewBtn();
		signIn.signInActions();
	}

	@When("^I Click on \"([^\"]*)\" option on proview page$")
	public void i_Click_on_option_on_proview_page(String arg1) throws Throwable {
		/*signIn.isRequestedTitleAvailable();
		signIn.proviewNotificationIcon();*/
	}

	@Then("^I Verify that the published book title in the notifications option$")
	public void i_Verify_that_the_published_book_title_in_the_notifications_option() throws Throwable {

	}

	@When("^I click on \"([^\"]*)\" option on proview page$")
	public void i_click_on_option_on_proview_page(String arg1) throws Throwable {

	}

	@When("^I Search for the published title in proview with the review tag on the artwork$")
	public void i_Search_for_the_published_title_in_proview_with_the_review_tag_on_the_artwork() throws Throwable {

	}

	@When("^I Navigate back to the PFS tab in the browser$")
	public void i_Navigate_back_to_the_PFS_tab_in_the_browser() throws Throwable {
		//	driver.close();
		driver.switchTo().window(parent);
	}

	@Then("^I verify That navigated to Review the title page$")
	public void i_verify_That_navigated_to_Review_the_title_page() throws Throwable {
		pp.isIt_ReviewTheTitle_Page();
	}

	@When("^I Click on the \"([^\"]*)\" button$")
	public void i_Click_on_the_button(String arg1) throws Throwable {
		pp.changeStateToFinalBtn();
	}

	@Then("^I verify the book \"([^\\\"]*)\" is in Publishing History with the published status \"([^\"]*)\"$")
	public void i_verify_the_book_is_in_Publishing_History_with_the_published_status(String arg1, String arg2) throws Throwable {
		ph.printTitleHistory(arg1 , arg2);
	}

	@When("^I Click on the title \"([^\"]*)\" in the \"([^\"]*)\" page$")
	public void i_Click_on_the_title_in_the_page(String arg1 ,String arg2) throws Throwable {
		ph.getTitleAndClick(arg1);
	}

	@Then("^I verify that the details of the \"([^\"]*)\" and artwork of the title with review tag at the right bottom$")
	public void i_verify_that_the_details_of_the_and_artwork_of_the_title_with_review_tag_at_the_right_bottom(String arg1) throws Throwable {
		ph.printDetailsOfTheTitleInPublishHistory();
	}

	@When("^I Go back to Proview page$")
	public void i_Go_back_to_Proview_page() throws Throwable {
		driver.switchTo().window(child_window);
	}

	@Then("^I check review tag on the artwork of the title is removed$")
	public void i_check_review_tag_on_the_artwork_of_the_title_is_removed() throws Throwable {

	}

	@Then("^I verify that user must see Green check mark$")
	public void i_verify_that_user_must_see_Green_check_mark() throws Throwable {
        ph.verifyPublishedTextIsDisplayed();
	}

	@When("^I Navigate back in the browser$")
	public void i_Navigate_back_in_the_browser() throws Throwable {
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(5000);
	}

	@Then("^User must be able to see an Validation error pop up \"([^\"]*)\"$")
	public void user_must_be_able_to_see_an_Validation_error_pop_up(String arg1) throws Throwable {
		ph.verifyErrorTextIsDisplayed(arg1);
	}

	@Then("^User must be able to see system error message \"([^\"]*)\"$")
	public void user_must_be_able_to_see_system_error_message(String arg1) throws Throwable {
		ph.verifyErrorTextIsDisplayed(arg1);
	}


}
