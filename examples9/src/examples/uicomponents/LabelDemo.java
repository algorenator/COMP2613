/**
 * Project: ex3
 * File: LabelDemo.java
 * Date: Jan 20, 2010
 * Time: 10:57:17 PM
 */

package examples.uicomponents;

import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import examples.uicomponents.util.ImageUtil;

/**
 * @author sam
 * 
 */
@SuppressWarnings("serial")
public class LabelDemo extends JFrame {

	public static void main(String[] args) throws IOException {
		new LabelDemo("ButtonDemo").setVisible(true);
	}

	public LabelDemo(String title) throws IOException {
		super(title);

		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380, 120);

		setLayout(new FlowLayout());
		ImageIcon icon = new ImageIcon(ImageUtil.loadImage(ButtonDemo.class, "images/grapes.gif"));

		JLabel leftLabel = new JLabel("Grapes", icon, SwingConstants.CENTER);
		leftLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		leftLabel.setVerticalTextPosition(SwingConstants.CENTER);
		leftLabel.setIconTextGap(5);
		leftLabel.setOpaque(true);
		leftLabel.setBackground(new Color(128, 0, 128));
		add(leftLabel);

		// Create a label with text, an icon, with centered horizontal alignment
		JLabel centeredLabel = new JLabel("Grapes", icon, SwingConstants.CENTER);
		// Set label's text alignment and gap between text and icon
		centeredLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		centeredLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		centeredLabel.setIconTextGap(5);
		// normally the label's background is transparent
		// make it opaque
		centeredLabel.setOpaque(true);
		centeredLabel.setBackground(new Color(128, 50, 128));
		add(centeredLabel);

		JLabel rightLabel = new JLabel("Grapes", icon, SwingConstants.CENTER);
		rightLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
		rightLabel.setVerticalTextPosition(SwingConstants.CENTER);
		rightLabel.setIconTextGap(5);
		rightLabel.setOpaque(true);
		rightLabel.setBackground(new Color(128, 100, 128));
		add(rightLabel);
	}
}
