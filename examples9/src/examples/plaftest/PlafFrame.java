package examples.plaftest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * A frame with a button panel for changing look and feel
 */
public @SuppressWarnings("serial")
class PlafFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	private final JPanel buttonPanel;

	public PlafFrame() {
		setTitle("PlafTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		buttonPanel = new JPanel();

		UIManager.LookAndFeelInfo[] lookAndFeelInfo = UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo info : lookAndFeelInfo) {
			makeButton(info.getName(), info.getClassName());
		}

		add(buttonPanel);
	}

	/**
	 * Makes a button to change the pluggable look and feel.
	 * 
	 * @param name
	 *            the button name
	 * @param plafName
	 *            the name of the look and feel class
	 */
	void makeButton(String name, final String plafName) {
		JButton button = new JButton(name);
		buttonPanel.add(button);

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// button action: switch to the new look and feel
				try {
					UIManager.setLookAndFeel(plafName);
					SwingUtilities.updateComponentTreeUI(PlafFrame.this);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}