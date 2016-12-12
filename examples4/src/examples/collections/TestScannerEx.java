package examples.collections;

import java.util.Scanner;

/**
 * 
 * @author sam
 */
public class TestScannerEx {

	public static void main(String[] args) {
		final String s = "123 \" abc def \" \"xyz\" 456";
		Scanner sc = new Scanner(s);
		ScannerEx sce = new ScannerEx(sc);
		if (sc.nextInt() != 123) {
			throw new Error();
		}
		if (!sce.nextQuotedString().equals(" abc def ")) {
			throw new Error();
		}
		if (!sce.nextQuotedString().equals("xyz")) {
			throw new Error();
		}
		if (sc.nextInt() != 456) {
			throw new Error();
		}
	}
}
