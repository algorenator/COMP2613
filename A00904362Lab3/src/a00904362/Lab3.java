/**
 * Project: A00904362Lab1
 * File: Lab1.java
 * Date: Feb 03, 2016
 * Time: 4:52:19 PM
 */

package a00904362;

import java.time.Duration;
import java.time.Instant;

import a00904362.utils.ApplicationException;
import a00904362.utils.PlayersIO;
import a00904362.utils.Validator;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

public class Lab3 {

	private static int exit_code = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Instant firstInstant = Instant.now();
		System.out.println(firstInstant);

		try {

			if (!Validator.validate_args(args)) {
				throw new ApplicationException("Usage java -jar A00123456Lab2.jar <input string>");
			}

			PlayersIO.displayPlayers(PlayersIO.populatePlayers(args[0]));
		} catch (ApplicationException e) {
			System.err.println(e.getMessage());
			exit_code = -1;
		} catch (Exception e) {
			e.printStackTrace();
			exit_code = -1;
		}

		Instant secondInstant = Instant.now();
		System.out.println(secondInstant);
		System.out.println(Duration.between(firstInstant, secondInstant).toMillis() + " ms");

		System.exit(exit_code);
	}

}
