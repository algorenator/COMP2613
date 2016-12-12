package examples.uicomponents;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import sun.swing.SwingUtilities2;

@SuppressWarnings("serial")
public class CheckBoxDemo extends ButtonDemo {

	// Create three check boxes to control the display of message
	private final JCheckBox centeredCheckBox;
	private final JCheckBox boldCheckBox;
	private final JCheckBox italicCheckBox;

	public static void main(String[] args) {
		new CheckBoxDemo("CheckBoxDemo").setVisible(true);
	}

	public CheckBoxDemo(String title) {
		super(title);

		centeredCheckBox = new JCheckBox("Centered");
		boldCheckBox = new JCheckBox("Bold");
		italicCheckBox = new JCheckBox("Italic");

		// Set mnemonic keys
		centeredCheckBox.setMnemonic('C');
		boldCheckBox.setMnemonic('B');
		italicCheckBox.setMnemonic('I');

		// Create a new panel to hold check boxes
		JPanel checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new GridLayout(3, 1));
		checkBoxPanel.add(centeredCheckBox);
		checkBoxPanel.add(boldCheckBox);
		checkBoxPanel.add(italicCheckBox);
		add(checkBoxPanel, BorderLayout.EAST);

		// Register listeners with the check boxes
		centeredCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messagePanel.setCentered(centeredCheckBox.isSelected());
			}
		});

		boldCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewFont();
			}
		});

		italicCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setNewFont();
			}
		});

		messagePanel.putClientProperty(SwingUtilities2.AA_TEXT_PROPERTY_KEY, new Boolean(true));

	}

	private void setNewFont() {
		// Determine a font style
		int fontStyle = Font.PLAIN;
		fontStyle += (boldCheckBox.isSelected() ? Font.BOLD : Font.PLAIN);
		fontStyle += (italicCheckBox.isSelected() ? Font.ITALIC : Font.PLAIN);

		// Set font for the message
		Font font = messagePanel.getFont();
		int size = font.getSize();
		// we could use the size from the messagePanel, but's let's make it
		// bigger
		size = (int) (1.5 * size);
		messagePanel.setFont(new Font(font.getName(), fontStyle, size));
	}
}
