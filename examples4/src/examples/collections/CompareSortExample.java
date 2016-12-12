package examples.collections;

import java.util.ArrayList;
import java.util.Collections;

import examples.collections.ExampleSorters.CompareByLength;
import examples.collections.ExampleSorters.CompareByReverseLength;

public class CompareSortExample {

	public static void main(String[] args) {
		new CompareSortExample();
	}

	public CompareSortExample() {
		String[] s = { "Leopard", "Deer", "Cow", "Cat", "Cougar", "Lion", "Dog" };

		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < s.length; i++) {
			list.add(s[i]);
			System.out.println(s[i]);
		}
		System.out.println("--------------------------");
		Collections.sort(list);
		CollectionUtil.display(list);

		System.out.println("--------------------------");
		CompareByLength cs = new CompareByLength();
		Collections.sort(list, cs);
		CollectionUtil.display(list);

		System.out.println("--------------------------");
		Collections.sort(list, new CompareByReverseLength());
		CollectionUtil.display(list);

		/*
		 * List<Item> items = new ArrayList<Item>();
		 * items.add(new Item("foo", "one", 123, 0.0F));
		 * items.add(new Item("bar", "two", 456, 0.1F));
		 * Collections.sort(items);
		 * CollectionUtil.display(items);
		 * Collections.sort(items, new CompareItemByDescription());
		 * CollectionUtil.display(items);
		 */
	}

}
