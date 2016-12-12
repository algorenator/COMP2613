package examples.uicomponents.dialogs.optiondialog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * @version 1.33 2007-04-28
 * @author Cay Horstmann
 */
public class OptionDialogTest {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception ex) {
			// ignore it
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				OptionDialogFrame frame = new OptionDialogFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
