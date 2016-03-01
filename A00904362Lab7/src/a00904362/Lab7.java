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
import java.sql.Connection;
import java.sql.DriverManager;
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
	private static String FILE_LOG_SET = "log.properties";

	private static Properties _properties;
	private static Connection _connection;
	private static Database database;
	// private PlayerDao playerDao;

	public static final String DB_PROPERTIES_FILENAME = "db.properties";

	public static final String DB_DRIVER_KEY = "db.driver";
	public static final String DB_URL_KEY = "db.url";
	public static final String DB_USER_KEY = "db.user";
	public static final String DB_PASSWORD_KEY = "db.password";
	// private static final String PlayerDao.TABLE_NAME = "A00904362_Player";

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

			PopulateDB();

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
		// System.out.println(secondInstant);
		LOG.info(secondInstant);
		// System.out.println(Duration.between(firstInstant, secondInstant).toMillis() + " ms");
		LOG.info(Duration.between(firstInstant, secondInstant).toMillis() + " ms");

		LOG.info("End Lab5. exit_code " + exit_code);

		System.exit(exit_code);
	}

	/**
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws ApplicationException
	 * @throws IOException
	 * @throws FileNotFoundException
	 * 
	 */
	private static void PopulateDB()
			throws ClassNotFoundException, SQLException, ApplicationException, FileNotFoundException, IOException {
		File file = new File(DB_PROPERTIES_FILENAME);
		if (!file.exists()) {
			throw new ApplicationException("File DB properties " + DB_PROPERTIES_FILENAME + " doesnt exist");
		}

		try {
			_properties = new Properties();
			_properties.load(new FileInputStream(file));

			database = new Database(_properties);
			PlayerDao playerDao = new PlayerDao(database);

			Connection connection = database.getConnection();

			if (!Database.tableExists(connection, PlayerDao.TABLE_NAME)) {
				LOG.info("Table " + PlayerDao.TABLE_NAME + " doesnt exists");
				playerDao.create();
				LOG.info("Table " + PlayerDao.TABLE_NAME + " created");
				playerDao.fillPlayers(players);
			} else {
				LOG.info("Table " + PlayerDao.TABLE_NAME + " exists");
				// playerDao.drop(); // for testing
				// LOG.info("Table " + PlayerDao.TABLE_NAME + " dropped"); // for testing
				// playerDao.create(); // for testing
			}

			LOG.info("Table " + PlayerDao.TABLE_NAME + " contains " + playerDao.countAll() + " records");
			LOG.info(playerDao.loadAll().toString());

			// connect();
		} finally {
			if (_connection != null) {
				_connection.close();
			}
		}

	}

	private static void connect() throws ClassNotFoundException, SQLException {
		LOG.info("Driver loading");
		Class.forName(_properties.getProperty(DB_DRIVER_KEY));
		LOG.info("Driver loaded");
		_connection = DriverManager.getConnection(_properties.getProperty(DB_URL_KEY),
				_properties.getProperty(DB_USER_KEY), _properties.getProperty(DB_PASSWORD_KEY));
		LOG.info("Database connected");
	}

}
