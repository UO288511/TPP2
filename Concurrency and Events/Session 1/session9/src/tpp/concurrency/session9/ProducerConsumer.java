package tpp.concurrency.session9;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
	private static final int CAPACITY = 5;
	private final Queue<Integer> buffer = new LinkedList<>();

	public void produce() throws InterruptedException {
		int value = 0;
		while (true) {
			if (buffer.size() == CAPACITY)
				continue;
			// Simulates the time to generate a value
			Thread.sleep(500);
			buffer.add(value);
			System.out.format("Produced: %d\n", value++);
			
		}
	}

	public void consume() throws InterruptedException {
		while (true) {
			int val = buffer.poll();
			System.out.println("Consumed: " + val);
			// Simulates a slow processing of the value retrieved
			Thread.sleep(1000);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer pc = new ProducerConsumer();

		Thread producer = new Thread(() -> {
			try {
				pc.produce();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		Thread consumer = new Thread(() -> {
			try {
				pc.consume();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		producer.start();
		// Let's allow the producer to add some values before the consumer starts
		Thread.sleep(1000);
		consumer.start();
		
		
	}
}