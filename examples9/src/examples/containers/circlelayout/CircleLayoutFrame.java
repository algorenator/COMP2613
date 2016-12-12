package examples.containers.circlelayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * A frame that shows buttons arranged along a circle.
 */
@SuppressWarnings("serial")
class CircleLayoutFrame extends JFrame {

	public CircleLayoutFrame() {
		setTitle("CircleLayoutTest");

		setLayout(new CircleLayout());
		add(new JButton("Yellow"));
		add(new JButton("Blue"));
		add(new JButton("Red"));
		add(new JButton("Green"));
		add(new JButton("Orange"));
		add(new JButton("Fuchsia"));
		add(new JButton("Indigo"));
		pack();
	}
}
