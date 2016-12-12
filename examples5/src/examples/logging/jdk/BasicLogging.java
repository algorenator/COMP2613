package examples.logging.jdk;

import java.util.logging.*;

public class BasicLogging {
	// Get a logger; the logger is automatically created if it doesn't already exist
	private static final Logger LOG = Logger.getLogger("com.mycompany.BasicLogging");

	public static void main(String[] args) {
		// Log a few message at different severity levels
		LOG.severe("my severe message");
		LOG.warning("my warning message");
		LOG.info("my info message");
		LOG.config("my config message");
		LOG.fine("my fine message");
		LOG.finer("my finer message");
		LOG.finest("my finest message");
	}
}
