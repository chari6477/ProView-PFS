package pfs.util.pages;

import org.apache.commons.lang.WordUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pfs.util.helpers.BaseObject;

public class OptionsMenu extends BaseObject{

	public OptionsMenu(WebDriver driver)
	{
		this.driver = driver;
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>OptionsMenu_Btn_ID</b>.
	 */
	public WebElement menuBtn(){
		return findWebElementFromPropertyName("OptionsMenu_Btn_ID");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @param option Should be any one of the following - <b>Sign Out, Language, Layout, Font, Text Size, Line Spacing, Color Scheme and Color Labels</b>
	 * @return WebElement for the property named <b>OptionsMenu_Options_XPATH</b>.
	 */
	public WebElement options(String option){
		return findWebElementFromPropertyName("OptionsMenu_Options_XPATH", option);
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @param language Should be any one of the following - <b>English - UK, English - US, Français, Español, Português, 한국어, Russian and Türkçe</b>
	 * @return WebElement for the property named <b>OptionsMenu_Languages_XPATH</b>.
	 */
	public WebElement languageOptions(String language){
		return findWebElementFromPropertyName("OptionsMenu_Languages_XPATH", language);
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @param colorScheme Should be any one of the following - <b>blackOnWhite, whiteOnBlack and blackOnGrey</b>
	 * @return WebElement for the property named <b>OptionsMenu_ColorSchemeOptions_XPATH</b>.
	 */
	public WebElement colorSchemeOptions(String colorScheme){
		return findWebElementFromPropertyName("OptionsMenu_ColorSchemeOptions_XPATH", colorScheme);
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @param layout Should be any one of the following - <b>Pages and Scroll</b>
	 * @return WebElement for the property named <b>OptionsMenu_Layouts_XPATH</b>.
	 */
	public WebElement layoutOptions(String layout){
		return findWebElementFromPropertyName("OptionsMenu_Layouts_XPATH",layout);
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>OptionsMenu_BackBtn_XPATH</b>.
	 */
	public WebElement backBtn(){
		return findWebElementFromPropertyName("OptionsMenu_BackBtn_XPATH");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>OptionsMenu_CloseBtn_XPATH</b>.
	 */
	public WebElement closeBtn(){
		return findWebElementFromPropertyName("OptionsMenu_CloseBtn_XPATH");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @param font  Should be any one of the following - <b>Arial, Helvetica, Georgia, Times New Roman and Verdana</b>
	 * @return WebElement for the property named <b>OptionsMenu_BackBtn_XPATH</b>.
	 */
	public WebElement fontOptions(String font){
		return findWebElementFromPropertyName("OptionsMenu_Fonts_XPATH", font);
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @param option  Should be any one of the following - <b>Plus and Minus</b>
	 * @return WebElement for the property named <b>OptionsMenu_TextSizeOptions_XPATH</b>.
	 */
	public WebElement textSizingOptions(String option){
		return findWebElementFromPropertyName("OptionsMenu_TextSizeOptions_XPATH", option);
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @param option  Should be any one of the following - <b>one, two and three</b>
	 * @return WebElement for the property named <b>OptionsMenu_LineSpacingOptions_XPATH</b>.
	 */
	public WebElement lineSpacingOptions(String option){
		return findWebElementFromPropertyName("OptionsMenu_LineSpacingOptions_XPATH", option);
	}

	/**
	 * Opens options menu
	 */
	public void open()
	{
		threadWait(3);
		clickWebElement(menuBtn());
		threadWait(3);
	}

	/**
	 * Selects required option from the already opened menu.
	 * @param option Should be any one of the following - <b>Sign Out, Language, Layout, Font, Text Size, Line Spacing, Color Scheme and Color Labels</b>
	 */
	public void selectOption(String option){
		clickWebElement(options(option));
	}

	/**
	 * Selects required language from the already opened language menu.
	 * @param language Should be any one of the following - <b>English - UK, English - US, Français, Español, Português, 한국어, Russian and Türkçe</b>
	 */
	public void selectLanguage(String language){
		clickWebElement(languageOptions(language));
	}

	/**
	 * Selects required color scheme from the already opened options menu.
	 * @param colorScheme Should be any one of the following - <b>Black On White, White On Black and Black On Grey</b>
	 */
	public void selectColorScheme(String colorScheme)
	{
		String colorSchemeArr[]=colorScheme.split(" ");
		colorScheme=colorSchemeArr[0].toLowerCase()+WordUtils.capitalize(colorSchemeArr[1])+WordUtils.capitalize(colorSchemeArr[2]);
		clickWebElement(colorSchemeOptions(colorScheme));
		clickWebElement(closeBtn());
	}

	/**
	 * Selects required layout from the already opened options menu.
	 * @param layout Should be any one of the following - <b>Pages and Scroll</b>
	 */
	public void selectLayout(String layout) throws InterruptedException
	{
		clickWebElement(layoutOptions(layout));
	}

	/**
	 * Selects required font from the already opened fonts menu.
	 * @param font  Should be any one of the following - <b>Arial, Helvetica, Georgia, Times New Roman and Verdana</b>
	 */
	public void selectFont(String font){
		clickWebElement(fontOptions(font));
	}

	/**
	 * Selects required text sizing from the already opened options menu.
	 * @param option  Should be any one of the following - <b>Plus and Minus</b>
	 */
	public void selectTextSizingOptions(String option){
		clickWebElement(textSizingOptions(option));
	}

	/**
	 * Selects required line spacing from the already opened options menu.
	 * @param space  Should be any one of the following - <b>one, two and three</b>
	 */
	public void selectLineSpace(String space){
		clickWebElement(lineSpacingOptions(space));
	}

	/**
	 * Clicks on back button
	 */
	public void clickBackBtn(){
		clickWebElement(backBtn());
	}

	/**
	 * Clicks on Sign Out button
	 * @throws InterruptedException
	 */
	public void signOut() throws InterruptedException
	{
		clickWebElement(options("Sign Out"));
		threadWait(2);
	}

	/**
	 * Verifies that we can't make changes in color scheme
	 */
	public void verifyCantMakeChangesToColorScheme()
	{
		Assert.assertFalse(verifyWebElementIsDisplayed("OptionsMenu_Options_XPATH","Color Scheme"));
	}
}
