package examples.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

/**
 * This example contains poor data member names and poor declarations
 * 
 */
@SuppressWarnings("serial")
public class ShowSpringLayout extends JApplet {
	public ShowSpringLayout() {
		SpringLayout springLayout = new SpringLayout();
		JPanel p1 = new JPanel(springLayout);
		JButton jbt1 = new JButton("Button 1");
		p1.add(jbt1);

		Spring spring = Spring.constant(0, 1000, 2000);
		springLayout.putConstraint(SpringLayout.WEST, jbt1, spring, SpringLayout.WEST, p1);
		springLayout.putConstraint(SpringLayout.EAST, p1, spring, SpringLayout.EAST, jbt1);
		springLayout.putConstraint(SpringLayout.NORTH, jbt1, spring, SpringLayout.NORTH, p1);
		springLayout.putConstraint(SpringLayout.SOUTH, p1, spring, SpringLayout.SOUTH, jbt1);

		getContentPane().add(p1, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		ShowSpringLayout applet = new ShowSpringLayout();
		JFrame frame = new JFrame();
		// EXIT_ON_CLOSE == 3
		frame.setDefaultCloseOperation(3);
		frame.setTitle("ShowSpringLayout");
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 320);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}
