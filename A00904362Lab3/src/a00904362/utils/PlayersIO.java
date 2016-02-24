/**
 * Project: A00904362Lab3
 * File: IOPlayers.java
 * Date: Feb 03, 2016
 * Time: 1:21:56 PM
 */

package a00904362.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import a00904362.data.Player;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

public class PlayersIO {

	private static String TABLE_BODY_FORMAT = "%-10s%010d%5s%-20s%-20s%-30s%-30s%-30s%n";
	private static String TABLE_HEADER_FORMAT = "%-10s%-10s%5s%-20s%-20s%-30s%-30s%-30s%n";
	private static String TABLE_LINE_SEPARATOR = String.format("%0143d", 0).replace("0", "-");
	private static String TABLE_TITLE = "Players Report";

	public static Player[] populatePlayers(String arg) throws ApplicationException {
		Player[] team = null;
		String[] temp1;
		String[] temp2;
		String rec_num;
		LocalDate date;

		String str = arg;

		temp1 = str.split("\\:");
		team = new Player[temp1.length];

		for (int i = 0; i < temp1.length; i++) {
			temp2 = temp1[i].split("\\|");
			rec_num = "Record # " + (i + 1) + ". ";

			if (temp2.length != Player.class.getDeclaredFields().length) {
				throw new ApplicationException(rec_num + "Expected " + Player.class.getDeclaredFields().length
						+ " elements but got " + temp2.length);
			}

			for (int j = 0; j < temp2.length; j++) {

				if (!Validator.validate_email(temp2[3])) {
					throw new ApplicationException(rec_num + "'" + temp2[3] + "' is an invalid email address");
				}

				if (!Validator.validate_id(temp2[0])) {
					throw new ApplicationException(rec_num + "Id in the list of players must be integer");
				}

				try {
					date = LocalDate.parse(temp2[5], DateTimeFormatter.ofPattern("yyyyMMdd"));

					Player person = new Player();
					person.setId(Integer.parseInt(temp2[0]));
					person.setFirstname(temp2[1]);
					person.setLastname(temp2[2]);
					person.setEmail(temp2[3]);
					person.setGamertag(temp2[4]);
					person.setDob(date);
					team[i] = person;

				} catch (DateTimeParseException e) {
					throw new ApplicationException(rec_num + temp2[5] + " - wrong date format. must be yyyyMMdd");
				}
			}
		}

		return team;
	}

	public static void displayPlayers(Player[] players) {

		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy");
		System.out.println(TABLE_TITLE);
		System.out.println(TABLE_LINE_SEPARATOR);
		System.out.format(TABLE_HEADER_FORMAT, "#.", "ID", " ", "First name", "Last name", "Email", "Gamertag",
				"Birthday");
		System.out.println(TABLE_LINE_SEPARATOR);

		for (int i = 0; i < players.length; i++) {
			System.out.format(TABLE_BODY_FORMAT, (i + 1) + ".", players[i].getId(), " ", players[i].getFirstname(),
					players[i].getLastname(), players[i].getEmail(), players[i].getGamertag(),
					sdf.format(players[i].getDob().getTime()));
		}

		System.out.println(TABLE_LINE_SEPARATOR);

	}

}
