package examples;

/**
 * File: EnumTest.java
 */

/**
 * @author Fred Fish, A00123456
 * 
 */

public class EnumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Season season = Season.SUMMER;
		System.out.println(season);
		System.out.println(season.getDescription());
		System.out.println(season.ordinal());

		Suit suit = Suit.SPADES;
		switch (suit) {
		case HEARTS:
			System.out.println(suit);
			break;
		case CLUBS:
			System.out.println(suit);
			break;
		case DIAMONDS:
			System.out.println(suit);
			break;
		case SPADES:
			System.out.println(suit);
			break;
		default:
			assert false : "Bad suit";
		}
	}

	private enum Season {
		// never reorder these as I'm storing them in the DB
		// please add to the end of the list
		WINTER("it's cold", 1), SPRING("getting warmer", 2), SUMMER("nice and warm", 3), FALL("getting colder", 4), AUTUMN(
		        "getting colder", 4);

		private String description;
		private int value;

		Season(String description, int value) {
			this.description = description;
			this.value = value;
		}

		public String getDescription() {
			return description;
		}

		@SuppressWarnings("unused")
		public void setDescription(String description) {
			this.description = description;
		}

		@SuppressWarnings("unused")
		public int getValue() {
			return value;
		}

		@SuppressWarnings("unused")
		public void setValue(int value) {
			this.value = value;
		}

	}

	private enum Suit {
		HEARTS, CLUBS, DIAMONDS, SPADES;
	}

}
