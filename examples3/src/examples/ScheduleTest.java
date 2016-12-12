package examples;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleTest {
	public ScheduleTest() {

		Timer timer = new Timer();
		Calendar midnight = new GregorianCalendar();
		midnight.set(Calendar.HOUR, 0);
		midnight.set(Calendar.MINUTE, 0);
		midnight.set(Calendar.SECOND, 0);
		midnight.set(Calendar.AM_PM, Calendar.AM);
		PastTask pastTask = new PastTask(midnight);
		timer.schedule(pastTask, midnight.getTime());
		Calendar jan1_2038 = new GregorianCalendar(2038, Calendar.JANUARY, 01);
		FutureTask futureTask = new FutureTask(jan1_2038);
		timer.schedule(futureTask, jan1_2038.getTime());
	}

	public static void main(String[] args) {
		System.out.println("Start test");
		new ScheduleTest();
		System.out.println("End test?");
	}

	// inner classes --------------------------------------------------------------------------------------------------

	private class PastTask extends TimerTask {

		private final Calendar time;

		public PastTask(Calendar time) {
			this.time = time;
		}

		@Override
		public void run() {
			System.out.println(DateFormat.getDateTimeInstance().format(time.getTime()) + " has passed");
		}
	}

	private class FutureTask extends TimerTask {

		private final Calendar time;

		public FutureTask(Calendar time) {
			this.time = time;
		}

		@Override
		public void run() {
			System.out.format("Happy New Year %tY!", time.getTime());
		}
	}
}