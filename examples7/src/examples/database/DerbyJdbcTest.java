package examples.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import examples.database.util.DbUtil;

/**
 * Creates a table using a derby jdbc connection
 */

/**
 * @author A00123456
 * 
 */
public class DerbyJdbcTest {

	public static final String DERBY_CLASSNAME = "org.apache.derby.jdbc.EmbeddedDriver";
	public static final String DERBY_CONNECT_URL = "jdbc:derby:derby_jdbc_test;create=true";
	public static final String DERBY_USER = "admin";
	public static final String DERBY_PASSWORD = "admin";
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
	public static final String SSN = "ssn";
	public static final String FIRST_NAME = "firstName";
	public static final String MI = "mi";
	public static final String LAST_NAME = "lastName";
	public static final String PHONE = "phone";
	public static final String BIRTHDATE = "birthDate";
	public static final String STREET = "street";
	public static final String ZIPCODE = "zipCode";
	public static final String DEPT_ID = "deptID";

	private static Connection _connection;
	private static Statement _statement;

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Load the database driver
		Class.forName(DERBY_CLASSNAME);
		System.out.println("Driver loaded");
		_connection = DriverManager.getConnection(DERBY_CONNECT_URL, DERBY_USER, DERBY_PASSWORD);
		System.out.println("Database connected");

		try {
			_statement = _connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Could not get the statement object from the DB");
			return;
		}

		String sqlString = null;

		try {
			if (!DbUtil.tableExists(_connection, "Student")) {
				sqlString = String.format("CREATE TABLE Student (%s VARCHAR(9), %s VARCHAR(40), %s VARCHAR(1), "
				        + "%s VARCHAR(40), "
				        + "%s VARCHAR(10), %s DATE, %s VARCHAR(40), %s VARCHAR(10), %s VARCHAR(4))", SSN, FIRST_NAME,
				        MI, LAST_NAME, PHONE, BIRTHDATE, STREET, ZIPCODE, DEPT_ID);

				_statement.executeUpdate(sqlString);
			} else {
				try {
					sqlString = "SELECT * FROM Student";
					_statement.executeQuery(sqlString);
					ResultSet resultSet = _statement.getResultSet();
					while (resultSet.next()) {
						System.out.println(String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s",
						        resultSet.getString(SSN), resultSet.getString(FIRST_NAME), resultSet.getString(MI),
						        resultSet.getString(LAST_NAME), resultSet.getString(PHONE),
						        resultSet.getString(BIRTHDATE), resultSet.getString(STREET),
						        resultSet.getString(ZIPCODE), resultSet.getString(DEPT_ID)));
					}
					sqlString = "DELETE FROM Student";
					int i = _statement.executeUpdate(sqlString);
					System.out.println(String.format("%d records removed", i));
				} catch (SQLException e) {
					// OK, probably doesn't exist
					System.out.println("Student table doesn't exist");
				}
			}
		} catch (SQLException e) {
			System.out.println("Could not create the table");
		}

		try {
			insert(new Student("444111110", "Jacob", "R", "Smith", "9129219434", "1985-04-09", "99 Kingston Street",
			        "31435", "BIOL"));
			insert(new Student("444111111", "John", "K", "Stevenson", "9129219434", "null", "100 Main Street", "31411",
			        "BIOL"));
			insert(new Student("444111112", "George", "K", "Smith", "9129213454", "1974-10-10", "1200 Abercorn St.",
			        "31419", "CS"));
			insert(new Student("444111113", "Frank", "E", "Jones", "9125919434", "1970-09-09", "100 Main Street",
			        "31411", "BIOL"));
			insert(new Student("444111114", "Jean", "K", "Smith", "9129219434", "1970-02-09", "100 Main Street",
			        "31411", "CHEM"));
			insert(new Student("444111115", "Josh", "R", "Woo", "7075989434", "1970-02-09", "555 Franklin St.",
			        "31411", "CHEM"));
			insert(new Student("444111116", "Josh", "R", "Smith", "9129219434", "1973-02-09", "100 Main Street",
			        "31411", "BIOL"));
			insert(new Student("444111117", "Joy", "P", "Kennedy", "9129229434", "1974-03-19", "103 Bay Street",
			        "31412", "CS"));
			insert(new Student("444111118", "Toni", "R", "Peterson", "9129229434", "1964-04-29", "103 Bay Street",
			        "31412", "MATH"));
			insert(new Student("444111119", "Patrick", "R", "Stoneman", "9129229434", "1969-04-29",
			        "101 Washington St.", "31435", "MATH"));
			insert(new Student("444111120", "Rick", "R", "Carter", "9125919434", "1986-04-09", "19 West Ford St.",
			        "31411", "BIOL"));

			ResultSet resultSet = null;
			sqlString = "select * from Student where ssn='444111120'";
			resultSet = _statement.executeQuery(sqlString);
			while (resultSet.next()) {
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				System.out.println(String.format("%s %s", firstName, lastName));
			}

			sqlString = "update Student set lastName='Dodge' where ssn='444111120'";
			int rowcount = _statement.executeUpdate(sqlString);
			System.out.println(String.format("Updated %d rows", rowcount));

			sqlString = "select * from Student where ssn='444111120'";
			resultSet = _statement.executeQuery(sqlString);
			while (resultSet.next()) {
				String firstName = resultSet.getString("firstName");
				String lastName = resultSet.getString("lastName");
				System.out.println(String.format("%s %s", firstName, lastName));
			}

			sqlString = "delete from Student where ssn='444111120'";
			rowcount = _statement.executeUpdate(sqlString);
			System.out.println(String.format("Deleted %d rows", rowcount));
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} finally {
			if (_statement != null) {
				try {
					_statement.close();
				} catch (SQLException e) {
					// ignore
				}
			}

			if (_connection != null) {
				try {
					_connection.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}
	}

	private static void insert(Student student) throws SQLException {
		// this is a bit of a 'hack' to insert a null date.
		// it's better to use a PreparedStatement
		String sqlString = String.format(
		        "insert into Student values('%s', '%s', '%s', '%s', '%s', %s, '%s', '%s', '%s')", student.getSsn(),
		        student.getFirstName(), student.getMi(), student.getLastName(), student.getPhone(),
		        student.getBirthDateString() == null ? null : String.format("'%s'", student.getBirthDateString()),
		        student.getStreet(), student.getZipCode(), student.getDeptID());
		_statement.executeUpdate(sqlString);
		System.out.println("Inserted " + sqlString);
	}

}
