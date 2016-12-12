package examples.database.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DumpSqlServerTables {

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

		// Create a statement
		Statement statement = connection.createStatement();

		// Execute a statement
		ResultSet resultSet = statement
		        .executeQuery("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE'");

		List<String> tableNames = new ArrayList<String>();

		while (resultSet.next()) {
			tableNames.add(resultSet.getString(3));
		}

		resultSet.close();

		for (String tableName : tableNames) {
			System.out.println(tableName);
			try {
				resultSet = statement.executeQuery(String.format("select * from %s", tableName));
				ResultSetMetaData rsmd = resultSet.getMetaData();
				int numColumns = rsmd.getColumnCount();

				for (int i = 1; i < numColumns + 1; i++) {
					String columnName = rsmd.getColumnName(i);
					System.out.println("\t" + columnName);
				}
			} catch (SQLException e) {
				System.out.println("Warning " + e.getMessage());
			} finally {
				resultSet.close();
			}
		}

		// Close the connection
		connection.close();
	}
}
