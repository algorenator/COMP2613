package examples.collections;

import java.util.Enumeration;
import java.util.Properties;

/**
 * This program prints out all system properties.
 */
public class SystemInfo {
	public static void main(String args[]) {
		Properties systemProperties = System.getProperties();
		Enumeration<?> properties = systemProperties.propertyNames();
		while (properties.hasMoreElements()) {
			String key = (String) properties.nextElement();
			System.out.println(key + "=" + systemProperties.getProperty(key));
		}
	}
}
