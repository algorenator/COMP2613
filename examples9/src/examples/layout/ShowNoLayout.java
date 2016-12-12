package examples.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This example contains poor data member names and poor declarations
 * 
 */
@SuppressWarnings("serial")
public class ShowNoLayout extends JApplet {
	private final JLabel jlbl = new JLabel("Resize the Window and Study No Layout", JLabel.CENTER);
	private final JTextArea jta1 = new JTextArea("Text Area 1", 5, 10);
	private final JTextArea jta2 = new JTextArea("Text Area 2", 5, 10);
	private final JTextField jtf = new JTextField("TextField");
	private final JPanel jp = new JPanel();
	private final JButton jbt1 = new JButton("Cancel");
	private final JButton jbt2 = new JButton("Ok");

	public ShowNoLayout() {
		// Set background color for the panel
		jp.setBackground(Color.red);

		// Specify no layout manager
		setLayout(null);

		// Add components to frame
		add(jlbl);
		add(jp);
		add(jta1);
		add(jta2);
		add(jtf);
		add(jbt1);
		add(jbt2);

		// Put components in the right place
		jlbl.setBounds(0, 10, 400, 40);
		jta1.setBounds(0, 50, 100, 100);
		jp.setBounds(100, 50, 200, 100);
		jta2.setBounds(300, 50, 100, 50);
		jtf.setBounds(300, 100, 100, 50);
		jbt1.setBounds(100, 150, 100, 50);
		jbt2.setBounds(200, 150, 100, 50);
	}

	public static void main(String[] args) {
		ShowNoLayout applet = new ShowNoLayout();
		JFrame frame = new JFrame();
		// EXIT_ON_CLOSE == 3
		frame.setDefaultCloseOperation(3);
		frame.setTitle("ShowNoLayout");
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 320);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}
