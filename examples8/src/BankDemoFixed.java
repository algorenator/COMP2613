public class BankDemoFixed {

	public static final int INITIAL_BALANCE = 10000;
	public static final int NACCOUNTS = 10;
	private int[] accounts;
	private int ntransacts;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BankDemoFixed b = new BankDemoFixed();
		for (int i = 1; i <= BankDemoFixed.NACCOUNTS; i++) {
			new TransactionThread3(b, i).start();
		}
	}

	public BankDemoFixed() {
		accounts = new int[NACCOUNTS];
		for (int i = 0; i < NACCOUNTS; i++) {
			accounts[i] = INITIAL_BALANCE;
		}
		ntransacts = 0;
		test();
	}

	public synchronized void transfer(int from, int to, double amount) {
		System.out.println(String.format("From %d, To %d, Amount = $%.0f", from,
				to, amount));
		while (accounts[from] < amount) {
			try {
				System.out.println(String.format(
						"From %d only has $%d but needs $%.0f", from,
						accounts[from], amount));
				wait();
				System.out.println(String.format("From %d woke up", from));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}

			System.out.println(String.format("From %d is now OK", from));
		}
		accounts[from] -= amount;
		// simulates transaction delay ...
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
		accounts[to] += amount;
		// simulates transaction delay ...
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
		ntransacts++;
		if (ntransacts % 500 == 0) {
			test();
		}

		notifyAll();
	}

	public void test() {
		int sum = 0;
		for (int i = 0; i < NACCOUNTS; i++) {
			sum += accounts[i];
		}
		System.out.println("Transactions:" + ntransacts + " Sum: " + sum);
	}
}

class TransactionThread3 extends Thread {

	private BankDemoFixed bank;
	private int from;

	public TransactionThread3(BankDemoFixed b, int i) {
		this.setName("Thread" + i);
		from = i - 1;
		bank = b;
	}

	public void run() {
		while (true) {
			int to = (int) ((BankDemoFixed.NACCOUNTS - 1) * Math.random());
			if (to == from) {
				to = (to + 1) % BankDemoFixed.NACCOUNTS;
			}
			int amount = (int) (BankDemoFixed.INITIAL_BALANCE * Math.random());
			bank.transfer(from, to, amount);
			try {
				sleep(1);
			} catch (InterruptedException e) {
			}
		}
	}
}
