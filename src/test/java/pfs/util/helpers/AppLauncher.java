package pfs.util.helpers;

import org.openqa.selenium.WebDriver;

public class AppLauncher extends DriverFactory{
	WebDriver driver = null;
	PropertyReader properties = new PropertyReader();

	public AppLauncher(WebDriver driver)
	{
		this.driver = driver;
	}
	public void closePFS()
	{
		destroyDriver();

	}
	public void launchPFS() throws InterruptedException
	{
		Thread.sleep(1000);
		if((properties.readProperty("platform")) != ("windows"))
		{
			switch(properties.readProperty("Environment"))
			{

			case "CI" :
				driver.get(properties.readProperty("CI_URL"));
				break;

			case "QED":
				driver.get(properties.readProperty("QED"));
				break;

			case "DEMO":
				driver.get(properties.readProperty("DEMO"));
				break;

			case "PROD":
				driver.get("https://proview.thomsonreuters.com");
				break;

			}
			driver.manage().deleteAllCookies();
			//driver.manage().window().maximize();
		}
	}
}
