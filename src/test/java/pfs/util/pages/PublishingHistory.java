package pfs.util.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pfs.util.helpers.BaseObject;

public class PublishingHistory extends BaseObject{

	public PublishingHistory(WebDriver driver)
	{
		this.driver = driver;
	}

	public void printTitleHistory(String titleName , String status)
	{
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		findWebElementFromPropertyName("titleSearch_XPATH").sendKeys(titleName);
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		int i=0;
		while(i>=0)
		{
			if(i>0)
			{
				if(statusIsFinal == true)
				{
					break;
				}
				
				findWebElementFromPropertyName("historyNext_XPATH").click();
				try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
			}
			getTableHeaderData();
			getTableBodyData(titleName , status);

			i++;
		}
	}

	public void getTableHeaderData()
	{
		List<WebElement> ths = driver.findElements(By.xpath("//thead/tr/th"));
		for(WebElement th : ths)
		{
			System.out.print(th.getText()+"\t\t");
		}
		System.out.println();
	}

	boolean statusIsFinal = false;
	WebElement titleNameTd = null;
	public void getTableBodyData(String titleName , String status)
	{
		List<WebElement> trs = driver.findElements(By.xpath("//tbody/tr"));
		for(WebElement tr : trs)
		{
			List<WebElement> tds = tr.findElements(By.tagName("td"));
			for(WebElement td : tds)
			{
				System.out.print(td.getText()+"\t\t");
			}
			System.out.println();

			if(tds.get(0).getText().trim().contains(titleName) && tds.get(4).getText().trim().equalsIgnoreCase(status))
			{
				System.out.println(titleName + " < --- > " + status);
				statusIsFinal = true;
				titleNameTd = tds.get(0);
				break;
			}
		}
		System.out.println();
	}

	public void getTitleAndClick(String titleName)
	{
		if(statusIsFinal == false)
		{
			System.err.println("Title name : " +titleName +" status is not final in Publishing History Table.");
		}
		if(statusIsFinal == true && titleNameTd.getText().trim().contains(titleName))
		{
			titleNameTd.click();
			try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}

	public void printDetailsOfTheTitleInPublishHistory()
	{
		String dataOfTitle = findWebElementFromPropertyName("titleDetails_XPATH").getText();
		System.out.println("Title information : "+ dataOfTitle);
	}

	public void verifyErrorTextIsDisplayed(String errorText) throws Exception
	{
		boolean errorStatus = verifyTextOnPage(errorText);
		if(errorStatus == false)
		{
			throw new Exception("Error text \""+errorText+"\" popup is not displayed OR timeout for page load.");
		}
	}

	public void verifyPublishedTextIsDisplayed()
	{
		waitForElementToBePresent("PublishedStatus_XPATH","xpath", 30);
	}
}
