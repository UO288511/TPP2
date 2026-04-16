package Exercise2;

public class CounterSynchronized {
	private int value;
	
	public CounterSynchronized(){
		value=0;
	}

    public synchronized void increment() {
        value++;
    }

    public int getValue() {
        return value;
    }

}
