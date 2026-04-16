package Exercise1;

public class Task2 extends Thread{
	@Override
    public void run() {
        System.out.println("Task 2 -> Thread running: " + Thread.currentThread().getName());
    }

}
