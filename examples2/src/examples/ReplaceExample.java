package examples;

public class ReplaceExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Java Java Java".replaceAll("v\\w", "wi"));
		System.out.println("Java Java Java".replaceFirst("v\\w", "wi"));
	}

}
