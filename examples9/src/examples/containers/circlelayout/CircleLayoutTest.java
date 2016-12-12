package examples.containers.circlelayout;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * @version 1.32 2007-06-12
 * @author Cay Horstmann
 */
public class CircleLayoutTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				CircleLayoutFrame frame = new CircleLayoutFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
