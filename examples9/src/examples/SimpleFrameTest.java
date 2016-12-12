package examples;

import javax.swing.JFrame;

/**
 * @author Sam Cirka
 */
@SuppressWarnings("serial")
public class SimpleFrameTest extends JFrame {

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	public SimpleFrameTest() {
		super("SimpleFrameTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SimpleFrameTest frame = new SimpleFrameTest();
		frame.setVisible(true);
	}
}
