package examples.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ShowBoxLayout extends JApplet {
	// Create two box containers
	private final Box box1 = Box.createHorizontalBox();
	private final Box box2 = Box.createVerticalBox();

	// Create a label to display flags
	private final JLabel jlblFlag = new JLabel();

	// Create image icons for flags
	private final ImageIcon imageIconUS = new ImageIcon(getClass().getResource("/image/us.gif"));
	private final ImageIcon imageIconCanada = new ImageIcon(getClass().getResource("/image/ca.gif"));
	private final ImageIcon imageIconNorway = new ImageIcon(getClass().getResource("/image/norway.gif"));
	private final ImageIcon imageIconGermany = new ImageIcon(getClass().getResource("/image/germany.gif"));
	private final ImageIcon imageIconPrint = new ImageIcon(getClass().getResource("/image/print.gif"));
	private final ImageIcon imageIconSave = new ImageIcon(getClass().getResource("/image/save.gif"));

	// Create buttons to select images
	private final JButton jbtUS = new JButton("US");
	private final JButton jbtCanada = new JButton("Canada");
	private final JButton jbtNorway = new JButton("Norway");
	private final JButton jbtGermany = new JButton("Germany");

	public ShowBoxLayout() {
		box1.add(new JButton(imageIconPrint));
		box1.add(Box.createHorizontalStrut(20));
		box1.add(new JButton(imageIconSave));

		box2.add(jbtUS);
		box2.add(Box.createVerticalStrut(8));
		box2.add(jbtCanada);
		box2.add(Box.createGlue());
		box2.add(jbtNorway);
		box2.add(Box.createRigidArea(new Dimension(10, 8)));
		box2.add(jbtGermany);

		box1.setBorder(new javax.swing.border.LineBorder(Color.red));
		box2.setBorder(new javax.swing.border.LineBorder(Color.black));

		add(box1, BorderLayout.NORTH);
		add(box2, BorderLayout.EAST);
		add(jlblFlag, BorderLayout.CENTER);

		// Register listeners
		jbtUS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jlblFlag.setIcon(imageIconUS);
			}
		});
		jbtCanada.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jlblFlag.setIcon(imageIconCanada);
			}
		});
		jbtNorway.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jlblFlag.setIcon(imageIconNorway);
			}
		});
		jbtGermany.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jlblFlag.setIcon(imageIconGermany);
			}
		});
	}

	public static void main(String[] args) {
		ShowBoxLayout applet = new ShowBoxLayout();
		JFrame frame = new JFrame();
		// EXIT_ON_CLOSE == 3
		frame.setDefaultCloseOperation(3);
		frame.setTitle("ShowBoxLayout");
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 320);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}
