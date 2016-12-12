package examples.uicomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


@SuppressWarnings("serial")
public class RadioButtonDemo extends CheckBoxDemo {
	// Declare radio buttons
	private JRadioButton redButton;
	private JRadioButton greenButton;
	private JRadioButton blueButton;

	public static void main(String[] args) {
		new RadioButtonDemo("RadioButtonDemo").setVisible(true);
	}

	public RadioButtonDemo(String title) {
		super(title);

		// Create a new panel to hold check boxes
		JPanel radioButtons = new JPanel();
		radioButtons.setLayout(new GridLayout(3, 1));
		radioButtons.add(redButton = new JRadioButton("Red"));
		radioButtons.add(greenButton = new JRadioButton("Green"));
		radioButtons.add(blueButton = new JRadioButton("Blue"));
		add(radioButtons, BorderLayout.WEST);

		// Create a radio button group to group three buttons
		ButtonGroup group = new ButtonGroup();
		group.add(redButton);
		group.add(greenButton);
		group.add(blueButton);

		// Set keyboard mnemonics
		redButton.setMnemonic('E');
		greenButton.setMnemonic('G');
		blueButton.setMnemonic('U');

		// Register listeners for check boxes
		redButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messagePanel.setForeground(Color.red);
			}
		});
		greenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messagePanel.setForeground(Color.green);
			}
		});
		blueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				messagePanel.setForeground(Color.blue);
			}
		});

		// Set initial message color to blue
		blueButton.setSelected(true);
		messagePanel.setForeground(Color.blue);
	}
}
