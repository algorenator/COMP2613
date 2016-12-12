package examples.uicomponents.dialogs.dataexchange;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * @version 1.33 2007-06-12
 * @author Cay Horstmann
 */
public class DataExchangeTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				DataExchangeFrame frame = new DataExchangeFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
