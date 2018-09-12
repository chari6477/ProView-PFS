package pfs.test.stepdefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pfs.util.helpers.DriverFactory;

public class Hook extends DriverFactory{
	Scenario scenario ;

	@Before
	public void testSetup(Scenario scenario)
	{
		this.scenario = scenario;
		System.out.println("Test Envoronment setup.");
		System.out.println("------------------------------------------------------------");
		System.out.println("Executing Scenario is : "+ scenario.getName());
	}

	@After
	public void tearDown(Scenario scenario) throws Exception
	{
		scenario.write("Scenario finished...");
		System.out.println("Scenario is ended...");
		if(scenario.isFailed())
		{
			System.err.println(scenario.getName() +    ": Scenario is failed.");
			try {
				scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES), "image/png");
			}catch(Exception e) {}

			Robot robot = new Robot();
			Thread.sleep(4000);

			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_ALT);
			robot.keyRelease(KeyEvent.VK_F4);
			Thread.sleep(4000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			driver = null;
		}

		System.out.println("------------------------------------------------------------");
	}

}
