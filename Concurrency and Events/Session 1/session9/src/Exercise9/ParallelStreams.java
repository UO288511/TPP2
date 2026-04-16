package Exercise9;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams {
	public static double expensiveOperation(double x) {
	    return Math.sin(Math.log(Math.pow(Math.sqrt(x), 3)));
	}
	
	public static double cheapOperation(double x) {
        return Math.sqrt(x);
    }
	
	public static void main(String[] args)  {
		var stream = IntStream.range(0, 10000).boxed();
		
		long time = System.currentTimeMillis();
		
		sequentialProcessing(stream);
		
		time = System.currentTimeMillis()-time;
		
	}
	
	public void sequentialProcessing(Stream<?> stream) {
		stream.parallel().flatMapToDouble();
		
	}
	
	public void parallelProcessing() {
		
	}
	

}
