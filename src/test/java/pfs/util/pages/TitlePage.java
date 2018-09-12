package pfs.util.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pfs.util.helpers.BaseObject;

public class TitlePage extends BaseObject{

	public TitlePage(WebDriver driver)
	{
		this.driver = driver;
	}

	int i = 1;
	public void highlightText(String textToBeHighlighted) throws InterruptedException
	{
		threadWait(3);
		selectTextOfWebElement(textOnPages(textToBeHighlighted));
	}

	public void addHighlight()
	{
		clickWebElement(selectedTextContextMenu("Highlight"));
	}

	public WebElement selectedTextContextMenu(String option){
		return findWebElementFromPropertyName("Title_SelectedTextContextMenu_Options_XPATH", option);
	}

	public void highlightColor(String color)
	{
		clickWebElement(highlightWithColor(color));
	}

	public WebElement highlightWithColor(String color){
		return findWebElementFromPropertyName("Title_Highlight_Colors_XPATH", color);
	}

	public void gotoNextPage()
	{
		i=1;
		while(i<3)
		{
			clickWebElement(findWebElementFromPropertyName("NextPageBtn_XPATH"));
			i++;
		}
	}
}
