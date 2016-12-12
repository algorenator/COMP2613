package examples;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 */

/**
 * @author scirka
 * 
 */
public class TickTockExample {
	private final Timer timer;

	public TickTockExample() {
		timer = new Timer();
		timer.schedule(new TickTock(), 0, 1000);
	}

	public static void main(String args[]) {
		System.out.println("About to schedule task.");
		new TickTockExample();
		System.out.println("Task scheduled.");
	}

	// inner classes --------------------------------------------------------------------------------------------------

	private class TickTock extends TimerTask {

		boolean tick = true;

		@Override
		public void run() {
			System.out.println(tick ? "Tick" : "Tock");
			tick = !tick;
		}
	}

}
