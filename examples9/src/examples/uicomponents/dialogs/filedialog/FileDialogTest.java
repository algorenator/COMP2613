package examples.uicomponents.dialogs.filedialog;

import java.awt.EventQueue;

import javax.swing.UIManager;

/**
 * 
 * @author sam
 */
public class FileDialogTest {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception ex) {
			// ignore it
		}
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				FileDialogFrame frame = new FileDialogFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
	}
}
