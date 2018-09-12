package pfs.test.stepdefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pfs.util.helpers.DriverFactory;
import pfs.util.pages.AnnotationsMenu;
import pfs.util.pages.OptionsMenu;
import pfs.util.pages.ProviewPage;
import pfs.util.pages.SignIn;
import pfs.util.pages.TitlePage;

public class Able_To_Create_annotations_or_not extends DriverFactory{

	ProviewPage library = new ProviewPage(driver);
	TitlePage title = new TitlePage(driver);
	SignIn signIn = new SignIn(driver);
	Screen screen = new Screen();
	AnnotationsMenu annotationsMenu = new AnnotationsMenu(driver);
	OptionsMenu optionsMenu = new OptionsMenu(driver);

	@When("^I open the title \"(.*?)\" in proview$")
	public void i_open_the_title(String titleName)
	{
		library.openTitle(titleName);
	}

	@When("^I add highlight in the color \"(.*?)\" by selecting the text \"(.*?)\"$")
	public void i_add_highlight_in_the_color_from_to(String color, String textToBeSelected) throws InterruptedException
	{
		title.gotoNextPage();
		Thread.sleep(3000);
		Pattern textToNote = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\textToBeHighlight.PNG");
		try {
			screen.doubleClick(textToNote);	
		} catch (FindFailed e) {
			e.printStackTrace();
			System.err.println("Waiting for text to be appear");
		}
		Thread.sleep(1000);
		title.addHighlight();
		title.highlightColor(color);
	}

	@When("^I open the annotations menu.$")
	public void i_open_the_annotations_menu() throws InterruptedException
	{
		Thread.sleep(2000);
		//annotationsMenu.openAnnotationsMenu();
		new Actions(driver).doubleClick(new ProviewPage(driver).annotationsMenu()).build().perform();
	}

	@Then("^I verify that the highlight is displayed in the annotations menu.$")
	public void i_verify_that_the_highlight_is_displayed_in_the_annotations_menu_for_highlight()
	{
		library.verifyAnnotationIsDisplayed();
	}

	@When("^Sign into Proview with onepass credentials$")
	public void sign_into_Proview_with_onepass_credentials() throws Throwable {
		Thread.sleep(5000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		Thread.sleep(2000);

		driver.get("https://proview.qed.thomsonreuters.com");
		Thread.sleep(3000);
		signIn.signInActions();
	}

	@When("^Search for the title in Proview libarary which got failed in PFS$")
	public void search_for_the_title_in_Proview_libarary_which_got_failed_in_PFS() throws Throwable {

	}

	@Then("^Failed title should not be present in Proview library$")
	public void failed_title_should_not_be_present_in_Proview_library() throws Throwable {

	}
	
	@When("^I delete the highlight from the annotations Menu$")
	public void i_delete_the_highlight_from_the_annotations_Menu() throws Throwable {
		annotationsMenu.navigateToAnnotation();
		annotationsMenu.deleteAnnotation();
	}

	@Then("^I verify that the highlight is not displayed in the annotations Menu$")
	public void i_verify_that_the_highlight_is_not_displayed_in_the_annotations_Menu() throws Throwable {
		annotationsMenu.verifyAnnotationIsDeleted();
		annotationsMenu.openAnnotationsMenu();
	}

	@When("^I open the optionS menu$")
	public void i_open_the_Options_menu() throws Throwable {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		optionsMenu.open();
	}

	@When("^I sign Out$")
	public void i_sign_Out() throws Throwable {
		optionsMenu.signOut();
	}
}
