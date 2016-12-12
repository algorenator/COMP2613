package examples.database;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FindGradeUsingPreparedStatement extends JFrame {

	public static final String TABLE_NAME = "derby_jdbc_test";
	public static final String SSN = "ssn";
	public static final String FIRST_NAME = "firstName";
	public static final String MI = "mi";
	public static final String LAST_NAME = "lastName";
	public static final String PHONE = "phone";
	public static final String BIRTHDATE = "birthDate";
	public static final String STREET = "street";
	public static final String ZIPCODE = "zipCode";
	public static final String DEPT_ID = "deptID";
	public static final int COLUMNS = 9;
	private static Connection _connection;
	private final JTextField nameField = new JTextField(9);
	private final JTextField courseField = new JTextField(5);
	private final JButton displayBirthDate = new JButton("Show Birth Date");

	// PreparedStatement for executing queries
	private PreparedStatement preparedStatement;

	// The follow data is held in the Student table. Use when searching records.
	// Fields = ssn, firstName, mi, lastName, birthDate, street, phone, zipCode, deptId
	// '444111110', 'Jacob', 'R', 'Smith', '9/4/1985', '99 Kingston Street', '9129219434', '31435', 'BIOL'
	// '444111111', 'John', 'K', 'Stevenson', null, '100 Main Street', '9129219785', '31411', 'BIOL'
	// '444111112', 'George', 'K', 'Smith', '10/10/1974', '1200 Abercorn Street', '9129214672', '31419', 'CS'
	// '444111113', 'Frank', 'E', 'Jones', '9/9/1970', '100 Main Street', '9129219785', '31411', 'BIOL'
	// '444111114', 'Jean', 'K', 'Smith', '9/2/1970', '100 Main Street', '9129219434', '31411', 'CHEM'
	// '444111115', 'Josh', 'R', 'Woo', '9/2/1970', '555 Franklin Street', '707598434', '31421', 'CHEM'
	// '444111116', 'Josh', 'R', 'Smith', '9/2/1973', '100 Main Street', '9129219434', '31411', 'CS'
	// '444111117', 'Joy', 'P', 'Kennedy', '3/19/1974', '103 Bay Street', '9129229434', '31412', 'MATH'
	// '444111118', 'Tony', 'R', 'Peterson', '4/29/1964', '101 Washington St.', '9129228858', '31419', 'MATH'
	// '444111119', 'Patrick', 'R', 'Stoneman', '4/29/1969', '101 Washington St.', '9129228858', '31419', 'MATH'
	// '444111120', 'Rick', 'R', 'Carter', '04/09/1986', '19 West Ford St.', '9125919434', '31422', 'BIOL'

	public FindGradeUsingPreparedStatement() {
		// Initialize database connection and create a Statement object
		initializeDB();

		displayBirthDate.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showBirthDate(e);
			}
		});

		JPanel jPanel1 = new JPanel();
		jPanel1.add(new JLabel("Last Name"));
		jPanel1.add(nameField);
		jPanel1.add(new JLabel("Department"));
		jPanel1.add(courseField);
		jPanel1.add(displayBirthDate);

		add(jPanel1, BorderLayout.NORTH);
	}

	private void initializeDB() {
		try {
			// Load the JDBC driver
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			System.out.println("Driver loaded");

			// Establish a connection
			_connection = DriverManager.getConnection(String.format(
			        "jdbc:derby:%s;create=true;user=admin;password=admin", TABLE_NAME));

			System.out.println("Database connected");

			dumpStudents();

			String queryString = "select firstName, mi, " + "lastName, birthDate from Student "
			        + "where lastName = ? and deptId = ? ";

			// Create a statement
			preparedStatement = _connection.prepareStatement(queryString);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void dumpStudents() throws SQLException {
		// Create a statement
		Statement statement = _connection.createStatement();

		// Execute a statement
		ResultSet resultSet = statement.executeQuery("select * from Student");

		// Iterate through the result and print the student names
		while (resultSet.next()) {
			for (int i = 1; i <= COLUMNS; i++) {
				System.out.print(resultSet.getObject(i) + "\t");
			}
			System.out.println();
		}

		statement.close();
	}

	private void showBirthDate(ActionEvent e) {
		String lName = nameField.getText();
		String deptId = courseField.getText();
		try {
			preparedStatement.setString(1, lName);
			preparedStatement.setString(2, deptId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String firstName = resultSet.getString(1);
				String mi = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				Date birthDate = resultSet.getDate(4);

				// Display result in a dialog box
				JOptionPane.showMessageDialog(null, firstName + " " + mi + " " + lastName + "'s birthday is "
				        + birthDate.toString() + " .");

			} else {
				// Display result in a dialog box
				JOptionPane.showMessageDialog(null, "Not found");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/** Main method */
	public static void main(String[] args) {
		FindGradeUsingPreparedStatement frame = new FindGradeUsingPreparedStatement();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Find Grades");
		frame.setSize(550, 80);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
