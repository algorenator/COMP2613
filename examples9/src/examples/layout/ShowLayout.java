package examples.layout;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

/**
 * This example contains poor data member names and poor declarations
 * 
 */
@SuppressWarnings("serial")
public class ShowLayout extends JApplet {
	// Get the url for HTML files
	private final String flowLayoutDesc = "FlowLayout arranges components " + "according to their preferredSize in "
	        + "a left-to-right flow, much like lines of text in a paragraph.";
	private final String gridLayoutDesc = "GridLayout arranges ...";
	private final String boxLayoutDesc = "BoxLayout arranges ...";

	private final JRadioButton jrbFlowLayout = new JRadioButton("FlowLayout");
	private final JRadioButton jrbGridLayout = new JRadioButton("GridLayout", true);
	private final JRadioButton jrbBoxLayout = new JRadioButton("BoxLayout");

	private final JPanel jpComponents = new JPanel();
	private final JTextArea jtfDescription = new JTextArea();

	// Create layout managers
	private final FlowLayout flowLayout = new FlowLayout();
	private final GridLayout gridLayout = new GridLayout(2, 2, 3, 3);
	private final BoxLayout boxLayout = new BoxLayout(jpComponents, BoxLayout.X_AXIS);

	public ShowLayout() {
		// Create a box to hold radio buttons
		Box jpChooseLayout = Box.createVerticalBox();
		jpChooseLayout.add(jrbFlowLayout);
		jpChooseLayout.add(jrbGridLayout);
		jpChooseLayout.add(jrbBoxLayout);

		// Group radio buttons
		ButtonGroup btg = new ButtonGroup();
		btg.add(jrbFlowLayout);
		btg.add(jrbGridLayout);
		btg.add(jrbBoxLayout);

		// Wrap lines and words
		jtfDescription.setLineWrap(true);
		jtfDescription.setWrapStyleWord(true);

		// Add fours buttons to jpComponents
		jpComponents.add(new JButton("Button 1"));
		jpComponents.add(new JButton("Button 2"));
		jpComponents.add(new JButton("Button 3"));
		jpComponents.add(new JButton("Button 4"));

		// Create two split panes to hold jpChooseLayout, jpComponents,
		// and jtfDescription
		JSplitPane jSplitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jpComponents,
		        new JScrollPane(jtfDescription));
		JSplitPane jSplitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jpChooseLayout, jSplitPane2);

		// Set FlowLayout as default
		jpComponents.setLayout(flowLayout);
		jpComponents.validate();
		jtfDescription.setText(flowLayoutDesc);

		add(jSplitPane1, BorderLayout.CENTER);

		// Register listeners
		jrbFlowLayout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jpComponents.setLayout(flowLayout);
				jtfDescription.setText(flowLayoutDesc);
				jpComponents.revalidate();
			}
		});
		jrbGridLayout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jpComponents.setLayout(gridLayout);
				jtfDescription.setText(gridLayoutDesc);
				jpComponents.revalidate();
			}
		});
		jrbBoxLayout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jpComponents.setLayout(boxLayout);
				jtfDescription.setText(boxLayoutDesc);
				jpComponents.revalidate();
			}
		});
	}

	public static void main(String[] args) {
		ShowLayout applet = new ShowLayout();
		JFrame frame = new JFrame();
		// EXIT_ON_CLOSE == 3
		frame.setDefaultCloseOperation(3);
		frame.setTitle("ShowLayout");
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 320);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
