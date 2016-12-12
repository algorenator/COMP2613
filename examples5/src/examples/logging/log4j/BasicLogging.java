package examples.logging.log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BasicLogging {

	private static final Logger LOG = Logger.getLogger(BasicLogging.class);

	public static void main(String[] args) {
		BasicConfigurator.configure();
		
		LOG.info("Starting BasicLogging.");
		
		BasicLogging basicLogging = new BasicLogging();

		try {
			basicLogging.foo();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		
		AnotherClass.bar();
		
		LOG.info("Exiting BasicLogging.");
	}
	
	private BasicLogging() {
		LOG.debug("BasicLogging constructor.");
	}

	private void foo() throws Exception {
		LOG.debug("foo() called.");
		
		if (true) {
			throw new Exception("Ouch!");
		}
	}

}
