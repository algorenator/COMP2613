package examples.collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		if (set.add("This")) {
			System.out.println("\"This\" added");
		} else {
			System.out.println("\"This\" rejected");
		}
		System.out.println(set.add("This") ? "\"This\" added" : "\"This\" rejected");
		System.out.println(set.add("This") ? "\"This\" added" : "\"This\" rejected");
		System.out.println(set.add("is") ? "\"is\" added" : "\"is\" rejected");
		System.out.println(set.add("is") ? "\"is\" added" : "\"is\" rejected");
		System.out.println(set.add("a") ? "\"a\" added" : "\"a\" rejected");
		System.out.println(set.add("a") ? "\"a\" added" : "\"a\" rejected");
		System.out.println(set.add("test") ? "\"test\" added" : "\"test\" rejected");

		CollectionUtil.display(set);
	}
}
