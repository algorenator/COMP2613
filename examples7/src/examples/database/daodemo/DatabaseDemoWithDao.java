package examples.database.daodemo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import examples.database.Student;
import examples.database.daodemo.dao.CourseDao;
import examples.database.daodemo.dao.EnrollmentDao;
import examples.database.daodemo.dao.StudentDao;
import examples.database.daodemo.data.Course;

public class DatabaseDemoWithDao {

	public static final String DB_PROPERTIES_FILENAME = "db.properties";

	private static Logger LOG = Logger.getLogger(DatabaseDemoWithDao.class.getName());

	private static Database database;
	private StudentDao studentDao;
	private CourseDao courseDao;
	private EnrollmentDao enrollmentDao;
	private final Properties dbProperties;
	private Connection connection;

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure("log.properties");
		File dbPropertiesFile = new File(DB_PROPERTIES_FILENAME);
		if (!dbPropertiesFile.exists()) {
			showUsage();
			System.exit(-1);
		}

		try {
			DatabaseDemoWithDao demo = new DatabaseDemoWithDao(dbPropertiesFile);
			demo.run();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			database.shutdown();
		}
	}

	private static void showUsage() {
		LOG.info("The database properties filename must be passed in the commandline.");
	}

	private DatabaseDemoWithDao(File dbPropertiesFile) throws IOException {
		dbProperties = new Properties();
		dbProperties.load(new FileReader(dbPropertiesFile));

		database = new Database(dbProperties);
	}

	private void run() throws ClassNotFoundException, SQLException {
		connection = database.getConnection();
		studentDao = new StudentDao(database);
		courseDao = new CourseDao(database);
		enrollmentDao = new EnrollmentDao(database);

		try {
			// drop the tables if they exist
			dropTables();

			// create the tables
			createTables();

			insertCourses();
			insertStudents();
			insertEnrollments();

			Student student = readStudent();
			student.setFirstName("Peter");
			update(student);
			delete(student);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			connection.close();
		}
	}

	private void delete(Student student) {
		try {
			studentDao.delete(student);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private Student readStudent() {
		Student student = null;
		try {
			student = studentDao.readBySsn("444111120");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return student;
	}

	private void update(Student student) {
		try {
			studentDao.update(student);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void dropTables() throws SQLException {
		enrollmentDao.drop();
		studentDao.drop();
		courseDao.drop();
	}

	private void createTables() throws SQLException {
		courseDao.create();
		studentDao.create();
		enrollmentDao.create();
	}

	private void insertCourses() throws SQLException {
		try {
			courseDao.add(new Course("11111", "CSCI", "1301", "Introduction to Java I", 4));
			courseDao.add(new Course("11112", "CSCI", "1302", "Introduction to Java II", 3));
			courseDao.add(new Course("11113", "CSCI", "3720", "Database Systems", 3));
			courseDao.add(new Course("11114", "CSCI", "4750", "Rapid Java Application", 3));
			courseDao.add(new Course("11115", "MATH", "2750", "Calculus I", 5));
			courseDao.add(new Course("11116", "MATH", "3750", "Calculus II", 5));
			courseDao.add(new Course("11118", "ITEC", "1301", "Database Administration", 3));
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	private void insertStudents() throws SQLException {
		try {
			studentDao.add(new Student("444111110", "Jacob", "R", "Smith", "9129219434", "1985-04-09",
			        "99 Kingston Street", "31435", "BIOL"));
			studentDao.add(new Student("444111111", "John", "K", "Stevenson", "9129219434", "null", "100 Main Street",
			        "31411", "BIOL"));
			studentDao.add(new Student("444111112", "George", "K", "Smith", "9129213454", "1974-10-10",
			        "1200 Abercorn St.", "31419", "CS"));
			studentDao.add(new Student("444111113", "Frank", "E", "Jones", "9125919434", "1970-09-09",
			        "100 Main Street", "31411", "BIOL"));
			studentDao.add(new Student("444111114", "Jean", "K", "Smith", "9129219434", "1970-02-09",
			        "100 Main Street", "31411", "CHEM"));
			studentDao.add(new Student("444111115", "Josh", "R", "Woo", "7075989434", "1970-02-09", "555 Franklin St.",
			        "31411", "CHEM"));
			studentDao.add(new Student("444111116", "Josh", "R", "Smith", "9129219434", "1973-02-09",
			        "100 Main Street", "31411", "BIOL"));
			studentDao.add(new Student("444111117", "Joy", "P", "Kennedy", "9129229434", "1974-03-19",
			        "103 Bay Street", "31412", "CS"));
			studentDao.add(new Student("444111118", "Toni", "R", "Peterson", "9129229434", "1964-04-29",
			        "103 Bay Street", "31412", "MATH"));
			studentDao.add(new Student("444111119", "Patrick", "R", "Stoneman", "9129229434", "1969-04-29",
			        "101 Washington St.", "31435", "MATH"));
			studentDao.add(new Student("444111120", "Rick", "R", "Carter", "9125919434", "1986-04-09",
			        "19 West Ford St.", "31411", "BIOL"));
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	private void insertEnrollments() throws SQLException {
		Statement statement = connection.createStatement();
		String insertString;

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
