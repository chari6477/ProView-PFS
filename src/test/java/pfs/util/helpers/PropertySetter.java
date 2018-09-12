package pfs.util.helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class PropertySetter {
	Properties properties = new Properties();

	public PropertySetter()
	{
		loadProperties();
	}

	private void loadProperties()
	{
		try
		{
			FileInputStream inputStream = new FileInputStream("src/main/resources\\automation.properties");
			properties.load(inputStream);
			inputStream.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void setProperty(String property, String value) throws IOException
	{
		OutputStream outputStream = new FileOutputStream("src/main/resources\\automation.properties");
		properties.setProperty(property, value);
		properties.store(outputStream, null);
		outputStream.close();
	}
}
