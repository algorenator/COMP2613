package examples.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("This");
		list.add("is");
		list.add("is");
		list.add("a");
		list.add("a");
		list.add("test");
		display(list);
	}

	static void display(List<String> list) {
		System.out.println("The size is: " + list.size());
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			System.out.println(String.format("%d. %s", i, s));
		}
	}
}
