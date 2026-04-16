package tpp.concurrency.session9;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// TODO 1. Make this class Callable
class FactorialCalculator {
	private int number;

	public FactorialCalculator(int number) {
		this.number = number;
	}

	public BigInteger compute() throws Exception {
		if (number < 0) {
			throw new IllegalArgumentException("The number must be non negative.");
		}

		System.out.println("Computing factorial of " + number + " in " + Thread.currentThread().getName());

		BigInteger resultado = BigInteger.ONE;
		for (int i = 1; i <= number; i++) {
			resultado = resultado.multiply(BigInteger.valueOf(i));
		}
		return resultado;
	}
}

public class PoolManager {
	public static void main(String[] args) {

		// Create an ExecutorService with a fixed thread pool
		ExecutorService executor = Executors.newFixedThreadPool(3);

		// Numbers to compute the factorial
		int[] numbers = { 50, 70, 30, 100, 40 };
		// Result list using Future
		List<Future<BigInteger>> results = new ArrayList<>();

		// 2. Submit the tasks
		for (int number : numbers) {
			// TODO 2.1 Create a task (Callable)

			// TODO 2.2 Submit the task to the ExecutorService

			// TODO 2.3 Store the Future objects

		}
		
		// TODO 3. Iterate the Future and print the results in the console
		for (int i = 0; i < results.size(); i++) {

		}

		// TODO 4. Shutdown the ExecutorService to free resources

		System.out.println("ExecutorService has been shut down.");
	}
}
