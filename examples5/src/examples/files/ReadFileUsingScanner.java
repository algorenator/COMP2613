/**
 * Project: examples5
 * File: ReadFileUsingScanner.java
 * Date: Oct 7, 2014
 * Time: 8:19:25 PM
 */

package examples.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * @author A00195151
 *
 */
public class ReadFileUsingScanner {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		Scanner scanner = null;
		Formatter output = null;
		
		try {
			scanner = new Scanner(new File(args[0]));
			output = new Formatter("ReadFileUsingScanner.out");

			int i = 0;
			while (scanner.hasNext()) {
				String row = scanner.nextLine();
				System.out.println(row);
				output.format("%d. %s%n", ++i, row);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (scanner != null) {
				try {
					scanner.close();
				} catch (Exception e) {}
			}
			if (output != null) {
				try {
					output.close();
				} catch (Exception e) {}
			}
		}
	}

}
