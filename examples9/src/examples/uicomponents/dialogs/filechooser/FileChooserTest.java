package examples.uicomponents.dialogs.filechooser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * @version 1.23 2007-06-12
 * @author Cay Horstmann
 */
public class FileChooserTest {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception ex) {
			// ignore it
		}
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ImageViewerFrame frame = new ImageViewerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
