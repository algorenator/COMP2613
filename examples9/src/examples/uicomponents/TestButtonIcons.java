package examples.uicomponents;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TestButtonIcons extends JFrame {
	public static void main(String[] args) throws IOException {
		new TestButtonIcons().setVisible(true);
	}

	public TestButtonIcons() throws IOException {
		super("ButtonIcons");
		setSize(165, 80);
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImageIcon usIcon = new ImageIcon(loadImage("images/caIcon.gif"));
		ImageIcon caIcon = new ImageIcon(loadImage("images/caIcon.gif"));
		ImageIcon ukIcon = new ImageIcon(loadImage("images/ukIcon.gif"));

		JButton button = new JButton("Click it", usIcon);

		button.setPressedIcon(caIcon);
		button.setRolloverIcon(ukIcon);

		add(button);
	}

	private static Image loadImage(final String name) throws IOException {
		InputStream stream = ButtonDemo.class.getResourceAsStream(name);
		if (stream == null) {
			throw new IOException("Cannot load " + name);
		}
		return ImageIO.read(stream);
	}
}
