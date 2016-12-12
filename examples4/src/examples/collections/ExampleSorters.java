/**
 * 
 */
package examples.collections;

import java.util.Comparator;

/**
 * @author Sam Cirka, A00123456
 * 
 */
public class ExampleSorters {

	public static class CompareByLength implements Comparator<String> {
		public int compare(String string1, String string2) {
			// our sorting criteria is length of string
			return string1.length() - string2.length();
		}
	}

	public static class CompareByReverseLength implements Comparator<String> {
		public int compare(String string1, String string2) {
			// our sorting criteria is length of string
			return string2.length() - string1.length();
		}
	}

	public static class CompareItemByDescription implements Comparator<Item> {
		public int compare(Item item1, Item item2) {
			return item1.getDescription().compareTo(item2.getDescription());
		}
	}
}
