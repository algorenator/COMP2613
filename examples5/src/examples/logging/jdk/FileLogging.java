package examples.logging.jdk;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileLogging {

	private static Logger logger;

	public static void main(String[] args) {
		// Get a logger; the logger is automatically created if
		// it doesn't already exist
		logger = Logger.getLogger("com.mycompany.BasicLogging");

		try {
			// Create a file handler that write log record to a file called my.log
			// By default, a file handler overwrites the contents of the log file each time it is created.
			// This example creates a file handler that appends.
			FileHandler handler = new FileHandler("FileLogging.log", true);
			// Add to the desired logger
			logger.addHandler(handler);
		} catch (IOException e) {
			// problem creating the file handler, log to the console only
		}

		// Log a few message at different severity levels
		logger.log(Level.INFO, "Default logging level set");
		logMessages();
		logger.log(Level.WARNING, "WARNING logging level set");
		logger.setLevel(Level.WARNING);
		logMessages();
	}

	private static void logMessages() {
		logger.severe("my severe message");
		logger.warning("my warning message");
		logger.info("my info message");
		logger.config("my config message");
		logger.fine("my fine message");
		logger.finer("my finer message");
		logger.finest("my finest message");
	}

}
