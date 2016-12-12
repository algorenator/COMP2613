package examples.containers;

import java.awt.EventQueue;

/**
 * @version 1.13 2007-06-12
 * @author Cay Horstmann
 */
public class ToolBarTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				ToolBarFrame frame = new ToolBarFrame();
				frame.setVisible(true);
			}
		});
	}
}
