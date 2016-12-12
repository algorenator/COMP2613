package examples.events.scribbledemo;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ScribbleDemo extends JFrame {
	public ScribbleDemo() {
		// Create a PaintPanel and add it to the frame
		add(new ScribblePanel(), BorderLayout.CENTER);
	}

	/** Main method */
	public static void main(String[] args) {
		ScribbleDemo frame = new ScribbleDemo();
		frame.setTitle("ScribbleDemo");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}
