/**
 * Project: A00904362Lab4
 * File: CompareByBirthdate.java
 * Date: Feb 9, 2016
 * Time: 11:48:57 AM
 */

package a00904362.utils;

import java.util.Comparator;

import a00904362.data.Player;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

public class CompareByBirthdate implements Comparator<Player> {

	public int compare(Player player1, Player player2) {
		return player1.getDob().compareTo(player2.getDob());
	}
}
