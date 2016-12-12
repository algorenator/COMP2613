package examples.uicomponents;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import examples.uicomponents.util.ImageUtil;

@SuppressWarnings("serial")
public class ComboBoxDemo extends JFrame {

	// Declare an array of Strings for flag titles
	private final String[] flagTitles = { "Canada", "China", "Denmark", "France", "Germany", "India", "Norway",
			"United Kingdom", "United States of America" };

	// Declare an ImageIcon array for the national flags of 9 countries
	private final ImageIcon[] flagImage = { new ImageIcon(ImageUtil.loadImage2(ComboBoxDemo.class, "images/ca.gif")), //
			new ImageIcon(ImageUtil.loadImage2(ComboBoxDemo.class, "images/china.gif")), //
			new ImageIcon(ImageUtil.loadImage2(ComboBoxDemo.class, "images/denmark.gif")), //
			new ImageIcon(ImageUtil.loadImage2(ComboBoxDemo.class, "images/fr.gif")), //
			new ImageIcon(ImageUtil.loadImage2(ComboBoxDemo.class, "images/germany.gif")), //
			new ImageIcon(ImageUtil.loadImage2(ComboBoxDemo.class, "images/india.gif")), //
			new ImageIcon(ImageUtil.loadImage2(ComboBoxDemo.class, "images/norway.gif")), //
			new ImageIcon(ImageUtil.loadImage2(ComboBoxDemo.class, "images/uk.gif")), //
			new ImageIcon(ImageUtil.loadImage2(ComboBoxDemo.class, "images/us.gif")) //
	};

	// Declare an array of strings for flag descriptions
	private final String[] flagDescription = new String[9];

	// Declare and create a description panel
	private final DescriptionPanel descriptionPanel = new DescriptionPanel();

	// Create a combo box for selecting countries
	private final JComboBox comboBox = new JComboBox(flagTitles);

	public static void main(String[] args) {
		new ComboBoxDemo("ButtonDemo").setVisible(true);
	}

	public ComboBoxDemo(String title) {
		super(title);

		setSize(400, 400);
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set text description
		flagDescription[0] = "The Maple Leaf flag \n\n" + "The Canadian National Flag was adopted by the Canadian "
				+ "Parliament on October 22, 1964 and was proclaimed into law "
				+ "by Her Majesty Queen Elizabeth II (the Queen of Canada) on "
				+ "February 15, 1965. The Canadian Flag (colloquially known "
				+ "as The Maple Leaf Flag) is a red flag of the proportions "
				+ "two by length and one by width, containing in its center a "
				+ "white square, with a single red stylized eleven-point " + "mapleleaf centered in the white square.";
		flagDescription[1] = "Description for China ... ";
		flagDescription[2] = "Description for Denmark ... ";
		flagDescription[3] = "Description for France ... ";
		flagDescription[4] = "Description for Germany ... ";
		flagDescription[5] = "Description for India ... ";
		flagDescription[6] = "Description for Norway ... ";
		flagDescription[7] = "Description for UK ... ";
		flagDescription[8] = "Description for US ... ";

		// Set the first country (Canada) for display
		setDisplay(0);

		// Add combo box and description panel to the list
		add(comboBox, BorderLayout.NORTH);
		add(descriptionPanel, BorderLayout.CENTER);

		// Register listener
		comboBox.addItemListener(new ItemListener() {
			/** Handle item selection */
			@Override
			public void itemStateChanged(ItemEvent e) {
				System.out.println(e.getStateChange());
				if (e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("comboBox select is " + comboBox.getSelectedItem());
					setDisplay(comboBox.getSelectedIndex());
				}
			}
		});
	}

	/** Set display information on the description panel */
	public void setDisplay(int index) {
		descriptionPanel.setTitle(flagTitles[index]);
		descriptionPanel.setImageIcon(flagImage[index]);
		descriptionPanel.setDescription(flagDescription[index]);
	}

}
