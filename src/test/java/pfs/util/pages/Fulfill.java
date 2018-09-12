package pfs.util.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;

import pfs.util.helpers.BaseObject;

public class Fulfill extends BaseObject{

	Robot robo = null;
	WebDriverWait wait;
	Screen screen = new Screen();
	public Fulfill(WebDriver driver)
	{
		this.driver = driver;
	}

	public void click_Activity(String text)
	{
		returnElementHavingExactText(text).click();
	}


	public void useSikuliByImage(String proprty)
	{
		Pattern textToNote = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\"+proprty+".PNG");
		try {
			screen.click(textToNote);	
		} catch (FindFailed e) {
			e.printStackTrace();
			System.err.println("Waiting for text to be appear");
		}
	}

	public boolean verifySikuliByImage(String proprty)
	{
		Pattern textToNote = new Pattern(System.getProperty("user.dir")+"\\SikuliCroppedUpImages\\"+proprty+".PNG");
		if(screen.exists(textToNote) != null)
		{
			return true;
		}

		return false;
	}

	public void hoverElement(String proprty)
	{
		useSikuliByImage(proprty);
	}
	
	public void verifyElementBySikuli(String proprty) throws InterruptedException
	{	
		Thread.sleep(5000);
		Assert.assertTrue(verifySikuliByImage(proprty));
	}

	public WebElement returnElementHavingExactText(String eleText)
	{
		boolean eleAvail = false;
		List<WebElement> spans  = driver.findElements(By.tagName("span"));
		for(WebElement span : spans)
		{
			if(span.getText().trim().equals(eleText))
			{
				eleAvail = true;
				return span;
			}
		}

		if(eleAvail == false)
		{
			try {
				throw new Exception("No element found having text : " + eleText);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public void verifyElementToBePresented(String locator)
	{

		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(properties.readProperty(locator))));
	}
	public void verifyPublishElementToBePresented(String locator)
	{
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(properties.readProperty(locator))));
	}

	public WebElement selectTitle(String titleName)
	{
		return new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'"+titleName+"')]/parent::div/following-sibling::span[2]")));
		//return driver.findElement(By.xpath("//div[contains(text(),'"+titleName+"')]/parent::div/following-sibling::span[2]"));
	}

	public void clickPlusSymbolOfTitle(String nameOfTitle) throws InterruptedException
	{
		Thread.sleep(5000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,250)");
		selectTitle(nameOfTitle).click();
	}

	public void countAddedTitlesInCart() throws Exception
	{
		try
		{
			String count = findWebElementFromPropertyName("CartCount_CSS").getText().trim();
			System.out.println("Cart count is :" + count);
		}catch(Exception e)
		{
			throw new Exception("The title is not added to the cart.");
		}
	}

	public void clickCart() throws InterruptedException
	{
		Thread.sleep(5000);
		findWebElementFromPropertyName("CartImage_XPATH").click();
	}

	public void clickAnElement(String property)
	{
		findWebElementFromPropertyName(property).click();
	}
	
	public void nextButton()
	{
		findWebElementFromPropertyName("NextBtnCart_XPATH").click();
	}

	public void selectTransactionTypeRadioButton(String radio)
	{
		List<WebElement> labels = driver.findElements(By.xpath("//input[@name='typetrans']"));

		if(radio.contains("Single"))
		{
			labels.get(0).click();
			System.out.println("Title type is :"+radio);
		}
		else if(radio.contains("Subscription"))
		{
			labels.get(1).click();
			System.out.println("Title type is :"+radio);
		}
		else
			System.err.println("Please choose a correct Transaction type...");
	}

	public void selectTokenTypeRadioButton(String radio)
	{
		List<WebElement> labels = driver.findElements(By.xpath("//input[@name='typetoken']"));

		if(radio.contains("Single"))
		{
			labels.get(0).click();
			System.out.println("Title type is :"+radio);
		}
		else if(radio.contains("Multi"))
		{
			labels.get(1).click();
			System.out.println("Title type is :"+radio);
		}
		else if(radio.contains("Bulk"))
		{
			labels.get(2).click();
			System.out.println("Title type is :"+radio);
		}
		else
			System.err.println("Please choose a correct Title type...");
	}

	public void selectTokenNameRadioButton(String radio)
	{
		List<WebElement> labels = driver.findElements(By.xpath("//input[@name='tokenNameType']"));

		if(radio.contains("Default"))
		{
			System.out.println("Title Name is :"+radio);
		}
		else if(radio.contains("Custom"))
		{
			labels.get(1).click();
			System.out.println("Title Name is :"+radio);
		}
		else
			System.err.println("Please choose a correct Title Name...");
	}

	public void tokenExpiryDate(String mm , String dd , String yy) throws AWTException
	{
		findWebElementFromPropertyName("Token_ExpiryDate_ID").click();
		findWebElementFromPropertyName("Token_ExpiryDate_ID").sendKeys(mm+" "+dd+" "+yy);
	}
	
	public void contentExpirationDate(String mm , String dd , String yy) throws AWTException
	{
		findWebElementFromPropertyName("Content_ExpiryDate_ID").click();
		findWebElementFromPropertyName("Content_ExpiryDate_ID").sendKeys(mm+" "+dd+" "+yy);
		findWebElementFromPropertyName("Content_ExpiryDate_Heading_XPATH").click();
	}
	
	public void sUBSCRIPTIONSTARTDATE(String mm , String dd , String yy) throws AWTException
	{
		findWebElementFromPropertyName("SUBSCRIPTION_START_DATE_XPATH").click();
		findWebElementFromPropertyName("SUBSCRIPTION_START_DATE_XPATH").sendKeys(mm+" "+dd+" "+yy);
		findWebElementFromPropertyName("SUBSCRIPTION_DETAIL_Heading_XPATH").click();
	}

	public void sUBSCRIPTIONENDDATE(String mm , String dd , String yy) throws AWTException
	{
		findWebElementFromPropertyName("SUBSCRIPTION_END_DATE_XPATH").click();
		findWebElementFromPropertyName("SUBSCRIPTION_END_DATE_XPATH").sendKeys(mm+" "+dd+" "+yy);
		findWebElementFromPropertyName("SUBSCRIPTION_DETAIL_Heading_XPATH").click();
	}
	public void nextButtonInEntitlementPage()
	{
		findWebElementFromPropertyName("NextBtnETM_XPATH").click();
	}

	public void verifyTextIsPresent(String text)
	{
		verifyTextOnPage(text);
	}
	
	public void verifyElementIsPresent(String property)
	{
		Assert.assertTrue(findWebElementFromPropertyName(property).isDisplayed());
	}
	
	public void enterTextIntoTextBox(String property1 , String property2)
	{
		findWebElementFromPropertyName(property1).clear();
		enterText(findWebElementFromPropertyName(property1), property2);
	}
	
	public void printEntitlementDetails() throws Exception
	{
		try
		{
			String Entitlement = findWebElementFromPropertyName("ENTITLEMENT_DETAILS_Print_XPATH").getText().trim();
			System.out.println("Entitlement Details :" + Entitlement);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("The Entitlement Details are not displayed.");
		}
	}
	
	public void printSubscriptionPeriod() throws Exception
	{
		try
		{
			String Entitlement = findWebElementFromPropertyName("Subscription_Period_Print_XPATH").getText().trim();
			System.out.println("Subscription Period :" + Entitlement);
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new Exception("The Subscription Period Details are not displayed.");
		}
	}
	

	
}
