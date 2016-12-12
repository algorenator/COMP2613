package examples.mvc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class ListModelDemo extends JFrame {

	private final DefaultListModel<String> listModel;
	private JList<String> theList;
	private JButton addButton;
	private JButton removeButton;

	public ListModelDemo() {
		listModel = new DefaultListModel<String>();

		createUI();
	}

	private void createUI() {
		theList = new JList<String>(listModel);
		addButton = new JButton("Add new item");
		removeButton = new JButton("Remove selected item");

		// Add items to the list model
		listModel.addElement("Item1");
		listModel.addElement("Item2");
		listModel.addElement("Item3");
		listModel.addElement("Item4");
		listModel.addElement("Item5");
		listModel.addElement("Item6");

		JPanel panel = new JPanel();
		panel.add(addButton);
		panel.add(removeButton);

		add(panel, BorderLayout.NORTH);
		add(new JScrollPane(theList), BorderLayout.CENTER);

		// Register listeners
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newItem = JOptionPane.showInputDialog("Enter a new item");

				if (newItem != null)
					if (theList.getSelectedIndex() == -1)
						listModel.addElement(newItem);
					else
						listModel.add(theList.getSelectedIndex(), newItem);
			}
		});

		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listModel.remove(theList.getSelectedIndex());
			}
		});

		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception ex) {
			// ignore it
		}
		ListModelDemo appView = new ListModelDemo();
		appView.setVisible(true);
	}
}
