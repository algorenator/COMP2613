/**
 * Project: A00904362Lab1
 * File: Lab1.java
 * Date: Jan 19, 2016
 * Time: 4:52:19 PM
 */

package a00904362;

import java.util.Arrays;

import a00904362.data.Player;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

public class Lab1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arrsize;
		Player[] players = null;

		try {
			arrsize = Integer.parseInt(args[0]);
			players = new Player[arrsize];
		} catch (NumberFormatException | ArrayIndexOutOfBoundsException | NegativeArraySizeException ex) {
			System.out.println("An integer value must be passed to the program");
			System.exit(-1);
		}

		for (int i = 0; i < players.length; i++) {

			players[i] = new Player(i, "FirstName", "LastName", "Email", "GamerTag");
		}

		System.out.println(Arrays.toString(players));
		System.exit(0);

	}

}
