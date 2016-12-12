package examples.uicomponents.joptionpane;

import java.awt.EventQueue;

public class OptionDialogTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new OptionDialogFrame().setVisible(true);
			}
		});
	}
}
