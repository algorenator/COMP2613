/**
 * Project: A00904362Lab3
 * File: ApplicationException.java
 * Date: Feb 03, 2016
 * Time: 11:23:04 AM
 */

package a00904362.utils;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

@SuppressWarnings("serial")
public class ApplicationException extends Exception {
	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public ApplicationException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

}
