package examples.collections;

// Extension routines for java.util.Scanner, to support scanning of quoted strings.
// Author: Christian d'Heureuse (http://www.source-code.biz)

public class ScannerEx {

	private final java.util.Scanner sc;

	// Constructor, used to pass the java.util.Scanner object.
	// Note: We cannot subclass java.util.Scanner, because unfortunately
	// it's declared as "final".
	public ScannerEx(java.util.Scanner sc) {
		this.sc = sc;
	}

	// Returns true if the next token is the beginning of a quoted string value.
	public boolean hasNextQuotedString() {
		return sc.hasNext("\\\".*");
	}

	// Scans a quoted string value from the scanner input.
	public String nextQuotedString() {
		if (!sc.hasNext()) {
			throw new java.util.NoSuchElementException();
		}
		if (!hasNextQuotedString()) {
			throw new java.util.InputMismatchException();
			// This is necessary because findInLine would skip over other tokens.
		}
		String s = sc.findInLine("\\\".*?\\\"");
		if (s == null) {
			throw new java.util.InputMismatchException();
		}
		return s.substring(1, s.length() - 1);
	}
} // end of class ScannerEx