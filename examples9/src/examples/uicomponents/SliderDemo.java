package examples.uicomponents;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


@SuppressWarnings("serial")
public class SliderDemo extends JFrame {

	private final JSlider horizontalSlider;
	private final JSlider verticalSlider;
	private final MessagePanel messagePanel;

	public static void main(String[] args) {
		new SliderDemo().setVisible(true);
	}

	public SliderDemo() {
		super("SliderDemo");

		horizontalSlider = new JSlider(JSlider.HORIZONTAL);
		verticalSlider = new JSlider(JSlider.VERTICAL);
		messagePanel = new MessagePanel("Welcome to Java");

		// Add sliders and message panel to the frame
		setLayout(new BorderLayout(5, 5));
		add(messagePanel, BorderLayout.CENTER);
		add(verticalSlider, BorderLayout.EAST);
		add(horizontalSlider, BorderLayout.SOUTH);

		// Set properties for sliders
		horizontalSlider.setMaximum(50);
		horizontalSlider.setPaintLabels(true);
		horizontalSlider.setPaintTicks(true);
		horizontalSlider.setMajorTickSpacing(10);
		horizontalSlider.setMinorTickSpacing(1);
		horizontalSlider.setPaintTrack(false);
		verticalSlider.setInverted(true);
		verticalSlider.setMaximum(10);
		verticalSlider.setPaintLabels(true);
		verticalSlider.setPaintTicks(true);
		verticalSlider.setMajorTickSpacing(10);
		verticalSlider.setMinorTickSpacing(1);

		// Register listener for the sliders
		horizontalSlider.addChangeListener(new ChangeListener() {
			/** Handle scroll bar adjustment actions */
			public void stateChanged(ChangeEvent e) {
				int value = horizontalSlider.getValue();
				int maximumValue = horizontalSlider.getMaximum();
				int newX = (value * messagePanel.getWidth() / maximumValue);
				messagePanel.setXCoordinate(newX);
			}
		});

		verticalSlider.addChangeListener(new ChangeListener() {
			/** Handle scroll bar adjustment actions */
			public void stateChanged(ChangeEvent e) {
				int value = verticalSlider.getValue();
				int maximumValue = verticalSlider.getMaximum();
				int newY = (value * messagePanel.getHeight() / maximumValue);
				messagePanel.setYCoordinate(newY);
			}
		});

		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		horizontalSlider.setValue(horizontalSlider.getMaximum() / 2);
		verticalSlider.setValue(verticalSlider.getMaximum() / 2);
		int x = (horizontalSlider.getValue() * messagePanel.getWidth() / horizontalSlider.getMaximum());
		int y = (verticalSlider.getValue() * messagePanel.getHeight() / verticalSlider.getMaximum());
		messagePanel.setCoordinate(x, y);
	}
}
