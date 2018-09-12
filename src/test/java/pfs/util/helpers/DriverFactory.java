package pfs.util.helpers;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	public static WebDriver driver;
	DriverSetter setter = new DriverSetter();

	public DriverFactory()
	{
		initialize();
	}

	private void createNewDriverInstance()
	{
		driver = setter.setDriver();
	}

	public void destroyDriver()
	{	
		driver.close();
		try{
			driver.quit();
		}catch(Exception e)
		{

		}
		try 
		{
			Thread.sleep(5000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e)
		{
		}
		driver = null;
	}

	public WebDriver getDriver()
	{
		return driver;
	}

	public void initialize()
	{
		if(driver == null)
		{
			createNewDriverInstance();
		}
	}
}
