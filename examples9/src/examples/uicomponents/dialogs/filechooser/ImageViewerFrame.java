package examples.uicomponents.dialogs.filechooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;

/**
 * A frame that has a menu for loading an image and a display area for the loaded image.
 */
@SuppressWarnings("serial")
public class ImageViewerFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 400;
	private final JLabel label;
	private final JFileChooser chooser;

	public ImageViewerFrame() {
		setTitle("FileChooserTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// set up menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("File");
		menuBar.add(menu);

		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new FileOpenListener());

		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		// use a label to display the images
		label = new JLabel();
		add(label);

		// set up file chooser
		chooser = new JFileChooser();

		// accept all image files ending with .jpg, .jpeg, .gif
		/*
		 * final ExtensionFileFilter filter = new ExtensionFileFilter(); filter.addExtension("jpg");
		 * filter.addExtension("jpeg"); filter.addExtension("gif"); filter.setDescription("Image files");
		 */
		FileFilter filter = new ImageFileFilter();
		chooser.addChoosableFileFilter(filter);

		chooser.setAccessory(new ImagePreviewer(chooser));

		Icon icon = new ImageIcon("palette.gif");
		FileIconView view = new FileIconView(filter, icon);
		chooser.setFileView(view);
	}

	/**
	 * This is the listener for the File->Open menu item.
	 */
	private class FileOpenListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			chooser.setCurrentDirectory(new File("."));

			// show file chooser dialog
			int result = chooser.showOpenDialog(ImageViewerFrame.this);

			// if image file accepted, set it as icon of the label
			if (result == JFileChooser.APPROVE_OPTION) {
				String name = chooser.getSelectedFile().getPath();
				label.setIcon(new ImageIcon(name));
			}
		}
	}
}
