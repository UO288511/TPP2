package tpp.concurrency.session9;

import java.util.concurrent.*;

public class ParallelLogProcessing {
	// The buffer size
	private static final int QUEUE_CAPACITY = 5;
	// A BlockingQueue handles thread signaling automatically
	private static final BlockingQueue<String> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

	// TODO

	public static void main(String[] args) throws InterruptedException {
		int producerCount = 3;
		int consumerCount = 2;

		ExecutorService producerService = Executors.newFixedThreadPool(producerCount);
		ExecutorService consumerService = Executors.newFixedThreadPool(consumerCount);

		// 1. Start Consumers (Analyzers)
		for (int i = 0; i < consumerCount; i++) {
			consumerService.execute(new Analyzer(i));
		}

		// 2. Start Producers (Scanners)
		for (int i = 0; i < producerCount; i++) {
			producerService.execute(new Scanner(i));
		}

		// 3. Shutdown logic
		producerService.shutdown();
		producerService.awaitTermination(1, TimeUnit.MINUTES);

		// TODO: After producers finish, how do we tell consumers to stop?
		// Hint: You need to put a POISON_PILL into the queue for EACH consumer.

		consumerService.shutdown();
		consumerService.awaitTermination(1, TimeUnit.MINUTES);
		System.out.println("Processing complete.");
	}

	static class Scanner implements Runnable {
		private final int id;

		Scanner(int id) {
			this.id = id;
		}

		@Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                String logEntry = "LogEntry-" + i + " from Scanner-" + id;
                // TODO: Add the log entry to the queue, blocking if there is no space
                
            }
            System.out.println("Scanner-" + id + " finished work.");
        }
	}

	static class Analyzer implements Runnable {
		private final int id;

		Analyzer(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			try {
				while (true) {
					// TODO: Retrieve the next log entry from the queue, blocking if there is none
					String log = null;
					System.out.println("Analyzer-" + id + " received: " + log);

					// TODO: Check for the Poison Pill to break the loop
					

					// Simulate processing time
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
