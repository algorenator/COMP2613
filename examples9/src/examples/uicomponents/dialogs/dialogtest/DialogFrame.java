package examples.uicomponents.dialogs.dialogtest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * A frame with a menu whose File->About action shows a dialog.
 */
@SuppressWarnings("serial")
public class DialogFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 300;
	private AboutDialog dialog;

	public DialogFrame() {
		setTitle("DialogTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationRelativeTo(null);

		// construct a File menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		// add About and Exit menu items
		// The About item shows the About dialog

		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(DialogFrame.this, "Dialog Test\nby me");
			}
		});

		fileMenu.add(aboutItem);

		JMenuItem customItem = new JMenuItem("Custom");
		customItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (dialog == null) { // first time
					dialog = new AboutDialog(DialogFrame.this);
				}
				dialog.setVisible(true); // pop up dialog
			}
		});

		fileMenu.add(customItem);

		// The Exit item exits the program
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		fileMenu.add(exitItem);
	}
}
