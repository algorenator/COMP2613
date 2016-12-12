package examples.properties;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MakePropertiesExample {
	static final String FILENAME = "MakePropertiesExample.properties";

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put("ForegroundColor", "Blue");
		properties.put("BackgroundColor", "Yellow");
		properties.put("Currency", "$US");
		properties.put("Weight", "Lbs");
		properties.put("Font", "Times New Roman");
		properties.put("DateFormat", "mm/dd/yyyy");
		properties.list(System.out);
		try {
			FileOutputStream out = new FileOutputStream(FILENAME);
			properties.store(out, "My properties file");
			out.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
