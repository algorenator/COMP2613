package examples.layout.layoutdemogb;

//Purpose: Show how to make a GridBagLayout using helper classes.
//       Two GridLayout subpanels of checkboxes and buttons are
//       created because these components have no alignment
//       in common with other parts of the GUI.  They are then
//       added to the GridBagLayout as components.
//Author : Fred Swartz - 2007-02-02 - Placed in public domain.
// http://www.leepoint.net/notes-java/GUI/layouts/gridbag-example.html

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

////////////////////////////////////////////////////////////////////DemoGridBag
@SuppressWarnings("serial")
public class DemoGridBag extends JFrame {
	// ================================================================
	// constants
	private static final int BORDER = 12; // Window border in pixels.
	private static final int GAP = 5; // Default gap btwn components.

	// ===================================================================
	// fields
	// ... GUI components
	private JLabel findLabel;
	private JLabel replaceLabel;
	private JTextField findTextField;
	private JTextField replaceTextField;
	private JButton findButton;
	private JButton replaceButton;
	private JButton replAllButton;
	private JButton closeButton;
	private JButton helpButton;
	private JCheckBox matchCaseCheckBox;
	private JCheckBox wholeWrdsCheckBox;
	private JCheckBox regexCheckBox;
	private JCheckBox highlightCheckBox;
	private JCheckBox wrapCheckBox;
	private JCheckBox selectionCheckBox;
	private JCheckBox backwardsCheckBox;
	private JCheckBox incrementCheckBox;

	JDialog replaceDialog;

	// ==============================================================
	// constructor
	public DemoGridBag() {
		JPanel panel = createContentPane();

		// ... Create a dialog box with GridBag content pane.
		replaceDialog = new JDialog();

		replaceDialog.setContentPane(panel);
		replaceDialog.setTitle("Find Replace");
		replaceDialog.pack();
		replaceDialog.setLocationRelativeTo(this);

		// ... Create a button for the window to display this dialog.
		JButton showDialogButton = new JButton("Show Find/Replace Dialog");
		showDialogButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				replaceDialog.setVisible(true);
			}
		});

		// ... Create content pane with one button and set window attributes.
		JPanel windowContent = new JPanel();
		windowContent.setLayout(new BorderLayout());
		windowContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		windowContent.add(showDialogButton, BorderLayout.CENTER);

		// ... Set the window characteristics.
		super.setContentPane(windowContent);
		super.pack(); // Layout components.
		super.setTitle("DemoGridBag");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLocationRelativeTo(null); // Center window.
	}

	// ========================================================
	// createContentPane
	private JPanel createContentPane() {
		findLabel = new JLabel("Find What:", JLabel.LEFT);
		replaceLabel = new JLabel("Replace With:", JLabel.LEFT);
		findTextField = new JTextField(20);
		replaceTextField = new JTextField(20);
		findButton = new JButton("Find");
		replaceButton = new JButton("Replace");
		replAllButton = new JButton("Replace All");
		closeButton = new JButton("Close");
		helpButton = new JButton("Help");
		matchCaseCheckBox = new JCheckBox("Match Case");
		wholeWrdsCheckBox = new JCheckBox("Whole Words");
		regexCheckBox = new JCheckBox("Regular Expressions");
		highlightCheckBox = new JCheckBox("Highlight Results", true);
		wrapCheckBox = new JCheckBox("Wrap Around", true);
		selectionCheckBox = new JCheckBox("Search Selection");
		backwardsCheckBox = new JCheckBox("Search Backwards");
		incrementCheckBox = new JCheckBox("Incremental Search", true);

		// ... Create an independent GridLayout panel of buttons.
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 1, GAP, GAP));
		buttonPanel.add(findButton);
		buttonPanel.add(replaceButton);
		buttonPanel.add(replAllButton);
		buttonPanel.add(closeButton);
		buttonPanel.add(helpButton);

		// ... Create an independent GridLayout panel of check boxes.
		JPanel checkBoxPanel = new JPanel();
		checkBoxPanel.setLayout(new GridLayout(4, 2));
		checkBoxPanel.add(matchCaseCheckBox);
		checkBoxPanel.add(wrapCheckBox);
		checkBoxPanel.add(wholeWrdsCheckBox);
		checkBoxPanel.add(selectionCheckBox);
		checkBoxPanel.add(regexCheckBox);
		checkBoxPanel.add(backwardsCheckBox);
		checkBoxPanel.add(highlightCheckBox);
		checkBoxPanel.add(incrementCheckBox);

		// ... Create GridBagLayout content pane; set border.
		JPanel content = new JPanel(new GridBagLayout());
		content.setBorder(BorderFactory.createEmptyBorder(BORDER, BORDER, BORDER, BORDER));

		// \\//\\//\\//\\//\\ GridBagLayout code begins here
		GBHelper gbh = new GBHelper(); // Create GridBag helper object.

		// ... First row
		content.add(findLabel, gbh);
		content.add(new Gap(GAP), gbh.nextCol());
		content.add(findTextField, gbh.nextCol().expandWidth());
		content.add(new Gap(GAP), gbh.nextCol());
		content.add(buttonPanel, gbh.nextCol().height(5).align(GridBagConstraints.NORTH));

		content.add(new Gap(GAP), gbh.nextRow()); // Add a gap below

		// ... Next row.
		content.add(replaceLabel, gbh.nextRow());
		content.add(new Gap(GAP), gbh.nextCol());
		content.add(replaceTextField, gbh.nextCol().expandWidth());

		content.add(new Gap(2 * GAP), gbh.nextRow()); // Add a big gap below

		// ... Last content row.
		content.add(checkBoxPanel, gbh.nextRow().nextCol().nextCol());

		// ... Add an area that can expand at the bottom.
		content.add(new Gap(), gbh.nextRow().width().expandHeight());
		// \\//\\//\\//\\//\\ GridBagLayout code ends here

		selectionCheckBox.setEnabled(false);

		return content;
	}

	// =====================================================================
	// main
	public static void main(String[] args) {
		// ... Set Look and Feel.
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception unused) {
			// Nothing can be done, so just ignore it.
		}

		// ... Start up GUI.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				DemoGridBag window = new DemoGridBag();
				window.setVisible(true);
			}
		});
	}
}
