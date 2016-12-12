package examples.uicomponents.dialogs.colorchooser;

import javax.swing.JFrame;

/**
 * A frame with a color chooser panel
 */
@SuppressWarnings("serial")
class ColorChooserFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	public ColorChooserFrame() {
		setTitle("ColorChooserTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// add color chooser panel to frame
		ColorChooserPanel panel = new ColorChooserPanel();
		add(panel);
	}

}
