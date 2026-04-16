package Exercise2;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionAtomicInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicInteger counter = new AtomicInteger(0);
		
		counter.incrementAndGet();
		
	}

}
