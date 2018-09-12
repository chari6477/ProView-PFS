package pfs.util.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ObjectRepositoryRead extends ConfigFileRead{
	Properties prop1 = new Properties();
	InputStream input1 = null;

	public ObjectRepositoryRead()
	{
		try {
			input1 = new FileInputStream(System.getProperty("user.dir")+"//PageObjectRepository.properties");
			prop1.load(input1);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String returnObject(String key)
	{
		String keyValue1 ;
		keyValue1 = prop1.getProperty(key);

		if (input1 != null) {
			try {
				input1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return keyValue1;
	}
}
