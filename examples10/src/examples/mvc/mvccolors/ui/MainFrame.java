package examples.mvc.mvccolors.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import examples.mvc.mvccolors.data.Colors;
import examples.mvc.mvccolors.data.NamedColor;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private ColorsModel colorsModel;
	private ColorsController colorsController;
	private JList<ColorItem> colorsView;
	private Swatch colorSwatch;
	private MyLabel colorText;

	public MainFrame() {
		super("ColorsMVCTest");

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);

		create();
	}

	private void create() {
		// create the list
		colorsModel = new ColorsModel();
		colorsController = new ColorsController();
		colorsView = new JList<ColorItem>(colorsModel);
		ListSelectionModel listSelectionModel = colorsView.getSelectionModel();
		listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		colorsView.addListSelectionListener(colorsController);
		JScrollPane colorsScrollPane = new JScrollPane(colorsView);
		colorsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		colorsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		colorsScrollPane.setPreferredSize(new Dimension(150, 20));
		add(colorsScrollPane, BorderLayout.WEST);

		// create the details view
		JPanel detailsView = new JPanel();
		add(detailsView, BorderLayout.CENTER);
		detailsView.setLayout(new GridLayout(0, 1));

		colorSwatch = new Swatch();
		detailsView.add(colorSwatch);

		colorText = new MyLabel();
		detailsView.add(colorText);
	}

	// Inner classes ---------------------------------------------------------

	private class ColorItem {

		private final NamedColor color;

		ColorItem(NamedColor color) {
			this.color = color;
		}

		/**
		 * @return Returns the color.
		 */
		public NamedColor getColor() {
			return color;
		}

		@Override
		public String toString() {
			return color.getName();
		}
	}

	private class ColorsModel extends DefaultListModel<ColorItem> {

		ColorsModel() {
			Iterator<NamedColor> iterator = Colors.getTheInstance().getIterator();
			while (iterator.hasNext()) {
				NamedColor color = iterator.next();
				// call DefaultListModel addElement(...)
				addElement(new ColorItem(color));
			}
		}
	}

	private class ColorsController implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent event) {
			if (event.getValueIsAdjusting()) {
				return;
			}

			System.out.println(event);

			Object o = colorsView.getSelectedValue();
			if (o == null) {
				return;
			}

			ColorItem item = (ColorItem) o;
			System.out.println(item);
			
			NamedColor namedColor = item.getColor();
			Colors.getTheInstance().newColorPicked(namedColor);
		}

	}
	
	private class Swatch extends JLabel implements Observer {
		
		public Swatch() {
			setOpaque(true);
			Colors.getTheInstance().addObserver(this);
		}

		@Override
		public void update(Observable observable, Object o) {
			if (!(o instanceof NamedColor)) {
				return;
			}
			
			NamedColor namedColor = (NamedColor) o;
			setBackground(namedColor.getColor());
		}
		
	}
	
	private class MyLabel extends JLabel implements Observer {
		
		public MyLabel() {
			Colors.getTheInstance().addObserver(this);
		}

		@Override
		public void update(Observable observable, Object o) {
			if (!(o instanceof NamedColor)) {
				return;
			}
			
			NamedColor namedColor = (NamedColor) o;
			setText(namedColor.getName() + " = " + namedColor);
		}
		
	}

}
