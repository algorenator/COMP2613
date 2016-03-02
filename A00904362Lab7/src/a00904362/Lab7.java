/**
 * Project: A00904362Lab1
 * File: Lab1.java
 * Date: Feb 09, 2016
 * Time: 4:52:19 PM
 */

package a00904362;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import a00904362.data.Player;
import a00904362.data.dao.PlayerDao;
import a00904362.data.db.Database;
import a00904362.utils.CompareByBirthdate;
import a00904362.utils.MiscUtil;
import a00904362.utils.PlayersIO;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

public class Lab7 {

	private static int exit_code = 0;
	private static List<Player> players;
	private static final Logger LOG = Logger.getLogger(Lab7.class);

	private static Properties _properties;
	private static Database database;

	private static final String DB_PROPERTIES_FILENAME = "db.properties";
	private static final String FILE_LOG_SET = "log.properties";
	private static final String LAB_NO = "Lab7";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		PropertyConfigurator.configure(FILE_LOG_SET);
		LOG.info("Starting " + LAB_NO);

		Instant firstInstant = Instant.now();
		LOG.info(firstInstant);

		try {

			// if (!Validator.validate_args(args)) {
			// throw new ApplicationException("Usage java -jar A00123456Lab2.jar <input string>");
			// }

			players = PlayersIO.populatePlayers();
			LOG.info("End PlayersIO.populatePlayers");

			PopulateDB(players); // Lab7

			Collections.sort(players, new CompareByBirthdate());

			PlayersIO.displayPlayers(players);
			LOG.info("End PlayersIO.displayPlayers");

		} catch (ApplicationException e) {
			// System.err.println(e.getMessage());
			LOG.error(e);
			exit_code = -1;
		} catch (Exception e) {
			// e.printStackTrace();
			LOG.error(MiscUtil.getStackTrace(e));
			exit_code = -1;
		}

		Instant secondInstant = Instant.now();
		LOG.info(secondInstant);
		LOG.info(Duration.between(firstInstant, secondInstant).toMillis() + " ms");

		database.shutdown();

		LOG.info(database.toString() + " stopped");
		LOG.info("End " + LAB_NO + ". exit_code " + exit_code);
		System.exit(exit_code);
	}

	private static void PopulateDB(List<Player> db_players) throws ClassNotFoundException, SQLException,
			ApplicationException, FileNotFoundException, IOException, NotFoundException {
		File file = new File(DB_PROPERTIES_FILENAME);
		if (!file.exists()) {
			throw new ApplicationException("File DB properties " + DB_PROPERTIES_FILENAME + " doesnt exist");
		}

		_properties = new Properties();
		_properties.load(new FileInputStream(file));

		database = new Database(_properties);
		database.getConnection();
		PlayerDao playerDao = new PlayerDao(database);

		if (!database.tableExists(playerDao.getTableName())) {
			LOG.info("Table " + playerDao.getTableName() + " doesnt exists");
			playerDao.create();
			LOG.info("Table " + playerDao.getTableName() + " created");
			playerDao.fillPlayers(db_players);
		} else {
			LOG.info("Table " + playerDao.getTableName() + " exists");
			// playerDao.drop(); // for testing
			// LOG.info("Table " + playerDao.getTableName() + " dropped"); // for testing
		}

		LOG.info("Table " + playerDao.getTableName() + " contains " + playerDao.countAll() + " records");
		LOG.info("records- " + playerDao.loadAll().toString());
		for (String pl : playerDao.getGamerTags()) {
			LOG.info("players by tag - "
					+ String.format("%-20s%-3s%-20s", pl, "-", playerDao.getPlayerByTag(pl).getLastname()));
		}

	}

}
