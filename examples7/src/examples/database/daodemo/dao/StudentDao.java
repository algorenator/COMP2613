package examples.database.daodemo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import examples.database.Student;
import examples.database.daodemo.Database;

public class StudentDao extends Dao {

	public static final String TABLE_NAME = "Student";
	public static final String SSN = "SSN";
	public static final String FIRSTNAME = "FIRSTNAME";
	public static final String MI = "MI";
	public static final String LASTNAME = "LASTNAME";
	public static final String PHONE = "PHONE";
	public static final String BIRTHDATE = "BIRTHDATE";
	public static final String STREET = "STREET";
	public static final String ZIPCODE = "ZIPCODE";
	public static final String DEPTID = "DEPTID";

	public StudentDao(Database database) {
		super(database, TABLE_NAME);
	}

	@Override
	public void create() throws SQLException {
		String createStatement = String
		        .format("create table %s(%s VARCHAR(9), %s VARCHAR(10), %s VARCHAR(1), %s VARCHAR(10), %s VARCHAR(10), %s VARCHAR(10), %s VARCHAR(20), %s VARCHAR(10), %s VARCHAR(4), primary key (%s) )",
		                _tableName, //
		                SSN, FIRSTNAME, MI, LASTNAME, PHONE, BIRTHDATE, STREET, ZIPCODE, DEPTID, SSN);
		super.create(createStatement);
	}

	public void add(Student student) throws SQLException {
		Statement statement = null;
		try {
			Connection connection = _database.getConnection();
			statement = connection.createStatement();
			String insertString = String.format(
			        "insert into %s values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", _tableName, //
			        student.getSsn(), //
			        student.getFirstName(), //
			        student.getMi(), //
			        student.getLastName(), //
			        student.getPhone(), //
			        student.getBirthDateString(), //
			        student.getStreet(), //
			        student.getZipCode(), //
			        student.getDeptID());
			statement.executeUpdate(insertString);
			System.out.println(insertString);
		} finally {
			close(statement);
		}
	}

	public Student readBySsn(String ssn) throws SQLException, Exception {
		Connection connection;
		Statement statement = null;
		Student student = null;
		try {
			connection = _database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sqlString = String.format("SELECT * FROM %s WHERE %s = '%s'", _tableName, SSN, ssn);
			ResultSet resultSet = statement.executeQuery(sqlString);

			// get the Student
			// throw an exception if we get more than one result
			int count = 0;
			while (resultSet.next()) {
				count++;
				if (count > 1) {
					throw new Exception(String.format("Expected one result, got %d", count));
				}
				student = new Student();
				student.setSsn(resultSet.getString(SSN));
				student.setFirstName(resultSet.getString(FIRSTNAME));
				student.setMi(resultSet.getString(MI));
				student.setLastName(resultSet.getString(LASTNAME));
				student.setPhone(resultSet.getString(PHONE));
				student.setBirthDate(resultSet.getString(BIRTHDATE));
				student.setStreet(resultSet.getString(STREET));
				student.setZipCode(resultSet.getString(ZIPCODE));
				student.setDeptID(resultSet.getString(DEPTID));
			}
		} finally {
			close(statement);
		}

		return student;
	}

	public void update(Student student) throws SQLException {
		Connection connection;
		Statement statement = null;
		try {
			connection = _database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sqlString = String
			        .format("UPDATE %s set %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s' WHERE %s='%s'",
			                _tableName, //
			                SSN, student.getSsn(), //
			                FIRSTNAME, student.getFirstName(), //
			                MI, student.getMi(), //
			                LASTNAME, student.getLastName(), //
			                PHONE, student.getPhone(), //
			                BIRTHDATE, student.getBirthDate(), //
			                STREET, student.getStreet(), //
			                ZIPCODE, student.getZipCode(), //
			                DEPTID, student.getDeptID(), //
			                SSN, student.getSsn());
			System.out.println(sqlString);
			int rowcount = statement.executeUpdate(sqlString);
			System.out.println(String.format("Updated %d rows", rowcount));
		} finally {
			close(statement);
		}
	}

	public void delete(Student student) throws SQLException {
		Connection connection;
		Statement statement = null;
		try {
			connection = _database.getConnection();
			statement = connection.createStatement();
			// Execute a statement
			String sqlString = String.format("DELETE from %s WHERE %s='%s'", _tableName, SSN, student.getSsn());
			System.out.println(sqlString);
			int rowcount = statement.executeUpdate(sqlString);
			System.out.println(String.format("Deleted %d rows", rowcount));
		} finally {
			close(statement);
		}
	}

}
