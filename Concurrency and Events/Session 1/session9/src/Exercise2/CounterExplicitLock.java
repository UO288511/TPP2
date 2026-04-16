package Exercise2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class CounterExplicitLock {
	private int value ;
    private final Lock lock = new ReentrantLock();
    
    public CounterExplicitLock() {
    	value =0;
    }

    public void increment() {
        lock.lock();
        try {
            value++;
        } finally {
            lock.unlock();
        }
    }

    public int getValue() {
        return value;
    }
}
