package brightercircle.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private final MainPanel mainPanel;

	public MainFrame() {
		super("MVC demo");

		mainPanel = new MainPanel();
		add(mainPanel);

		setSize(200, 220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
