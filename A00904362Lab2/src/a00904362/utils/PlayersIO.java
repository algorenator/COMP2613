/**
 * Project: A00904362Lab2
 * File: IOPlayers.java
 * Date: Jan 27, 2016
 * Time: 1:21:56 PM
 */

package a00904362.utils;

import a00904362.data.Player;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

public class PlayersIO {

	private static String TABLE_BODY_FORMAT = "%-10s%010d%5s%-30s%-30s%-30s%-30s%n";
	private static String TABLE_HEADER_FORMAT = "%-10s%-10s%5s%-30s%-30s%-30s%-30s%n";
	private static String TABLE_LINE_SEPARATOR = String.format("%0133d", 0).replace("0", "-");
	private static String TABLE_TITLE = "Players Report";

	public static Player[] populatePlayers(String arg) {
		Player[] team = null;
		String[] temp1;
		String[] temp2;

		String str = arg;
		try {
			temp1 = str.split("\\:");
			team = new Player[temp1.length];

			for (int i = 0; i < temp1.length; i++) {
				temp2 = temp1[i].split("\\|");
				for (int j = 0; j < temp2.length; j++) {

					Player person = new Player();
					person.setId(temp2[0]);
					person.setFirstname(temp2[1]);
					person.setLastname(temp2[2]);
					person.setEmail(temp2[3]);
					person.setGamertag(temp2[4]);
					team[i] = person;
				}
			}
		} catch (Exception e) {
			System.err.println("Wrong formated list of players was passed in the argument");
			System.exit(-1);
		}

		return team;
	}

	public static void displayPlayers(Player[] players) {

		System.out.println(TABLE_TITLE);
		System.out.println(TABLE_LINE_SEPARATOR);
		System.out.format(TABLE_HEADER_FORMAT, "#.", "ID", " ", "First name", "Last name", "Email", "Gamertag");
		System.out.println(TABLE_LINE_SEPARATOR);

		for (int i = 0; i < players.length; i++) {
			System.out.format(TABLE_BODY_FORMAT, (i + 1) + ".", players[i].getId(), " ", players[i].getFirstname(),
					players[i].getLastname(), players[i].getEmail(), players[i].getGamertag());
		}

		System.out.println(TABLE_LINE_SEPARATOR);

	}

}
