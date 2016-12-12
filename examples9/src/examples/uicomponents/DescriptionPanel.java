package examples.uicomponents;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Define a panel for displaying image and text
 * 
 * @author sam
 * 
 */
@SuppressWarnings("serial")
public class DescriptionPanel extends JPanel {
	/** Label for displaying an image icon and a text */
	private final JLabel imageTitle = new JLabel();

	/** Text area for displaying text */
	private final JTextArea textArea = new JTextArea();

	public DescriptionPanel() {
		// Center the icon and text and place the text under the icon
		imageTitle.setHorizontalAlignment(JLabel.CENTER);
		imageTitle.setHorizontalTextPosition(JLabel.CENTER);
		imageTitle.setVerticalTextPosition(JLabel.BOTTOM);

		// Set the font in the label and the text field
		imageTitle.setFont(new Font("SansSerif", Font.BOLD, 16));
		textArea.setFont(new Font("Serif", Font.PLAIN, 14));

		// Set lineWrap and wrapStyleWord true for the text area
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);

		// Create a scroll pane to hold the text area
		JScrollPane scrollPane = new JScrollPane(textArea);

		// Set BorderLayout for the panel, add label and scrollpane
		setLayout(new BorderLayout(5, 5));
		add(scrollPane, BorderLayout.CENTER);
		add(imageTitle, BorderLayout.WEST);
	}

	/** Set the title */
	public void setTitle(String title) {
		imageTitle.setText(title);
	}

	/** Set the image icon */
	public void setImageIcon(ImageIcon icon) {
		imageTitle.setIcon(icon);
	}

	/** Set the text description */
	public void setDescription(String text) {
		textArea.setText(text);
	}
}
