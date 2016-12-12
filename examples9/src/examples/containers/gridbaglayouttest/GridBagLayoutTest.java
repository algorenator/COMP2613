package examples.containers.gridbaglayouttest;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * @version 1.33 2007-06-12
 * @author Cay Horstmann
 */
public class GridBagLayoutTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				FontFrame frame = new FontFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
