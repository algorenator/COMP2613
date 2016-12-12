package examples.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesExample {
	static final String FILENAME = "MakePropertiesExample.properties";

	public static void main(String[] args) {
		new ReadPropertiesExample();
	}

	public ReadPropertiesExample() {
		Properties properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(FILENAME);
			properties.load(in);
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			System.exit(-1);
		}

		properties.list(System.out);
		// This is how you can read name value pairs
		System.out.println("-- using getProperty() --");
		System.out.println("Font=" + properties.getProperty("Font"));
	}
}
