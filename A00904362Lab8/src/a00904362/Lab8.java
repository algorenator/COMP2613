/**
 * Project: A00904362Lab8
 * File: Lab8.java
 * Date: Mar 9, 2016
 * Time: 11:53:23 AM
 */

package a00904362;

/**
 * @author Alexey Gorbenko, A00904362
 *
 */

public class Lab8 {

	private static int LIMIT = 100;
	private static boolean newline = false;
	private static boolean finish = false;

	static Object sync = new Object();

	public static void main(String[] args) {
		// monitor
		Object sync = new Object();

		// Create tasks
		Runnable tortoise = new Racer("Tortoise", sync);
		Runnable hare = new Racer("Hare", sync);

		// Create threads
		Thread thread1 = new Thread(hare);
		Thread thread2 = new Thread(tortoise);

		// Start threads
		thread1.start();
		thread2.start();

	}

	static class Racer implements Runnable {
		private String runnername;
		private int distance = 0;
		private Object sync;

		public Racer(String str, Object sync) {
			this.sync = sync;
			this.runnername = str;
		}

		public void report() {
			newline = !newline;
			if (newline) {
				System.out.println();
			}
			System.out.print(runnername + " " + distance + " ");
			if (distance >= LIMIT) {
				finish = true;
				System.out.println();
				System.out.println("**** " + runnername + " WINNER! ****");

			}
		}

		private void step() throws InterruptedException {
			synchronized (sync) {
				distance = (int) (distance + randomInteger(1, 5));
				Thread.sleep(100);
				sync.notify();
				if (!finish) {
					report();
					sync.wait();
				}
			}

		}

		@Override
		public void run() {

			while (distance < LIMIT || !finish) {
				try {
					step();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			// System.out.println("finish-" + runnername);
		}

	}

	public static int randomInteger(int min, int max) {
		int randomNum = min + (int) (Math.random() * ((max - min) + 1));
		return randomNum;
	}
}
