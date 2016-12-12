package examples.collections;

class OuterClass {
	static int a = 1;

	static class InnerClass {
		static int b = a + 1;
		int c = 3;
	}
}