package pfs.util.helpers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseObject {
	public static String environment = null;
	public static String password = null;
	public static String platform = null;
	public static String titleLayout = null;
	public static String username = null;
	public static String currentTab;
	public WebDriver driver = null;
	public PropertyReader properties = new PropertyReader();

	Robot robot;
	protected void assertTrue()
	{

	}

	/**
	 * Clicks on an element on the screen.
	 * @param element The identifier of the element
	 * @param byType The type of "element". Accepted values are: css, id, xpath.
	 */
	protected void click(String element, String byType)
	{
		findElement(element, byType).click();
	}

	protected void doubleClick(String propertyName, String byType)
	{
		Actions select = new Actions(driver);
		select.doubleClick(findElement(propertyName, byType)).build().perform();
	}

	/**
	 * Drags and drops an element to a new location.
	 * @param element
	 * @param dropLocation
	 * @param elementType
	 * @param dropLocationType
	 */
	protected void dragAndDrop(String element, String elementType, String dropLocation, String dropLocationType)
	{
		Actions action = new Actions(driver);
		action.dragAndDrop(findElement(element, elementType), findElement(dropLocation, dropLocationType)).perform();
	}

	/**
	 * 
	 * @param element
	 * @param byType
	 * @return
	 */
	protected WebElement findElement(String element, String byType)
	{
		//		AFTER createByFromProperty IS CHANGED, UPDATE THIS METHOD SIGNATURE
		return driver.findElement(createByFromProperty(element, byType));
	}

	protected String getAttribute(String element, String type, String attribute)
	{
		return findElement(element, type).getAttribute(attribute);
	}

	protected String getCssValue(String element, String type, String cssValue)
	{
		return findElement(element, type).getCssValue(cssValue);
	}

	/**
	 * Returns the page source in a String.
	 * @return
	 */
	protected String getPageSource()
	{
		return driver.getPageSource();
	}

	public void getWebsite(String website)
	{
		driver.get(website);
	}

	public void launchProView() throws InterruptedException
	{
		getWebsite(readProperty(readProperty("Test_Environment") + "_URL"));
		Thread.sleep(4000);
	}

	protected void moveToElement(String propertyName, String byType)
	{
		Actions action = new Actions(driver);
		action.moveToElement(findElement(propertyName, byType));
	}

	protected By createByFromProperty(String propertyName, String byType)
	{
		//		USE THIS CODE AFTER PROPERTIES HAVE BEEN RENAMED
		//		this method signature will then remove byType (only propertyName will be used)
		//		
		//		if(propertyName.contains("CSS"))
		//		{
		//			return By.cssSelector(readProperty(properties.readProperty(propertyName));
		//		}
		//		else if(propertyName.contains("ID"))
		//		{
		//			return By.id(readProperty(properties.readProperty(propertyName));
		//		}
		//		else if(propertyName.contains("XPath"))
		//		{
		//			return By.xpath(readProperty(properties.readProperty(propertyName));
		//		}
		//		else
		//		{
		//			throw new Exception("Element type not found. Must be CSS, ID, or XPath.");
		//		}

		switch(byType)
		{
		case "css":
			return By.cssSelector(properties.readProperty(propertyName));
		case "id":
			return By.id(properties.readProperty(propertyName));
		case "xpath":
			return By.xpath(properties.readProperty(propertyName));
		default:
			//this is probably horrible treatment
			return new By.ById(propertyName);
		}
	}


	protected void type(String element, String byType, Keys key)
	{
		findElement(element, byType).clear();
		findElement(element, byType).sendKeys(key);
	}

	protected void type(String element, String byType, String text)
	{
		findElement(element, byType).clear();
		findElement(element, byType).sendKeys(text);
	}

	protected void typeCommand(String element, String byType, Keys key1, Keys key2)
	{
		findElement(element, byType).clear();
		findElement(element, byType).sendKeys(key1, key2);
	}

	protected String verifyElementClass(String element, String type)
	{
		return findElement(element, type).getAttribute("class");
	}

	protected boolean verifyElementIsDisplayed(String element, String type)
	{
		return findElement(element, type).isDisplayed();
	}

	protected boolean verifyElementIsEnabled(String element, String type)
	{
		return findElement(element, type).isEnabled();
	}

	protected boolean verifyTextInElement(String element, String byType, String text)
	{
		return findElement(element, byType).getText().contains(text);
	}


	protected void waitForElementToBeClickable(String element, String byType, long timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(createByFromProperty(element, byType)));
	}

	protected void waitForElementToBePresent(String element, String byType, long timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(createByFromProperty(element, byType)));
	}

	protected void waitForElementToBeVisible(String element, String byType, long timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(createByFromProperty(element, byType)));
	}



	//_______________________________________New Methods___________________________________________________


	protected String readProperty(String propertyName)
	{
		return properties.readProperty(propertyName);
	}


	protected WebElement findWebElementFromPropertyName(String propertyName){
		return waitForElementToBePresent(locatorTypeFinder(propertyName,""),100);
	}

	protected WebElement findWebElementFromPropertyName(String propertyName, String argumentValue){
		return waitForElementToBePresent(locatorTypeFinder(propertyName, argumentValue),20);
	}

	protected WebElement findWebElementFromPropertyName(String propertyName, long timeout){
		return waitForElementToBePresent(locatorTypeFinder(propertyName, ""),timeout);
	}

	protected WebElement findWebElementFromPropertyName(String propertyName, String argumentValue, long timeout){
		return waitForElementToBePresent(locatorTypeFinder(propertyName, argumentValue),timeout);
	}

	protected WebElement waitForElementToBePresent(By locatorType, long timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locatorType));
		jsScrollIntoView(element);
		return element;
	}

	protected By locatorTypeFinder(String propertyName, String argumentValue){
		System.out.println("\nAction: Find Element\t\tName: "+propertyName+"\t\tValue: "+String.format(readProperty(propertyName), argumentValue));
		By locatorType=null;
		if(propertyName.contains("_ID")){
			locatorType=By.id(String.format(readProperty(propertyName), argumentValue));
		}else if(propertyName.contains("_CSS")){
			locatorType=By.cssSelector(String.format(readProperty(propertyName), argumentValue));
		}else if(propertyName.contains("_XPATH")){
			locatorType=By.xpath(String.format(readProperty(propertyName), argumentValue));
		}else{
			System.out.println("Valid type of locator type needed.");
		}
		return locatorType;
	}

	protected WebElement waitForElementToBeClickable(WebElement webElement, long timeout)
	{

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		return wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public void clickWebElement(WebElement webElement){
		clickWebElement(webElement, 20);
	}

	protected void clickWebElement(WebElement webElement, long timeout){
		threadWait(1);
		System.out.println("\nAction: Click\t\t\tWebElement: Element Found in Previous Step");
		if(System.getProperty("Browser").equals("IE")){
			Actions action=new Actions(driver);
			action.click(waitForElementToBeClickable(webElement,timeout)).build().perform();
		}else{
			waitForElementToBeClickable(webElement,timeout).click();
		}
	}

	protected void enterText(WebElement webElement, String textToEnter){
		System.out.println("\nAction: Text Entry\t\tText: "+textToEnter);
		threadWait(1);
		try {
			webElement.clear();
			threadWait(1);
		} catch (Exception e) {
			System.out.println("Unable to Clear");
		}
		webElement.sendKeys(textToEnter);
		threadWait(2);
	}
	
	protected void moveToWebElement(WebElement element)
	{
		threadWait(1);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	protected boolean verifyWebElementIsDisplayed(String propertyName, String argumentName, long timeOut)
	{
		threadWait(1);
		try{
			findWebElementFromPropertyName(propertyName,argumentName,timeOut);
			return true;
		}catch(Exception e){
			return false;
		}
	}

	protected boolean verifyWebElementIsDisplayed(String propertyName)
	{
		return verifyWebElementIsDisplayed(propertyName, "", 10);
	}

	protected boolean verifyWebElementIsDisplayed(String propertyName, String argumentName)
	{
		return verifyWebElementIsDisplayed(propertyName, argumentName, 100);
	}

	protected boolean verifyWebElementIsDisplayed(String propertyName, long timeOut)
	{
		return verifyWebElementIsDisplayed(propertyName, "", timeOut);
	}

	public void clickWebElementByActionsClass(WebElement webElement){
		threadWait(3);
		Actions actions=new Actions(driver);
		actions.click(webElement).build().perform();
	}

	public void threadWait(int seconds){
		try {
			System.out.println("\nAction: Wait\t\t\tDuration: "+seconds+" seconds");
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean verifyTextOnPage(String text)
	{
		threadWait(3);
		boolean result=verifyWebElementIsDisplayed("PAGE_CONTENT_XPATH",text);
		if(result){
			return result;
		}else{
			return verifyWebElementIsDisplayed("PAGE_CONTENT1_XPATH",text);
		}
	}

	public WebElement textOnPage(String text){
		threadWait(3);
		return findWebElementFromPropertyName("PAGE_CONTENT_XPATH",text);
	}

	public WebElement textOnPages(String text){
		threadWait(3);
		return findWebElementFromPropertyName("PAGE_CONTENT2_XPATH",text);
	}

	public WebElement getSelectedDropdownOption(String dropdownPropertyName){

		return (new Select(findWebElementFromPropertyName(dropdownPropertyName))).getFirstSelectedOption();
	}

	public WebElement getSelectedDropdownOption(WebElement dropdown){

		return (new Select(dropdown)).getFirstSelectedOption();
	}

	public void selectOptionFromDropdown(WebElement dropdown, String option){
		(new Select(dropdown)).selectByVisibleText(option);
	}

	protected boolean verifyTextInWebElement(WebElement element, String textToVerify)
	{
		return element.getText().contains(textToVerify);
	}

	public void clearText(WebElement element){
		try {
			element.clear();
		} catch (Exception e) {
			System.out.println("Unable to clear text field");
		}
	}

	public void jQueryScroll(String propertyName, String scrollAmount){
		if(!propertyName.contains("_ID")){
			System.out.println("Please give only ID value.");
			System.exit(0);
		}
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("$('#"+readProperty(propertyName)+"').animate({ scrollTop:'"+scrollAmount+"px' })");
	}

	public void jsScrollIntoView(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public WebElement bodyTag(){
		return findWebElementFromPropertyName("Body_Tag_CSS");
	}

	public String getAttribute(WebElement element, String attribute)
	{
		return element.getAttribute(attribute);
	}

	public String getCSSValues(WebElement element, String attribute){
		return element.getCssValue(attribute);
	}

	public void selectTextOfWebElement(WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element,0,0).click().keyDown(Keys.SHIFT).moveToElement(element,element.getSize().width, 0).click().keyUp(Keys.SHIFT).build().perform();
		// actions.moveToElement(element,0,0).clickAndHold().moveByOffset(100, 0).release().perform();
	}

	public void dragAndDrop(WebElement dragElement, WebElement dropInElement){
		Actions actions = new Actions(driver);
		actions.dragAndDrop(dragElement, dropInElement).build().perform();
	}

	protected void doubleClickOnWebElement(WebElement webElement)
	{
		Actions select = new Actions(driver);
		select.doubleClick(webElement).build().perform();
	}

	protected void switchToActiveElement(){
		driver.switchTo().activeElement();
	}

	protected void switchToFrame(String frameID){
		driver.switchTo().frame(frameID);
	}

	/*
	-------------------
          CHARI
	-------------------
	 */

	public void pressKeyEnter()
	{
		try {	robot = new Robot();  } catch (AWTException e) {	e.printStackTrace();}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		threadWait(5);
	}

	public void pressKeysCTRLplusV(String command)
	{
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		StringSelection stringSelection = new StringSelection( command );
		clipboard.setContents(stringSelection, stringSelection);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		threadWait(5);
	}

	public void pressKeyWindows()
	{
		try {	robot = new Robot();  } catch (AWTException e) {	e.printStackTrace();}
		robot.keyPress(KeyEvent.VK_WINDOWS);
		robot.keyRelease(KeyEvent.VK_WINDOWS);
		threadWait(3);
	}



	public  void highlightElement(WebElement element) {
		for (int i = 0; i <2; i++) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: purple; border: 2px solid green; background-color:yellow");
			threadWait(1);
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	}

	
}
