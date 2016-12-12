package examples.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample2 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("This");
		list.add("is");
		list.add("is");
		list.add("a");
		list.add("a");
		list.add("test");

		CollectionUtil.display(list);
	}
}
