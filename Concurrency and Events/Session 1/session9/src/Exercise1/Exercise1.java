package Exercise1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise1 {

	public static void main(String[] args) throws InterruptedException {
		
		//1) Using Runnable + Thread
		Task1 t1a = new Task1();
		Task1 t1b = new Task1();

		Thread t1 = new Thread(t1a, "Runnable thread 1a");
		Thread t2 = new Thread(t1b, "Runnable thread 1b");

		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		
		// 2) Using classes that extend Thread
		Task2 t2a = new Task2();
		Task2 t2b = new Task2();

		t2a.start();
		t2b.start();
		
		
		
		ExecutorService executor = Executors.newFixedThreadPool(2);

		executor.submit(() -> System.out.println("running: " + Thread.currentThread().getName()));
		executor.submit(() -> System.out.println("running: " + Thread.currentThread().getName()));

		executor.shutdown();

	}

}
