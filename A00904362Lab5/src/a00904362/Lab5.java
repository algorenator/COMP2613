/**
 * Project: A00904362Lab1
 * File: Lab1.java
 * Date: Feb 09, 2016
 * Time: 4:52:19 PM
 */

package a00904362;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import a00904362.data.Player;
import a00904362.utils.ApplicationException;
import a00904362.utils.CompareByBirthdate;
import a00904362.utils.PlayersIO;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

public class Lab5 {

	private static int exit_code = 0;
	private static List<Player> players;
	private static final Logger LOG = Logger.getLogger(Lab5.class);
	private static String FILE_LOG_SET = "log.properties";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PropertyConfigurator.configure(FILE_LOG_SET);
		LOG.info("Starting Lab5");

		Instant firstInstant = Instant.now();
		LOG.info(firstInstant);

		try {

			// if (!Validator.validate_args(args)) {
			// throw new ApplicationException("Usage java -jar A00123456Lab2.jar <input string>");
			// }

			players = PlayersIO.populatePlayers();
			LOG.info("End PlayersIO.populatePlayers");

			// Collections.sort(players, new CompareByBirthdate());

			// !!!! for assumption
			// List<Player> beerDrinkers = players.stream().filter(p -> p.getId() > 3).collect(Collectors.toList());
			List<Player> beerDrinkers = players.stream().sorted(new CompareByBirthdate()).filter(p -> p.getId() > 3)
					.collect(Collectors.toList());

			PlayersIO.displayPlayers(beerDrinkers);

			// PlayersIO.displayPlayers(players);
			LOG.info("End PlayersIO.displayPlayers");

		} catch (ApplicationException e) {
			// System.err.println(e.getMessage());
			LOG.error(e);
			exit_code = -1;
		} catch (Exception e) {
			// e.printStackTrace();
			LOG.error(e);
			exit_code = -1;
		}

		Instant secondInstant = Instant.now();
		// System.out.println(secondInstant);
		LOG.info(secondInstant);
		// System.out.println(Duration.between(firstInstant, secondInstant).toMillis() + " ms");
		LOG.info(Duration.between(firstInstant, secondInstant).toMillis() + " ms");

		LOG.info("End Lab5. exit_code " + exit_code);

		System.exit(exit_code);
	}

}
