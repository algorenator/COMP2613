/**
 * 
 */
package examples;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * From: http://howtodoinjava.com/2014/11/17/java-regex-validate-canadian-postal-zip-codes/
 *
 */
public class PostalCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> zips = new ArrayList<String>();

		// Valid ZIP codes
		zips.add("K1A 0B1");
		zips.add("B1Z 0B9");

		// Invalid ZIP codes
		zips.add("K1A 0D1");
		zips.add("W1A 0B1");
		zips.add("Z1A 0B1");

		String regex = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";

		Pattern pattern = Pattern.compile(regex);

		for (String zip : zips) {
			Matcher matcher = pattern.matcher(zip);
			System.out.println(String.format("%s %s a valid postal code", zip, matcher.matches() ? "is" : "is not"));
		}
	}

}
