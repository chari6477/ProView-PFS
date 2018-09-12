package pfs.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pfs.util.helpers.BaseObject;

public class SignIn extends BaseObject{
	
	public SignIn(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement cookieContinueLink(){
		return findWebElementFromPropertyName("Cookie_ContinueLink_ID");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>SignIn_UsernameTextFld_ID</b>.
	 */
	public WebElement usernameTextFld(){
		return findWebElementFromPropertyName("SignIn_UsernameTextFld_ID");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>SignIn_PasswordTextFld_ID</b>.
	 */
	public WebElement passwordTextFld(){
		return findWebElementFromPropertyName("SignIn_PasswordTextFld_ID");
	}

	/**
	 * This method creates WebElement object based on property given.
	 * @return WebElement for the property named <b>SignIn_SignInButton_ID</b>.
	 */
	public WebElement signInBtn(){
		return findWebElementFromPropertyName("SignIn_SignInButton_ID");
	}
	
	public void cookieTermsAcceptance(){
		try {
			clickWebElement(cookieContinueLink());
		} catch (Exception e) {
		}
	}

	/**
	 * Performs the sign in action of ProView app
	 */
	public void signInAction(){
		try {
			enterText(usernameTextFld(), readProperty("SignIn_Username_TestData"));
			enterText(passwordTextFld(), readProperty("SignIn_Password_TestData"));
			clickWebElement(signInBtn());
			threadWait(5);
		}catch(Exception e)
		{
			System.out.println("Already Signed In...");
		}
	}
	
	public void signInActions(){
		try {
			enterText(usernameTextFld(), readProperty("SignIn_Username_PRO_TestData"));
			enterText(passwordTextFld(), readProperty("SignIn_Password_PRO_TestData"));
			clickWebElement(signInBtn());
			threadWait(5);
		}catch(Exception e)
		{
			System.out.println("Already Signed In...");
		}
	}
	
	public void webBrowserProviewLaunch()
	{
		clickWebElement(findWebElementFromPropertyName("WebBrowserProview_ID"));
	}
	public void launchProviewBtn()
	{
		clickWebElement(findWebElementFromPropertyName("LaunchProview_ID"));
	}
	
	public void loginWithMyOnepassAccount()
	{
		clickWebElement(findWebElementFromPropertyName("LoginWithMyOnespassAccount_ID"));
	}
	
	public void isRequestedTitleAvailable()
	{
		try {
			String messageTitle = findWebElementFromPropertyName("MessageDialogBody_XPATH").getText().trim();
			System.err.println(messageTitle);
			threadWait(2);
			clickWebElement(findWebElementFromPropertyName("MessagePopupOK_XPATH"));
		}catch(Exception e)
		{	
			System.out.println("User requested title is available in proview titles.");
		}
	}
	
	public void proviewNotificationIcon()
	{
		clickWebElement(findWebElementFromPropertyName("NotificatioIcon_ID"));
	}
}
