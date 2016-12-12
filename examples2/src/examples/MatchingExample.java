package examples;

public class MatchingExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Java".matches("Java"));
		System.out.println("Java".equals("Java"));
		System.out.println("Java".equals("J" + "a" + "v" + "a"));
		System.out.println("Java is fun".matches("Java.*"));
		System.out.println("Java is cool".matches("Java.*"));
		System.out.println("Java is powerful".matches("Java.*"));
	}

}
