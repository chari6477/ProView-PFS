package pfs.util.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	Properties properties = new Properties();

	public PropertyReader()
	{
		loadProperties();
	}

	private void loadProperties()
	{
		try
		{
			FileInputStream inputStream = new FileInputStream("src/test/resources/automation.properties");

			properties.load(inputStream);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public String readProperty(String property)
	{
		return properties.getProperty(property);
	}
}
