package examples.uicomponents.dialogs.dataexchange;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * A frame with a menu whose File->Connect action shows a password dialog.
 */
@SuppressWarnings("serial")
class DataExchangeFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	private PasswordChooser dialog = null;
	private final JTextArea textArea;

	public DataExchangeFrame() {
		setTitle("DataExchangeTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// construct a File menu

		JMenuBar mbar = new JMenuBar();
		setJMenuBar(mbar);
		JMenu fileMenu = new JMenu("File");
		mbar.add(fileMenu);

		// add Connect and Exit menu items

		JMenuItem connectItem = new JMenuItem("Connect");
		connectItem.addActionListener(new ConnectAction());
		fileMenu.add(connectItem);

		// The Exit item exits the program

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);

		textArea = new JTextArea();
		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}

	/**
	 * The Connect action pops up the password dialog.
	 */
	private class ConnectAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// if first time, construct dialog

			if (dialog == null) {
				dialog = new PasswordChooser(); // set default values
			}
			dialog.setUser(new User("yourname", null));

			// pop up dialog
			if (dialog.showDialog(DataExchangeFrame.this, "Connect")) {
				// if accepted, retrieve user input
				User u = dialog.getUser();
				textArea.append("user name = " + u.getName() + ", password = " + (new String(u.getPassword())) + "\n");
			}
		}
	}
}
