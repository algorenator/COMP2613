package examples.uicomponents.dialogs.dialogtest;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class DialogTest {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				DialogFrame frame = new DialogFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
