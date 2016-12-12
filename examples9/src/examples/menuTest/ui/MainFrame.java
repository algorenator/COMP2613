/**
 * Project: M4
 * File: MainFrame.java
 * Date: May 18, 2010
 * Time: 8:37:39 PM
 */

package examples.menuTest.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * @author Fred Fish, A00123456
 * 
 */

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private final MainFrame theMainFrame;

	public MainFrame() {
		super("Menu Test");

		theMainFrame = this;

		createUI();

		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void createUI() {
		createMenu();
	}

	private void createMenu() {
		// 1. Create a menu bar and add it to the frame
		JMenuBar mainMenuBar = new JMenuBar();
		setJMenuBar(mainMenuBar);

		// 2. Add menus to the menu bar
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		mainMenuBar.add(fileMenu);
		JMenu helpMenu = new JMenu("Help");
		mainMenuBar.add(helpMenu);

		// 3. Add items to the menus
		JMenuItem load = new JMenuItem("Load");
		fileMenu.add(load);
		JMenuItem save = new JMenuItem("Save");
		fileMenu.add(save);
		JMenuItem exit = new JMenuItem("Exit", KeyEvent.VK_X);
		JMenuItem about = new JMenuItem("About");
		about.setMnemonic('A');
		helpMenu.add(about);

		// Add submenus to menus (optional)
		JMenu optionsMenu = new JMenu("Options");
		fileMenu.add(optionsMenu);
		JMenuItem option1 = new JMenuItem("Option 1");
		optionsMenu.add(option1);
		JMenuItem option2 = new JMenuItem("Option 2");
		optionsMenu.add(option2);

		fileMenu.addSeparator();
		fileMenu.add(exit);

		// 4. Attach actions to the menu items
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		about.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * static�void showMessageDialog(Component�parentComponent, Object�message, String�title,
				 * int�messageType) Brings up a dialog that displays a message using a default icon determined by the
				 * messageType parameter.
				 */
				JOptionPane.showMessageDialog(MainFrame.this, "Hello World!");
				JOptionPane.showMessageDialog(theMainFrame, "Hello World!");

				JDialog aDialog = new JDialog(MainFrame.this, "Hello");
				aDialog.setSize(200, 200);
				aDialog.setLocationRelativeTo(MainFrame.this);
				aDialog.setVisible(true);
			}
		});

	}

}
