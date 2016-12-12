package examples.database.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlServerJdbcTest {

	public static final String DRIVER_CLASSNAME = "net.sourceforge.jtds.jdbc.Driver";
	public static final String SQLSERVER_CONNECT_URL = "jdbc:jtds:sqlserver://Beangrinder.bcit.ca";
	public static final String SQLSERVER_USER = "javastudent";
	public static final String SQLSERVER_PASSWORD = "compjava";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// Load the JDBC driver
		Class.forName(DRIVER_CLASSNAME);
		System.out.println("Driver loaded");

		// Establish a connection
		Connection connection = DriverManager.getConnection(SQLSERVER_CONNECT_URL, SQLSERVER_USER, SQLSERVER_PASSWORD);
		System.out.println("Database connected");

		// Create a statement
		Statement statement = connection.createStatement();

		// Execute a statement
		String sql = "select firstName, mi, lastName, birthDate from Student where lastName = 'Smith'";
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.println(sql);

		// Iterate through the result and print the student names
		while (resultSet.next()) {
			System.out.println(resultSet.getString("firstName") + "\t" + resultSet.getString("mi") + "\t"
			        + resultSet.getString("lastName") + "\t" + resultSet.getDate("birthDate"));
		}
		// Close the connection
		connection.close();
	}
}
