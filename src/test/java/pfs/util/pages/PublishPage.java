package pfs.util.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pfs.util.helpers.BaseObject;


public class PublishPage extends BaseObject{

	public PublishPage(WebDriver driver)
	{
		this.driver = driver;
	}

	public void selectOptionFromPageDropDown(String dd , String opt)
	{
		try {Thread.sleep(10000);} catch (InterruptedException e) {e.printStackTrace();}
		selectOptionFromDropdown(findWebElementFromPropertyName(dd+"_ID") , opt);

	}

	public void enterTextInTextfield(String text , String textbox)
	{
		enterText(findWebElementFromPropertyName(textbox+"_ID"), text);
	}

	public void clickAbutton(String textOnButton)
	{
		findWebElementFromPropertyName(textOnButton+"_XPATH").click();
	}
	
	public void clickBrowsebutton(String textOnButton)
	{
		findWebElementFromPropertyName(textOnButton+"_ID").sendKeys("D:\\BrowserGit\\Proview-PFS\\EpubFiles\\epub3.epub");
	}

	public void uploadAfile(String filename) throws AWTException, InterruptedException
	{
		Thread.sleep(3000);
		StringSelection sel = new StringSelection("D:\\BrowserGit\\Proview-PFS\\EpubFiles\\"+filename+".epub");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public void uploadTwofiles(String filename1 , String filename2) throws AWTException, InterruptedException
	{
		Thread.sleep(3000);
		StringSelection sel = new StringSelection("\"D:\\BrowserGit\\Proview-PFS\\EpubFiles\\"+filename1+".epub\""+" "+"\"D:\\BrowserGit\\Proview-PFS\\EpubFiles\\"+filename2+".epub\"");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	

	public void verifyErrorMessage(String errorText) throws InterruptedException
	{
		Thread.sleep(1000);
		verifyTextOnPage(errorText);
	}

	public void isTextDisplayed(String text) throws InterruptedException
	{
		waitForElementToBePresent("successMsg_CSS","css", 100);

		if(verifyTextInElement("successMsg_CSS","css", text))
		{
			System.out.println("File uploaded Successfully");
		}
	}

	public WebElement checkRimageOntheTitle(String review) throws InterruptedException
	{
		waitForElementToBePresent(review+"_XPATH","xpath", 20);
		return findWebElementFromPropertyName(review+"_XPATH");
	}

	public void reviewInProviewBtn(String review) throws InterruptedException
	{
		Thread.sleep(5000);
		waitForElementToBePresent(review+"_XPATH","xpath", 20);
		findWebElementFromPropertyName(review+"_XPATH").click();		 
	}

	public void spinningWheelWhileUploading()
	{
		String spinningWheelImagePath = findWebElementFromPropertyName("SpinningWheel_XPATH").getAttribute("src");
		System.out.println("Spinning wheel image src : "+spinningWheelImagePath);
	}
	
	public void isIt_ReviewTheTitle_Page()
	{
		waitForElementToBePresent("changeStateToFinalBtn_XPATH","xpath", 20);
	}
	
	public void changeStateToFinalBtn()
	{
		clickWebElement(findWebElementFromPropertyName("changeStateToFinalBtn_XPATH"));
	}
	
	public void printUploadErrorMessage()
	{
		waitForElementToBePresent("ErrorMessagePopUp_XPATH","xpath", 20);
		String errorMsg = findWebElementFromPropertyName("ErrorMessagePopUp_XPATH").getText();
		System.err.println(errorMsg);
	}
}


