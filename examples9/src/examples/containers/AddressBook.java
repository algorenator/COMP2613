package examples.containers;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class AddressBook extends JFrame {
	// Specify the size of five string fields in the record
	final static int NAME_SIZE = 32;
	final static int STREET_SIZE = 32;
	final static int CITY_SIZE = 20;
	final static int STATE_SIZE = 2;
	final static int ZIP_SIZE = 5;
	final static int RECORD_SIZE = (NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE);

	// Access address.dat using RandomAccessFile
	private RandomAccessFile randomAccessFile;

	// Text fields
	private final JTextField nameField = new JTextField(NAME_SIZE);
	private final JTextField streetField = new JTextField(STREET_SIZE);
	private final JTextField cityField = new JTextField(CITY_SIZE);
	private final JTextField stateField = new JTextField(ZIP_SIZE);
	private final JTextField zipField = new JTextField(ZIP_SIZE);

	// Buttons
	private final JButton addButton = new JButton("Add");
	private final JButton firstButton = new JButton("First");
	private final JButton nextButton = new JButton("Next");
	private final JButton previousButton = new JButton("Previous");
	private final JButton lastButton = new JButton("Last");

	public AddressBook() {
		// Open or create a random access file
		try {
			randomAccessFile = new RandomAccessFile("address.dat", "rw");
		} catch (IOException ex) {
			System.out.print("Error: " + ex);
			System.exit(0);
		}

		// addressPanel for holding labels Name, Street, and City
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(3, 1));
		panel1.add(new JLabel("Name"));
		panel1.add(new JLabel("Street"));
		panel1.add(new JLabel("City"));

		// Panel statePanel for holding state
		JPanel statePanel = new JPanel();
		statePanel.setLayout(new BorderLayout());
		statePanel.add(new JLabel("State"), BorderLayout.WEST);
		statePanel.add(stateField, BorderLayout.CENTER);

		// Panel jpZip for holding zip
		JPanel zipPanel = new JPanel();
		zipPanel.setLayout(new BorderLayout());
		zipPanel.add(new JLabel("Zip"), BorderLayout.WEST);
		zipPanel.add(zipField, BorderLayout.CENTER);

		// Panel stateZipPanel for holding statePanel and zipPanel
		JPanel stateZipPanel = new JPanel();
		stateZipPanel.setLayout(new BorderLayout());
		stateZipPanel.add(statePanel, BorderLayout.WEST);
		stateZipPanel.add(zipPanel, BorderLayout.CENTER);

		// Panel p3 for holding cityField and stateZipPanel
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		panel3.add(cityField, BorderLayout.CENTER);
		panel3.add(stateZipPanel, BorderLayout.EAST);

		// Panel p4 for holding jtfName, jtfStreet, and p3
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(3, 1));
		panel4.add(nameField);
		panel4.add(streetField);
		panel4.add(panel3);

		// Place p1 and p4 into jpAddress
		JPanel addressPanel = new JPanel(new BorderLayout());
		addressPanel.add(panel1, BorderLayout.WEST);
		addressPanel.add(panel4, BorderLayout.CENTER);

		// Set the panel with line border
		addressPanel.setBorder(new BevelBorder(BevelBorder.RAISED));

		// Add buttons to a panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(firstButton);
		buttonPanel.add(nextButton);
		buttonPanel.add(previousButton);
		buttonPanel.add(lastButton);

		// Add addressPanel and buttonPanel to the frame
		add(addressPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				writeAddress();
			}
		});
		firstButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (randomAccessFile.length() > 0)
						readAddress(0);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long currentPosition = randomAccessFile.getFilePointer();
					if (currentPosition < randomAccessFile.length())
						readAddress(currentPosition);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		previousButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long currentPosition = randomAccessFile.getFilePointer();
					if (currentPosition - 2 * RECORD_SIZE > 0)
						// Why 2 * 2 * RECORD_SIZE? See the follow-up remarks
						readAddress(currentPosition - 2 * 2 * RECORD_SIZE);
					else
						readAddress(0);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		lastButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					long lastPosition = randomAccessFile.length();
					if (lastPosition > 0)
						// Why 2 * RECORD_SIZE? See the follow-up remarks
						readAddress(lastPosition - 2 * RECORD_SIZE);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});

		// Display the first record if exists
		try {
			if (randomAccessFile.length() > 0)
				readAddress(0);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/** Write a record at the end of the file */
	public void writeAddress() {
		try {
			randomAccessFile.seek(randomAccessFile.length());
			FixedLengthStringIO.writeFixedLengthString(nameField.getText(), NAME_SIZE, randomAccessFile);
			FixedLengthStringIO.writeFixedLengthString(streetField.getText(), STREET_SIZE, randomAccessFile);
			FixedLengthStringIO.writeFixedLengthString(cityField.getText(), CITY_SIZE, randomAccessFile);
			FixedLengthStringIO.writeFixedLengthString(stateField.getText(), STATE_SIZE, randomAccessFile);
			FixedLengthStringIO.writeFixedLengthString(zipField.getText(), ZIP_SIZE, randomAccessFile);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/** Read a record at the specified position */
	public void readAddress(long position) throws IOException {
		randomAccessFile.seek(position);
		String name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE, randomAccessFile);
		String street = FixedLengthStringIO.readFixedLengthString(STREET_SIZE, randomAccessFile);
		String city = FixedLengthStringIO.readFixedLengthString(CITY_SIZE, randomAccessFile);
		String state = FixedLengthStringIO.readFixedLengthString(STATE_SIZE, randomAccessFile);
		String zip = FixedLengthStringIO.readFixedLengthString(ZIP_SIZE, randomAccessFile);

		nameField.setText(name);
		streetField.setText(street);
		cityField.setText(city);
		stateField.setText(state);
		zipField.setText(zip);
	}

	public static void main(String[] args) {
		try {
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		AddressBook frame = new AddressBook();
		frame.pack();
		frame.setTitle("AddressBook");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
