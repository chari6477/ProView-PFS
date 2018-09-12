package pfs.util.pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pfs.util.helpers.BaseObject;

public class ProviewPage extends BaseObject{

	public ProviewPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public void openTitle(String titleName)
	{
		clickWebElement(title(titleName));
	}

	public WebElement title(String title){
		WebElement book=null;
		try{
			book=findWebElementFromPropertyName("Book_"+title+"_XPATH",10);
		}catch(Exception e){
			searchForTitle(title);
			threadWait(2);
			book=findWebElementFromPropertyName("Book_"+title+"_XPATH");
		}

		return book;
	}

	public void searchForTitle(String title){
		enterText(filterByNameOrAuthorTextFld(), readProperty("Book_"+title+"_Title"));
	}

	public WebElement filterByNameOrAuthorTextFld(){
		return findWebElementFromPropertyName("Library_FilterByNameOrAuthorTextFld_XPATH");
	}

	public WebElement annotationsMenu(){
		return findWebElementFromPropertyName("AnnotationsMenu_Btn_ID");
	}

	public void verifyAnnotationIsDisplayed()
	{
		Assert.assertTrue(verifyWebElementIsDisplayed("AnnotationsMenu_AnnotationEntry_CSS"));
	}

	public void displayAvailableNotificationsList()
	{
		List<WebElement> notifications = driver.findElements(By.xpath(readProperty("NotificationList_XPATH")));
		if(notifications.size() != 0)
		{
			for(WebElement notification : notifications)
			{
				String notificationText = notification.getText().trim();
				System.out.println("Notifications list are below ...");
				System.out.println("--------------------------------");
				System.out.println(notificationText);
			}
		}
		else
		{
			System.err.println("No Notifications are available...");
		}
	}
}
