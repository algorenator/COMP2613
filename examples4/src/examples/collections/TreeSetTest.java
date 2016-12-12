package examples.collections;

/**
 @version 1.00 1999-07-07
 @author Cay Horstmann
 */

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This program sorts a set of item by comparing their descriptions.
 */
public class TreeSetTest {
	public static void main(String[] args) {
		SortedSet<Item> parts = new TreeSet<Item>();
		parts.add(new Item("Toaster", 1234));
		parts.add(new Item("Widget", 4562));
		parts.add(new Item("Modem", 9912));
		System.out.println(parts);

		SortedSet<Item> sortByDescription = new TreeSet<Item>(new Comparator<Item>() {
			public int compare(Item itemA, Item itemB) {
				String descrA = itemA.getDescription();
				String descrB = itemB.getDescription();
				return descrA.compareTo(descrB);
			}
		});

		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
	}
}

