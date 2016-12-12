package examples.database.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import examples.database.util.DbUtil;

public class CreateSqlServerSchema {

	public static final String CLASSNAME = "net.sourceforge.jtds.jdbc.Driver";
	public static final String CONNECT_URL = "jdbc:jtds:sqlserver://Beangrinder.bcit.ca";
	public static final String USER = "javastudent";
	public static final String PASSWORD = "compjava";
	private static Connection connection;

	public static void main(String[] args) throws Exception {
		new CreateSqlServerSchema().run();
	}

	private void run() throws ClassNotFoundException, SQLException {
		connect();

		Statement statement = connection.createStatement();

		if (DbUtil.tableExists(connection, "Enrollment")) {
			statement.executeUpdate("drop table Enrollment");
		}

		if (DbUtil.tableExists(connection, "Student")) {
			statement.executeUpdate("drop table Student");
		}

		if (DbUtil.tableExists(connection, "Course")) {
			statement.executeUpdate("drop table Course");
		}

		try {
			insertCourses();
			insertStudents();
			insertEnrollments();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			connection.close();
		}
	}

	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName(CLASSNAME);
		System.out.println("Driver loaded");
		connection = DriverManager.getConnection(CONNECT_URL, USER, PASSWORD);
		System.out.println("Database connected");
	}

	private static void insertStudents() throws SQLException {
		// ssn firstName mi lastName phone birthDate street zipCode deptID
		Statement statement = connection.createStatement();
		String insertString;

		try {
			String createString = "create table Student(ssn VARCHAR(9), firstName VARCHAR(10), mi VARCHAR(1), lastName VARCHAR(10), phone VARCHAR(10), birthDate VARCHAR(10), street VARCHAR(20), zipCode VARCHAR(10), deptID VARCHAR(4), primary key (ssn) )";

			statement.executeUpdate(createString);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		try {
			insertString = "insert into Student values('444111110', 'Jacob', 'R', 'Smith', '9129219434', '1985-04-09', '99 Kingston Street', '31435', 'BIOL')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Student values('444111111', 'John', 'K', 'Stevenson', '9129219434', 'null', '100 Main Street', '31411', 'BIOL')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Student values('444111112', 'George', 'K', 'Smith', '9129213454', '1974-10-10', '1200 Abercorn St.', '31419', 'CS')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Student values('444111113', 'Frank', 'E', 'Jones', '9125919434', '1970-09-09', '100 Main Street', '31411', 'BIOL')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Student values('444111114', 'Jean', 'K', 'Smith', '9129219434', '1970-02-09', '100 Main Street', '31411', 'CHEM')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Student values('444111115', 'Josh', 'R', 'Woo', '7075989434', '1970-02-09', '555 Franklin St.', '31411', 'CHEM')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Student values('444111116', 'Josh', 'R', 'Smith', '9129219434', '1973-02-09', '100 Main Street', '31411', 'BIOL')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Student values('444111117', 'Joy', 'P', 'Kennedy', '9129229434', '1974-03-19', '103 Bay Street', '31412', 'CS')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Student values('444111118', 'Toni', 'R', 'Peterson', '9129229434', '1964-04-29', '103 Bay Street', '31412', 'MATH')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Student values('444111119', 'Patrick', 'R', 'Stoneman', '9129229434', '1969-04-29', '101 Washington St.', '31435', 'MATH')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Student values('444111120', 'Rick', 'R', 'Carter', '9125919434', '1986-04-09', '19 West Ford St.', '31411', 'BIOL')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "update Student set lastName='Dodge' where ssn='444111120'";
			int rowcount = statement.executeUpdate(insertString);
			System.out.println(String.format("Updated %d rows", rowcount));
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}

	private static void insertCourses() throws SQLException {
		Statement statement = connection.createStatement();
		String insertString;
		try {
			String createString = "create table Course (courseId VARCHAR(10), subjectId VARCHAR(4), courseNumber VARCHAR(4), title VARCHAR(64), numOfCredits INTEGER, primary key (courseId) )";
			statement.executeUpdate(createString);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		try {
			insertString = "insert into Course values('11111', 'CSCI', '1301', 'Introduction to Java I', 4)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Course values('11112', 'CSCI', '1302', 'Introduction to Java II', 3)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Course values('11113', 'CSCI', '3720', 'Database Systems', 3)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Course values('11114', 'CSCI', '4750', 'Rapid Java Application', 3)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Course values('11115', 'MATH', '2750', 'Calculus I', 5)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Course values('11116', 'MATH', '3750', 'Calculus II', 5)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Course values('11117', 'EDUC', '1344', 'Reading', 3)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Course values('11118', 'ITEC', '1301', 'Database Administration', 3)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}

	private static void insertEnrollments() throws SQLException {
		Statement statement = connection.createStatement();
		String insertString;
		try {
			String createString = "create table Enrollment ( ssn VARCHAR(9), courseId VARCHAR(10), dateRegistered date, grade VARCHAR(1), primary key (ssn, courseId), foreign key (ssn) references Student, foreign key (courseId) references Course )";
			statement.executeUpdate(createString);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		try {
			insertString = "insert into Enrollment values ('444111110', '11111', '2004-03-19', 'A')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Enrollment values ('444111110', '11112', '2004-03-19', 'B')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Enrollment values ('444111110', '11113', '2004-03-19', 'C')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Enrollment values ('444111111', '11111', '2004-03-19', 'D')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Enrollment values ('444111111', '11112', '2004-03-19', 'F')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Enrollment values ('444111111', '11113', '2004-03-19', 'A')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Enrollment values ('444111112', '11114', '2004-03-19', 'B')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Enrollment values ('444111112', '11115', '2004-03-19', 'C')";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);

			insertString = "insert into Enrollment values ('444111112', '11116', '2004-03-19', null)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
			insertString = "insert into Enrollment values ('444111113', '11111', '2004-03-19', null)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
			insertString = "insert into Enrollment values ('444111113', '11113', '2004-03-19', null)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
			insertString = "insert into Enrollment values ('444111114', '11115', '2004-03-19', null)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
			insertString = "insert into Enrollment values ('444111115', '11115', '2004-03-19', null)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
			insertString = "insert into Enrollment values ('444111115', '11116', '2004-03-19', null)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
			insertString = "insert into Enrollment values ('444111116', '11111', '2004-03-19', null)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
			insertString = "insert into Enrollment values ('444111117', '11111', '2004-03-19', null)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
			insertString = "insert into Enrollment values ('444111118', '11111', '2004-03-19', null)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
			insertString = "insert into Enrollment values ('444111118', '11112', '2004-03-19', null)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
			insertString = "insert into Enrollment values ('444111118', '11113', '2004-03-19', null)";
			statement.executeUpdate(insertString);
			System.out.println("Inserted " + insertString);
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (statement != null) {
				statement.close();
			}
		}
	}

}
