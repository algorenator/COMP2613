package examples.uicomponents.menus;

import java.awt.EventQueue;

/**
 * @version 1.23 2007-05-30
 * @author Cay Horstmann
 */
public class MenuTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				MenuFrame frame = new MenuFrame();
				frame.setVisible(true);
			}
		});
	}
}
