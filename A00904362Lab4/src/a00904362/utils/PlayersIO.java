/**
 * Project: A00904362Lab3
 * File: IOPlayers.java
 * Date: Feb 09, 2016
 * Time: 1:21:56 PM
 */

package a00904362.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	public static List<Player> populatePlayers(String arg) throws ApplicationException {

		String[] temp1;
		String[] temp2;
		String rec_num;
		LocalDate date;

		List<Player> players = new ArrayList<Player>();

		String str = arg;

		temp1 = str.split("\\:");

		for (int i = 0; i < temp1.length; i++) {
			temp2 = temp1[i].split("\\|");
			rec_num = "Record # " + (i + 1) + ". ";

			if (temp2.length != Player.class.getDeclaredFields().length) {
				throw new ApplicationException(rec_num + "Expected " + Player.class.getDeclaredFields().length
						+ " elements but got " + temp2.length);
			}

			Player person = new Player();

			if (!Validator.validate_email(temp2[3])) {
				throw new ApplicationException(rec_num + "'" + temp2[3] + "' is an invalid email address");
			}

			if (!Validator.validate_id(temp2[0])) {
				throw new ApplicationException(rec_num + "Id in the list of players must be integer");
			}

			try {
				date = LocalDate.parse(temp2[5], DateTimeFormatter.ofPattern("yyyyMMdd"));

				person.setId(Integer.parseInt(temp2[0]));
				person.setFirstname(temp2[1]);
				person.setLastname(temp2[2]);
				person.setEmail(temp2[3]);
				person.setGamertag(temp2[4]);
				person.setDob(date);
				players.add(person);

			} catch (DateTimeParseException e) {
				throw new ApplicationException(rec_num + temp2[5] + " - wrong date format. must be yyyyMMdd");
			}

		}

		return players;
	}

	public static void displayPlayers(List<Player> players) {

		int i = 0;
		Collections.sort(players, new CompareByBirthdate());

		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy");
		System.out.println(TABLE_TITLE);
		System.out.println(TABLE_LINE_SEPARATOR);
		System.out.format(TABLE_HEADER_FORMAT, "#.", "ID", " ", "First name", "Last name", "Email", "Gamertag",
				"Birthday");
		System.out.println(TABLE_LINE_SEPARATOR);

		for (Player pl : players) {
			System.out.format(TABLE_BODY_FORMAT, (++i) + ".", pl.getId(), " ", pl.getFirstname(), pl.getLastname(),
					pl.getEmail(), pl.getGamertag(), sdf.format(pl.getDob().getTime()));
		}

		System.out.println(TABLE_LINE_SEPARATOR);

	}

}
