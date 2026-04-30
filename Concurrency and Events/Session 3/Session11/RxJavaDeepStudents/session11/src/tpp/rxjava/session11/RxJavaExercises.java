package tpp.rxjava.session11;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.management.RuntimeErrorException;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxJavaExercises {

	public static void main(String[] args) throws InterruptedException {
		// Uncomment the exercise you want to run

		//ex1_Merge();
		//ex2_Zip();
		//ex3_GroupBy();
		//ex4_Reduce();
		//ex5_Schedulers();
		//ex6_Schedulers();
		ex7_Retry();
		ex8_ErrorResume();
		ex9_Buffer();
		ex10_Window();
		ex11_Debounce();
		ex12_Sample();
		ex13_Backpressure();
		ex14_Flowable();
	}

	// --- MODULE 1: COMBINING ---
	private static void ex1_Merge() throws InterruptedException {
		Observable<String> names = Observable.just("Diego", "Martin", "Fernandez")
				.delay(100, TimeUnit.MILLISECONDS);
		Observable<String> colors = Observable.just("Red", "Blue", "Green");
		//Si pones el delay, el theards are dropped if the fucntion end, por lo que solo se ejecuta los colos
		
		//Observable.merge(names, colors).blockingSubscribe(item -> System.out.println(item)); 
		//basically same
		Observable.merge(names, colors).
			subscribe(item -> System.out.println(item));

		//para que ssalga todo, sino la fuicnion acaba antes de que el delay funcione
		//Por lo que no salen
		//si el subscribe no fucnioa, el blocking subscribe espera  aque acabe todo para que salga
		Thread.sleep(1000);
	}

	record Grade(String name, double grade) {

	}

	private static void ex2_Zip() {
		Observable<String> names = Observable.just("Carla", "Sara", "Laura");
	    Observable<Double> grades = Observable.just(8.5, 7.0, 9.3);
	    
	    Observable.zip(names, grades, Grade::new)
	    	.subscribe(item -> System.out.println(item));
	    
	    
	    
	}

	private static void ex3_GroupBy() {
		Observable<String> names = Observable.just("Diego", "Martin", "Fernandez");
		names.groupBy(word -> word.substring(0,1))
        	.flatMapSingle(group -> group.toList())
        	.blockingSubscribe(System.out::println);
		
	}
	
	
	private static void ex4_Reduce() {
		Observable.range(1, 10)
        	.reduce(0, Integer::sum)
        	.subscribe(result -> System.out.println("Suma = " + result));
	}

	// --- MODULE 2: SCHEDULERS ---
	private static void ex5_Schedulers() {
		Observable.fromCallable(() -> {
	        System.out.println("Heavy computation on: " + Thread.currentThread().getName());
	        Thread.sleep(2000);
	        return "Finsih!";
	    })
		    .subscribeOn(Schedulers.computation())   // trabajo pesado
		    .observeOn(Schedulers.single())          // recibir resultado
		    .blockingSubscribe(result ->
		            System.out.println("Received on: " + Thread.currentThread().getName() + " → " + result)
		    );
		
		//Schedulers.single()
		//Schedulers.computation()
		//Schedulers.io()
	}

	private static void ex6_Schedulers() {
		// TODO Transform this into parallel processing
		Observable.range(1, 20).flatMap(i -> Observable.just(i).map(item -> {
			System.out.println(Thread.currentThread() + ": Starting " + i);
			Thread.sleep(500);
			return item;
		})).subscribe((i) -> System.out.println(Thread.currentThread() + ": Done with " + i));
		System.out.println("Tasks launched!");
	}

	// --- MODULE 3: ERROR MANAGEMENT ---
	private static void ex7_Retry() {
		Random rnd = new Random();
		AtomicInteger attemps = new AtomicInteger();

	    Observable.fromCallable(() -> {
	    	int attempt = attemps.incrementAndGet();
	    	double d = rnd.nextDouble();
	    	if(d<0.7) {
	    		throw new RuntimeException( "FAIL");
	    	}
	    	return "Computation sucessfull on try: " + attempt + " \n Number = " + d;
	    }).retry(10)
	    	.blockingSubscribe(System.out::println, error -> System.out.println(error.getMessage()));
	            
	}

	private static void ex8_ErrorResume() {
		Observable.range(1, 3)
	            .map(i -> {
	                System.out.println("Processing: " + i);
	                if (i == 2)
	                    throw new RuntimeException("Fail");
	                return i;
	            }).onErrorResumeNext(erroe -> Observable.just(10, 11, 12));
		}

	   

	// --- MODULE 4: FLOW CONTROL ---
	private static void ex9_Buffer() {
		// TODO
	}

	private static void ex10_Window() {
		// TODO
	}

	private static String message = "I've seen things you people wouldn't believe. Attack ships on fire off the shoulder of Orion. I watched c-beams glitter in the dark near the Tannhäuser Gate. All those moments will be lost in time, like tears in rain. Time to die.";

	private static void ex11_Debounce() {
		Random rnd = new Random(0);
		Observable<String> keyStrokes = Observable.fromArray(message.split(""))
				.concatMap(letter -> Observable.just(letter).delay(rnd.nextInt(10, 100), TimeUnit.MILLISECONDS));

		// TODO
	}

	private static void ex12_Sample() {
		Random rnd = new Random(0);
		Observable<String> keyStrokes = Observable.fromArray(message.split(""))
				.concatMap(letter -> Observable.just(letter).delay(rnd.nextInt(10, 100), TimeUnit.MILLISECONDS));

		// TODO
	}

	private static class FatObject {
		private long id;
		byte[] data;

		public FatObject(long id) {
			this.id = id;
			this.data = new byte[1000]; // 1 kb
		}

		public long getId() {
			return id;
		}
	}

	private static void ex13_Backpressure() {
		Observable<FatObject> obs = Observable.interval(1, TimeUnit.NANOSECONDS).map(i -> {
//			System.out.println(Thread.currentThread().getName() + ": Emitted " + i);
			return new FatObject(i);
		}); // 1KB for each nanosecond

		// TODO
	}

	private static void ex14_Flowable() {
		Flowable<FatObject> obs = Flowable.interval(1, TimeUnit.NANOSECONDS)
				.map(FatObject::new); // 1KB for each nanosecond

		// TODO

	}
}
