package examples.plaftest;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * @version 1.32 2007-06-12
 * @author Cay Horstmann
 */
public class PlafTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				PlafFrame frame = new PlafFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
