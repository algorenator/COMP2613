package examples.database;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Run 'DatabaseDemo' first to populate the database.
 * 
 * @author scirka
 * 
 */
@SuppressWarnings("serial")
public class FindGrade extends JFrame {
	public static final String DB_PROPERTIES_FILENAME = "db.properties";

	public static final String DB_DRIVER_KEY = "db.driver";
	public static final String DB_URL_KEY = "db.url";
	public static final String DB_USER_KEY = "db.user";
	public static final String DB_PASSWORD_KEY = "db.password";

	private final JTextField ssnField = new JTextField(9);
	private final JTextField courseIdField = new JTextField(5);
	private final JButton showGradeButton = new JButton("Show Grade");

	private final Properties _properties;
	private static Connection _connection;

	/** Main method */
	public static void main(String[] args) {
		File file = new File(DB_PROPERTIES_FILENAME);
		if (!file.exists()) {
			showUsage();
			System.exit(-1);
		}

		try {
			FindGrade app = new FindGrade(file);
			app.setVisible(true);
		} catch (Exception e) {
			if (_connection != null) {
				try {
					_connection.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private static void showUsage() {
		JOptionPane.showMessageDialog(null,
		        String.format("Program cannot start because %s cannot be found.", DB_PROPERTIES_FILENAME));
	}

	/**
	 * Initialize the app
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public FindGrade(File propertiesFile) throws FileNotFoundException, IOException, ClassNotFoundException,
	        SQLException {
		_properties = new Properties();
		_properties.load(new FileInputStream(propertiesFile));

		// Initialize database connection and create a Statement object
		initializeDB();

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				if (_connection != null) {
					try {
						_connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				System.exit(0);
			}
		});

		setTitle("Find Grades");
		setSize(440, 80);
		setLocationRelativeTo(null); // Center the frame

		showGradeButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				Statement statement = null;
				try {
					statement = _connection.createStatement();
					doShowGrade(statement, event);
				} catch (SQLException e) {
					if (statement != null) {
						try {
							statement.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(FindGrade.this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel jPanel1 = new JPanel();
		jPanel1.add(new JLabel("SSN"));
		jPanel1.add(ssnField);
		jPanel1.add(new JLabel("Course ID"));
		jPanel1.add(courseIdField);
		jPanel1.add(showGradeButton);

		add(jPanel1, BorderLayout.NORTH);
	}

	private void initializeDB() throws ClassNotFoundException, SQLException {
		Class.forName(_properties.getProperty(DB_DRIVER_KEY));
		System.out.println("Driver loaded");
		_connection = DriverManager.getConnection(_properties.getProperty(DB_URL_KEY),
		        _properties.getProperty(DB_USER_KEY), _properties.getProperty(DB_PASSWORD_KEY));
		System.out.println("Database connected");
	}

	private void doShowGrade(Statement statement, ActionEvent e) throws SQLException {
		String ssn = ssnField.getText();
		String courseId = courseIdField.getText();
		String queryString = "select firstName, mi, " + "lastName, title, grade from Student, Enrollment, Course "
		        + "where Student.ssn = '" + ssn + "' and Enrollment.courseId " + "= '" + courseId
		        + "' and Enrollment.courseId = Course.courseId " + " and Enrollment.ssn = Student.ssn";

		ResultSet rset = statement.executeQuery(queryString);

		if (rset.next()) {
			String lastName = rset.getString(1);
			String mi = rset.getString(2);
			String firstName = rset.getString(3);
			String title = rset.getString(4);
			String grade = rset.getString(5);

			// Display result in a dialog box
			JOptionPane.showMessageDialog(null, firstName + " " + mi + " " + lastName + "'s grade on course " + title
			        + " is " + grade);
		} else {
			// Display result in a dialog box
			JOptionPane.showMessageDialog(null, "Not found");
		}
	}

}
