package brightercircle.model;

import java.awt.Color;
import java.util.Observable;

public class Model extends Observable {

	private static final Model theInstance = new Model();
	private Color color;
	private int count;

	public static Model getTheInstance() {
		return theInstance;
	}

	private Model() {
		color = new Color(0x010000);
		count = 10;
	}

	public void brighter() {
		if (--count <= 0) {
			color = color.brighter();
			count = 10;

			setChanged();
			notifyObservers(color);
		}
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}