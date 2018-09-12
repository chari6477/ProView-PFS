package pfs.util.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileRead {
	Properties prop = new Properties();
	InputStream input = null;

	public ConfigFileRead()
	{
		try {
			input = new FileInputStream(System.getProperty("user.dir")+"//config.properties");
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String readProperties(String key)
	{
		String keyValue ;
		keyValue = prop.getProperty(key);

		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return keyValue;
	}
}
