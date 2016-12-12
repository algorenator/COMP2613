package brightercircle.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

import brightercircle.model.Model;

@SuppressWarnings("serial")
public class MainPanel extends JComponent implements Observer {

	private Color color;

	public MainPanel() {
		Model.getTheInstance().addObserver(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (color == null) {
			return;
		}

		g.setColor(color);
		g.fillOval(0, 0, getWidth(), getHeight());
	}

	@Override
	public void update(Observable observable, Object value) {
		if (!(value instanceof Color)) {
			return;
		}

		color = (Color) value;
		repaint();
	}
}
