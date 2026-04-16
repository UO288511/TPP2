package tpp.concurrency.session9;

import java.util.concurrent.*;
import java.util.Map;

public class ConcurrentMap {

	private static final Map<String, Long> counts = new ConcurrentHashMap<>();

	public static void main(String[] args) throws InterruptedException {
		int numThreads = 10;
		int updatesPerThread = 10000;
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);

		for (int i = 0; i < numThreads; i++) {
			executor.execute(() -> {
				for (int j = 0; j < updatesPerThread; j++) {
					accessMap("AAA");
				}
			});
		}

		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.MINUTES);

		System.out.println("Final Count: " + counts.get("AAA"));
		System.out.println("Expected Count: " + (numThreads * updatesPerThread));
	}

	public static void accessMap(String symbol) {
		Long current = counts.getOrDefault(symbol, 0L);
		counts.put(symbol, current + 1);
	}
}