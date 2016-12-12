package examples.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * This example contains poor data member names and poor declarations
 * 
 */
@SuppressWarnings("serial")
public class ShowGridBagLayout extends JApplet {
	private final JLabel label1;
	private final JTextArea textArea1;
	private final JTextArea textArea2;
	private final JTextField textField;
	private final JPanel panel;
	private final JButton button1;
	private final JButton button2;

	public ShowGridBagLayout() {
		label1 = new JLabel("Resize the Window and Study GridBagLayout", JLabel.CENTER);
		textArea1 = new JTextArea("Text Area 1", 5, 15);
		textArea2 = new JTextArea("Text Area 2", 5, 15);
		textField = new JTextField("JTextField");
		panel = new JPanel();
		button1 = new JButton("Button 1");
		button2 = new JButton("Button 2");
		// Set GridBagLayout in the container
		setLayout(new GridBagLayout());

		// Create an GridBagConstraints object
		GridBagConstraints gbConstraints = new GridBagConstraints();

		gbConstraints.fill = GridBagConstraints.BOTH;
		gbConstraints.anchor = GridBagConstraints.CENTER;

		Container container = getContentPane();

		// Place JLabel to occupy row 0 (the first row)
		addComponent(label1, container, gbConstraints, 0, 0, 1, 4, 0, 0);

		// Place text area 1 in row 1 and 2, and column 0
		addComponent(textArea1, container, gbConstraints, 1, 0, 2, 1, 5, 1);

		// Place text area 2 in row 1 and column 3
		addComponent(textArea2, container, gbConstraints, 1, 3, 1, 1, 5, 1);

		// Place text field in row 2 and column 3
		addComponent(textField, container, gbConstraints, 2, 3, 1, 1, 5, 0);

		// Place JButton 1 in row 3 and column 1
		addComponent(button1, container, gbConstraints, 3, 1, 1, 1, 5, 0);

		// Place JButton 2 in row 3 and column 2
		addComponent(button2, container, gbConstraints, 3, 2, 1, 1, 5, 0);

		// Place Panel in row 1 and 2, and column 1 and 2
		panel.setBackground(Color.red);
		panel.setBorder(new javax.swing.border.LineBorder(Color.black));
		gbConstraints.insets = new Insets(10, 10, 10, 10);
		addComponent(panel, container, gbConstraints, 1, 1, 2, 2, 10, 1);
	}

	/** Add a component to the container of GridBagLayout */
	private void addComponent(Component c, Container container, GridBagConstraints gbConstraints, int row, int column,
	        int numberOfRows, int numberOfColumns, double weightx, double weighty) {
		// Set parameters
		gbConstraints.gridx = column;
		gbConstraints.gridy = row;
		gbConstraints.gridwidth = numberOfColumns;
		gbConstraints.gridheight = numberOfRows;
		gbConstraints.weightx = weightx;
		gbConstraints.weighty = weighty;

		// Add component to the container with the specified layout
		container.add(c, gbConstraints);
	}

	public static void main(String[] args) {
		// ... Set Look and Feel.
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception unused) {
			// Nothing can be done, so just ignore it.
		}

		ShowGridBagLayout applet = new ShowGridBagLayout();
		JFrame frame = new JFrame();
		// EXIT_ON_CLOSE == 3
		frame.setDefaultCloseOperation(3);
		frame.setTitle("ShowGridBagLayout");
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 320);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}
