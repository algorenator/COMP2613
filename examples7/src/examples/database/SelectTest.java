package examples.database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Run 'DatabaseDemo' first to populate the database.
 * 
 * @author scirka
 * 
 */
public class SelectTest {

	public static final String DB_PROPERTIES_FILENAME = "db.properties";

	public static final String DB_DRIVER_KEY = "db.driver";
	public static final String DB_URL_KEY = "db.url";
	public static final String DB_USER_KEY = "db.user";
	public static final String DB_PASSWORD_KEY = "db.password";

	private final Properties _properties;
	private static Connection _connection;

	public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException,
	        IOException {
		File file = new File(DB_PROPERTIES_FILENAME);
		if (!file.exists()) {
			showUsage();
			System.exit(-1);
		}

		try {
			new SelectTest(file).run();
		} finally {
			if (_connection != null) {
				_connection.close();
			}
		}
	}

	private SelectTest(File file) throws FileNotFoundException, IOException {
		_properties = new Properties();
		_properties.load(new FileInputStream(file));
	}

	private void run() throws ClassNotFoundException, SQLException {
		connect();

		// Create a statement
		Statement statement = _connection.createStatement();

		// Execute a statement
		ResultSet resultSet = statement.executeQuery("select firstName, mi, lastName from Student where lastName "
		        + " = 'Smith'");

		// Iterate through the result and print the student names
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
		}

		// Close the connection
		_connection.close();
	}

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(_properties.getProperty(DB_DRIVER_KEY));
		System.out.println("Driver loaded");
		_connection = DriverManager.getConnection(_properties.getProperty(DB_URL_KEY),
		        _properties.getProperty(DB_USER_KEY), _properties.getProperty(DB_PASSWORD_KEY));
		System.out.println("Database connected");
	}

	private static void showUsage() {
		System.err.println(String.format("Program cannot start because %s cannot be found.", DB_PROPERTIES_FILENAME));
	}

}
