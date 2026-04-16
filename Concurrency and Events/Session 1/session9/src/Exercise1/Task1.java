package Exercise1;

public class Task1 implements Runnable{

	@Override
	public void run() {
		System.out.println(" Task 1 -> The thread " + Thread.currentThread().getName() + " is running");
	}

}
