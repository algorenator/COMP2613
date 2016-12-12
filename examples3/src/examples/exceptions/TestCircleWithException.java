package examples.exceptions;

public class TestCircleWithException {
	/** Main method */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			CircleWithException c1 = new CircleWithException(5);
			CircleWithException c2 = new CircleWithException(-5);
			CircleWithException c3 = new CircleWithException(0);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}

		System.out.println("Number of objects created: " + CircleWithException.getNumberOfObjects());
	}
}