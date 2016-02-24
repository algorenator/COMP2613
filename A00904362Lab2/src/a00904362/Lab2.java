/**
 * Project: A00904362Lab1
 * File: Lab1.java
 * Date: Jan 27, 2016
 * Time: 4:52:19 PM
 */

package a00904362;

import a00904362.utils.PlayersIO;
import a00904362.utils.Validator;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

public class Lab2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Validator.validate_args(args);

		PlayersIO.displayPlayers(PlayersIO.populatePlayers(args[0]));

		System.exit(0);
	}

}
