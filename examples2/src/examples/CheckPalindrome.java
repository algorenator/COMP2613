package examples;

public class CheckPalindrome {
	/** Main method */
	public static void main(String[] args) {
		// Declare and initialize output string
		String s = args[0];

		// Display the result
		System.out.format("\"%s\" is%s a palindrome", s, isPalindrome(s) ? "" : " NOT");
	}

	/** Check if a string is a palindrome */
	public static boolean isPalindrome(String s) {
		// The index of the first character in the string
		int low = 0;

		// The index of the last character in the string
		int high = s.length() - 1;

		while (low < high) {
			if (s.charAt(low) != s.charAt(high)) {
				return false; // Not a palindrome
			}

			low++;
			high--;
		}

		return true; // The string is a palindrome
	}
}
