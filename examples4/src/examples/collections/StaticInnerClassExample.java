package examples.collections;

public class StaticInnerClassExample {
	public static void main(String[] args) {
		System.out.println("a = " + OuterClass.a);
		System.out.println("c = " + OuterClass.InnerClass.b);

		OuterClass.InnerClass ocic = new OuterClass.InnerClass();
		System.out.println("c = " + ocic.c);
	}
}