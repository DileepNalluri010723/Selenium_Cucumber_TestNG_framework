package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static String getProperties(String propertyName) throws IOException
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("src\\main\\java\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = new Properties();
		properties.load(fis);
		return properties.getProperty(propertyName);
		}
}
