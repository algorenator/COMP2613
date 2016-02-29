/**
 * Project: A00904362Lab3
 * File: IOPlayers.java
 * Date: Feb 09, 2016
 * Time: 1:21:56 PM
 */

package a00904362.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import a00904362.ApplicationException;
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
	private static String FILE_IN = "players.txt";
	private static String FILE_OUT = "players_report.txt";

	private static final Logger LOG = Logger.getLogger(PlayersIO.class);

	public static List<Player> populatePlayers() throws ApplicationException, IOException {

		String[] temp2;
		String rec_num;
		LocalDate date;
		BufferedReader inputStream = null;

		List<Player> players = new ArrayList<Player>();

		// Set<Player> hp = new LinkedHashSet<Player>();

		Map<Integer, Player> hp = new HashMap<Integer, Player>();

		LOG.info("Starting PlayersIO.populatePlayers");
		int i = 1;

		try {
			inputStream = new BufferedReader(new FileReader(FILE_IN));

			String l;

			while ((l = inputStream.readLine()) != null) {

				temp2 = l.split("\\|");

				rec_num = "Record # " + (i++) + ". ";

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
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}

		return players;
	}

	public static void displayPlayers(List<Player> players) throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd yyyy");
		PrintWriter outputStream = null;
		outputStream = new PrintWriter(new FileWriter(FILE_OUT));
		LOG.info("Starting PlayersIO.displayPlayers");

		int i = 0;

		try {

			outputStream.println(TABLE_TITLE);
			outputStream.println(TABLE_LINE_SEPARATOR);
			outputStream.format(TABLE_HEADER_FORMAT, "#.", "ID", " ", "First name", "Last name", "Email", "Gamertag",
					"Birthday");
			outputStream.println(TABLE_LINE_SEPARATOR);

			for (Player pl : players) {
				outputStream.format(TABLE_BODY_FORMAT, (++i) + ".", pl.getId(), " ", pl.getFirstname(),
						pl.getLastname(), pl.getEmail(), pl.getGamertag(), sdf.format(pl.getDob().getTime()));
			}

			outputStream.println(TABLE_LINE_SEPARATOR);

		} finally {

			if (outputStream != null) {
				outputStream.close();
			}

		}

	}
}
