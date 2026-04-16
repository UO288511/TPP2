package tpp.concurrency.session9;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class defines a counter. It is simple, however it is not thread safe!
 */
class Counter {
	private volatile int value;

	public Counter() {
		value = 0;
	}

	public void increment() {
		value++;
	}

	public int getValue() {
		return value;
	}
}

/**
 * This class shows a example of race condition, when the result of the
 * execution depends on the order in which the threads are executed
 */
public class RaceCondition {
	private static final int NUM_THREADS = 10;
	private static final int INC_PER_THREAD = 1000;
	private static final int TOTAL_EXPECTED = NUM_THREADS * INC_PER_THREAD;

	public static void main(String[] args) throws InterruptedException {
		// common counter, shared among threads
		Counter counter = new Counter();
		//AtomicInteger counter = new AtomicInteger(0);

		// Each thread will increment the counter a number of times
		// The expected result in the counter is that number multiplied by the number of
		// threads, but this does not happen most of the times
		Runnable task = () -> {
			for (int i = 0; i < INC_PER_THREAD; i++) {
				counter.increment();
				//counter.incrementAndGet();

			}
		};

		Thread[] threads = new Thread[NUM_THREADS];

		for (int i = 0; i < NUM_THREADS; i++) {
			threads[i] = new Thread(task);
			threads[i].start();
		}

		for (int i = 0; i < NUM_THREADS; i++) {
			threads[i].join(); // Wait for all threads to finish
		}
		System.out.println("Final count: " + counter.getValue() + " (Expected: " + TOTAL_EXPECTED + ")");
	}
}