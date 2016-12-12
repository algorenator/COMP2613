package examples.mvc.mvccolors.data;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class Colors extends Observable {

	private static Colors theInstance;
	private final ArrayList<NamedColor> colors;

	private Colors() {
		colors = new ArrayList<NamedColor>();

		loadColors();
	}

	public static Colors getTheInstance() {
		if (theInstance == null) {
			theInstance = new Colors();
		}
		return theInstance;
	}

	private void loadColors() {
		colors.add(new NamedColor("Black", Color.BLACK));
		colors.add(new NamedColor("Blue", Color.BLUE));
		colors.add(new NamedColor("Cyan", Color.CYAN));
		colors.add(new NamedColor("Dark Gray", Color.DARK_GRAY));
		colors.add(new NamedColor("Gray", Color.GRAY));
		colors.add(new NamedColor("Green", Color.GREEN));
		colors.add(new NamedColor("Light Gray", Color.LIGHT_GRAY));
		colors.add(new NamedColor("Magenta", Color.MAGENTA));
		colors.add(new NamedColor("Orange", Color.ORANGE));
		colors.add(new NamedColor("Pink", Color.PINK));
		colors.add(new NamedColor("Red", Color.RED));
		colors.add(new NamedColor("White", Color.WHITE));
		colors.add(new NamedColor("Yellow", Color.YELLOW));
	}

	public Iterator<NamedColor> getIterator() {
		return colors.iterator();
	}
	
	public void newColorPicked(NamedColor namedColor) {
		setChanged();
		notifyObservers(namedColor);
	}
}
