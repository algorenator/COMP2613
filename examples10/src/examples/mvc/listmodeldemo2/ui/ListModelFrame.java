package examples.mvc.listmodeldemo2.ui;

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

@SuppressWarnings("serial")
public class ListModelFrame extends JFrame {

	@SuppressWarnings("rawtypes")
	private DefaultListModel listModel;
	private JList<String> theList;
	private JButton addButton;
	private JButton removeButton;

	@SuppressWarnings("rawtypes")
	public ListModelFrame(DefaultListModel listModel) {
		createUI(listModel);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void createUI(DefaultListModel listModel) {
		this.listModel = listModel;
		theList = new JList<String>(listModel);
		addButton = new JButton("Add new item");
		removeButton = new JButton("Remove selected item");

		JPanel panel = new JPanel();
		panel.add(addButton);
		panel.add(removeButton);

		add(panel, BorderLayout.NORTH);
		add(new JScrollPane(theList), BorderLayout.CENTER);

		// Register listeners
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doAdd();
			}
		});

		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doRemove();
			}
		});

		setSize(300, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	protected void doRemove() {
		listModel.remove(theList.getSelectedIndex());
	}

	@SuppressWarnings("unchecked")
	protected void doAdd() {
		String newItem = JOptionPane.showInputDialog("Enter a new item");

		if (newItem != null) {
			if (theList.getSelectedIndex() == -1) {
				listModel.addElement(newItem);
			} else {
				listModel.add(theList.getSelectedIndex(), newItem);
			}
		}
	}
}
