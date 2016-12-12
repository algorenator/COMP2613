package examples;

public class CountEachLetter {

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	public static void main(String[] args) {
		String inputString = args[0];

		// Invoke the countLetters method to count each letter
		int[] counts = countLetters(inputString.toLowerCase());

		// Declare and initialize output string
		String output = "";

		// Display results
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] != 0) {
				output += (char) ('a' + i) + " appears  " + counts[i] + ((counts[i] == 1) ? " time\n" : " times\n");
			}
		}

		// Display the result
		System.out.println(output);
	}

	// Count each letter in the string
	public static int[] countLetters(String s) {
		int[] counts = new int[ALPHABET.length()];

		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetter(s.charAt(i))) {
				counts[s.charAt(i) - 'a']++;
			}
		}

		return counts;
	}
}
