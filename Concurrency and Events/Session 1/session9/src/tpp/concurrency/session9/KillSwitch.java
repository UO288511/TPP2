package tpp.concurrency.session9;

public class KillSwitch extends Thread {

	private volatile boolean stopRequested = false;

	@Override
	public void run() {
		long count = 0;
		while (!stopRequested) {
			count++;
		}
		System.out.println("Secondary thread stopped. Final count: " + count);
	}

	public void stopRunning() {
		stopRequested = true;
	}

	public static void main(String[] args) throws InterruptedException {
		KillSwitch secondThread = new KillSwitch();
		secondThread.start();

		// Delay of 2 seconds before stopping
		Thread.sleep(2000);

		System.out.println("Requesting to stop from the main thread...");
		secondThread.stopRunning();

		secondThread.join(); // Waiting for the secondary thread to finish
		System.out.println("Program ended properly.");
	}
}
