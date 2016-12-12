package examples.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author sam
 */
public class TestScannerEx2 {

	public static void main(String[] args) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new File("Guests.txt"));
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Scanner lineScanner = new Scanner(line);
			ScannerEx extendedScanner = new ScannerEx(lineScanner);
			System.out.println(line);
			for (int i = 0; i < 4; i++) {
				System.out.println(i + ". " + extendedScanner.nextQuotedString());
			}
		}
	}
}
