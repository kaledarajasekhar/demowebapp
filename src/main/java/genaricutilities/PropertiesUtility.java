package genaricutilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesUtility {

	public String getPropertyValue(String key) throws Throwable {

		FileInputStream fis = new FileInputStream(IPathUtility.propertiesPath);

		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public void setPropertyValue(String key, String value) throws Throwable {

		FileInputStream fis = new FileInputStream(IPathUtility.propertiesPath);

		Properties prop = new Properties();
		prop.load(fis);
		prop.setProperty(key, value);
		FileOutputStream fos = new FileOutputStream(IPathUtility.propertiesPath);
		prop.store(fos, "");
	}
}
