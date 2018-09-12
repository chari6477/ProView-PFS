package pfs.util.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReturnPageElement extends ObjectRepositoryRead{
	public WebDriver driver = null;
	ObjectRepositoryRead pfr = new ObjectRepositoryRead();

	public String byLocator;
	public String byValue;
	
	public ReturnPageElement(WebDriver driver)
	{
		this.driver = driver;
	}

	public String returnPropValue(String key)
	{
		return pfr.returnObject(key);
	}

	public void locatorAndPath(String key)
	{
		String value = returnPropValue(key);
		String keyValues[] =  value.split("!");
		byLocator = keyValues[0];
		byValue = keyValues[1];
	}

	public WebElement getWebElementBy(String key , int time)
	{
		locatorAndPath(key);
		int i=0;
		while(i < time)
		{
			try {
				switch(byLocator)
				{
				case "ID" :
					return driver.findElement(By.id(byValue));

				case "NAME" :
					return driver.findElement(By.name(byValue));
				case "TAGNAME" :
					return driver.findElement(By.tagName(byValue));
				case "CLASSNAME" :
					return driver.findElement(By.className(byValue));
				case "LINKTEXT" :
					return driver.findElement(By.linkText(byValue));
				case "PLINKT" :
					return driver.findElement(By.partialLinkText(byValue));
				case "XPATH" :
					return driver.findElement(By.xpath(byValue));
				case "CSS" :
					return driver.findElement(By.cssSelector(byValue));

				default :
					System.err.println("Invalid locator key you are giving, pls make sure you are correct...");
				}

			}catch(Exception e)
			{
				try {Thread.sleep(1000);} catch (InterruptedException e1) {	e1.printStackTrace();}
			}

			i++;
		}
		return null;
	}

}
