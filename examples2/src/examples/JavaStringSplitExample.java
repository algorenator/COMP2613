package examples;

import java.util.Arrays;

/*
 * http://www.java-examples.com/java-string-split-example
 * Java String split example.
 * This Java String split example describes how Java String is split into multiple Java String objects.
 */

public class JavaStringSplitExample {

	public static void main(String args[]) {
		/*
		 * Java String class defines following methods to split Java String object. String[] split( String
		 * regularExpression ) Splits the string according to given regular expression. String[] split( String
		 * reularExpression, int limit ) Splits the string according to given regular expression. The number of
		 * resultant substrings by splitting the string is controlled by limit argument.
		 */

		/* String to split. */
		String str = "one-two-three";
		String[] temp;

		/* delimiter */
		String delimiter = "-";
		System.out.println("string = " + str);
		System.out.println("delimiter = " + delimiter);
		/* given string will be split by the argument delimiter provided. */
		temp = str.split(delimiter);
		/* print substrings */
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}

		/*
		 * IMPORTANT : Some special characters need to be escaped while providing them as delimiters like "." and "|".
		 */

		str = "one|two|three";
		delimiter = "\\|";
		System.out.println("string = " + str);
		System.out.println("delimiter = " + delimiter);
		temp = str.split(delimiter);
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}

		str = "one.two.three";
		delimiter = "\\.";
		System.out.println("string = " + str);
		System.out.println("delimiter = " + delimiter);
		temp = str.split(delimiter);
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}

		/*
		 * Using second argument in the String.split() method, we can control the maximum number of substrings generated
		 * by splitting a string.
		 */

		System.out.println("string = " + str);
		System.out.println("delimiter = " + delimiter);
		temp = str.split(delimiter, 2);
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i]);
		}

		System.out.println(Arrays.toString("Java1HTML2Perl".split("\\d")));
	}

}