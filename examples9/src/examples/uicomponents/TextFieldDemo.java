package examples.uicomponents;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class TextFieldDemo extends RadioButtonDemo {
	private final JTextField jtfMessage = new JTextField(10);

	/** Main method */
	public static void main(String[] args) {
		TextFieldDemo frame = new TextFieldDemo();
		frame.pack();
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public TextFieldDemo() {
		super("TextFieldDemo");
		// Create a new panel to hold label and text field
		JPanel jpTextField = new JPanel();
		jpTextField.setLayout(new BorderLayout(5, 0));
		jpTextField.add(new JLabel("Enter a new message"), BorderLayout.WEST);
		jpTextField.add(jtfMessage, BorderLayout.CENTER);
		add(jpTextField, BorderLayout.NORTH);

		jtfMessage.setHorizontalAlignment(JTextField.RIGHT);

		// Register listener
		jtfMessage.addActionListener(new ActionListener() {
			/** Handle ActionEvent */
			public void actionPerformed(ActionEvent e) {
				messagePanel.setMessage(jtfMessage.getText());
				jtfMessage.requestFocusInWindow();
			}
		});
	}
}
