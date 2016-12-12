package examples.uicomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import examples.uicomponents.util.ImageUtil;

@SuppressWarnings("serial")
public class ButtonDemo extends JFrame {

	// Create a panel for displaying message
	protected MessagePanel messagePanel = new MessagePanel("Welcome to Java");

	protected JPanel buttonPanel;

	// Declare two buttons to move the message left and right
	private final JButton leftButton = new JButton("<<");
	private final JButton rightButton = new JButton(">>");

	public static void main(String[] args) {
		new ButtonDemo("ButtonDemo").setVisible(true);
	}

	public ButtonDemo(String title) {
		super(title);

		setSize(500, 200);
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the background color of messagePanel
		messagePanel.setBackground(Color.white);

		// Create a panel to hold two Buttons left "<<" and right ">>"
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(leftButton);
		buttonPanel.add(rightButton);

		// Set keyboard mnemonics
		leftButton.setMnemonic('L');
		rightButton.setMnemonic('R');

		// Set tool tip text on the buttons
		leftButton.setToolTipText("Move message to left");
		rightButton.setToolTipText("Move message to right");

		// Set icons and remove text
		try {
			leftButton.setIcon(new ImageIcon(ImageUtil.loadImage(ButtonDemo.class, "images/bighand.left.gif")));
			leftButton.setText(null);
		} catch (IOException e1) {
			leftButton.setText("<<");
		}
		try {
			rightButton.setIcon(new ImageIcon(ImageUtil.loadImage(ButtonDemo.class, "images/bighand.right.gif")));
			rightButton.setText(null);
		} catch (IOException e1) {
			leftButton.setText(">>");
		}

		// Place panels in the frame
		setLayout(new BorderLayout());
		add(messagePanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		// Register listeners with the buttons
		leftButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				messagePanel.moveLeft();
			}
		});

		rightButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				messagePanel.moveRight();
			}
		});
	}

}
